package com.snipe.controller;

import com.snipe.DTO.Result;
import com.snipe.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/car")
public class CarInfoController {
    @Autowired
    private CarInfoService carInfoService;

    @ResponseBody
    @RequestMapping("/importFile")
    public Result importFile(HttpServletRequest request, @RequestParam("carinfo") MultipartFile mfile) throws Exception {
        Result result = carInfoService.fileImport(request,mfile);
        return result;
    }

    @RequestMapping("/toFileUpload")
    public String toImportFile(){
        return "importExcel";
    }
}
