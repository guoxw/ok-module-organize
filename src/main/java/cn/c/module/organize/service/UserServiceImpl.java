package cn.c.module.organize.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import cn.c.core.excepion.BusinessException;
import cn.c.core.excepion.EntityNotFoundException;
import cn.c.core.service.CrudServiceImpl;
import cn.c.module.organize.domain.User;
import cn.c.module.organize.repository.UserRepository;

@Service
public class UserServiceImpl extends CrudServiceImpl<User, UserRepository> implements UserService {

	public User save(User entity) {
		if(entity.isNew()) {
			entity.setCreateTime(new Date());
		} else {
			User userByFind = this.findOne(entity.getId());
			if(userByFind == null) {
				throw new EntityNotFoundException("修改的用户不存在,或已被删除!!!");
			}
			entity.setUsername(userByFind.getUsername());
			entity.setPassword(userByFind.getPassword());
			entity.setAdmin(userByFind.isAdmin());
			entity.setUpdateTime(new Date());
		}
		entity = super.save(entity);
		return entity;
		
	}
	
	@Override
	public User verificationUser(String username, String password) {
		User user = this.getRepository().findByUsername(username);
		if(user == null) {
			throw new BusinessException("登录用户不存在!");
		}
		if(!password.equals(user.getPassword())){
			throw new BusinessException("登录密码错误!");
		}
		return user;
			
	}

}
