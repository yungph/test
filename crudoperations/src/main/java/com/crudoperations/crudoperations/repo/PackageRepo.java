package com.crudoperations.crudoperations.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crudoperations.crudoperations.models.Package;

import jakarta.transaction.Transactional;



@Repository
public interface PackageRepo extends JpaRepository<Package,String> {
    
    // public Package findById(long id);

    @Query(value = "select * from Package where is_top_deal = 1",nativeQuery = true)
    List<Package> getTopDeals();

    @Query(value = "select * from package where discount > 0 ",nativeQuery = true)
    List<Package> getDiscountedPackages();

    @Modifying
    @Transactional
    @Query(value = "UPDATE package SET is_top_deal = 1 WHERE id = :id", nativeQuery = true)
    void markAsTopDeal(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE package SET is_top_deal = 0 WHERE id = :id", nativeQuery = true)
    void unmarkAsTopDeal(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE package SET discount = 0 WHERE id = :id", nativeQuery = true)
    void removeDiscount(@Param("id") String id);

    @Modifying
    @Transactional
    @Query("UPDATE Package p SET p.discount = :discount WHERE p.id = :id")
    void updateDiscount(@Param("id") String id, @Param("discount") int discount);
}
