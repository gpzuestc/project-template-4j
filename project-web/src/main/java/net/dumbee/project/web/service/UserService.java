package net.dumbee.project.web.service;

import net.dumbee.project.commons.result.OpResult;
import net.dumbee.project.web.vo.UserVO;

public interface UserService {
	
	OpResult<UserVO> loadUser(Long uid);
	
	OpResult<UserVO> createUser(UserVO userVO);
}
