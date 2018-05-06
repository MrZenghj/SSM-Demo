package com.snipe.utils;

import com.snipe.entity.CarInfo;
import com.snipe.exception.ExcelException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   POI 对excel文件的批量导入
 */
public class POIExcelImportUtil {
    //存储到读取的数据
    private static List<CarInfo> carInfoList = null;
    //excel规定的格式（表头）
    public static String[] rowHeads = new String[]{"车牌号","车类型","出产日期","价格"};

    /**
     *  @decription 从传入的文件读取对应的信息
     *  @param request 请求对象
     *  @param fileName 文件名字
     *  @param mfile 请求的对象文件
     *  @return List 返回对应的信息
     */
    public static List<CarInfo> getDateFromExcel(HttpServletRequest request, String fileName , MultipartFile mfile){
        //将传入的文件进行类型转换
        CommonsMultipartFile cfile = (CommonsMultipartFile)mfile;
        //存储暂时路径
        String path = request.getServletContext().getRealPath("/excelfile/");
        File file = new  File(path);
        //创建一个目录
        if (!file.exists()) file.mkdirs();
        //新建一个文件（临时存储上传的文件）
        File newFile = new File(path + new Date().getTime() +
                fileName.substring(fileName.lastIndexOf(".")));
        //建上传的文件copy一份到服务器中
        try {
            cfile.getFileItem().write(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建excel工作簿
        Workbook workbook = createWorkBook(newFile);
        //得到一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //验证表头
        if(!validateHeader(sheet)){
            return null;
        }
        //读取工作表
        carInfoList = readExcel(sheet);
        return carInfoList;
    }

    private static List<CarInfo> readExcel(Sheet sheet){
        //获取总行数
        int totalRowNum = sheet.getPhysicalNumberOfRows();

        //是否有除了表头之外的数据
        if(totalRowNum >= 2 && sheet.getRow(0) != null){
            carInfoList = new ArrayList<>();
            for(int r = 1;r < totalRowNum ;r++){
                Row row = sheet.getRow(r);
                if (row == null) continue;
                CarInfo carInfo = new CarInfo();
                //循环Excel的列
                for(int c = 0; c < rowHeads.length; c++){
                    Cell cell = row.getCell(c);
                    /*
                     * 判断语句可根据列名的增加做相应增减
                     */
                    if (null != cell) {
                        if(c==0) {
                            carInfo.setCarNo(cell.getStringCellValue()); //车牌号
                        }else if(c==1) {
                            carInfo.setType(cell.getStringCellValue()); //车类型
                        }else if(c==2) {
                            cell.setCellType(Cell.CELL_TYPE_STRING); //设置类型(读取类型为String)
                            carInfo.setProduceDate(cell.getStringCellValue()); //出产日期
                        }else if(c==3) {
                            cell.setCellType(Cell.CELL_TYPE_STRING); //设置类型(读取类型为String)
                            carInfo.setPrice(Integer.parseInt(cell.getStringCellValue())); //起拍价
                        }
                    }
                }
                carInfoList.add(carInfo); //存放进入list集合
            }
        }
        return carInfoList;
    }


    /**
     * @Title: createWorkBook
     * @Description: 通过传入的文件返回一个Excel工作簿（03或者07版本）
     * @param file
     * @return Workbook
     * @throws
     */
    public static Workbook createWorkBook(File file) {
        Workbook workbook = null;
        FileInputStream fis =null;
        try {
            //获取一个绝对地址的流
            fis = new FileInputStream(file);
            //2003版本的excel，用.xls结尾
            workbook = new HSSFWorkbook(fis);//得到工作簿
        } catch (Exception ex) {
            try{
                //2007版本的excel，用.xlsx结尾
                fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return workbook;
    }

    /**
     *  @decription 验证上传的文件头部是否与规定的一致
     *  @param  sheet excel表
     *  @return
     */
    public static boolean validateHeader(Sheet sheet){
        boolean tag = true;
        Row row = sheet.getRow(0);
        //验证表头的长度是否和指定的一致
        if(row.getPhysicalNumberOfCells() != rowHeads.length){
            tag = false;
            return tag;
        }
        // 逐行检查每个表头是否正确
        for (int i = 0; i < rowHeads.length; i++) {
            Cell cell = row.getCell(i);
            //判断表头名字是否相符
            if(!getRightTypeCell(cell).toString().equals(rowHeads[i])){
                tag = false;
                return tag;
            }
        }
        return tag;
    }


    /**
     *  @decription  判断上传的文件是不是excel格式
     *  @param filename
     *  @return
     */
    public static boolean validateFile(String filename){
       if(!filename.endsWith(".xls") && !filename.endsWith(".xlsx")){
            return false;
       }
       return true;
    }

    /**
     *  @decription 获取对应单元格数值
     *  @param cell
     *  @return
     */
    public static Object getRightTypeCell(Cell cell){
        Object object = null;
        switch(cell.getCellType()) {
            case Cell.CELL_TYPE_STRING : {
                object=cell.getStringCellValue();
                break;
            }
            case Cell.CELL_TYPE_NUMERIC : {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object=cell.getNumericCellValue();
                break;
            }
            case Cell.CELL_TYPE_FORMULA : {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object=cell.getNumericCellValue();
                break;
            }
            case Cell.CELL_TYPE_BLANK : {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
                object=cell.getStringCellValue();
                break;
            }
        }
        return object;
    }
}
