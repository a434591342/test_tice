package com.hjy.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2021/3/30
 * Time: 15:12
 * Description: 验证码
 */
@RestController
public class CaptchaController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @ApiOperation(value = "验证码")
//    @GetMapping(value = "/captcha",produces = "image/jpeg")     //这里加produces才能在接口页面访问到图片
    @GetMapping(value = "/captcha")     //这里加produces才能在接口页面访问到图片

    public String captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // 定义response输出类型为image/jpeg类型
//        response.setDateHeader("Expires", 0);
//        // Set standard HTTP/1.1 no-cache headers.
//        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
//        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
//        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
//        // Set standard HTTP/1.0 no-cache header.
//        response.setHeader("Pragma", "no-cache");
//        // return a jpeg
//        response.setContentType("image/jpeg");
        //-------------------生成验证码 begin --------------------------
        //获取验证码文本内容
        String text = defaultKaptcha.createText();
        System.out.println("验证码内容："+text);
        //将验证码文本内容放入session
        // TODO: 2021/9/13 这里先弄成死的
        request.getSession().setAttribute("captcha","1234");

        //根据文本验证码内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            //输出流输出图片，格式为jpg
//            ImageIO.write(image,"jpg",outputStream);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            String data = DatatypeConverter.printBase64Binary(baos.toByteArray());
            String imageString = "data:image/jpg;base64," + data;
            System.out.println(imageString);
            return imageString;
//            outputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (null!=outputStream){
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        //-------------------生成验证码 end --------------------------
    }
}