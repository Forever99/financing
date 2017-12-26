package cn.edu.zhku.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="addSpendCate",method=RequestMethod.POST)
	@ResponseBody
	public String addSpendCate(@RequestBody SpendCategory spendCate) {
		int num = 0;
		spendService.addSpendCate(spendCate);
		num = spendCate.getId();  //原来 会自动 封装到 实体类中  返回的 int 类型 是 影响的行数 
		if(num!=0) {//返回 json数据给 前端
			return "{\"name\":\""+spendCate.getName()+"\",\"value\":\""+num+"\"}";
		}
		return "{\"name\":\"none\",\"value\":\""+num+"\"}";
	}
	@RequestMapping(value="addSpendRecord",method=RequestMethod.POST)
	public String addSpendRecord(SpendRecord spendRecord,HttpServletRequest request) {
		Date date = new Date();
		System.out.println(date.toString());
		spendRecord.setDate(date);
		int num = spendService.addSpendRecord(spendRecord);
		String msg = "添加消费记录信息  失败，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		if(num!=0) {
			msg = "添加消费记录信息成功 ，3秒后跳转到首页 <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		}
		request.setAttribute("msg", msg);
		return "message";
	}
	
}
