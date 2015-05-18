package cn.c.module.organize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.c.core.controller.CrudController;
import cn.c.module.organize.domain.User;
import cn.c.module.organize.service.UserService;

@Controller
@RequestMapping("/organize/user")
public class UserController extends CrudController<User, UserService> {
	
}
