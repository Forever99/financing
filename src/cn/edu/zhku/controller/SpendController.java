package cn.edu.zhku.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zhku.pojo.SpendCategory;
import cn.edu.zhku.pojo.SpendRecord;
import cn.edu.zhku.service.SpendService;

@Controller
@RequestMapping("/spend")
public class SpendController {
	@Autowired
	private SpendService spendService;
	//增加消费 类别
	/*@RequestMapping("addSpendCate")*/
	@RequestMapping("test")//测试 
	public String addSpendCate(SpendCategory spendCate,HttpServletRequest request) {
		System.out.println("进入test controller  "+spendCate.getName());
		int num = 0;
		String msg = "添加消费类别 失败，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		num = spendService.addSpendCate(spendCate);
		if(num!=0) {
			List<SpendCategory> list = spendService.queryAllSpendCate();
			request.setAttribute("spendCateList", list);
			return "test";//先进行测试
		}
		return "error";
	}
	@RequestMapping(value="addSpendRecord",method=RequestMethod.POST)
	public String addSpendRecord(SpendRecord spendRecord,HttpServletRequest request) {
		Date date = new Date();
		System.out.println(date.toString());
		spendRecord.setDate(date);
		int num = spendService.addSpendRecord(spendRecord);
		String msg = "添加消费记录信息  失败，3秒后跳转到首页 <meta http-equiv=\\\"refresh\\\" content=\\\"3;url=/financing/index.action\\\"></meta>";
		if(num!=0) {
			msg = "添加消费记录信息成功 ，3秒后跳转到首页 <meta http-equiv=\\\"refresh\\\" content=\\\"3;url=/financing/index.action\\\"></meta>";
		}
		request.setAttribute("msg", msg);
		return "message";
	}
	
}
