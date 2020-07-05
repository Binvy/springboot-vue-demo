package com.binvi.springboot.demo03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/7 19:42
 */
@RestController
public class FileUploadController {

    private static final Logger logger =  LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping("/upload")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("upload");
        return mv;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        logger.info("upload start");
        return uploadSingleFile(uploadFile, request);
    }

    @PostMapping("/uploads")
    public String uploads(List<MultipartFile> uploadFiles, HttpServletRequest request) {
        logger.info("upload files start");
        StringBuilder sb = new StringBuilder();
        for (MultipartFile file : uploadFiles) {
            sb.append(uploadSingleFile(file, request)).append("\n");
        }
        return sb.toString();
    }

    private static String uploadSingleFile(MultipartFile file, HttpServletRequest request) {
        logger.info("generate file name start");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String currentTime = sdf.format(new Date());
        String realPath = request.getSession().getServletContext().getRealPath("/file/");
        String path = realPath + currentTime;
        File folder = new File(path);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldFileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()
                + oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
        File newFile = new File(folder, newFileName);
        try {
            file.transferTo(newFile);
            String filePath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/file/" + currentTime + "/" + newFileName;
            return oldFileName + "上传成功！上传路径为:" + filePath;
        } catch (IOException e) {
            logger.info("upload single file exception");
            e.printStackTrace();
        }
        return oldFileName + "上传失败";
    }

}
