package cn.c.module.organize.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.c.module.organize.domain.User;

public class PassportInterceptor extends HandlerInterceptorAdapter{
	
	private static final String SIGNIN_PATH = "/passport/signin";
	private static final String SIGNIN_PATH_DO = "/passport/signin/do";
	private static final String RESOURCES_DIRECTOR = "/resources";
	
	
	/** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURL().toString();
		if(url.matches(".+" + request.getContextPath() + RESOURCES_DIRECTOR + "/.+")) {
			return true;
		}
		
		if (url.endsWith(request.getContextPath() + SIGNIN_PATH) || url.endsWith(request.getContextPath() + SIGNIN_PATH_DO)) {
			return true;
		} else {
			User user = (User)request.getSession().getAttribute("passport");
			if(user != null) {
				return true;
			}
		}
		//request.getRequestDispatcher(SIGNIN_PATH).forward(request, response);
		response.sendRedirect(request.getContextPath() + SIGNIN_PATH);
		return false;
	}


}
