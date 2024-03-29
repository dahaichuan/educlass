package com.haoyi.educlass.service;

import com.haoyi.educlass.domain.Video;
import java.util.List;

public interface VideoService {
    List<Video> findAll();
    Video findById(int id);
    int update(Video Video);
    int delete(int id);
    int save(Video video);
}
