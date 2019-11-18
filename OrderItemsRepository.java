package com.msr.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.msr.oms.entity.OrderItems;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderItemsRepository.
 */
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

	/*
	 * @Query(value = "SELECT * FROM order_items WHERE order_id=:orderId",
	 * nativeQuery = true) public OrderItems getAllOrders(@Param("orderId") Integer
	 * orderId);
	 */
	/**
	 * Find by order id.
	 *
	 * @param orderId
	 *            the order id
	 * @return the list
	 */
	@Query(value = "select * from order_items where order_id=:order_id", nativeQuery = true)
	public List<OrderItems> findByOrderId(@Param("order_id") Long orderId);

	/*
	 * @Query(value=
	 * " select order_quantity,price,discount,tax,total from order_items where item_id=:item_id"
	 * , nativeQuery = true) public List<OrderItems> findByItemId(@Param("item_id")
	 * Long item_id);
	 */
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM order_items WHERE order_id =:orderId", nativeQuery = true)
	public void deleteOrderItemsByOrderId(@Param("orderId") Long orderId);

	@Query(value = "select color_id from order_items where order_id=:orderId and order_item_id=:orderItemId", nativeQuery = true)
	public Long getColorId(@Param("orderId") Long orderId,@Param("orderItemId") Long orderItemId);

	@Query(value = "select size_id from order_items where order_id=:orderId and order_item_id=:orderItemId", nativeQuery = true)
	public Long getSizeId(@Param("orderId") Long orderId,@Param("orderItemId") Long orderItemId);

	@Query(value = "select style_id from order_items where order_id=:orderId and order_item_id=:orderItemId", nativeQuery = true)
	public Long getStyleId(@Param("orderId") Long orderId,@Param("orderItemId") Long orderItemId);

	@Query(value = "select * from order_items where order_id=:orderId", nativeQuery = true)
	public List<OrderItems> getOrderIds(@Param("orderId") Long orderId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM order_items WHERE order_id=:orderId", nativeQuery = true)
	public void deleteFromOrderItems(@Param("orderId") Long orderId);
	
}
