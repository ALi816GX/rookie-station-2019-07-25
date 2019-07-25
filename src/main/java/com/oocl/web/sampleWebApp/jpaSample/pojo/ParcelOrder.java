package com.oocl.web.sampleWebApp.jpaSample.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/25
 * @Time:09:26
 * @description:
 */
@Entity
@Data
@NoArgsConstructor
public class ParcelOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;
    private String recipient;
    private String tell;
    private String state;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date appointTime;


}
