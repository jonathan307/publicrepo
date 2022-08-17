package com.files.controller;

import com.files.domain.postgres.entity.Customer;
import com.files.dto.MyDbResponse;
import com.files.dto.MyServiceResponse;
import com.files.dto.MyShoppingResponse;
import com.files.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    private final MyService myservice;

    @Autowired
    public MyController(final MyService myservice) {
        this.myservice = myservice;
    }

    @GetMapping(value = "/my-resource", produces = "application/json")
    ResponseEntity<MyServiceResponse> listResources() {
        MyServiceResponse myres = myservice.listResources();
        return ResponseEntity.ok(myres);
    }

    @GetMapping(value = "/my-items", produces = "application/json")
    ResponseEntity<MyShoppingResponse> listItems() {
        MyShoppingResponse myshop = myservice.listItems();
        return ResponseEntity.ok(myshop);
    }

    @GetMapping(value = "/my-dbuserdata", produces = "application/json")
    ResponseEntity<List<MyDbResponse>> getUserDataDbData() {
        List<MyDbResponse> mydbres = myservice.getUserDataDbData();
        return new ResponseEntity<>(mydbres, HttpStatus.OK);
    }

    @GetMapping(value = "/my-dbcust", produces = "application/json")
    ResponseEntity<List<Customer>> getCustDbData() {
        List<Customer> mydbres = myservice.getCustDbData();
        return new ResponseEntity<>(mydbres, HttpStatus.OK);
    }

}
