package cn.edu.zhku.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;
import cn.edu.zhku.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeController {
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping(value="addIncomeCate",method=RequestMethod.POST)
	public String addIncomeCate(IncomeCategory incomeCate,HttpServletRequest request) {
		int num = 0;
		String msg = "添加收入类别 失败，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		num = incomeService.addIncomeCate(incomeCate);
		if(num!=0) {
			msg = "添加收入类别 成功，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
			//添加成功后 要更新存在session中的 消费类别信息
			request.getSession().setAttribute("incomecate",incomeService.queryAllIncomeCate());
		}
		request.setAttribute("msg", msg);
		return "message";
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
