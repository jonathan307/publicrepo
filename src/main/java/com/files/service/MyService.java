package com.files.service;

import com.files.domain.postgres.entity.UserData;
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

    public MyService(final UserRepository userRepo) {
        this.userRepo = userRepo;
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

    public List<MyDbResponse> getDbData() {

        List<MyDbResponse> mydbresList = new ArrayList<>();
        MyDbResponse mydbres;
        List<UserData> udata;
        udata = userRepo.getDataForFile();
        for(UserData ud: udata){
            mydbres = new MyDbResponse();
            mydbres.setFirstName(ud.getFirstName());
            mydbres.setLastName(ud.getLastName());
            mydbres.setDateOfBirth(ud.getDateOfBirth());
            mydbresList.add(mydbres);
        }

        return mydbresList;
    }

}
