package com.huang.flower.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class FileController {

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws Exception {
        //如果这里没有设置路径的话就会默认保存到根目录下
        String filePath = file.getOriginalFilename();
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    @PostMapping("/upload1")
    public Map<String, Object> upload1(@RequestParam("file") MultipartFile file) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (file.isEmpty()) {
            map.put("uploadMsg", "上传失败");
            return map;
        }

        String fileName = file.getOriginalFilename();
        System.out.println("我的文件 名是" + fileName);
        String filepath = "C:\\Users\\huang\\images\\";
        File dest = new File(filepath + fileName);

        try {
            file.transferTo(dest);
            map.put("uploadMsg", "上传成功！");
            return map;
        } catch (IOException e) {
            map.put("uploadMsg", "上传失败");
            return map;
        }
    }

    @PostMapping("/upload2")
    public Map<String, Object> upload2(@RequestParam("file") MultipartFile file) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (file.isEmpty()) {
            map.put("uploadMsg", "上传失败");
            return map;
        }

        String fileName = file.getOriginalFilename();
        System.out.println("我的文件 名是" + fileName);
        String filepath = "C:\\Users\\huang\\images\\";
        File dest = new File(filepath + fileName);

        try {
            file.transferTo(dest);
            map.put("uploadMsg", "上传成功！");
            return map;
        } catch (IOException e) {
            map.put("uploadMsg", "上传失败");
            return map;
        }
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Map<String, Object>  submit(String imageNameIndex, String url, MultipartFile file)
            throws Exception {
        System.out.println(url);
        Map<String, Object> map = new HashMap<String, Object>();
        if (file.isEmpty()) {
            map.put("uploadMsg", "上传失败");
            return map;
        }

        String fileName = file.getOriginalFilename();
        System.out.println("我的文件 名是" + fileName);
        String filepath = "C:\\Users\\huang\\images\\";
        File dest = new File(filepath + fileName);

        try {
            file.transferTo(dest);
            map.put("uploadMsg", "上传成功！");
            return map;
        } catch (IOException e) {
            map.put("uploadMsg", "上传失败");
            return map;
        }
    }

}
