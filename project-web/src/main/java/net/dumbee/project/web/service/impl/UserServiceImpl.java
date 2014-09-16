package net.dumbee.project.web.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dumbee.project.commons.result.OpResult;
import net.dumbee.project.core.entity.User;
import net.dumbee.project.core.service.UserCoreService;
import net.dumbee.project.web.result.MessageWeb;
import net.dumbee.project.web.service.UserService;
import net.dumbee.project.web.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserCoreService userCoreService;
	
	@Override
	public OpResult<UserVO> loadUser(Long uid) {
		OpResult<UserVO> opResult = new OpResult<UserVO>();
		if(uid == null){
			return null;
		}
		User user = userCoreService.loadUser(uid);
		if(user != null){
			UserVO userVO = new UserVO();
			userVO.setUid(user.getId());
			userVO.setUsername(user.getName());
			opResult.setData(userVO);
		}else{
			opResult.setMessage(MessageWeb.USER_NOT_EXIST);
		}
		return opResult;
	}

	@Override
	public OpResult<UserVO> createUser(UserVO userVO) {
		OpResult<UserVO> opResult = new OpResult<UserVO>();
		User user = new User();
		user.setName(userVO.getUsername());
		try {
			int r = userCoreService.saveUser(user);
			if(r == 1){
				userVO.setUid(user.getId());
				opResult.setData(userVO);
			}
		} catch (Exception e) {
			log.error(e);
			opResult.setMessage(MessageWeb.CREATE_USER_FAIL);
		}
		return opResult;
	}

}
