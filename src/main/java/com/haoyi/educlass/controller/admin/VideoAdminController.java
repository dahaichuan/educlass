package com.haoyi.educlass.controller.admin;

import com.haoyi.educlass.domain.Video;
import com.haoyi.educlass.mapper.VideoMapper;
import com.haoyi.educlass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {
    @Autowired
    private VideoService videoService;

    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value = "video_id",required = true)int videoId){
        return videoService.delete(videoId);
    }
    @PutMapping("update_by_id")
    public Object update(@RequestBody Video video){
        return videoService.update(video);
    }

    @PostMapping("save")
    public Object save(@RequestBody Video video){
        return videoService.save(video);
    }
}
