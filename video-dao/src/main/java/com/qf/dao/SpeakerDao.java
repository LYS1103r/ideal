package com.qf.dao;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SpeakerDao {
    @Select("select * from speaker")
    public List<Speaker> getAll();

    public List<Speaker> getAllPage(QueryVo queryVo);

    @Select("select count(1) from speaker")
    public Integer getCount();

    @Delete("delete from speaker where id=#{id}")
    public void speakerDel(Integer id);

    @Select("select * from speaker where id=#{id}")
    public Speaker edit(Integer id);

    @Insert("insert into speaker(speaker_name,speaker_desc,speaker_job,head_img_url) values(#{speaker_name},#{speaker_desc},#{speaker_job},#{head_img_url})")
    public void save(Speaker speaker);

    @Update("update speaker set speaker_name=#{speaker_name},speaker_desc=#{speaker_desc},speaker_job=#{speaker_job},head_img_url=#{head_img_url} where id=#{id}")
    public void update(Speaker speaker);


}
