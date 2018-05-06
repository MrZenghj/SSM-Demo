package com.snipe.dao;

import com.snipe.entity.CarInfo;

import java.util.List;

/**
 *   车辆信息 实体dao
 */
public interface CarInfoDao {

    //批量插入车辆信息
    public void insertBatch(List<CarInfo> list);

    //查询车辆信息
    public List<CarInfo> getCarInfo();
}