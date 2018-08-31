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
public class JoinusController {

    @Autowired
    private DateRepository dateRepository;

    @RequestMapping("/joinus.html")
    public ModelAndView join() {
        TimeUtil timeUtil = new TimeUtil();
        ModelAndView mav = new ModelAndView();
        Integer id = 1;
        String start_date = dateRepository.findStartJoinDate(id);
        String end_date = dateRepository.findEndJoinDate(id);
        if (start_date.equals("") || end_date.equals("")) {
            String info = "招新时间错误，请联系工作人员设置";
            mav.setViewName("message");
            mav.addObject("error", info);
            return mav;
        }

        switch (timeUtil.time(start_date, end_date)) {
            case "true":
                mav.setViewName("joinus");
                return mav;
            case "error":
                mav.addObject("error", "很抱歉，出现了一个错误");
                mav.setViewName("message");
                return mav;
            default:
                String info = "翼灵物联网工作室招新日期为每年九月 ！";
                mav.setViewName("message");
                mav.addObject("error", info);
                return mav;
        }
    }
}
