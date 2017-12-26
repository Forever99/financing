package cn.edu.zhku.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;
import cn.edu.zhku.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeController {
	@Autowired
	private IncomeService incomeService;
	
	//jq + ajax 操作 
	@RequestMapping(value="addIncomeCate",method=RequestMethod.POST)
	@ResponseBody
	public String addIncomeCate(@RequestBody IncomeCategory incomeCate) {
		int num = 0;
		incomeService.addIncomeCate(incomeCate);
		num = incomeCate.getId();
		if(num!=0) {
			return "{\"name\":\""+incomeCate.getName()+"\",\"value\":\""+num+"\"}";
		}
		return "{\"name\":\"none\",\"value\":\""+num+"\"}";
	}
	
	@RequestMapping(value="addIncomeRecord",method=RequestMethod.POST)
	public String addIncomeRecord(IncomeRecord incomeRecord,HttpServletRequest request) {
		int num = 0;
		Date date = new Date();
		incomeRecord.setDate(date);
		String msg = "添加收入类别 失败，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		num = incomeService.addIncomeRecord(incomeRecord);
		if(num!=0) {
			msg = "添加收入信息  成功，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
			//或者这里 要 查询 数据 给 首页 显示账单
		}
		request.setAttribute("msg", msg);
		return "message";
	}
}
