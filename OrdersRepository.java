package com.msr.oms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msr.oms.entity.Orders;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrdersRepository.
 * 
 * @author vamshib.
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	/**
	 * Gets the all orders.
	 *
	 * @param deleteStatus the delete status
	 * @return the all orders
	 */
	@Query(value= "SELECT * FROM orders WHERE status != :deleteStatus", nativeQuery = true)
	public List<Orders> getAllOrders(@Param("deleteStatus") Integer deleteStatus);

	/**
	 * Gets the all orders by customer name.
	 *
	 * @param deleteStatus the delete status
	 * @param customerMail the customer mail
	 * @return the all orders by customer name
	 */
	@Query(value= "SELECT * FROM orders ord ,customer cust WHERE cust.customer_id=ord.customer_id AND "
			+ "ord.status != :deleteStatus AND cust.company_email=:customerMail", nativeQuery = true)
	public List<Orders> getAllOrdersByCustomerEmail(@Param("deleteStatus") Integer deleteStatus,@Param("customerMail") String customerMail);

	/**
	 * Gets the all orders by customer email and order status.
	 *
	 * @param orderStatus the order status
	 * @param customerMail the customer mail
	 * @return the all orders by customer email and order status
	 */
	@Query(value= "SELECT * FROM orders ord ,customer cust WHERE cust.customer_id=ord.customer_id AND "
			+ " ord.order_status = :orderStatus AND cust.company_email=:customerMail", nativeQuery = true)
	public List<Orders> getAllOrdersByCustomerEmailAndOrderStatus(@Param("orderStatus") String orderStatus,@Param("customerMail") String customerMail);

	/**
	 * Gets the all orders by customer email and order payments status.
	 *
	 * @param paymentsStatus the payments status
	 * @param customerMail the customer mail
	 * @return the all orders by customer email and order payments status
	 */
	@Query(value= "SELECT * FROM orders ord ,customer cust WHERE cust.customer_id=ord.customer_id AND "
			+ " ord.payments_status = :paymentsStatus AND cust.company_email=:customerMail", nativeQuery = true)
	public List<Orders> getAllOrdersByCustomerEmailAndOrderPaymentsStatus(@Param("paymentsStatus") String paymentsStatus,@Param("customerMail") String customerMail);
	
	/**
	 * Gets the all orders by manufacturer email and order payments status.
	 *
	 * @param paymentsStatus the payments status
	 * @param manufacturerMail the manufacturer mail
	 * @return the all orders by manufacturer email and order payments status
	 */
	@Query(value= "SELECT * FROM orders ord ,manufacturers manufacturer WHERE manufacturer.manufacturer_id=ord.manufacturer_id AND "
			+ " ord.payments_status = :paymentsStatus AND manufacturer.manufacturer_email=:manufacturerMail", nativeQuery = true)
	public List<Orders> getAllOrdersByManufacturerEmailAndOrderPaymentsStatus(@Param("paymentsStatus") String paymentsStatus,@Param("manufacturerMail") String manufacturerMail);
	/**
	 * Gets the all orders by manufacturer email.
	 *
	 * @param deleteStatus the delete status
	 * @param manufacturerMail the manufacturer mail
	 * @return the all orders by manufacturer email
	 */
	@Query(value= "SELECT * FROM orders ord ,manufacturers manufacturer WHERE manufacturer.manufacturer_id=ord.manufacturer_id AND "
			+ " ord.status != :deleteStatus AND manufacturer.manufacturer_email=:manufacturerMail", nativeQuery = true)
	public List<Orders> getAllOrdersByManufacturerEmail(@Param("deleteStatus") Integer deleteStatus,@Param("manufacturerMail") String manufacturerMail);

	/**
	 * Gets the all orders by manufacturer email and order status.
	 *
	 * @param orderStatus the order status
	 * @param manufacturerMail the manufacturer mail
	 * @return the all orders by manufacturer email and order status
	 */
	@Query(value= "SELECT * FROM orders ord ,manufacturers manufacturer WHERE manufacturer.manufacturer_id=ord.manufacturer_id AND "
			+ " ord.order_status = :orderStatus AND manufacturer.manufacturer_email=:manufacturerMail", nativeQuery = true)
	public List<Orders> getAllOrdersByManufacturerEmailAndOrderStatus(@Param("orderStatus") String orderStatus,@Param("manufacturerMail") String manufacturerMail);

	/**
	 * gets the order by order status.
	 *
	 * @param orderStatus the order status
	 * @return the list
	 */
	public List<Orders> findByOrderStatus(String orderStatus);

	/**
	 *  
	 * Delete product.
	 *
	 * @param status the status
	 * @param orderStatus the order status
	 * @param orderId the order id
	 * @return the int
	 */
	@Modifying
	@Transactional
	@Query(value= "UPDATE orders  SET status = :status,order_status=:orderStatus WHERE order_id = :order_id", nativeQuery = true)
	public int deleteOrderByOrderId(@Param("status") Integer status,@Param("orderStatus") String orderStatus, @Param("order_id") Long orderId);

	/**
	 * Finalize order by order id.
	 *
	 * @param orderStatus the order status
	 * @param orderId the order id
	 * @return the int
	 */
	@Modifying
	@Transactional
	@Query(value= "update orders  set order_status = :order_status where order_id = :order_id", nativeQuery = true)
	public int finalizeOrderByOrderId(@Param("order_status") String orderStatus , @Param("order_id") Long orderId);
	
	/**
	 * Update order for payments status by order id.
	 *
	 * @param paymentStatus the payment status
	 * @param orderId the order id
	 * @return the int
	 */
	@Modifying
	@Transactional
	@Query(value= "update orders  set  payments_status = :payments_status,order_status=:order_status where order_id = :order_id", nativeQuery = true)
	public int updateOrderForPaymentsStatusByOrderId(@Param("payments_status") String paymentStatus,@Param("order_status") String orderStatus , @Param("order_id") Long orderId);

	/**
	 * this method is used for getting max(excluding 'S' comparing from second index)
	 * sales order id in number format.
	 * 
	 * @return Long
	 */
	@Query(value= "SELECT MAX(CAST(SUBSTRING(sale_order_id,3, length(sale_order_id)) AS UNSIGNED)) FROM orders", nativeQuery = true)
	public Long getMaxSaleOrderId();
	
	/**
	 * Gets the all paid orders by payment status.
	 *
	 * @param paymentStatus the payment status
	 * @return the all paid orders by payment status
	 */
	@Query(value= "select * from orders where payments_status = :payments_status", nativeQuery = true)
	public List<Orders> getAllPaidOrdersByPaymentStatus(@Param("payments_status") String paymentStatus);


}
