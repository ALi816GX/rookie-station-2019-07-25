package com.oocl.web.sampleWebApp.jpaSample.controller;

import com.alibaba.fastjson.JSON;
import com.oocl.web.sampleWebApp.jpaSample.pojo.ParcelOrder;
import com.oocl.web.sampleWebApp.jpaSample.repository.ParcelOrderlRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/25
 * @Time:12:53
 * @description:
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ParcelOrderControllerTest {

    @Autowired
    private ParcelOrderlRepository parcelOrderlRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_parcelOrder_when_call_get_parcelOrders() throws Exception {

        String jsonResult = "[]";
        mockMvc.perform(get("/parcelorders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }


    @Test
    public void should_return_Success_when_call_add_parcelOrder() throws Exception {

        String jsonResult = "Success";
        ParcelOrder parcelorder = new ParcelOrder(1231L, "a","a","a",new Date());
        String parcelorderContent = JSON.toJSONString(parcelorder);

        mockMvc.perform(post("/parcelorders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(parcelorderContent)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(jsonResult));

    }



    @Test
    public void should_return_Success_when_call_update_parcelOrder() throws Exception {

        String jsonResult = "Success";
        ParcelOrder parcelorder = new ParcelOrder(1231L, "b","a","a",new Date());
        parcelorder.setId(3L);
        String parcelorderContent = JSON.toJSONString(parcelorder);

        mockMvc.perform(put("/parcelorders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(parcelorderContent)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(jsonResult));

    }






}