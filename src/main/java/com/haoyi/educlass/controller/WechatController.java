package com.haoyi.educlass.controller;

import com.haoyi.educlass.config.WeChatConfig;
import com.haoyi.educlass.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;
    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginurl(@RequestParam(value = "access_page",required = true)String accesspage) throws UnsupportedEncodingException {
        String redirectUrl=weChatConfig.getOpenRedirecturl();
        String callbackUrl= URLEncoder.encode(redirectUrl,"GBK");
        String qrcodeUrl=String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppid(),callbackUrl,accesspage);
        return JsonData.buildSuccess(qrcodeUrl);
    }

    @GetMapping("/user/callback")
    public void wechatUserCallback(@RequestParam(value = "code",required = true) String code, String state, HttpServlet response){
        System.out.println("code"+code);
        System.out.println("state"+state);
    }
}
