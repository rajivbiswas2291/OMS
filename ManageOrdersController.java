package com.msr.oms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.msr.admin.dto.StyleDto;
import com.msr.admin.utils.RoleContanstsEnum;
import com.msr.oms.dto.ColorsAndSizesDTO;
import com.msr.oms.dto.CurrencyDTO;
import com.msr.oms.dto.CustomerDTO;
import com.msr.oms.dto.DropDownDTO;
import com.msr.oms.dto.EditOrder;
import com.msr.oms.dto.EmailSettingsDTO;
import com.msr.oms.dto.ItemNameSearchResponseDTO;
import com.msr.oms.dto.ItemsDTO;
import com.msr.oms.dto.ManufacturerDTO;
import com.msr.oms.dto.OrderAssignDto;
import com.msr.oms.dto.OrderPreviewDto;
import com.msr.oms.dto.OrdersDashboardDTO;
import com.msr.oms.dto.PaypalCredentialsDto;
import com.msr.oms.dto.PaypalRequestDto;
import com.msr.oms.dto.PriceListDTO;
import com.msr.oms.dto.SaveOrderDTO;
import com.msr.oms.dto.ShippingCostDTO;
import com.msr.oms.dto.TotalAreDto;
import com.msr.oms.email.service.EmailSenderService;
import com.msr.oms.entity.BillingAddress;
import com.msr.oms.entity.CurrencyMaster;
import com.msr.oms.entity.Customer;
import com.msr.oms.entity.Manufacturers;
import com.msr.oms.entity.ManufacturersApiCredentials;
import com.msr.oms.entity.OrderAssign;
import com.msr.oms.entity.OrderItems;
import com.msr.oms.entity.Orders;
import com.msr.oms.entity.PaymentsEntity;
import com.msr.oms.entity.PaypalCredentialsEntity;
import com.msr.oms.entity.PriceListMaster;
import com.msr.oms.entity.ShippingAddress;
import com.msr.oms.entity.ShippingCostMaster;
import com.msr.oms.entity.TotalAreMaster;
import com.msr.oms.repository.CustomerRepository;
import com.msr.oms.repository.ManufacturersApiCredentialsRepository;
import com.msr.oms.repository.OrderItemsRepository;
import com.msr.oms.repository.OrdersRepository;
import com.msr.oms.repository.PaymentRepository;
import com.msr.oms.repository.PaypalCredentialsRepository;
import com.msr.oms.service.ManageOrdersService;
import com.msr.oms.utils.OrderStatusEnum;
import com.msr.onboard.dto.ManufacturerOnBoardDTO;
import com.msr.onboard.repository.BillingAddressRepository;
import com.msr.onboard.repository.ManufacturerOnboardRepository;
import com.msr.onboard.repository.ShippingAddressRepository;
import com.msr.product.dto.ColorsDTO;
import com.msr.product.dto.ManageProductsDTO;
import com.msr.product.dto.ProductDTO;
import com.msr.product.dto.SizesDTO;
import com.msr.product.dto.StyleInformationDTO;
import com.msr.product.entity.CategoryMaster;
import com.msr.product.entity.ColorsMaster;
import com.msr.product.entity.Product;
import com.msr.product.entity.ProductColorsMapping;
import com.msr.product.entity.ProductSizeMapping;
import com.msr.product.entity.SizeMaster;
import com.msr.product.entity.StylesMaster;
import com.msr.product.repository.BrandMasterRepository;
import com.msr.product.repository.CategoryMappingRepository;
import com.msr.product.repository.CategoryMasterRepository;
import com.msr.product.repository.CategoryStyleMappingRepository;
import com.msr.product.repository.ColorsMasterRepository;
import com.msr.product.repository.ProductColorMappingReopsitory;
import com.msr.product.repository.ProductRepository;
import com.msr.product.repository.ProductSizeMappingRepository;
import com.msr.product.repository.SizeMasterRepository;
import com.msr.product.repository.StyleMasterRepository;
import com.msr.product.service.ProductService;
import com.msr.product.utills.GenericResponseDTO;
import com.msr.product.utills.MessageConstants;
import com.msr.product.utills.NullCheckUtills;
import com.msr.security.jwt.configuration.JWTTokenProvider;
import com.msr.security.user.repository.RoleMasterRepository;
import com.msr.security.user.repository.UserRepo;
import com.msr.security.user.utills.SecurityEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * the class ManageOrdersController.
 * 
 * this class is used for perform operations on orders like create/edit/delete.
 * 
 * @author vamshib
 *
 */
@RestController
@RequestMapping(value = "/oms")
@Api(value = "ManageOrdersController")
public class ManageOrdersController {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private ProductSizeMappingRepository productSizeMappingRepository;

	/** The manage orders service. */
	@Autowired
	private ManageOrdersService manageOrdersService;

	/** The null check utills. */
	@Autowired
	private NullCheckUtills nullCheckUtills;

	/** The email sender service. */
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private ProductColorMappingReopsitory productColorMappingReopsitory;

	/** The token provider. */
	@Autowired
	private JWTTokenProvider tokenProvider;

	/** The billing address repository. */
	@Autowired
	private BillingAddressRepository billingAddressRepository;

	/** The shipping address repository. */
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;

	@Autowired
	private StyleMasterRepository styleMasterRepository;

	/** The product creation service. */
	@Autowired
	private ProductService productService;

	@Autowired
	private PaypalCredentialsRepository paypalCredentialsRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/** The user repo. */

	@Autowired
	private ManufacturerOnboardRepository manufacturerOnboardRepository;

