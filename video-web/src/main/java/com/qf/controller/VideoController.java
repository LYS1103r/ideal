package com.qf.controller;



import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import com.qf.service.SubjectService;
import com.qf.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/list")
    public String getAll(Model model,QueryVo queryVo){
        Page<Video> page =videoService.getAll(queryVo);
        //List<Video> list=videoService.getAll(queryVo);
        for (Video video:page.getRows()){
            System.out.println(video);
        }
        /*model.addAttribute("videoAll",list);*/
        model.addAttribute("page",page);

        model.addAttribute("courseList",courseService.getAll());
        model.addAttribute("speakerList",speakerService.getAll());

        model.addAttribute("title",queryVo.getTitle());
        model.addAttribute("speakerId",queryVo.getSpeakerId());
        model.addAttribute("courseId",queryVo.getCourseId());
        return "behind/videoList";
    }

    @RequestMapping("/videoDel")
    public void deleteById(HttpServletResponse response, Integer id) throws IOException {
        videoService.deleteById(id);
        System.out.println("表现层：单个删除成功。。。。");
        System.out.println(id);
        response.getWriter().print("success");
    }

    @RequestMapping("/delBatchVideos")
    public String deleteArray(@RequestParam("ids") String[] ids){
        for (String id:ids){
            Integer integer= Integer.valueOf(id);
            videoService.deleteById(integer);
        }
        return "redirect:list";
    }

    @RequestMapping("/addVideo")
    public String addvideo(Model model){
        model.addAttribute("courseList",courseService.getAll());
        model.addAttribute("speakerList",speakerService.getAll());
        return "behind/addVideo";
    }

    @RequestMapping("/edit")
    public String editvideo(Integer id,Model model){
        Video video=videoService.editvideo(id);
        model.addAttribute("video",video);
        model.addAttribute("courseList",courseService.getAll());
        model.addAttribute("speakerList",speakerService.getAll());
        return "behind/addVideo";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video){
        if (video.getId()==null){
            video.setPlay_num(0);
            videoService.save(video);
        }else{
            videoService.update(video);
        }
        return "redirect:list";
    }



    //////////////////////////////////////////////

    @RequestMapping("/showVideo")
    public String showVideo(Integer videoId, String subjectName, Model model){
        System.out.println(videoId+"  "+subjectName);
        Video video=videoService.getVorS(videoId);
        HashMap<String,Integer> map=new HashMap<>();
        map.put("first",video.getCourse_id());
        map.put("second",videoId);
        model.addAttribute("video",video);
        model.addAttribute("course",courseService.getCorV(map));
        model.addAttribute("subjectList",subjectService.getAll());
        model.addAttribute("subjectName",subjectName);
        //request.getSession().setAttribute("subjectName",subjectName);
        return "before/section";
    }

    @RequestMapping("/updatePlayNum")
    public void updatePlayNum(Integer id,Integer playNum){
        System.out.println(playNum);
        HashMap<String,Integer> map=new HashMap<>();
        map.put("first",playNum);
        map.put("second",id);
        videoService.updatePlayNum(map);
    }

}
