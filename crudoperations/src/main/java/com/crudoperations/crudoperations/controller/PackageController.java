package com.crudoperations.crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperations.crudoperations.models.IdRequest;
import com.crudoperations.crudoperations.models.Package;

import com.crudoperations.crudoperations.service.PackageService;

@RestController
public class PackageController {
    
    @Autowired
    PackageService service;

    @PostMapping("/createPackage")
    public ResponseEntity<Package> createPackage(@RequestBody  Package package1){
        Package createdPackage = service.createPackage(package1);
        return ResponseEntity.ok(createdPackage);
    }

    @PutMapping("/updatePackage")
    public ResponseEntity<Package> updatePackage(@RequestBody Package package1){
        Package updatedPackage = service.createPackage(package1);
        return ResponseEntity.ok(updatedPackage);
    }
    @GetMapping("/getPackage")
    public ResponseEntity<Package> getPackage(@RequestBody IdRequest idRequest){
        Package pkg = service.getPackage(idRequest.getId());
        return ResponseEntity.ok(pkg);
    }

    @DeleteMapping("/deletePackage")
    public ResponseEntity<Void> deletePackage(@RequestBody IdRequest idRequest){
        service.deletePackage(idRequest.getId());
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/getAllPackages")
    public ResponseEntity<List<Package>> findAllPackages(){
        List<Package> packages = service.findAllPackages();
        return ResponseEntity.ok(packages);
    }

    @PostMapping("/markAsTopDeal")
    public ResponseEntity<Void> markAsTopDeal(@RequestBody IdRequest idRequest) {
        service.markAsTopDeal(idRequest.getId());
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/unmarkAsTopDeal")
    public ResponseEntity<Void> unmarkAsTopDeal(@RequestBody IdRequest idRequest) {
        service.unmarkAsTopDeal(idRequest.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getTopDeals")
    public ResponseEntity<List<Package>> getTopDeals() {
        List<Package> packages = service.getTopDeals();
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/getDiscountedPackages")
    public ResponseEntity<List<Package>> getDiscountedPackages() {
        List<Package> packages = service.getDiscountedPackages();
        return ResponseEntity.ok(packages);
    }

    @PostMapping("/removeDiscount")
    public ResponseEntity<Void> removeDiscount(@RequestBody IdRequest idRequest) {
        service.removeDiscount(idRequest.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getPackagesPaginated")
    public ResponseEntity<Page<Package>> getPaginatedPackages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Package> packages = service.getPaginatedPackages(page, size);
        return ResponseEntity.ok(packages);
    }
    
    @PostMapping("/setDiscount")
    public ResponseEntity<Void> updateDiscount(@RequestBody IdRequest idRequest) {
        service.updateDiscount(idRequest.getId(), idRequest.getDiscount());
        return ResponseEntity.noContent().build();
    }

    // public static class IdRequest {
    //     private String id;

    //     public String getId() {
    //         return id;
    //     }

    //     public void setId(String id) {
    //         this.id = id;
    //     }
    // }
}
