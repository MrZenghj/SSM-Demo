package com.snipe.service;

import com.snipe.entity.FileMark;
/**
 *  文件上传标记service
 */
public interface FileMarkService {
   //判断文件是否已经上传过
   boolean selectByMark(String fileMark);

   //添加上传过得文件标记
   void insertMark(FileMark fileMark);
}
