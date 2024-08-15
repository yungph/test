package com.crudoperations.crudoperations.service;

import java.util.List;

//import org.hibernate.validator.constraints.UUID;
// import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import java.util.UUID;
import com.crudoperations.crudoperations.repo.PackageRepo;
import com.crudoperations.crudoperations.models.Package;

@Service
public class PackageService {

    @Autowired
    PackageRepo repo;

    public Package createPackage(Package package1) {
        String id = UUID.randomUUID().toString().replace("-", "");
        package1.setId(id);
        return repo.save(package1);
    }

    public Package updatePackage(Package package1){
        return repo.save(package1);
    }

    public Package getPackage(String id){
        return repo.findById(id).get();
    }

    public void deletePackage(String id){
        repo.deleteById(id);
    }
    public List<Package> findAllPackages(){
        return repo.findAll();
    }

    public void markAsTopDeal(String id){
        repo.markAsTopDeal(id);
    }
    public void unmarkAsTopDeal(String id){
        repo.unmarkAsTopDeal(id);
    }

    public List<Package> getTopDeals(){
        return repo.getTopDeals();
    }
    public List<Package> getDiscountedPackages(){
        return repo.getDiscountedPackages();
    }

    public void removeDiscount(String id){
        repo.removeDiscount(id);
    }

    public Page<Package> getPaginatedPackages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }

    public void updateDiscount(String id, int discount) {
        repo.updateDiscount(id, discount);
    }    
    



    
}
