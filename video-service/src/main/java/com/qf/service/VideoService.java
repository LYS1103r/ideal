package com.qf.service;

import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.videos.utils.Page;

import java.util.HashMap;


public interface VideoService {
    public Page<Video> getAll(QueryVo queryVo);

    public void deleteById(Integer id);

    public Video editvideo(Integer id);

    public void save(Video video);

    public void update(Video video);

    public Video getVorS(Integer id);

    public void updatePlayNum(HashMap<String,Integer> map);
}
