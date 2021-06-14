package com.castle.pdftools.demo.controller;

import com.castle.pdftools.demo.entity.RespBody;
import com.castle.pdftools.utils.FileUploaderUtils;
import com.castle.pdftools.utils.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件转 pdf 示例
 * @author Dawn
 */
@RestController
@RequestMapping("/demo")
public class PdfToolsDemo {
    @Autowired
    private FileUploaderUtils fileUploaderUtils;
    @Autowired
    private PdfUtils pdfUtils;

    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("upload")
    public RespBody<Map<String, Object>> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return RespBody.fail(-1,"请上传文件");
        }
        String fileName = file.getOriginalFilename();
        String urlFileName = fileUploaderUtils.getRandomFileName(FileUploaderUtils.getSuffix(fileName));
        String url = fileUploaderUtils.upload(file.getBytes(),urlFileName);
        Map<String, Object> data = new HashMap<>(1);
        data.put("src", url);
        return RespBody.data(data);
    }


    /**
     * 文件上传并转为pdf
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("toPdf")
    public RespBody<Map<String, Object>> toPdf(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return RespBody.fail(-1,"请上传文件");
        }
        String fileName = file.getOriginalFilename();
        String urlFileName = fileUploaderUtils.getRandomFileName(FileUploaderUtils.getSuffix(fileName));
        String originalUrl = fileUploaderUtils.upload(file.getBytes(),urlFileName);
        pdfUtils.toPdf(pdfUtils.getServerPath(originalUrl),pdfUtils.getTargetFolder(originalUrl));
        Map<String, Object> data = new HashMap<>();
        data.put("src", originalUrl);
        data.put("pdfPath", pdfUtils.getPDFUrl(originalUrl));
        return RespBody.data(data);
    }

    /**
     * 文件上传并转为图片
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("toPng")
    public RespBody<Map<String, Object>> toPng(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return RespBody.fail(-1,"请上传文件");
        }
        String fileName = file.getOriginalFilename();
        String urlFileName = fileUploaderUtils.getRandomFileName(FileUploaderUtils.getSuffix(fileName));
        String originalUrl = fileUploaderUtils.upload(file.getBytes(),urlFileName);
        pdfUtils.toPdf(pdfUtils.getServerPath(originalUrl),pdfUtils.getTargetFolder(originalUrl));

        int page = pdfUtils.pdf2Image(pdfUtils.getServerPath(pdfUtils.getPDFUrl(originalUrl)),pdfUtils.getTargetFolder(originalUrl),96);
        Map<String, Object> data = new HashMap<>();
        data.put("src", originalUrl);
        data.put("pdfPath", pdfUtils.getPDFUrl(originalUrl));
        data.put("pngNum",page);
        data.put("pngList",pdfUtils.getPngUrl(originalUrl,page));
        return RespBody.data(data);
    }

}
