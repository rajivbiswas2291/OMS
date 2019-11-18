package com.msr.oms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msr.admin.dto.StyleDto;
import com.msr.admin.utils.RoleContanstsEnum;
import com.msr.oms.dto.EmailSettingsDTO;
import com.msr.oms.dto.ItemsDTO;
import com.msr.oms.dto.SaveOrderDTO;
import com.msr.oms.entity.BillingAddress;
import com.msr.oms.entity.CurrencyMaster;
import com.msr.oms.entity.Customer;
import com.msr.oms.entity.EmailSettings;
import com.msr.oms.entity.Manufacturers;
import com.msr.oms.entity.OrderAssign;
import com.msr.oms.entity.OrderItems;
import com.msr.oms.entity.Orders;
import com.msr.oms.entity.PriceListMaster;
import com.msr.oms.entity.ShippingAddress;
import com.msr.oms.entity.ShippingCostMaster;
import com.msr.oms.entity.TotalAreMaster;
import com.msr.oms.repository.CurrencyMasterRepository;
import com.msr.oms.repository.CustomerRepository;
import com.msr.oms.repository.EmailSettingsRepository;
import com.msr.oms.repository.ManufacturersRepository;
import com.msr.oms.repository.OrderAssignRepository;
import com.msr.oms.repository.OrderItemsRepository;
import com.msr.oms.repository.OrdersRepository;
import com.msr.oms.repository.PriceListMasterRepository;
import com.msr.oms.repository.ShippingCostMasterRepository;
import com.msr.oms.repository.TotalAreMasterRepository;
import com.msr.oms.service.ManageOrdersService;
import com.msr.oms.utils.OrderStatusEnum;
import com.msr.onboard.repository.BillingAddressRepository;
import com.msr.onboard.repository.ShippingAddressRepository;
import com.msr.product.dto.ColorsDTO;
import com.msr.product.dto.SizesDTO;
import com.msr.product.entity.CategoryMaster;
import com.msr.product.entity.ColorsMaster;
import com.msr.product.entity.ManufacturerTypesMaster;
import com.msr.product.entity.Product;
import com.msr.product.entity.ProductColorsMapping;
import com.msr.product.entity.SizeMaster;
import com.msr.product.entity.StylesMaster;
import com.msr.product.repository.CategoryMappingRepository;
import com.msr.product.repository.CategoryMasterRepository;
import com.msr.product.repository.CategoryStyleMappingRepository;
import com.msr.product.repository.ColorsMasterRepository;
import com.msr.product.repository.ManufacturerRepository;
import com.msr.product.repository.ProductColorMappingReopsitory;
import com.msr.product.repository.ProductImagesRepository;
import com.msr.product.repository.ProductRepository;
import com.msr.product.repository.SizeMasterRepository;
import com.msr.product.repository.StyleMasterRepository;
import com.msr.product.utills.MessageConstants;
import com.msr.security.jwt.configuration.JWTTokenProvider;
import com.msr.security.user.repository.RoleMasterRepository;

// TODO: Auto-generated Javadoc
/**
 * the class ManageOrdersServiceImpl. this class is used to perform
 * create/edit/delete orders.
 * 
 * @author vamshib
 */
@Service
@Transactional
public class ManageOrdersServiceImpl implements ManageOrdersService {

	/** The orders repository. */
	@Autowired
	private OrdersRepository ordersRepository;

	/** The order items repository. */
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	/** The currency master repository. */
	@Autowired
	private CurrencyMasterRepository currencyMasterRepository;

	/** The currency master repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/** The price list master repository. */
	@Autowired
	private PriceListMasterRepository priceListMasterRepository;

	/** The shipping cost master repository. */
	@Autowired
	private ShippingCostMasterRepository shippingCostMasterRepository;

	/** The total are master repository. */
	@Autowired
	private TotalAreMasterRepository totalAreMasterRepository;

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/** The manufacturer repository. */
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	/** The order assign repository. */
	@Autowired
	private OrderAssignRepository orderAssignRepository;

