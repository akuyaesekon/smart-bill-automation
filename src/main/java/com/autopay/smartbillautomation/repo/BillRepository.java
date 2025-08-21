package com.autopay.smartbillautomation.repo;

import com.autopay.smartbillautomation.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    // Find all bills associated with a specific user ID
    List<Bill> findAllByUserId(Integer userId);
}
