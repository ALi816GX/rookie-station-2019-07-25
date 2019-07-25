package com.oocl.web.sampleWebApp.jpaSample.controller;

import com.oocl.web.sampleWebApp.jpaSample.pojo.ParcelOrder;
import com.oocl.web.sampleWebApp.jpaSample.repository.ParcelOrderlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/25
 * @Time:09:45
 * @description:
 */

@RestController
@RequestMapping("/parcelorders")
//@CrossOrigin(origins = "*")
public class ParcelOrderController {


    @Autowired
    private ParcelOrderlRepository parcelOrderlRepository;


    @GetMapping
    public List<ParcelOrder> getParcelOrders(){

        return parcelOrderlRepository.findAll();

    }


    @PostMapping
    public String addParcelOrder(@RequestBody ParcelOrder parcelOrder){

        ParcelOrder result = parcelOrderlRepository.save(parcelOrder);

        if(result.getId() != 0){
            return "Success";
        }
        else {
            return "Fail";
        }
    }


    @PutMapping
    public String updateParcelOrder(@RequestBody ParcelOrder parcelOrder){

        ParcelOrder result = parcelOrderlRepository.save(parcelOrder);

        if(result.getId() != null){
            return "Success";
        }
        else {
            return "Fail";
        }

    }

}
