package com.msr.oms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.msr.oms.dto.EmailSettingsDTO;
import com.msr.oms.dto.SaveOrderDTO;
import com.msr.oms.entity.BillingAddress;
import com.msr.oms.entity.CurrencyMaster;
import com.msr.oms.entity.Customer;
import com.msr.oms.entity.Manufacturers;
import com.msr.oms.entity.OrderAssign;
import com.msr.oms.entity.OrderItems;
import com.msr.oms.entity.Orders;
import com.msr.oms.entity.PriceListMaster;
import com.msr.oms.entity.ShippingAddress;
import com.msr.oms.entity.ShippingCostMaster;
import com.msr.oms.entity.TotalAreMaster;
import com.msr.product.entity.ManufacturerTypesMaster;
import com.msr.product.entity.Product;
import com.msr.product.entity.ProductColorsMapping;
import com.msr.product.entity.SizeMaster;
import com.msr.product.entity.StylesMaster;

// TODO: Auto-generated Javadoc
/**
 * the interface ManageOrdersService. this interface is used to perform
 * create/edit/delete orders.
 * 
 * @author vamshib
 *
 */
public interface ManageOrdersService {

	/**
	 * Gets the all customers.
	 *
	 * @param jwtToken the jwt token
	 * @return the all customers
	 */
	public List<Customer> getAllCustomers(String jwtToken);

	/**
	 * Gets the all manufacturer types.
	 *
	 * @return the all manufacturer types
	 */
	public List<ManufacturerTypesMaster> getAllManufacturerTypes();

	/**
	 * Gets the all currencies.
	 *
	 * @return the all currencies
	 */
	public List<CurrencyMaster> getAllCurrencies();

	/**
	 * Gets the all price lists.
	 *
	 * @return the all price lists
	 */
	public List<PriceListMaster> getAllPriceLists();

	/**
	 * Gets the all total are master.
	 *
	 * @return the all total are master
	 */
	public List<TotalAreMaster> getAllTotalAreMaster();

	/**
	 * Gets the all shipping costs.
	 *
	 * @return the all shipping costs
	 */
	public List<ShippingCostMaster> getAllShippingCosts();

	/**
	 * Gets the assignees.
	 *
	 * @return the assignees
	 */
	public List<OrderAssign> getAssignees();

	/**
	 * this method is used for getting all the orders.
	 *
	 * @param email the email
	 * @return Orders list
	 */
	public List<Orders> getAllOrders(String email);

	/**
	 * this is for Delete order by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the string
	 */
	public boolean deleteOrderByOrderId(Long orderId);

	/**
	 * Gets the product based on art name for displaying the details of the selected
	 * product.
	 *
	 * @param productArtName
	 *            the product art name
	 * @return the product based on art name
	 */
	public List<Product> getProductsBasedOnArtNameAndCustomerId(Long customerId,String productArtName);

	/**
	 * Gets the product by style id.
	 *
	 * @param styleId
	 *            the style id
	 * @return the product by style id
	 */
	public List<Product> getProductByStyleId(Long styleId);

	/**
	 * Gets the product based on art name for displaying the details of the selected
	 * product.
	 *
	 * @param manufactureId
	 *            the manufacture id
	 * @param brandId
	 *            the brand id
	 * @return the product based on art name
	 */
	public List<StylesMaster> getStylesByBrandId(Long brandId);

	/**
	 * Creates the new sales order for the Customer.
	 *
	 * @param saveOrderDTO
	 *            the save order DTO
	 * @return the response entity
	 */
	public ResponseEntity<SaveOrderDTO> createNewSalesOrder(SaveOrderDTO saveOrderDTO);

	/**
	 * Gets the order details by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the order details by order id
	 */
	public Orders getOrderDetailsByOrderId(Long orderId);

	/**
	 * Gets the manufacture details.
	 *
	 * @param manufacturerId
	 *            the manufacturer id
	 * @return the manufacture details
	 */
	public ManufacturerTypesMaster getManufactureDetails(Long manufacturerId);

	/**
	 * Gets the manufactures details.
	 *
	 * @param manufacturerId
	 *            the manufacturer id
	 * @return the manufactures details
	 */
	public Manufacturers getManufacturesDetails(Long manufacturerId);

	/**
	 * Gets the order items by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the order items by order id
	 */
	public List<OrderItems> getOrderItemsByOrderId(Long orderId);

	/**
	 * This is for finalizing the order to be sent to the manufacturer.
	 *
	 * @param orderId
	 *            the order id
	 * @return true, if successful
	 */
	public boolean finalizeOrder(Long orderId);

	/**
	 * Gets the orders by order status.
	 *
	 * @param orderStatus            the order status
	 * @param email the email
	 * @return the orders by order status
	 */
	public List<Orders> getOrdersByOrderStatus(String orderStatus, String email);

	/**
	 * Save email details.
	 *
	 * @param emailSettingsDTO
	 *            the email settings DTO
	 * @return true, if successful
	 */
	public boolean saveEmailDetails(EmailSettingsDTO emailSettingsDTO);

	/**
	 * Gets the manufacturers.
	 *
	 * @return the manufacturers
	 */
	public List<Manufacturers> getManufacturers();

	/**
	 * Gets the front product image.
	 *
	 * @param productId
	 *            the product id
	 * @return the front product image
	 */
	public String[] getFrontProductImage(Long productId);

	/**
	 * Gets the product sizes by product id.
	 *
	 * @param productId
	 *            the product id
	 * @return the product sizes by product id
	 */
	public List<SizeMaster> getProductSizesByProductId(long productId);

	/**
	 * Gets the product sizes by product id.
	 *
	 * @param productId
	 *            the product id
	 * @return the product sizes by product id
	 */
	public List<ProductColorsMapping> getProductColorsByProductId(long productId);

	/**
	 * Gets the bill to address in string format.
	 *
	 * @param billingEntity the billing entity
	 * @return the bill to address in string format
	 */
	public String getBillToAddressInStringFormat(BillingAddress billingEntity);

	/**
	 * Gets the shipping address in string format.
	 *
	 * @param shippingEntity the shipping entity
	 * @return the shipping address in string format
	 */
	
	public String getShippingAddressInStringFormat(ShippingAddress shippingEntity);

	public List<Orders> getOrdersByOrderPaymentStatus(String orderStatus, String email);
}
