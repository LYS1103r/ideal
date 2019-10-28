package com.qf.service.impl;

import com.qf.dao.VideoDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service("videoService")
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public Page<Video> getAll(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Video> list = videoDao.getAll(queryVo);

        // 查询到的数据总条数
        Integer total = videoDao.getCount(queryVo);

        // 封装返回的page对象
        Page<Video> videoPage = new Page<Video>();
        //查询数据
        videoPage.setRows(list);
        //当前页
        videoPage.setPage(queryVo.getPage());
        //每页数据
        videoPage.setSize(queryVo.getRows());
        //总记录数
        videoPage.setTotal(total);

        return videoPage;
    }

    @Override
    public void deleteById(Integer id) {
        videoDao.deleteById(id);
    }

    @Override
    public Video editvideo(Integer id) {
        return videoDao.editvideo(id);
    }

    @Override
    public void save(Video video) {
        videoDao.save(video);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public Video getVorS(Integer id) {
        return videoDao.getVorS(id);
    }

    @Override
    public void updatePlayNum(HashMap<String, Integer> map) {
        videoDao.updatePlayNum(map);
    }


}
