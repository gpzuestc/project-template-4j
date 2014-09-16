package net.dumbee.project.web.controller;

import net.dumbee.project.commons.result.RespDataView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class ErrorController {
	
	@RequestMapping(value="{code}")
	@ResponseBody
	public RespDataView errorProcess(@PathVariable("code") int code){
		RespDataView respDataBean = new RespDataView();
		respDataBean.setStatusCode(code);
		return respDataBean;
	}
}
