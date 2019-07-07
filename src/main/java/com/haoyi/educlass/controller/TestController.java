package com.haoyi.educlass.controller;

import com.haoyi.educlass.config.WeChatConfig;
import com.haoyi.educlass.domain.JsonData;
import com.haoyi.educlass.domain.Video;
import com.haoyi.educlass.mapper.VideoMapper;
import com.haoyi.educlass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @RequestMapping("test12")
    public String test(){
        System.out.println("test123");
        return "Hello Edu Class";
    }

    @Autowired
    private WeChatConfig weChatConfig;

    @RequestMapping("test_config")
    public JsonData testconfig(){
        System.out.println(weChatConfig.getAppid());
        return JsonData.buildSuccess(weChatConfig.getAppid());
    }

    @Autowired
    private VideoService videoService;

    @RequestMapping("test_db")
    public Object testdb(){
        //System.out.println("test123");
        return videoService.findAll();
    }
}
