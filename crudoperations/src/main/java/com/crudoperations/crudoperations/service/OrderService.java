package com.crudoperations.crudoperations.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crudoperations.crudoperations.models.Order;
import com.crudoperations.crudoperations.repo.OrderRepo;
import com.crudoperations.crudoperations.repo.PackageRepo;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;
    
    @Autowired
    PackageRepo packageRepo;

    public Order creatOrder(Order order){
        String id =UUID.randomUUID().toString().replace("-", "");
        order.setOrder_id(id);
        order.setStatus("PENDING");
        return repo.save(order);
    }

    public Order getOrder(String id){
        return repo.findById(id).get();
    }

    public void deleteOrder(String id){
        repo.deleteById(id);
    }

    public void cancelOrder(String id){
        repo.cancelOrder(id);
    }
    public void confirmOrder(String id){
        repo.confirmOrder(id);
    }
    public List<Order> checkOrderStatusForPhone(String phoneNumber){
        return repo.checkOrderStatus(phoneNumber);
    }

    public int getOrdersCount(){
        return repo.getOrdersCount();
    }

    public int getOrdersCountForStatus(String status){
        if(status.equals("CONFIRMED")) return repo.getOrdersCountForCONFIRMED();
        else if (status.equals("PENDING")) return repo.getOrdersCountForPENDING();
        else return repo.getOrdersCountForCANCELLED();
    }

    public Page<Order> getPaginatedOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }


}
