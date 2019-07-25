package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.pojo.ParcelOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/25
 * @Time:09:40
 * @description:
 */
public interface ParcelOrderlRepository extends JpaRepository<ParcelOrder,Long> {

    @Override
    List<ParcelOrder> findAll();

    ParcelOrder findParcelOrderByOrderId(Long id);

}
