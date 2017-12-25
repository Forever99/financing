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
		String msg = "���������� ʧ�ܣ�3�����ת����ҳ <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		num = incomeService.addIncomeCate(incomeCate);
		if(num!=0) {
			msg = "���������� �ɹ���3�����ת����ҳ <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
			//��ӳɹ��� Ҫ���´���session�е� ���������Ϣ
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
		String msg = "���������� ʧ�ܣ�3�����ת����ҳ <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		num = incomeService.addIncomeRecord(incomeRecord);
		if(num!=0) {
			msg = "���������Ϣ  �ɹ���3�����ת����ҳ <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
			//�������� Ҫ ��ѯ ���� �� ��ҳ ��ʾ�˵�
		}
		request.setAttribute("msg", msg);
		return "message";
	}
}
