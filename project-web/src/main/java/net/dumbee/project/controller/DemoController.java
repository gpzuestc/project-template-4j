package net.dumbee.project.controller;

import net.dumbee.project.model.JsonView;
import net.dumbee.project.vo.UserVO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	private static Logger log = LogManager.getLogger(DemoController.class);
//	private static Logger log = LogManager.getFormatterLogger(DemoController.class);

	@RequestMapping("/hello.page")
	public String helloJsp(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "user/hello";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String helloString(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return "As string; hello," + name;
	}
	
	@RequestMapping("/hello1")
	@ResponseBody
	public String helloString2(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return "{\"name\":\"guopengzhang\"}";
	}
	
	@RequestMapping("/hello.json")
	@ResponseBody
	public JsonView helloJson(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		log.info("log: {}, {}", name, name); // LogManager.getLogger
		log.info("log: %s : %s", name, name); // LogManager.getFormatterLogger
		JsonView jsonView = new JsonView();
		jsonView.setStatusText("hello");
		jsonView.setStatusCode(200);
		jsonView.setData(name);
		return jsonView;
	}
	
	@RequestMapping("/hello1.json")
	@ResponseBody
	public JsonView helloJson1(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		JsonView jsonView = new JsonView();
		jsonView.setStatusText("hello");
		jsonView.setStatusCode(200);
		UserVO userVO = new UserVO();
		userVO.setUid(10000L);
		jsonView.setData(userVO);
		return jsonView;
	}
	
	@RequestMapping("/hello.xml")
	@ResponseBody
	public JsonView helloXml(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		JsonView jsonView = new JsonView();
		jsonView.setStatusText("hello");
		jsonView.setStatusCode(200);
		UserVO userVO = new UserVO();
		userVO.setUid(10000L);
		jsonView.setData(userVO);
		return jsonView;
	}
}
