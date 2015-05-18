package cn.c.module.organize.service;

import cn.c.core.service.CrudService;
import cn.c.module.organize.domain.User;

public interface UserService extends CrudService<User> {

	public User verificationUser(String username, String password);

}
