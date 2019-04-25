package com.chinasofti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pic")
public class PictureController {


    @PostMapping("/upload")
    @ResponseBody // ajax
    public Map  filesUpload(MultipartFile  uploadFile, HttpServletRequest request) {

        String realPath = request.getSession().getServletContext().getRealPath("/image/");
        String savePath=null;
        try {
            // 文件保存路径
            savePath = realPath +File.separator+ uploadFile.getOriginalFilename();
            // 转存文件
            uploadFile.transferTo(new File(savePath));
            //5、返回map
            Map result = new HashMap<>();
            result.put("error", 0);
//            request.getContextPath()  项目名
            result.put("url", request.getContextPath()+"/image/"+uploadFile.getOriginalFilename());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            //5、返回map
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return result;
        }
    }

}
