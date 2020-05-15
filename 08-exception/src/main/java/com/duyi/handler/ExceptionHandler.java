package com.duyi.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * 实际上是一个切面的应用，Controller抛出的异常将全部被这里坚挺到并捕获
 */
@ControllerAdvice
public class ExceptionHandler {
    /** 拦截Exception类的异常 */
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView handler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/全局异常");
        /**
         * 还能将错误消息传递至前端
         */
        mv.addObject("message", e.getMessage());
        return mv;
    }
}