	/** The email settings repository. */
	@Autowired
	private EmailSettingsRepository emailSettingsRepository;

	/** The manufacturers repository. */
	@Autowired
	private ManufacturersRepository manufacturersRepository;

	/** The style master repository. */
	@Autowired
	private StyleMasterRepository styleMasterRepository;

	/** The product images repository. */
	@Autowired
	private ProductImagesRepository productImagesRepository;

	/** The product size mapping repository. */
	@Autowired
	private SizeMasterRepository sizeMasterRepository;

	/** The product color mapping reopsitory. */
	@Autowired
	private ProductColorMappingReopsitory productColorMappingReopsitory;

	/** The colors master. */
	@Autowired
	private ColorsMasterRepository colorsMasterRepository;

	/** The role master repository. */
	@Autowired
	private RoleMasterRepository roleMasterRepository;

	/** The token provider. */
	@Autowired
	private JWTTokenProvider tokenProvider;

	/** The billing address repository. */
	@Autowired
	private BillingAddressRepository billingAddressRepository;

	/** The shipping address repository. */
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;

	/**
	 * Gets the all orders.
	 *
	 * @param email
	 *            the email
	 * @return the all orders
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lgndu.oms.service.ManageOrdersService#getAllOrders()
	 */
	@Override
	public List<Orders> getAllOrders(String email) {
		String roleName = roleMasterRepository.getRoleByUserName(email);

		if (RoleContanstsEnum.BRAND_ADMIN.role().equals(roleName)) {
			return ordersRepository.getAllOrdersByCustomerEmail(MessageConstants.DELETE_STATUS, email);
		} else if (RoleContanstsEnum.MANUFACTURER_ADMIN.role().equals(roleName)) {
			return ordersRepository.getAllOrdersByManufacturerEmail(MessageConstants.DELETE_STATUS, email);
		} else {
			return ordersRepository.getAllOrders(MessageConstants.DELETE_STATUS);
		}
	}

	/**
	 * Gets the orders by order status.
	 *
	 * @param orderStatus
	 *            the order status
	 * @param email
	 *            the email
	 * @return the orders by order status
	 */
	@Override
	public List<Orders> getOrdersByOrderStatus(String orderStatus, String email) {
		String roleName = roleMasterRepository.getRoleByUserName(email);
		if (RoleContanstsEnum.BRAND_ADMIN.role().equals(roleName)) {
			return ordersRepository.getAllOrdersByCustomerEmailAndOrderStatus(orderStatus, email);
		} else if (RoleContanstsEnum.MANUFACTURER_ADMIN.role().equals(roleName)) {
			return ordersRepository.getAllOrdersByManufacturerEmailAndOrderStatus(orderStatus, email
					);
		}/* else if (RoleContanstsEnum.BRAND_ADMIN.role().equals(roleName) && orderStatus.equals("ACTIVE")) {
			return ordersRepository.getAllOrdersByManufacturerEmailAndOrderStatus(orderStatus, email
					);
		} else if (RoleContanstsEnum.MANUFACTURER_ADMIN.role().equals(roleName) && orderStatus.equals("ACTIVE")) {
			return ordersRepository.getAllOrdersByManufacturerEmailAndOrderStatus(orderStatus, email
					);
		}
		else if(orderStatus.equals("ACTIVE")) {
			return ordersRepository.findByOrderStatusAndPaymentStatus(orderStatus,
					MessageConstants.PAYMENT_STATUS_UNPAID);
		}*/
		else {
			return ordersRepository.findByOrderStatus(orderStatus);
		}
	}

	@Override
	public List<Orders> getOrdersByOrderPaymentStatus(String orderStatus, String email) {
		String roleName = roleMasterRepository.getRoleByUserName(email);
		if (RoleContanstsEnum.BRAND_ADMIN.role().equals(roleName)) {
			return ordersRepository
					.getAllOrdersByCustomerEmailAndOrderPaymentsStatus(MessageConstants.PAYMENT_STATUS_PAID, email);
		} else if (RoleContanstsEnum.MANUFACTURER_ADMIN.role().equals(roleName)) {
			return ordersRepository
					.getAllOrdersByManufacturerEmailAndOrderPaymentsStatus(MessageConstants.PAYMENT_STATUS_PAID, email);
		} else {
			return ordersRepository.getAllPaidOrdersByPaymentStatus(MessageConstants.PAYMENT_STATUS_PAID);
		}
	}

