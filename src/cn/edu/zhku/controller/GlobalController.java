package cn.edu.zhku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class GlobalController {
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search() {
		System.out.println("in search");
		return "test";
	}
}
