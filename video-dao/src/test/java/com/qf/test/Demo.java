package com.qf.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.dao.*;
import com.qf.entity.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Demo {

    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao=(AdminDao)context.getBean("adminDao");
        List<Admin> list=adminDao.getAll();
        for (Admin admin:list){
            System.out.println(admin);
        }
    }

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao=(AdminDao)context.getBean("adminDao");
        Admin admin=new Admin();
        admin.setUsername("laoyan");
        admin.setPassword("123456");
        Integer num=adminDao.login(admin);
        System.out.println(num);
    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao=(VideoDao)context.getBean("videoDao");
        QueryVo queryVo=new QueryVo();
        List<Video> all = videoDao.getAll(queryVo);
        for (Video video:all){
            System.out.println(video);
        }

    }

    //测试
    @Test
    public void likevideo(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao=(VideoDao)context.getBean("videoDao");
        String str="开发";
        Integer co=videoDao.likeco(str);
        List<Video> list=videoDao.likevideo(str);
        //Video video=new Video();
        //video.setTitle(str);
       // videoDao.insertdemo(video);
       // videoDao.deletedemo(str);
        for (Video video:list){
            System.out.println(video.toString());
        }
        System.out.println("---------------------------\n-------------------");
        System.out.println("共查询数据："+co+"  条");
        System.out.println("-------测试结束-----");

    }

    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SpeakerDao speakerDao=(SpeakerDao)context.getBean("speakerDao");

        List<Speaker> all = speakerDao.getAll();
        for (Speaker speaker:all){
            System.out.println(speaker);
        }

    }

    @Test
    public void test4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao=(VideoDao)context.getBean("videoDao");

        Video video=videoDao.editvideo(227);

        System.out.println(video);

    }

    @Test
    public void test5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao=(VideoDao)context.getBean("videoDao");

        Video video=new Video();
        video.setCourse_id(23);
        video.setDetail("asdfghjhgfdsdfggfdfgg");
        video.setImage_url("http://");
        video.setPlay_num(666);
        video.setSpearker_id(2);
        video.setTime(23);
        video.setTitle("qwertyutrewweghgfggfdffd");
        video.setVideo_url("http://");
        videoDao.save(video);

        System.out.println(video);

    }

    @Test
    public void test6(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao=(VideoDao)context.getBean("videoDao");

        Video video=new Video();
        video.setId(259);
        video.setDetail("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        video.setTitle("ppppppppppppppppppppppppppppp");
        videoDao.update(video);

    }

    @Test
    public void test7(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectDao subjectDao=(SubjectDao)context.getBean("subjectDao");
        Subject subject = subjectDao.thereAll(6);
        System.out.println(subject);


    }

    @Test
    public void test8(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoDao videoDao=(VideoDao)context.getBean("videoDao");
        Integer id=218;
        Video vorS = videoDao.getVorS(id);
        System.out.println(vorS);


        System.out.println("----------------------------------------------------------");
        List<Map<String,Object>> list=new ArrayList<>();
        for (int i=12;i<30;i+=3){
            Map<String ,Object> map=new HashMap<String ,Object>();
            map.put("job_id",i);
            map.put("time",new Date());
            list.add(map);
        }
        String str=list.toString();
        System.out.println("str: "+str);
        System.out.println("------------------------------------------------------------");

        JSONArray array=JSONArray.parseArray(str);
        for (int i=0;i<array.size();i++){
            JSONObject obj=(JSONObject)array.get(i);
            System.out.println(obj.getString("obj_id"));
        }

    }

    @Test
    public void test9(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseDao courseDao=(CourseDao)context.getBean("courseDao");
        HashMap<String,Integer> map=new HashMap<>();
        map.put("first",6);
        map.put("second",220);
        Course corV = courseDao.getCorV(map);
        System.out.println(corV);

    }


}
