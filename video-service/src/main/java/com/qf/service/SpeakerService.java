package com.qf.service;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.videos.utils.Page;

import java.util.List;

public interface SpeakerService {
    public List<Speaker> getAll();

    public Page<Speaker> getAllPage(QueryVo queryVo);

    public void speakerDel(Integer id);

    public Speaker edit(Integer id);

    public void save(Speaker speaker);

    public void update(Speaker speaker);
}
