package net.dumbee.project.web.service.impl;

import org.springframework.stereotype.Service;

import net.dumbee.project.commons.result.OpResult;
import net.dumbee.project.web.result.MessageWeb;
import net.dumbee.project.web.service.UserService;
import net.dumbee.project.web.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public OpResult<UserVO> loadUser(Long uid) {
		OpResult<UserVO> opResult = new OpResult<UserVO>();
		if(uid == null){
			return null;
		}
		if(uid < 10){
			UserVO userVO = new UserVO();
			userVO.setUid(1000000L);
			userVO.setUserName("gpzuestc");
			opResult.setData(userVO);
		}else{
			opResult.setMessage(MessageWeb.USER_NOT_EXIST);
		}
		return opResult;
	}

}
