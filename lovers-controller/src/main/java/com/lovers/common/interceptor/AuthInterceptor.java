package com.lovers.common.interceptor;

import com.lovers.common.base.constants.CommonConstants;
import com.lovers.common.base.controller.BaseController;
import com.lovers.common.base.controller.CommonController;
import com.lovers.common.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${lovers.projectPath}")
    protected String projectPath;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(CommonConstants.SESSION_USER);
        if(attribute!=null){
//            session.setAttribute(CommonConstants.SESSION_USER,attribute);
            session.setAttribute(CommonConstants.IS_LOGIN,true);
        }else{
            session.setAttribute(CommonConstants.IS_LOGIN,false);
        }
        //清理掉数据
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object bean = handlerMethod.getBean();
            if(bean instanceof BaseController){
                ((CommonController) bean).getReqData().clear();
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            request.setAttribute("cxt",request.getServerName()+":"+request.getServerPort());
            Object bean = handlerMethod.getBean();
            if(bean instanceof BaseController){
                request.setAttribute("reqData",((CommonController) bean).getReqData());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(handler instanceof HandlerMethod){
            log.info("----------------------------");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object bean = handlerMethod.getBean();
            if(bean instanceof CommonController){
                SysUser sysUser = ((CommonController) bean).getSysUser();
                if(sysUser!=null)
                log.info("当前用户为：{}",((CommonController) bean).getSysUser().getUserName());
            }
            log.info("当前拦截的方法为：{}",handlerMethod.getMethod().getName());
            log.info("当前拦截的方法参数为：{}",request.getParameterMap().toString());
            log.info("当前拦截的方法为：{}",handlerMethod.getBean().getClass().getName());
            log.info("当前拦截的路径为：{}",request.getRequestURI());
        }

    }
}
