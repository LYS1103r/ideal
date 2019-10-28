package com.qf.service.impl;

import com.qf.dao.SpeakerDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;
    @Override
    public List<Speaker> getAll() {
        return speakerDao.getAll();
    }

    @Override
    public Page<Speaker> getAllPage(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Speaker> list = speakerDao.getAllPage(queryVo);

        // 查询到的数据总条数
        Integer total = speakerDao.getCount();

        // 封装返回的page对象
        Page<Speaker> speakerPage = new Page<Speaker>();
        //查询数据
        speakerPage.setRows(list);
        //当前页
        speakerPage.setPage(queryVo.getPage());
        //每页数据
        speakerPage.setSize(queryVo.getRows());
        //总记录数
        speakerPage.setTotal(total);

        return speakerPage;
    }

    @Override
    public void speakerDel(Integer id) {
        speakerDao.speakerDel(id);
    }

    @Override
    public Speaker edit(Integer id) {
        return speakerDao.edit(id);
    }

    @Override
    public void save(Speaker speaker) {
        speakerDao.save(speaker);
    }

    @Override
    public void update(Speaker speaker) {
        speakerDao.update(speaker);
    }
}
