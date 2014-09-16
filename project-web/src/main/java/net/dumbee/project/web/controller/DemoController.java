package net.dumbee.project.web.controller;

import javax.servlet.http.HttpServletRequest;

import net.dumbee.project.commons.result.RespDataView;
import net.dumbee.project.web.vo.UserVO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController{
	
	private static Logger log = LogManager.getLogger(DemoController.class);
//	private static Logger log = LogManager.getFormatterLogger(DemoController.class);

	@RequestMapping("/helloPage")
	public String helloJsp(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "demo/hello";
	}
	
	@RequestMapping("/helloStr")
	@ResponseBody
	public String helloString(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return "As string; hello," + name;
	}
	
	@RequestMapping("/helloJsonStr")
	@ResponseBody
	public String helloJsonString(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		log.info("{} : {}", request.getRequestURI(), request.getParameter("name"));
		log.info("{} : {} : {}", this.hashCode(), request.hashCode(), request.toString());
		return "{\"name\":\"" + name + "\"}";
	}
	
	@RequestMapping("/helloObj")
	@ResponseBody
	public RespDataView helloObj(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		RespDataView respDataBean = new RespDataView();
		respDataBean.setStatusText("hello");
		respDataBean.setStatusCode(200);
		UserVO userVO = new UserVO();
		userVO.setUid(10000L);
		respDataBean.setData(userVO);
		return respDataBean;
	}
}
