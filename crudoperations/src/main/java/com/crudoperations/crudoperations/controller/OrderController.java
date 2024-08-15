package com.crudoperations.crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperations.crudoperations.models.IdRequest;
import com.crudoperations.crudoperations.models.Order;
import com.crudoperations.crudoperations.service.OrderService;

@RestController
public class OrderController {
    
    @Autowired
    OrderService service;

    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        service.creatOrder(order);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<Order> GetOrder(@RequestBody IdRequest idRequest){
        Order order = service.getOrder(idRequest.getId());
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/deleteOrder")
    public ResponseEntity<Void> deleteOrder(@RequestBody IdRequest idRequest){
        service.deleteOrder(idRequest.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cancelOrder")
    public ResponseEntity<Void> cancelOrder(@RequestBody IdRequest idRequest){
        service.cancelOrder(idRequest.getId());
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/confirmOrder")
    public ResponseEntity<Void> confirnmOrder(@RequestBody IdRequest idRequest){
        service.confirmOrder(idRequest.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/checkOrdersStatusForPhoneNumber")
    public ResponseEntity<List<Order>> checkOrderStatusForPhone(@RequestBody  IdRequest idRequest){
        List<Order> allOrders = service.checkOrderStatusForPhone(idRequest.getPhoneNumber());
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/getOrdersCount")
    public ResponseEntity<Integer> getOrdersCount(){
        return ResponseEntity.ok(service.getOrdersCount());
    }

    @GetMapping("/getOrdersCountForStatus")
    public ResponseEntity<Integer> getOrdersCountForStatus(@RequestBody IdRequest idRequest){
        int count = service.getOrdersCountForStatus(idRequest.getStatus());
        return ResponseEntity.ok(count);
    }

    @GetMapping("/getOrdersPaginated")
    public ResponseEntity<Page<Order>> getPaginatedPackages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Order> order = service.getPaginatedOrders(page, size);
        return ResponseEntity.ok(order);


    }

    
}
