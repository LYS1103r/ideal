package com.qf.controller;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;


    @RequestMapping("/showSpeakerList")
    public String getAll(Model model, QueryVo queryVo){
        Page<Speaker> speakerPage = speakerService.getAllPage(queryVo);
        model.addAttribute("page",speakerPage);
        return "behind/speakerList";
    }

    @RequestMapping("/speakerDel")
    public void speakerDel(Integer id, HttpServletResponse response) throws IOException {
        speakerService.speakerDel(id);
        response.getWriter().print("success");
    }

    @RequestMapping("/addSpeaker")
    public String addSpeaker(){
        return "behind/addSpeaker";
    }

    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        Speaker speaker = speakerService.edit(id);
        model.addAttribute("speaker",speaker);
        return "behind/addSpeaker";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker){
        if (speaker.getId()==null){
            speakerService.save(speaker);
        }else{
            speakerService.update(speaker);
        }
        return "redirect:showSpeakerList";
    }
}
