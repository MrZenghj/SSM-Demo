package com.snipe.service;

import com.snipe.DTO.Result;
import com.snipe.entity.CarInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  车辆信息service
 */
public interface CarInfoService {
    //批量插入车辆信息
    public void insertBatch(List<CarInfo> list);

    //查询车辆信息
    public List<CarInfo> getCarInfo();

    //读取文件插入信息
    public Result fileImport(HttpServletRequest request, MultipartFile mFile) throws Exception;
}
