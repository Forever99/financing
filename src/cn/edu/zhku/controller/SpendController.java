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
	//�������� ���
	/*@RequestMapping("addSpendCate")*/
	@RequestMapping("test")//���� 
	public String addSpendCate(SpendCategory spendCate,HttpServletRequest request) {
		System.out.println("����test controller  "+spendCate.getName());
		int num = 0;
		String msg = "���������� ʧ�ܣ�3�����ת����ҳ <meta http-equiv=\"refresh\" content=\"3;url=/financing/index.action\"></meta>";
		num = spendService.addSpendCate(spendCate);
		if(num!=0) {
			List<SpendCategory> list = spendService.queryAllSpendCate();
			request.setAttribute("spendCateList", list);
			return "test";//�Ƚ��в���
		}
		return "error";
	}
	@RequestMapping(value="addSpendRecord",method=RequestMethod.POST)
	public String addSpendRecord(SpendRecord spendRecord,HttpServletRequest request) {
		Date date = new Date();
		System.out.println(date.toString());
		spendRecord.setDate(date);
		int num = spendService.addSpendRecord(spendRecord);
		String msg = "������Ѽ�¼��Ϣ  ʧ�ܣ�3�����ת����ҳ <meta http-equiv=\\\"refresh\\\" content=\\\"3;url=/financing/index.action\\\"></meta>";
		if(num!=0) {
			msg = "������Ѽ�¼��Ϣ�ɹ� ��3�����ת����ҳ <meta http-equiv=\\\"refresh\\\" content=\\\"3;url=/financing/index.action\\\"></meta>";
		}
		request.setAttribute("msg", msg);
		return "message";
	}
	
}
