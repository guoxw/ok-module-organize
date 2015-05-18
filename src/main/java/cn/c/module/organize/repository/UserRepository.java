package cn.c.module.organize.repository;

import cn.c.core.repository.CrudRepository;
import cn.c.module.organize.domain.User;

public interface UserRepository extends CrudRepository<User> {

	User findByUsername(String username);

}
