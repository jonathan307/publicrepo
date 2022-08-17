package com.files.domain.postgres.repository;

import com.files.domain.postgres.entity.Customer;
import com.files.domain.postgres.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query("SELECT cs " +
            "FROM Customer cs")
    List<Customer> getDataForFile();

}