	/**
	 * Gets the drop down value for order for filling up the form.
	 *
	 * @return the drop down value for order
	 */
	@ApiOperation(value = "Getting the Master Table values for Various dropdowns in the form", response = String.class)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getMasterDetailsForDropdowns(HttpServletRequest request) {
		DropDownDTO dropDownDto = new DropDownDTO();
		List<OrderAssign> listOfAssign = manageOrdersService.getAssignees();
		List<OrderAssignDto> listOfOrderAssignDto = new ArrayList<OrderAssignDto>();
		for (OrderAssign orderAssign : listOfAssign) {
			OrderAssignDto orderAssignDto = new OrderAssignDto();
			orderAssignDto.setOrderAssignToId(orderAssign.getOrderAssignToId());
			orderAssignDto.setAssignedTo(orderAssign.getAssignedTo());
			listOfOrderAssignDto.add(orderAssignDto);
		}
		dropDownDto.setAssignTo(listOfOrderAssignDto);

		List<Customer> listOfCustomer = manageOrdersService
				.getAllCustomers(request.getHeader(SecurityEnum.JWT_TOKEN.status()));
		List<CustomerDTO> listOfCusomerDto = new ArrayList<CustomerDTO>();
		for (Customer customer : listOfCustomer) {
			CustomerDTO customerDto = new CustomerDTO();
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setCustomerName(customer.getCustomerName());
			listOfCusomerDto.add(customerDto);
		}
		dropDownDto.setCustomers(listOfCusomerDto);

		List<Manufacturers> listOfManufactures = manageOrdersService.getManufacturers();
		List<ManufacturerDTO> manufactureDto = new ArrayList<ManufacturerDTO>();
		for (Manufacturers manufacturers : listOfManufactures) {
			ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
			manufacturerDTO.setManufacturerId(manufacturers.getManufactureId());
			manufacturerDTO.setManufacturerName(manufacturers.getManufacturerName());
			manufactureDto.add(manufacturerDTO);
		}
		dropDownDto.setManufacturers(manufactureDto);

		List<CurrencyMaster> listOfCurrencies = manageOrdersService.getAllCurrencies();
		List<CurrencyDTO> currencyDto = new ArrayList<CurrencyDTO>();
		for (CurrencyMaster currencyMaster : listOfCurrencies) {
			CurrencyDTO currencyDTO = new CurrencyDTO();
			currencyDTO.setCurrencyId(currencyMaster.getCurrencyId());
			currencyDTO.setCurrencyName(currencyMaster.getCurrencyName());
			currencyDTO.setCurrencyCode(currencyMaster.getCurrencyCode());
			currencyDto.add(currencyDTO);
		}
		dropDownDto.setCurrencies(currencyDto);

		List<PriceListMaster> listOfPriceList = manageOrdersService.getAllPriceLists();
		List<PriceListDTO> listOfPriceListDTO = new ArrayList<PriceListDTO>();
		for (PriceListMaster priceListMaster : listOfPriceList) {
			PriceListDTO priceListDTO = new PriceListDTO();
			priceListDTO.setPriceListId(priceListMaster.getPriceListId());
			priceListDTO.setPriceListName(priceListMaster.getPriceListName());
			listOfPriceListDTO.add(priceListDTO);
		}
		dropDownDto.setPriceList(listOfPriceListDTO);

		List<TotalAreMaster> listOfTotalAre = manageOrdersService.getAllTotalAreMaster();
		List<TotalAreDto> listOfTotalAreDto = new ArrayList<TotalAreDto>();
		for (TotalAreMaster totalAreMaster : listOfTotalAre) {
			TotalAreDto totalAreDto = new TotalAreDto();
			totalAreDto.setTotalAreId(totalAreMaster.getTotalAreId());
			totalAreDto.setTotalAreName(totalAreMaster.getTotalAreName());
			listOfTotalAreDto.add(totalAreDto);
		}
		dropDownDto.setTotalAre(listOfTotalAreDto);

		List<ShippingCostMaster> listOfShippingCostMaster = manageOrdersService.getAllShippingCosts();
		List<ShippingCostDTO> listOfShippingCostDTO = new ArrayList<ShippingCostDTO>();
		for (ShippingCostMaster shippingCostMaster : listOfShippingCostMaster) {
			ShippingCostDTO shippingCostDTO = new ShippingCostDTO();
			shippingCostDTO.setShipplingCostId(shippingCostMaster.getShipplingCostId());
			shippingCostDTO.setShippingCostName(shippingCostMaster.getShippingCostName());
			listOfShippingCostDTO.add(shippingCostDTO);
		}
		dropDownDto.setShippingCost(listOfShippingCostDTO);
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setResponse(dropDownDto);
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);

	}

	/**
	 * Gets the all order details.
	 *
	 * @return the all order details
	 */
	@ApiOperation(value = "Getting all the orders", response = OrdersDashboardDTO.class)
	@RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getAllOrders(HttpServletRequest request) {
		List<OrdersDashboardDTO> ordersList = new ArrayList<>();
		String jwtToken = request.getHeader(SecurityEnum.JWT_TOKEN.status());
		jwtToken = jwtToken.replace("Bearer ", "");
		String jwtIdToken = tokenProvider.getIDTokenFromJwtToken(jwtToken);
		List<Orders> orders = manageOrdersService.getAllOrders(jwtIdToken);
		if (!nullCheckUtills.isListNullOrEmpty(orders)) {
			for (Orders order : orders) {
				OrdersDashboardDTO dto = new OrdersDashboardDTO();
				BeanUtils.copyProperties(order, dto);
				dto.setCreatedOn(order.getCreatedOn().toString());
				ordersList.add(dto);
			}
		}
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setResponse(ordersList);
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	/**
	 * Gets the all order details.
	 *
	 * @param orderStatus
	 *            the order status
	 * @return the all order details
	 */
	@ApiOperation(value = "Getting all the orders by order status", response = OrdersDashboardDTO.class)
	@RequestMapping(value = "/orders/status/{orderStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getOrdersByOrderStatus(HttpServletRequest request,
			@ApiParam(value = "orderStatus from which order will be shown for form page", required = true) @PathVariable String orderStatus) {
		List<OrdersDashboardDTO> ordersList = new ArrayList<>();
		String jwtToken = request.getHeader(SecurityEnum.JWT_TOKEN.status());
		jwtToken = jwtToken.replace("Bearer ", "");
		String jwtIdToken = tokenProvider.getIDTokenFromJwtToken(jwtToken);
		List<Orders> orders = manageOrdersService.getOrdersByOrderStatus(orderStatus, jwtIdToken);
		if (!nullCheckUtills.isListNullOrEmpty(orders)) {
			for (Orders order : orders) {
				OrdersDashboardDTO dto = new OrdersDashboardDTO();
				BeanUtils.copyProperties(order, dto);
				dto.setCreatedOn(order.getCreatedOn().toString());
				ordersList.add(dto);
			}
		}
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setResponse(ordersList);
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/getAllPaidOrders/{paymentStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getAllPaidOrders(HttpServletRequest request,
			@PathVariable String paymentStatus) {
		// List<Orders>
		// listOfOrders=ordersRepository.getAllPaidOrdersByPaymentStatus(MessageConstants.PAYMENT_STATUS_PAID);
		List<OrdersDashboardDTO> ordersList = new ArrayList<>();
		String jwtToken = request.getHeader(SecurityEnum.JWT_TOKEN.status());
		jwtToken = jwtToken.replace("Bearer ", "");
		String jwtIdToken = tokenProvider.getIDTokenFromJwtToken(jwtToken);
		List<Orders> orders = manageOrdersService.getOrdersByOrderPaymentStatus(paymentStatus, jwtIdToken);
		if (!nullCheckUtills.isListNullOrEmpty(orders)) {
			for (Orders order : orders) {
				OrdersDashboardDTO dto = new OrdersDashboardDTO();
				BeanUtils.copyProperties(order, dto);
				dto.setCreatedOn(order.getCreatedOn().toString());
				ordersList.add(dto);
			}
		}
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setResponse(ordersList);
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	/**
	 * Creates the new sales order.
	 *
	 * @param saveOrderDTO
	 *            the save order DTO
	 * @return the response entity
	 */
	@ApiOperation(value = "Creating a new order", response = SaveOrderDTO.class)
	@RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> createNewSalesOrder(@RequestBody SaveOrderDTO saveOrderDTO) {
		ResponseEntity<SaveOrderDTO> responseEntity = manageOrdersService.createNewSalesOrder(saveOrderDTO);
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setResponse(responseEntity.getBody());
		genericResponseDTO.setStatusCode(responseEntity.getStatusCodeValue());
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, responseEntity.getStatusCode());
	}

	/**
	 * Deletes the order by orderId.
	 *
	 * @param orderId
	 *            the order id
	 * @return {@link ResponseEntity<String>}
	 */
	@ApiOperation(value = "Deleting the order by orderId", response = String.class)
	@RequestMapping(value = "/orders/{orderId}", method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponseDTO> deleteOrderByOrderId(
			@ApiParam(value = "orderId from which order will be deleted for database ", required = true) @PathVariable Long orderId) {
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		if (manageOrdersService.deleteOrderByOrderId(orderId)) {
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			genericResponseDTO.setResponseMessage(MessageConstants.ORDER_DELETION_SUCCESS_MESSAGE);
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
		} else {
			genericResponseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the styles by manufacture and brand id.
	 *
	 * @param brandId
	 *            the brand id
	 * @param manufacturerId
	 *            the manufacturer id
	 * @return the styles by manufacture and brand id
	 */
	@ApiOperation(value = "gets all the style by manufacturer and brand", response = StyleInformationDTO.class)
	@RequestMapping(value = "/brands/{brandId}/styles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getStylesByBrandId(@PathVariable Long brandId) {
		List<StyleInformationDTO> styleDtos = new ArrayList<>();
		List<StylesMaster> styleMasterList = manageOrdersService.getStylesByBrandId(brandId);
		for (StylesMaster styleMaster : styleMasterList) {
			StyleInformationDTO dto = new StyleInformationDTO();
			dto.setStyleId(styleMaster.getStyleId());
			dto.setStyleName(styleMaster.getStyleName());
			File file = new File(styleMaster.getStyleImgLocation());
			if (file.exists()) {
				FileInputStream inputStream;
				try {
					inputStream = new FileInputStream(file);
					byte[] bytes = new byte[(int) file.length()];
					inputStream.read(bytes);
					String encodedImageInBase64 = new String(Base64.encodeBase64(bytes), "UTF-8");
					dto.setProductImage(encodedImageInBase64);
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			styleDtos.add(dto);
		}
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		genericResponseDTO.setResponse(styleDtos);
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	/**
	 * Gets the products by style id.
	 *
	 * @param styleId
	 *            the style id
	 * @return the products by style id
	 */
	@ApiOperation(value = "Gets All the products that is crerated for that particular style", response = StyleInformationDTO.class)
	@RequestMapping(value = "/styles/{styleId}/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getProductsByStyleId(@PathVariable Long styleId) {
		List<ManageProductsDTO> manageProductList = new ArrayList<ManageProductsDTO>();
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		List<Product> productList = manageOrdersService.getProductByStyleId(styleId);
		if (!nullCheckUtills.isListNullOrEmpty(productList)) {
			for (Product product : productList) {
				ManageProductsDTO manageProductDTO = new ManageProductsDTO();
				manageProductDTO.setArtName(product.getProductArtName());
				manageProductDTO.setProductId(product.getProductId());
				String[] productImages = manageOrdersService.getFrontProductImage(product.getProductId());
				for (String productImage : productImages) {
					File file = new File(productImage);
					FileInputStream inputStream;
					try {
						inputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int) file.length()];
						inputStream.read(bytes);
						String encodedImageInBase64 = new String(Base64.encodeBase64(bytes), "UTF-8");
						inputStream.close();
						manageProductDTO.setProduct(encodedImageInBase64);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
				manageProductList.add(manageProductDTO);
			}
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			genericResponseDTO.setResponse(manageProductList);
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
		} else {
			genericResponseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Gets the product by order name.
	 *
	 * @param productName
	 *            the product name
	 * @return the product by order name
	 */
	@ApiOperation(value = "Searching the product by productName or anything smililar to that", response = ProductDTO.class)
	@RequestMapping(value = "/customer/{customerId}/products/{productName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getProductsBasedOnArtNameAndCustomerId(HttpServletRequest request,
			@PathVariable Long customerId, @PathVariable String productName) {
		List<Product> listOfProducts = manageOrdersService.getProductsBasedOnArtNameAndCustomerId(customerId,
				productName);
		List<ItemNameSearchResponseDTO> responseDTOList = new ArrayList<>();
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		if (nullCheckUtills.isListNullOrEmpty(listOfProducts)) {
			genericResponseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
			genericResponseDTO
					.setResponseMessage("No products found for the selected customer with the given Art name!");
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.NOT_FOUND);
		} else {
			for (Product productEntity : listOfProducts) {
				ItemNameSearchResponseDTO responseDTO = new ItemNameSearchResponseDTO();
				BeanUtils.copyProperties(productEntity, responseDTO);

				if (productEntity.getStylesMaster() != null)
					responseDTO.setProductPrice(productEntity.getStylesMaster().getStyleCost());

				String[] productImages = productService.getFrontProductImage(productEntity.getProductId());
				/**
				 * here we are getting the image from location and converting it to Base64
				 * format.
				 */
				if (productImages != null && productImages.length > 0) {
					for (String productImage : productImages) {
						File file = new File(productImage);
						if (file.exists()) {
							try {
								FileInputStream inputStream = new FileInputStream(file);
								byte[] bytes = new byte[(int) file.length()];
								inputStream.read(bytes);
								String base64encodedImage = new String(Base64.encodeBase64(bytes), "UTF-8");
								responseDTO.setArtImage(base64encodedImage);
								inputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				responseDTOList.add(responseDTO);
			}
			genericResponseDTO.setResponse(responseDTOList);
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
		}
	}

	/**
	 * Gets the colors and sizes by product id.
	 *
	 * @param productId
	 *            the product id
	 * @return the colors and sizes by product id
	 */
	@RequestMapping(value = "/products/{productId}/colors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getColorsAndSizesByProductId(@PathVariable Long productId) {
		ColorsAndSizesDTO colorsAndSizes = new ColorsAndSizesDTO();
		List<ColorsDTO> colorsDTOList = new ArrayList<>();
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		List<ProductColorsMapping> colorsList = manageOrdersService.getProductColorsByProductId(productId);
		if (nullCheckUtills.isListNullOrEmpty(colorsList)) {
			genericResponseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
			genericResponseDTO.setResponseMessage("No styles available with selected");
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO,HttpStatus.OK);
		} else {
			for (ProductColorsMapping color : colorsList) {
				ColorsDTO colorsDTO = new ColorsDTO();
				ColorsMaster colorMaster = color.getColorsMaster();
				colorsDTO.setColorId(colorMaster.getColorId());
				colorsDTO.setColorName(colorMaster.getColorName());
				colorsDTO.setColorCode(colorMaster.getColorCode());
				colorsDTOList.add(colorsDTO);
			}
			colorsAndSizes.setColorsDTO(colorsDTOList);
			genericResponseDTO.setResponse(colorsAndSizes);
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO,HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/products/{productId}/sizes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getSizesByProductId(@PathVariable Long productId) {
		ColorsAndSizesDTO colorsAndSizes = new ColorsAndSizesDTO();
		List<SizesDTO> sizesDTOList = new ArrayList<>();
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		List<SizeMaster> sizesList = manageOrdersService.getProductSizesByProductId(productId);
		if (nullCheckUtills.isListNullOrEmpty(sizesList)) {
			genericResponseDTO.setStatusCode(HttpStatus.NOT_FOUND.value());
			genericResponseDTO.setResponseMessage("No sizes available with selected product");
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO,HttpStatus.OK);
		} else {
			for (SizeMaster size : sizesList) {
				SizesDTO sizesDTO = new SizesDTO();
				sizesDTO.setSizeId(size.getSizeId());
				sizesDTO.setSizeName(size.getSizeName());
				sizesDTOList.add(sizesDTO);
			}
			colorsAndSizes.setSizesDTO(sizesDTOList);
			genericResponseDTO.setResponse(colorsAndSizes);
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO,HttpStatus.OK);
		}

	}

	/**
	 * Getting the edit Order details based on the orderId.
	 *
	 * @param orderId
	 *            the order id
	 * @return the edits the order
	 */
	@ApiOperation(value = "Editing the order", response = EditOrder.class)
	@RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> editOrderDetails(
			@ApiParam(value = "Order Id from which order will be shown from database table", required = true) @PathVariable Long orderId) {

		Orders order = manageOrdersService.getOrderDetailsByOrderId(orderId);
		EditOrder editOrder = new EditOrder();
		BeanUtils.copyProperties(order, editOrder);
		if (order.getCustomer() != null) {
			editOrder.setCustomerId(order.getCustomer().getCustomerId());
			editOrder.setCustomerName(order.getCustomer().getCustomerName());
		}

		// editOrder.setManufacturerId(order.getManufacturerId());
		// editOrder.setManufacturerid(order.getManufacturers().getManufacturerid());
		if (order.getTotalAreMaster() != null) {
			editOrder.setTotalAreId(order.getTotalAreMaster().getTotalAreId());
		}
		if (order.getCurrencyMaster() != null) {
			editOrder.setCurrencyId(order.getCurrencyMaster().getCurrencyId());
			editOrder.setCurrencyCode(order.getCurrencyMaster().getCurrencyCode());
		}
		if (order.getShippingCostMaster() != null) {
			editOrder.setShipplingCostId(order.getShippingCostMaster().getShipplingCostId());
		}
		if (order.getPriceListMaster() != null) {
			editOrder.setPriceListId(order.getPriceListMaster().getPriceListId());
		}

		if (order.getOrderAssign() != null) {
			editOrder.setOrderAssignToId(order.getOrderAssign().getOrderAssignToId());
		}

		if (order.getManufacturers() != null) {
			editOrder.setManufacturerId(order.getManufacturers().getManufactureId());
		}
		List<OrderItems> items = manageOrdersService.getOrderItemsByOrderId(orderId);
		List<ItemsDTO> listOfitemDto = new ArrayList<ItemsDTO>();
		for (OrderItems orderItems : items) {
			ItemsDTO itemsDto = new ItemsDTO();
			BeanUtils.copyProperties(orderItems, itemsDto);
			listOfitemDto.add(itemsDto);
		}
		editOrder.setItems(listOfitemDto);
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		genericResponseDTO.setResponse(editOrder);
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	/**
	 * Preview order based on the order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the order preview dto
	 */

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Autowired
	private ColorsMasterRepository colorsMasterRepository;

	@Autowired
	private SizeMasterRepository sizeMasterRepository;

	@Autowired
	private CategoryStyleMappingRepository categoryStyleMappingRepository;

	@Autowired
	private CategoryMappingRepository categoryMappingRepository;

	@Autowired
	private CategoryMasterRepository categoryMasterRepository;

	@ApiOperation(value = "Reviewing the order", response = OrderPreviewDto.class)
	@RequestMapping(value = "/orders/{orderId}/preview", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> previewOrder(
			@ApiParam(value = "orderId from which order will be displayed for order details print nad preview both ", required = true) @PathVariable Long orderId) {

		List<ColorsDTO> colorsDTOList = null;
		List<List<ColorsDTO>> colorsListDto = new ArrayList<>();
		List<SizesDTO> sizesDTOList = null;
		List<List<SizesDTO>> sizesListDto = new ArrayList<>();
		List<StyleDto> listOfStylesMaster = new ArrayList<>();
		// List<StyleDto> liststyleDto=new ArrayList<>();
		Orders order = manageOrdersService.getOrderDetailsByOrderId(orderId);
		OrderPreviewDto previewDto = new OrderPreviewDto();
		//

		Long brandId = customerRepository.getBrandIdByCustomerId(order.getCustomer().getCustomerId());
		List<StylesMaster> styleMasterList = manageOrdersService.getStylesByBrandId(brandId);
		//
		for (StylesMaster styleMaster : styleMasterList) {
			StyleDto dto = new StyleDto();
			dto.setStyleId(styleMaster.getStyleId());
			dto.setStyleName(styleMaster.getStyleName());
			listOfStylesMaster.add(dto);
		}
		previewDto.setStyleDTO(listOfStylesMaster);

		//
		BeanUtils.copyProperties(order, previewDto);

		previewDto.setOrderId(order.getOrderId());
		previewDto.setOrderStatus(order.getOrderStatus());
		previewDto.setStatus(order.isStatus());
		previewDto.setTotalDiscount(order.getTotalDiscount());
		if (order.getCustomer() != null) {
			BillingAddress billingEntity = billingAddressRepository.findByCustomer(order.getCustomer());
			if (billingEntity != null) {
				previewDto.setBillToAddress(manageOrdersService.getBillToAddressInStringFormat(billingEntity));
				previewDto.setBillToAddressName(billingEntity.getBillingAddressName());
			}
			ShippingAddress shippingEntity = shippingAddressRepository.findByCustomer(order.getCustomer());
			if (shippingEntity != null) {
				previewDto.setShipToAddress(manageOrdersService.getShippingAddressInStringFormat(shippingEntity));
				previewDto.setShipToAddressName(shippingEntity.getShippingAddressName());
			}
			previewDto.setCustomerId(order.getCustomer().getCustomerId());
			previewDto.setCustomerName(order.getCustomer().getCustomerName());
			previewDto.setCustomerStatus(order.getCustomer().isStatus());
		}

		if (order.getCurrencyMaster() != null) {
			previewDto.setCurrencyId(order.getCurrencyMaster().getCurrencyId());
			previewDto.setCurrencyName(order.getCurrencyMaster().getCurrencyName());
			previewDto.setCurrencyCode(order.getCurrencyMaster().getCurrencyCode());
		}

		if (order.getTotalAreMaster() != null) {
			previewDto.setTotalAreId(order.getTotalAreMaster().getTotalAreId());
			previewDto.setTotalAre(order.getTotalAreMaster().getTotalAreName());
		}
		if (order.getShippingCostMaster() != null) {
			previewDto.setShipplingCostId(order.getShippingCostMaster().getShipplingCostId());
			previewDto.setShippingCostName(order.getShippingCostMaster().getShippingCostName());
		}
		if (order.getOrderAssign() != null) {
			previewDto.setAssignToId(order.getOrderAssign().getOrderAssignToId());
			previewDto.setAssignedTo(order.getOrderAssign().getAssignedTo());
		}
		if (order.getManufacturers() != null) {
			ShippingAddress shippingEntity = shippingAddressRepository.findByManufacturers(order.getManufacturers());
			if (shippingEntity != null) {
				previewDto.setShipFromAddress(manageOrdersService.getShippingAddressInStringFormat(shippingEntity));
				previewDto.setShipFromAddressName(shippingEntity.getShippingAddressName());
			}
			previewDto.setManufacturerId(order.getManufacturers().getManufactureId());
			previewDto.setManufacturerName(order.getManufacturers().getManufacturerName());
		}
		if (order.getPriceListMaster() != null) {
			previewDto.setPriceListId(order.getPriceListMaster().getPriceListId());
			previewDto.setPriceListName(order.getPriceListMaster().getPriceListName());
		}
		previewDto.setTotalUnits(order.getTotalUnits());
		List<OrderItems> items = manageOrdersService.getOrderItemsByOrderId(orderId);
		List<ItemsDTO> listOfitemDto = new ArrayList<ItemsDTO>();
		for (OrderItems orderItems : items) {
			ItemsDTO itemsDto = new ItemsDTO();
			Long categoryStyMappingId = categoryStyleMappingRepository
					.getCategoryMapingId(orderItems.getStyleMaster().getStyleId());
			Long categoryMappingId = categoryMappingRepository.getCategoriesId(categoryStyMappingId);
			String categoryName = categoryMasterRepository.getCategoriesNameById(categoryMappingId);
			// CategoryMaster categoryMaster =
			// styleMasterRepository.getCategoryNameByStyleId(orderItems.getStyleMaster().getStyleId());
			itemsDto.setCategoryName(categoryName);

			List<ProductColorsMapping> colorsList = manageOrdersService
					.getProductColorsByProductId(orderItems.getProduct().getProductId());
			colorsDTOList = new ArrayList<>();

			for (ProductColorsMapping color : colorsList) {
				ColorsDTO colorsDTO = new ColorsDTO();
				ColorsMaster colorMaster = color.getColorsMaster();
				colorsDTO.setColorId(colorMaster.getColorId());
				colorsDTO.setColorName(colorMaster.getColorName());
				colorsDTO.setColorCode(colorMaster.getColorCode());
				colorsDTOList.add(colorsDTO);
				colorsListDto.add(colorsDTOList);
			}
			previewDto.setColorDTO(colorsListDto);
			List<SizeMaster> sizesList = manageOrdersService
					.getProductSizesByProductId(orderItems.getProduct().getProductId());
			sizesDTOList = new ArrayList<>();
			for (SizeMaster size : sizesList) {
				SizesDTO sizesDTO = new SizesDTO();
				sizesDTO.setSizeId(size.getSizeId());
				sizesDTO.setSizeName(size.getSizeName());
				sizesDTOList.add(sizesDTO);
				sizesListDto.add(sizesDTOList);
			}
			previewDto.setSizeDTO(sizesListDto);

			/*
			 * List<Product> product =
			 * productRepository.getStyleIdFromProduct(orderItems.getProduct().getProductId(
			 * )); for (Product products : product) { StyleDto dto = new StyleDto();
			 * dto.setStyleId(products.getStylesMaster().getStyleId());
			 * dto.setStyleNo(products.getStylesMaster().getStyleNo());
			 * dto.setStyleName(products.getStylesMaster().getStyleName());
			 * listOfStylesMaster.add(dto); }
			 */
			Long colorId = orderItemsRepository.getColorId(orderId, orderItems.getOrderItemId());
			Long sizeId = orderItemsRepository.getSizeId(orderId, orderItems.getOrderItemId());
			/*
			 * List<OrderItems> listOfOrders=orderItemsRepository.getOrderIds(orderId);
			 * if(listOfOrders!=null) { orderItemsRepository.deleteFromOrderItems(orderId);
			 * }
			 */
			Long styleId = orderItemsRepository.getStyleId(orderId, orderItems.getOrderItemId());
			if (colorId != null) {
				String colorName = colorsMasterRepository.getColorNameByColorId(colorId);
				itemsDto.setColorName(colorName);
			}
			if (sizeId != null) {
				String sizeName = sizeMasterRepository.getSizeNameBySizeId(sizeId);
				itemsDto.setSizeName(sizeName);
			}
			if (styleId != null) {
				String styleName = styleMasterRepository.getStyleNameByStyleId(styleId, MessageConstants.DELETE_STATUS);
				itemsDto.setStyleName(styleName);
			}
			BeanUtils.copyProperties(orderItems, itemsDto);

			itemsDto.setSizeId(orderItemsRepository.getSizeId(orderId, orderItems.getOrderItemId()));
			itemsDto.setColorId(orderItemsRepository.getColorId(orderId, orderItems.getOrderItemId()));
			itemsDto.setStyleId(orderItemsRepository.getStyleId(orderId, orderItems.getOrderItemId()));

			if (orderItems.getProduct() != null) {
				itemsDto.setItemId(orderItems.getProduct().getProductId());
				String[] productImages = productService.getFrontProductImage(orderItems.getProduct().getProductId());

				/**
				 * here we are getting the image from location and converting it to Base64
				 * format.
				 */
				if (productImages != null && productImages.length > 0) {
					for (String productImage : productImages) {
						File file = new File(productImage);
						if (file.exists()) {
							try {
								FileInputStream inputStream = new FileInputStream(file);
								byte[] bytes = new byte[(int) file.length()];
								inputStream.read(bytes);
								String base64encodedImage = new String(Base64.encodeBase64(bytes), "UTF-8");
								itemsDto.setArtImage(base64encodedImage);
								inputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			// previewDto.setStyleDTO(listOfStylesMaster);
			listOfitemDto.add(itemsDto);
		}
		previewDto.setItems(listOfitemDto);
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setResponse(previewDto);
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	/**
	 * Finalize order based on OrderId once finalized order cannot be changed again.
	 *
	 * @param orderId
	 *            the order id
	 * @return true, if successful
	 */
	@ApiOperation(value = "Finalizing the order", response = Boolean.class)
	@RequestMapping(value = "/orders/{orderId}/finalize", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> finalizeOrder(
			@ApiParam(value = "orderId from which order will be FINALIZED for ordering ", required = true) @PathVariable Long orderId) {
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		try {
			manageOrdersService.finalizeOrder(orderId);
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			genericResponseDTO.setResponseMessage("Order finalized succesfully!");
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
		} catch (Exception exception) {
			genericResponseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			genericResponseDTO.setErrorMessage("Something went wrong while accesing request please try again!");
			genericResponseDTO.setErrorDiscription(exception.toString());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the paypal credentials.
	 *
	 * @return the paypal credentials
	 */
	@RequestMapping(value = "/orders/getPaypalCredentials", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> getPaypalCredentials() {
		PaypalCredentialsDto paypalCredentialsDto = new PaypalCredentialsDto();
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		try {
			List<PaypalCredentialsEntity> listOfpaypalCredentials = paypalCredentialsRepository.findAll();
			for (PaypalCredentialsEntity paypalCredentialsEntity : listOfpaypalCredentials) {
				paypalCredentialsDto.setClient_id(paypalCredentialsEntity.getClientId());
			}
			genericResponseDTO.setResponse(paypalCredentialsDto);
			genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		} catch (Exception exception) {
			exception.printStackTrace();
			genericResponseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			genericResponseDTO.setErrorMessage("Something went wrong while fetching records");
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/checkTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> accessTokenAndTransactionId(
			@RequestBody PaypalRequestDto paypalRequestDto) {
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		PaypalCredentialsDto paypalCredentialsDto = new PaypalCredentialsDto();
		try {
			List<PaypalCredentialsEntity> listOfpaypalCredentials = paypalCredentialsRepository.findAll();
			for (PaypalCredentialsEntity paypalCredentialsEntity : listOfpaypalCredentials) {
				paypalCredentialsDto.setClient_id(paypalCredentialsEntity.getClientId());
				paypalCredentialsDto.setClient_secret(paypalCredentialsEntity.getClientSecret());
			}
			String s = "";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			String plainCreds = paypalCredentialsDto.getClient_id() + ":" + paypalCredentialsDto.getClient_secret();
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			headers.add("Authorization", "Basic " + base64Creds);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

			map.add("client_id", paypalCredentialsDto.getClient_id());
			map.add("client_secret", paypalCredentialsDto.getClient_secret());
			map.add("grant_type", "client_credentials");
			map.add("username", paypalCredentialsDto.getClient_id());
			map.add("password", paypalCredentialsDto.getClient_secret());
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
					headers);
			String urlForAccessToken = "https://api.sandbox.paypal.com/v1/oauth2/token";
			ResponseEntity<String> result = template.postForEntity(urlForAccessToken, request, String.class);
			System.out.println(result);
			JSONObject jsonOBjedct = new JSONObject(result.getBody());
			Iterator<?> keys = jsonOBjedct.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				if (key.contains("access_token")) {
					s = (String) (jsonOBjedct.get(key));
				}
			}
			System.out.println(s);
			String surl = paypalRequestDto.getUrl();
			String[] array = surl.split("/");
			for (int a = 0; a < array.length; a++) {
				System.out.println(a);
				System.out.println(array[a]);
			}
			String redrwanUrl = array[0] + "//" + array[2] + "/" + array[3] + "/" + array[4] + "/" + array[5] + "/{id}";
			System.out.println();
			String finalUrl = redrwanUrl;
			HttpHeaders header2 = new HttpHeaders();
			header2.add("Authorization", "Bearer " + s);
			header2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			header2.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> entity = new HttpEntity<>(header2);
			Map<String, String> params2 = new HashMap<String, String>();
			params2.put("id", array[6]);
			ResponseEntity<String> body2 = template.exchange(finalUrl, HttpMethod.GET, entity, String.class, params2);
			System.out.println("Orders Details--->" + body2.getBody());
			System.out.println(result);
			String responseBody = "";
			JSONObject jsonOREsponse = new JSONObject(body2.getBody());
			Iterator<?> keys1 = jsonOREsponse.keys();
			while (keys1.hasNext()) {
				String key = (String) keys1.next();
				if (key.contains("id")) {
					responseBody = (String) (jsonOREsponse.get(key));
				}
			}
			System.out.println(responseBody);
			if (responseBody.equals(array[6]) && paypalRequestDto.getStatus().equals("COMPLETED")) {
				genericResponseDTO.setResponseMessage("Transaction is " + paypalRequestDto.getStatus().toLowerCase());
				genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			} else if (responseBody.equals(array[6]) && paypalRequestDto.getStatus().equals("PENDING")) {
				genericResponseDTO.setResponseMessage("Transaction is " + paypalRequestDto.getStatus().toLowerCase());
				genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			} else {
				genericResponseDTO.setResponseMessage("Transaction is " + paypalRequestDto.getStatus().toLowerCase());
				genericResponseDTO.setStatusCode(HttpStatus.OK.value());
			}
			Orders orders = ordersRepository.findOne(paypalRequestDto.getOrderId());
			PaymentsEntity entitys = new PaymentsEntity();
			entitys.setTransactionId(array[6]);
			entitys.setOrders(orders);
			entitys.setPaymentDate(new Date());
			entitys.setFundingSource(paypalRequestDto.getFundingSource());
			PaymentsEntity paymentsEntity = paymentRepository.saveAndFlush(entitys);
			ordersRepository.updateOrderForPaymentsStatusByOrderId(MessageConstants.PAYMENT_STATUS_PAID,
					MessageConstants.PAYMENT_STATUS_PAID, paypalRequestDto.getOrderId());
			if (paymentsEntity != null) {
				return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
			}
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
		} catch (Exception exception) {
			exception.printStackTrace();
			genericResponseDTO.setResponseMessage("Something went wrong in the request");
			genericResponseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Finalize order based on OrderId once finalized order cannot be changed again.
	 *
	 * @param orderId
	 *            the order id
	 * @return true, if successful
	 * @throws MessagingException
	 *             the messaging exception
	 */
	@ApiOperation(value = "Sending an email of the order", response = Boolean.class)
	@RequestMapping(value = "/orders/{orderId}/email", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> emailOrder(
			@ApiParam(value = "orderId from which order will be FINALIZED for ordering ", required = true) @PathVariable Long orderId)
			throws MessagingException {
		Orders order = manageOrdersService.getOrderDetailsByOrderId(orderId);
		String htmlText = "";
		emailSenderService.sendMail(order.getEmail(), OrderStatusEnum.ORDER_CONFIRMATION.status(), "", null);
		EmailSettingsDTO emailSettings = new EmailSettingsDTO();
		emailSettings.setAlertType(UUID.randomUUID().toString());
		emailSettings.setCreatedBy(System.getProperty("user.name"));
		emailSettings.setCreatedOn(new Date());
		emailSettings.setEmailBody(htmlText);
		emailSettings.setSendTo(order.getEmail());
		emailSettings.setStatus(true);
		emailSettings.setSubject(OrderStatusEnum.ORDER_CONFIRMATION.status());
		manageOrdersService.saveEmailDetails(emailSettings);
		GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatusCode(HttpStatus.OK.value());
		genericResponseDTO.setResponseMessage(MessageConstants.ORDER_EMAIL_SUCCESS_MESSAGE);
		return new ResponseEntity<GenericResponseDTO>(genericResponseDTO, HttpStatus.OK);
	}

	@Autowired
	private ManufacturersApiCredentialsRepository manufacturersApiCredentialsRepository;

	/*
	 * @RequestMapping(value = "/orders/{orderId}/email", method =
	 * RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<GenericResponseDTO> pushOrders(SaveOrderDTO saveOrderDto)
	 * throws Exception { GenericResponseDTO genericResponseDTO=new
	 * GenericResponseDTO(); Long manufactureId=saveOrderDto.getManufacturerId();
	 * ManufacturersApiCredentials
	 * manufacturersApiCredentials=manufacturersApiCredentialsRepository.
	 * LCredentials(manufactureId, MessageConstants.DELETE_STATUS); String s =
	 * ""; RestTemplate template = new RestTemplate(); HttpHeaders headers = new
	 * HttpHeaders(); headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	 * MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
	 * String>();
	 * 
	 * map.add("client_id",manufacturersApiCredentials.getClientId());
	 * map.add("client_secret",manufacturersApiCredentials.getClientSecret());
	 * map.add("grant_type", manufacturersApiCredentials.getGrantType());
	 * map.add("username",manufacturersApiCredentials.getUserName());
	 * map.add("password", manufacturersApiCredentials.getPassword());
	 * HttpEntity<MultiValueMap<String, String>> request = new
	 * HttpEntity<MultiValueMap<String, String>>(map, headers); String url =
	 * "https://t6apidevelopment.azurewebsites.net/oauth/token";
	 * ResponseEntity<String> result = template.postForEntity(url, request,
	 * String.class); System.out.println("ACCESS TOKEN--->"+result.getBody());
	 * JSONObject jsonOBjedct = new JSONObject(result.getBody()); Iterator<?> keys =
	 * jsonOBjedct.keys(); while (keys.hasNext()) { String key = (String)
	 * keys.next(); if (key.contains("access_token")) { s = (String)
	 * (jsonOBjedct.get(key)); } } String url3 =
	 * "https://t6apidevelopment.azurewebsites.net/api/Order/GetOrderStatus/{id}";
	 * HttpHeaders header2 = new HttpHeaders(); header2.add("Authorization",
	 * "Bearer " + s); header2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * header2.setContentType(MediaType.APPLICATION_JSON); HttpEntity<Object> entity
	 * = new HttpEntity<>(header2); Map<String, String> params2 = new
	 * HashMap<String, String>(); params2.put("id", "384620");
	 * 
	 * // UriComponentsBuilder builder = //
	 * UriComponentsBuilder.fromUriString(url2).queryParam("id", 2);
	 * ResponseEntity<String> body2 = template.exchange(url3, HttpMethod.GET,
	 * entity, String.class, params2); // String bodys =template.getForObject(url2,
	 * String.class, variables);
	 * System.out.println("Orders Details--->"+body2.getBody()); dfdggdg return
	 * null; }
	 */

}
