package com.snipe.dao;

import com.snipe.entity.FileMark;
import org.apache.ibatis.annotations.Param;

/**
 *  查找文件标记Dao
 */
public interface FileMarkDao {
    //通过fileMark查找文件是否上传过
    FileMark selectByMark(@Param("fileMark") String fileMark);

    //上传完成添加文件标志
    void insertMart(FileMark fileMark);
}
