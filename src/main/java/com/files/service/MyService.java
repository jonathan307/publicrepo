package com.files.service;

import com.files.domain.postgres.entity.Customer;
import com.files.domain.postgres.entity.UserData;
import com.files.domain.postgres.repository.CustomerRepo;
import com.files.domain.postgres.repository.UserRepository;
import com.files.dto.MyDbResponse;
import com.files.dto.MyServiceResponse;
import com.files.dto.MyShoppingResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    private final UserRepository userRepo;
    private final CustomerRepo custRepo;

    public MyService(final UserRepository userRepo, final CustomerRepo custRepo) {
        this.userRepo = userRepo;
        this.custRepo = custRepo;
    }

    public MyServiceResponse listResources(){
        MyServiceResponse myres = new MyServiceResponse();
        myres.setName("Jonathan");
        myres.setStatus("Active");
        myres.setDob("July 30");
        myres.setStreet("Sky Valley");
        myres.setState("Florida");
        myres.setZipcode("34711");
        return myres;
    }

    public MyShoppingResponse listItems(){
        MyShoppingResponse myshop = new MyShoppingResponse();
        myshop.setItem("Milk");
        myshop.setPrice("$7.99");
        myshop.setDescription("2%");
        return myshop;
    }

    public List<MyDbResponse> getUserDataDbData() {

        List<MyDbResponse> mydbresList = new ArrayList<>();
        MyDbResponse mydbres;
        List<UserData> udata;
        udata = userRepo.getDataForFile();
        for(UserData ud: udata){
            mydbres = new MyDbResponse();
            mydbres.setId(ud.getId());
            mydbres.setFirstName(ud.getFirstName());
            mydbres.setLastName(ud.getLastName());
            mydbres.setDateOfBirth(ud.getDateOfBirth());
            mydbres.setLastUpdateDate(ud.getLastUpdateDate());
            mydbresList.add(mydbres);
        }

        return mydbresList;
    }

    public List<Customer> getCustDbData() {

        List<Customer> mydbresList = new ArrayList<>();
        Customer mydbres;
        List<Customer> udata;
        udata = custRepo.getDataForFile();
        for(Customer ud: udata){
            mydbres = new Customer();
            mydbres.setCreateDt(ud.getCreateDt());
            mydbres.setCustomerId(ud.getCustomerId());
            mydbres.setEmail(ud.getEmail());
            mydbres.setName(ud.getName());
            mydbres.setMobileNumber(ud.getMobileNumber());
            mydbresList.add(mydbres);
        }

        return mydbresList;
    }

}
