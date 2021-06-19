package com.castle.pdftools.demo.controller;

import com.castle.pdftools.demo.entity.RespBody;
import com.castle.pdftools.utils.FileUploaderUtils;
import com.castle.pdftools.utils.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件转 pdf 示例
 * @author Dawn
 */
@Controller
public class PageDemo {

    @RequestMapping("/index")
    public String toIndex(){
        return "hello";
    }

}
