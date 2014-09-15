package net.dumbee.project.web.controller;

import net.dumbee.project.web.pojo.RespDataBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class ErrorController {
	
	@RequestMapping(value="{code}")
	@ResponseBody
	public RespDataBean errorProcess(@PathVariable("code") int code){
		RespDataBean respDataBean = new RespDataBean();
		respDataBean.setStatusCode(code);
		return respDataBean;
	}
}
