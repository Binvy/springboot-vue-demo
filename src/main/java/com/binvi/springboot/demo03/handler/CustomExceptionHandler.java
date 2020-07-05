package com.binvi.springboot.demo03.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author binvi
 * @version 1.0
 * @Description: 全局异常处理
 * @date 2019/6/7 21:59
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /*@ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e,
                                HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("上传文件大小超出限制");
        out.flush();
        out.close();
    }*/

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "上传文件大小超出限制!");
        mv.setViewName("error");
        return mv;
    }

    /*@ExceptionHandler(AuthorizationException.class)
    public ModelAndView authException(AuthorizationException e) {
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error", e.getMessage());
        return mv;
    }*/

}
