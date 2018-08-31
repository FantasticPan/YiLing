package com.iot.officalsite.controller;

import com.iot.officalsite.repository.DateRepository;
import com.iot.officalsite.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 李攀 on 2018/1/8.
 */
@Controller
public class MatchController {

    @Autowired
    private DateRepository dateRepository;

    @RequestMapping("/match.html")
    public ModelAndView competition() {

        TimeUtil timeUtil = new TimeUtil();
        ModelAndView mav = new ModelAndView();
        Integer id = 1;
        String start_date = dateRepository.findStartMatchDate(id);
        String end_date = dateRepository.findEndMatchDate(id);
        if (start_date.equals("") || end_date.equals("")) {
            String info = "报名时间错误，请联系工作人员设置";
            mav.setViewName("message");
            mav.addObject("error", info);
            return mav;
        }

        switch (timeUtil.time(start_date, end_date)) {
            case "true":
                mav.setViewName("match");
                return mav;
            case "error":
                mav.addObject("error", "很抱歉，出现了一个错误");
                mav.setViewName("message");
                return mav;
            default:
                String info = "未到物联网创意大赛报名日期 ！";
                mav.setViewName("message");
                mav.addObject("error", info);
                return mav;
        }
    }
}
