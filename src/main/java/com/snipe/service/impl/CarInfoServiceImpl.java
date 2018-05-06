package com.snipe.service.impl;

import com.snipe.DTO.Result;
import com.snipe.dao.CarInfoDao;
import com.snipe.entity.CarInfo;
import com.snipe.entity.FileMark;
import com.snipe.exception.ExcelException;
import com.snipe.service.CarInfoService;
import com.snipe.service.FileMarkService;
import com.snipe.utils.EncryptUtil;
import com.snipe.utils.POIExcelImportUtil;
import com.snipe.utils.ResultUtil;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service("carInfoService")
public class CarInfoServiceImpl implements CarInfoService{
    @Autowired
    private CarInfoDao carInfoDao;
    @Autowired
    private FileMarkService fileMarkService;

    @Override
    public void insertBatch(List<CarInfo> list) {
        carInfoDao.insertBatch(list);
    }

    @Override
    public List<CarInfo> getCarInfo() {
        return carInfoDao.getCarInfo();
    }

    /**
     *  处理批量导入业务
     *  @param request。
     *  @param mFile
     *  @return String 返回业务信息
     */
    public Result fileImport(HttpServletRequest request, MultipartFile mFile) throws Exception {

        String originalFilename = mFile.getOriginalFilename();
        //转换文件为流形式
        CommonsMultipartFile cFile = (CommonsMultipartFile) mFile;
        DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
        InputStream inputStream = null;
        String fmark = null;
        try {
            inputStream = fileItem.getInputStream();
            fmark = EncryptUtil.encoding(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //判断文件是否为excel文件
        if(!POIExcelImportUtil.validateFile(originalFilename)){
            return ResultUtil.error(103,"非excel文件，请上传正确的文件");
        }

        //判断文件是否为同一个文件
        boolean tag = fileMarkService.selectByMark(fmark);
        if(tag){
            return ResultUtil.success(); // 同一个文件上传 快传
        }

        //读取到文件的信息
        List<CarInfo> list = POIExcelImportUtil.getDateFromExcel(request,originalFilename,mFile);
        if(list == null ){
            //throw new ExcelException(105,"读取文件错误，请检查表格式是否正确");
            return ResultUtil.error(105,"读取文件错误，请检查表格式是否正确");
        }
        //批量插入
        insertBatch(list);

        //文件标记存入表中
        FileMark fileMark = new FileMark();
        fileMark.setMark(fmark);
        fileMark.setReference(null);
        fileMarkService.insertMark(fileMark);
        return ResultUtil.success();
    }
}
