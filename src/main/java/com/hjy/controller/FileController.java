package com.hjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjy.pojo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

@RestController
@RequestMapping("file")
@Slf4j
public class FileController {

    @Value("${file.upload.url}")
    private String uploadFilePath;

    @Value("${file.download.url}")
    private String downloadFilePath;

    @Value("${file.delete.url}")
    private String deleteFilePath;

    @RequestMapping("/upload")
    public RespBean fileUpload(@RequestParam("file") MultipartFile file) {
        JSONObject object = new JSONObject();

        String fileName = file.getOriginalFilename();  // 文件名
        File dest = new File(uploadFilePath + '/' + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            log.error("{}", e);
            return RespBean.error("程序错误，请重新上传");
        }
        object.put("success", 1);
        object.put("result", "文件上传成功");
        return RespBean.success("文件上传成功");
    }

    @RequestMapping("/download")
    public String fileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName) throws UnsupportedEncodingException {
        File file = new File(downloadFilePath + '/' + fileName);
        String new_fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1");
        if (!file.exists()) {
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" +new_fileName);


        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            log.error("{}", e);
            return "下载失败";
        }
        return "下载成功";
    }


    @Scheduled(cron = "0 0 3 * * ?")
    private void deleteFiles() {
        deleteFile(new File(deleteFilePath));
    }

    public void deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            log.info("暂无文件");
            return;
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //打印文件名
            String name = f.getName();
            log.info(name);
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                f.delete();
            }
        }
        //删除空文件夹  for循环已经把上一层节点的目录清空。
        file.delete();
    }

    public static boolean downloadFromUrl(String url, String fileName, String dir) {
        try {
            URL httpurl = new URL(url);
            System.out.println(fileName);
            File file = new File(dir + '/' + fileName);

            //目录不存在 则创建
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
                log.info("文件重复，替换掉" + file.toPath().toString());
            }
            FileUtils.copyURLToFile(httpurl, file);
        } catch (Exception e) {
            log.error("{}", e);
            return false;
        }
        log.info("保存成功：" + dir + '/' + fileName);
        return true;
    }

}
