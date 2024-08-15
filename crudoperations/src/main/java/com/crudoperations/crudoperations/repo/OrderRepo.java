package com.crudoperations.crudoperations.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crudoperations.crudoperations.models.Order;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepo extends JpaRepository<Order,String> {

    @Query(value = "select * from orders where user_phone= :phoneNumber" , nativeQuery = true)
    List<Order> checkOrderStatus(@Param("phoneNumber") String phoneNumber);

    @Query(value = "Select count(*) from orders ",nativeQuery = true)
    int getOrdersCount();

    @Query(value = "Select count(*) from orders where status='CONFIRMED' ",nativeQuery = true)
    int getOrdersCountForCONFIRMED();

    @Query(value = "Select count(*) from orders where status='CANCELLED' ",nativeQuery = true)
    int getOrdersCountForCANCELLED();
    
    @Query(value = "Select count(*) from orders where status='PENDING' ",nativeQuery = true)
    int getOrdersCountForPENDING();

    @Modifying
    @Transactional
    @Query(value = "update orders set status='CANCELED' where order_id= :id ",nativeQuery = true)
    void cancelOrder(@Param("id") String id );

    @Modifying
    @Transactional
    @Query(value = "update orders set status='CONFIRMED' where order_id= :id ",nativeQuery = true)
    void confirmOrder(@Param("id") String id );
    

}
