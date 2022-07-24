package com.summerboot.restservice;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView fix1(RuntimeException e) {
        System.out.println("全局的异常处理器RuntimeException");
        ModelMap mmp = new ModelMap();
        mmp.addAttribute("ex", e);
        return new ModelAndView("error", mmp);
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView fix1(Exception e) {
        System.out.println("全局的异常处理器Exception");
        ModelMap mmp = new ModelMap();
        mmp.addAttribute("ex", e);
        return new ModelAndView("error", mmp);
    }
}
