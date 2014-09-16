package net.dumbee.project.web.controller;

import net.dumbee.project.commons.result.RespDataView;
import net.dumbee.project.web.service.UserService;
import net.dumbee.project.web.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{uid}")
	@ResponseBody
	public RespDataView loadUser(@PathVariable("uid") Long uid){
		return response(userService.loadUser(uid));
	}
	
	@RequestMapping("create")
	@ResponseBody
	
	public RespDataView create(@ModelAttribute UserVO userVO){
		return response(userService.createUser(userVO));
	}
}
