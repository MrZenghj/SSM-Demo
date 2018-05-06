package com.snipe.service.impl;

import com.snipe.dao.FileMarkDao;
import com.snipe.entity.FileMark;
import com.snipe.service.FileMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileMarkService")
public class FileMarkServiceImpl implements FileMarkService {
    @Autowired
    private FileMarkDao fileMarkDao;

    @Override
    public boolean selectByMark(String fileMark) {
        boolean b = true;
        FileMark fileMark1 = fileMarkDao.selectByMark(fileMark);
        if(fileMark1 == null){
            b = false;
        }
        return b;
    }

    @Override
    public void insertMark(FileMark fileMark) {
        fileMarkDao.insertMart(fileMark);
    }
}
