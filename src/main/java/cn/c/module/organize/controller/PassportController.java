package cn.c.module.organize.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.c.core.controller.CrudController;
import cn.c.module.organize.domain.User;
import cn.c.module.organize.service.UserService;

@Controller
@RequestMapping("/passport")
public class PassportController extends CrudController<User, UserService> {
	
	@Override
	protected String getPathDirector(){
		this.addAttribute(URI_DIRECTOR_KEY, this.getUriDirector());
		return "/organize/passport";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin(){
		User user = (User)this.getHttpServletRequest().getSession().getAttribute("passport");
		if(user != null) {
			return this.redirectTo("/main");
		}
		return this.to("/signin");
	}
	
	@RequestMapping(value="/signin/do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doSigninByAjax(@RequestParam(required=true)String username, @RequestParam(required=true)String password){
		Map<String, Object> rusultMap = new HashMap<String, Object>();
		User user = this.getService().verificationUser(username, password);
		this.getHttpServletRequest().getSession().setAttribute("passport", user);
		return rusultMap;
	}
	
	@RequestMapping(value="/exit", method=RequestMethod.GET)
	public String exit(){
		this.getHttpServletRequest().getSession().removeAttribute("passport");
		return this.redirectTo("signin");
	}
	
}
