package com.qf.dao;

import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface VideoDao {

    public List<Video> getAll(QueryVo queryVo);


    public Integer getCount(QueryVo queryVo);

    @Delete("delete from video where id=#{id}")
    public void deleteById(Integer id);

    public Video editvideo(Integer id);

    @Insert("insert into video(title,detail,time,spearker_id,course_id,video_url,image_url,play_num) values (#{title},#{detail},#{time},#{spearker_id},#{course_id},#{video_url},#{image_url},#{play_num})")
    public void save(Video video);

    @Update("update video set title=#{title},detail=#{detail},time=#{time},spearker_id=#{spearker_id},course_id=#{course_id},video_url=#{video_url},image_url=#{image_url} where id=#{id}")
    public void update(Video video);

    @Select("select * from video where course_id=#{id}")
    public List<Video> getByCourseId(Integer id);

    //@Select("select video.*,speaker.* from video left join speaker on video.spearker_id=speaker.id where video.id=#{id}")
    public Video getVorS(Integer id);

    @Update("update video set play_num=#{first}+1 where id=#{second}")
    public void updatePlayNum(HashMap<String,Integer> map);

}