	/**
	 * Creates the new sales order.
	 *
	 * @param saveOrderDTO
	 *            the save order DTO
	 * @return the response entity
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lgndu.oms.service.ManageOrdersService#createNewSalesOrder(com.lgndu.oms.
	 * dto.SaveOrderDTO)
	 */
	@Autowired
	private CategoryStyleMappingRepository categoryStyleMappingRepository;

	@Autowired
	private CategoryMappingRepository categoryMappingRepository;

	@Autowired
	private CategoryMasterRepository categoryMasterRepository;

	@Override
	public ResponseEntity<SaveOrderDTO> createNewSalesOrder(SaveOrderDTO saveOrderDTO) {
		List<ColorsDTO> colorsDTOList = new ArrayList<>();
		List<SizesDTO> sizesDTOList = new ArrayList<>();
		List<List<ColorsDTO>> colorsListDto = null;
		List<List<SizesDTO>> sizesListDto = null;
		List<StyleDto> listOfStylesMaster = new ArrayList<>();
		// Long
		// brandId=customerRepository.getBrandIdByCustomerId(saveOrderDTO.getCustomerId());
		// List<StylesMaster> styleMasterList = this.getStylesByBrandId(brandId);

		try {
			Orders order = new Orders();
			CurrencyMaster currencyMaster = null;
			TotalAreMaster totalAreMaster = null;
			OrderAssign orderAssign = null;
			Customer customer = null;
			Manufacturers manufacturers = null;
			Long brandId = customerRepository.getBrandIdByCustomerId(saveOrderDTO.getCustomerId());
			List<StylesMaster> styleMasterList = this.getStylesByBrandId(brandId);
			//
			for (StylesMaster styleMaster : styleMasterList) {
				StyleDto dto = new StyleDto();
				dto.setStyleId(styleMaster.getStyleId());
				dto.setStyleName(styleMaster.getStyleName());
				listOfStylesMaster.add(dto);
			}
			saveOrderDTO.setStyleDTO(listOfStylesMaster);
			//
			BeanUtils.copyProperties(saveOrderDTO, order);
			if (saveOrderDTO.getCurrencyId() != null) {
				currencyMaster = currencyMasterRepository.findOne(saveOrderDTO.getCurrencyId());
			}
			if (saveOrderDTO.getTotalAreId() != null) {
				totalAreMaster = totalAreMasterRepository.findOne(saveOrderDTO.getTotalAreId());
			}
			if (saveOrderDTO.getAssignToId() != null) {
				orderAssign = orderAssignRepository.findOne(saveOrderDTO.getAssignToId());
				order.setCurrencyMaster(currencyMaster);
			}
			if (saveOrderDTO.getCustomerId() != null) {
				customer = customerRepository.findOne(saveOrderDTO.getCustomerId());
				order.setCustomer(customerRepository.findOne(saveOrderDTO.getCustomerId()));
			}
			if (saveOrderDTO.getPriceListId() != null) {
				order.setPriceListMaster(priceListMasterRepository.findOne(saveOrderDTO.getPriceListId()));
			}
			if (saveOrderDTO.getShipplingCostId() != null) {
				order.setShippingCostMaster(shippingCostMasterRepository.findOne(saveOrderDTO.getShipplingCostId()));
			}
			if (saveOrderDTO.getManufacturerId() != null) {
				manufacturers = manufacturersRepository.findOne(saveOrderDTO.getManufacturerId());
				order.setManufacturers(manufacturers);
			}
			if (saveOrderDTO.getOrderId() == null) {
				String createsalesOrderId = generateSalesOrderId();
				saveOrderDTO.setSaleOrderId(createsalesOrderId);
				order.setSaleOrderId(createsalesOrderId);
			} else {
				/**
				 * this is for updating the cart while upadting the order.
				 */
				System.err.println("OrderID>>>>>>>>>>>>>>  " + saveOrderDTO.getOrderId());
				orderItemsRepository.deleteOrderItemsByOrderId(saveOrderDTO.getOrderId());
			}
			order.setTotalAreMaster(totalAreMaster);
			order.setOrderAssign(orderAssign);
			order.setStatus(MessageConstants.CREATE_STATUS);
			order.setOrderStatus(OrderStatusEnum.ORDER_ACTIVE.status());
			order.setCreatedBy(System.getProperty("user.name"));
			order.setCreatedOn(new Date());
			order.setPaymentStatus(MessageConstants.PAYMENT_STATUS_UNPAID);
			order = ordersRepository.saveAndFlush(order);
			/*
			 * List<OrderItems>
			 * listOfOrders=orderItemsRepository.getOrderIds(order.getOrderId());
			 * if(listOfOrders!=null) {
			 * orderItemsRepository.deleteFromOrderItems(order.getOrderId()); }
			 */
			for (ItemsDTO itemDTO : saveOrderDTO.getItems()) {
				OrderItems orderItems = new OrderItems();

				BeanUtils.copyProperties(itemDTO, orderItems);
				orderItems.setOrders(order);
				orderItems.setCreatedBy(System.getProperty("user.name"));
				orderItems.setCreatedOn(new Date());

				if (itemDTO.getStyleId() != null)
					orderItems.setStyleMaster(styleMasterRepository.findOne(itemDTO.getStyleId()));

				Long categoryStyMappingId = categoryStyleMappingRepository.getCategoryMapingId(itemDTO.getStyleId());
				Long categoryMappingId = categoryMappingRepository.getCategoriesId(categoryStyMappingId);
				String categoryName = categoryMasterRepository.getCategoriesNameById(categoryMappingId);

				// CategoryMaster categoryMaster =
				// styleMasterRepository.getCategoryNameByStyleId(itemDTO.getStyleId());
				itemDTO.setCategoryName(categoryName);
				// itemDTO.setCategoryId(categoryMaster.getCategoryId());
				if (itemDTO.getSizeId() != null)
					orderItems.setSizeMaster(sizeMasterRepository.findOne(itemDTO.getSizeId()));

				if (itemDTO.getColorId() != null)
					orderItems.setColorsMaster(colorsMasterRepository.findOne(itemDTO.getColorId()));
				Product product = productRepository.findOne(itemDTO.getItemId());
				orderItems.setProduct(productRepository.findOne(itemDTO.getItemId()));
				OrderItems orderitems = orderItemsRepository.saveAndFlush(orderItems);

				//
				if (orderitems.getProduct().getProductId() != null) {
					colorsListDto = new ArrayList<>();
					sizesListDto = new ArrayList<>();
					List<ProductColorsMapping> colorsList = this
							.getProductColorsByProductId(orderitems.getProduct().getProductId());
					for (ProductColorsMapping color : colorsList) {
						ColorsDTO colorsDTO = new ColorsDTO();
						ColorsMaster colorMaster = color.getColorsMaster();
						colorsDTO.setColorId(colorMaster.getColorId());
						colorsDTO.setColorName(colorMaster.getColorName());
						colorsDTO.setColorCode(colorMaster.getColorCode());
						colorsDTOList.add(colorsDTO);
						colorsListDto.add(colorsDTOList);
					}
					saveOrderDTO.setColorDTO(colorsListDto);

					List<SizeMaster> sizesList = this
							.getProductSizesByProductId(orderitems.getProduct().getProductId());
					for (SizeMaster size : sizesList) {
						SizesDTO sizesDTO = new SizesDTO();
						sizesDTO.setSizeId(size.getSizeId());
						sizesDTO.setSizeName(size.getSizeName());
						sizesDTOList.add(sizesDTO);
						sizesListDto.add(sizesDTOList);

					}
					saveOrderDTO.setSizeDTO(sizesListDto);
				}
				/*
				 * List<Product> product =
				 * productRepository.getStyleIdFromProduct(orderitems.getProduct().getProductId(
				 * )); for (Product products : product) { StyleDto dto = new StyleDto();
				 * dto.setStyleId(products.getStylesMaster().getStyleId());
				 * dto.setStyleNo(products.getStylesMaster().getStyleNo());
				 * dto.setStyleName(products.getStylesMaster().getStyleName());
				 * listOfStylesMaster.add(dto); } saveOrderDTO.setStyleDTO(listOfStylesMaster);
				 */
				//

			}
			if (customer != null) {
				BillingAddress billingEntity = billingAddressRepository.findByCustomer(customer);
				if (billingEntity != null) {
					saveOrderDTO.setBillToAddress(this.getBillToAddressInStringFormat(billingEntity));
					saveOrderDTO.setBillToAddressName(billingEntity.getBillingAddressName());
				}
				ShippingAddress shippingEntity = shippingAddressRepository.findByCustomer(customer);
				if (shippingEntity != null) {
					saveOrderDTO.setShipToAddress(this.getShippingAddressInStringFormat(shippingEntity));
					saveOrderDTO.setShipToAddressName(shippingEntity.getShippingAddressName());
				}
			}
			if (manufacturers != null) {
				ShippingAddress shippingEntity = shippingAddressRepository.findByManufacturers(manufacturers);
				saveOrderDTO.setShipFromAddress(this.getShippingAddressInStringFormat(shippingEntity));
				saveOrderDTO.setShipFromAddressName(shippingEntity.getShippingAddressName());
			}
			saveOrderDTO.setCurrencyName(currencyMaster.getCurrencyName());
			saveOrderDTO.setTotalAre(totalAreMaster.getTotalAreName());
			saveOrderDTO.setOrderId(order.getOrderId());
			saveOrderDTO.setAssignedTo(orderAssign.getAssignedTo());
			saveOrderDTO.setCustomerName(customer.getCustomerName());
			saveOrderDTO.setCurrencyCode(currencyMaster.getCurrencyCode());
			return new ResponseEntity<SaveOrderDTO>(saveOrderDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<SaveOrderDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * this method is responsible for generating Sales Order Id in the format of
	 * SO0001.
	 * 
	 * @return the sales order id
	 */
	public String generateSalesOrderId() {
		Long salesOrderId = ordersRepository.getMaxSaleOrderId();
		String createSalesOrderId = "";
		if (salesOrderId == null) {
			createSalesOrderId = MessageConstants.SALES_ORDER_ID;
		} else {
			salesOrderId = salesOrderId + 1;
			if (salesOrderId < 10) {
				createSalesOrderId = "SO000" + salesOrderId;
			} else if (salesOrderId < 100) {
				createSalesOrderId = "SO00" + salesOrderId;
			} else if (salesOrderId < 1000) {
				createSalesOrderId = "SO0" + salesOrderId;
			} else {
				createSalesOrderId = "SO" + salesOrderId;
			}
		}
		return createSalesOrderId;
	}

	/**
	 * Delete order by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return true, if successful
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lgndu.oms.service.ManageOrdersService#deleteOrderByOrderId(java.lang.
	 * Long)
	 */
	@Override
	public boolean deleteOrderByOrderId(Long orderId) {
		try {
			ordersRepository.deleteOrderByOrderId(MessageConstants.DELETE_STATUS, OrderStatusEnum.ORDER_DELETE.status(),
					orderId);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * Gets the products based on art name.
	 *
	 * @param customerId
	 *            the customer id
	 * @param productArtName
	 *            the product art name
	 * @return the products based on art name
	 */
	@Override
	public List<Product> getProductsBasedOnArtNameAndCustomerId(Long customerId, String productArtName) {
		return productRepository.getProductsBasedOnArtNameAndCustomerId(customerId, productArtName);
	}

	/**
	 * Gets the all customers.
	 *
	 * @param jwtToken
	 *            the jwt token
	 * @return the all customers
	 */
	@Override
	public List<Customer> getAllCustomers(String jwtToken) {
		jwtToken = jwtToken.replace("Bearer ", "");
		String jwtIdToken = tokenProvider.getIDTokenFromJwtToken(jwtToken);
		String roleName = roleMasterRepository.getRoleByUserName(jwtIdToken);
		if (RoleContanstsEnum.BRAND_ADMIN.role().equals(roleName)) {
			List<Customer> customers = new ArrayList<>();
			customers.add(customerRepository.findByCompanyEmail(jwtIdToken));
			return customers;
		} else {
			return customerRepository.getAllBrandsByStatus(MessageConstants.DELETE_STATUS);
		}
	}

	/**
	 * Gets the all manufacturer types.
	 *
	 * @return the all manufacturer types
	 */
	@Override
	public List<ManufacturerTypesMaster> getAllManufacturerTypes() {
		return manufacturerRepository.findAll();
	}

	/**
	 * Gets the all currencies.
	 *
	 * @return the all currencies
	 */
	@Override
	public List<CurrencyMaster> getAllCurrencies() {
		return currencyMasterRepository.findAll();
	}

	/**
	 * Gets the all price lists.
	 *
	 * @return the all price lists
	 */
	@Override
	public List<PriceListMaster> getAllPriceLists() {
		return priceListMasterRepository.findAll();
	}

	/**
	 * Gets the all total are master.
	 *
	 * @return the all total are master
	 */
	@Override
	public List<TotalAreMaster> getAllTotalAreMaster() {
		return totalAreMasterRepository.findAll();
	}

	/**
	 * Gets the all shipping costs.
	 *
	 * @return the all shipping costs
	 */
	@Override
	public List<ShippingCostMaster> getAllShippingCosts() {
		return shippingCostMasterRepository.findAll();
	}

	/**
	 * Gets the assignees.
	 *
	 * @return the assignees
	 */
	@Override
	public List<OrderAssign> getAssignees() {
		return orderAssignRepository.findAll();
	}

	/**
	 * Gets the manufacturers.
	 *
	 * @return the manufacturers
	 */
	@Override
	public List<Manufacturers> getManufacturers() {
		return manufacturersRepository.getAllBrandsByStatus(MessageConstants.DELETE_STATUS);
	}

	/**
	 * Gets the order details by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the order details by order id
	 */
	@Override
	public Orders getOrderDetailsByOrderId(Long orderId) {
		return ordersRepository.findOne(orderId);
	}

	/**
	 * Gets the manufacture details.
	 *
	 * @param manufacturerId
	 *            the manufacturer id
	 * @return the manufacture details
	 */
	@Override
	public ManufacturerTypesMaster getManufactureDetails(Long manufacturerId) {
		return manufacturerRepository.findOne(manufacturerId);
	}

	/**
	 * Gets the manufactures details.
	 *
	 * @param manufacturerId
	 *            the manufacturer id
	 * @return the manufactures details
	 */
	@Override
	public Manufacturers getManufacturesDetails(Long manufacturerId) {
		return manufacturersRepository.findOne(manufacturerId);
	}

	/**
	 * Gets the order items by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the order items by order id
	 */
	@Override
	public List<OrderItems> getOrderItemsByOrderId(Long orderId) {
		return orderItemsRepository.findByOrderId(orderId);
	}

	/**
	 * Finalize order.
	 *
	 * @param orderId
	 *            the order id
	 * @return true, if successful
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lgndu.oms.service.ManageOrdersService#finalizeOrder(java.lang.Long)
	 */
	@Override
	public boolean finalizeOrder(Long orderId) {
		try {
			ordersRepository.finalizeOrderByOrderId(OrderStatusEnum.ORDER_FINALIZE.status(), orderId);
			return true;
		} catch (Exception exception) {
			return false;
		}

	}

	/**
	 * Save email details.
	 *
	 * @param emailSettingsDTO
	 *            the email settings DTO
	 * @return true, if successful
	 */
	@Override
	public boolean saveEmailDetails(EmailSettingsDTO emailSettingsDTO) {
		EmailSettings emailSettings = new EmailSettings();
		BeanUtils.copyProperties(emailSettingsDTO, emailSettings);
		emailSettings = emailSettingsRepository.save(emailSettings);
		if (emailSettings.getEmailSettingId() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the styles by manufacture and brand id.
	 *
	 * @param brandId
	 *            the brand id
	 * @return the styles by manufacture and brand id
	 */
	@Override
	public List<StylesMaster> getStylesByBrandId(Long brandId) {
		return styleMasterRepository.getStylesByBrandId(brandId);
	}

	/**
	 * Gets the product by style id.
	 *
	 * @param styleId
	 *            the style id
	 * @return the product by style id
	 */
	@Override
	public List<Product> getProductByStyleId(Long styleId) {
		return productRepository.getProductsByStyleId(styleId, MessageConstants.DELETE_STATUS);
	}

	/**
	 * Gets the front product image.
	 *
	 * @param productId
	 *            the product id
	 * @return the front product image
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lgndu.oms.service.ManageOrdersService#getFrontProductImage(java.lang.
	 * Long)
	 */
	@Override
	public String[] getFrontProductImage(Long productId) {
		return productImagesRepository.getFrontProductImagesByProductId(productId,
				MessageConstants.PRODUCT_FRONT_IMAGE);
	}

	/**
	 * Gets the product sizes by product id.
	 *
	 * @param productId
	 *            the product id
	 * @return the product sizes by product id
	 */
	@Override
	public List<SizeMaster> getProductSizesByProductId(long productId) {
		return sizeMasterRepository.getProductSizesByProductId(productId);
	}

	/**
	 * Gets the product colors by product id.
	 *
	 * @param productId
	 *            the product id
	 * @return the product colors by product id
	 */
	@Override
	public List<ProductColorsMapping> getProductColorsByProductId(long productId) {
		return productColorMappingReopsitory.getProductColorsByProductId(productId);
	}

	/**
	 * Gets the billing address in string format.
	 *
	 * @param billingEntity
	 *            the billing entity
	 * @return the billing address in string format
	 */
	public String getBillToAddressInStringFormat(BillingAddress billingEntity) {
		String billingAddress = "";
		if (billingEntity.getFirstName() != null)
			billingAddress += billingEntity.getFirstName() + "\n";
		if (billingEntity.getStreetAddress() != null)
			billingAddress += billingEntity.getStreetAddress() + "\n";
		if (billingEntity.getBillingAddressCity() != null)
			billingAddress += billingEntity.getBillingAddressCity() + "\n";
		if (billingEntity.getBillingAddressState() != null)
			billingAddress += billingEntity.getBillingAddressState() + "\n";
		if (billingEntity.getBillingAddressZipcode() != null)
			billingAddress += billingEntity.getBillingAddressZipcode() + "\n";
		return billingAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msr.oms.service.ManageOrdersService#getShippingAddressInStringFormat(com.
	 * msr.oms.entity.ShippingAddress)
	 */
	public String getShippingAddressInStringFormat(ShippingAddress shippingEntity) {
		String shippingAddress = "";
		if (shippingEntity.getFirstName() != null)
			shippingAddress += shippingEntity.getFirstName() + "\n";
		if (shippingEntity.getStreetAddress() != null)
			shippingAddress += shippingEntity.getStreetAddress() + "\n";
		if (shippingEntity.getShippingAddressCity() != null)
			shippingAddress += shippingEntity.getShippingAddressCity() + "\n";
		if (shippingEntity.getShippingAddressState() != null)
			shippingAddress += shippingEntity.getShippingAddressState() + "\n";
		if (shippingEntity.getShippingAddressZipcode() != null)
			shippingAddress += shippingEntity.getShippingAddressZipcode() + "\n";
		return shippingAddress;
	}
}
