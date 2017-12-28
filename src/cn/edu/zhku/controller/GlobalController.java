package cn.edu.zhku.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.edu.zhku.pojo.IncomeRecord;
import cn.edu.zhku.pojo.RecordInfo;
import cn.edu.zhku.pojo.SpendRecord;
import cn.edu.zhku.service.IncomeService;
import cn.edu.zhku.service.RecordInfoService;
import cn.edu.zhku.service.SpendService;
import cn.edu.zhku.util.SingleDateFormat;
@Controller
public class GlobalController {
	@Autowired
	private SpendService spendService;
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private RecordInfoService recordInfoService;
	
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search() {
		System.out.println("in search");
		return "test";
	}
	@RequestMapping(value="/findDateRecord",method = RequestMethod.POST)
	@ResponseBody
	public String getDateRecord(@RequestBody RecordInfo recordInfo) {
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		
		map1.put("date",null);
		map1.put("id",recordInfo.getUser_id());
		
		//��סת�� ���� 
		recordInfo.setDate(SingleDateFormat.exchangeDate(recordInfo.getDate()));
		//���� ���û� �� �������� ����֧ 
		map2.put("date", recordInfo.getDate());
		map2.put("id", recordInfo.getUser_id());
		
		//��ѯ ���û� ���е� �����¼ �Լ� ֧����¼ �� ����� ֧���� 
		List<IncomeRecord> incomeList = incomeService.queryIncomeRecordByDateId(map1);
		List<SpendRecord> spendList = spendService.querySpendRecordByDateUserId(map1);
		
		List<IncomeRecord> incomeList2 = incomeService.queryIncomeRecordByDateId(map2);
		List<SpendRecord> spendList2 = spendService.querySpendRecordByDateUserId(map2);
		
		int iMTotal = 0;//��ס ����µ�������
		int sMTotal = 0;
		int iDTotal = 0;//��ס ���� ��������
		int sDTotal = 0;
		
		//ͳ�� ���� ��֧
		for(IncomeRecord ir:incomeList2) {
			iDTotal+=ir.getIncomenum();
		}
		for(SpendRecord sr:spendList2) {
			sDTotal+=sr.getSpendnum();
		}

		//��ȡ �·� 
		String datestr = SingleDateFormat.getDateToString(recordInfo.getDate());
		String [] dateArray = datestr.split("-");
		String month = dateArray[1];//�·�
		//��� fastjson-1.1.15 ����� 1.1.20�Ļ� eclipse ʶ���ˣ�����  fastjson
		
		String month2 = "";
		//�� ǰ̨�������� �·� ͳ�� ͳһ�·����� ���� 
		for(IncomeRecord ir:incomeList) {
			month2 = SingleDateFormat.getDateToString(ir.getDate()).split("-")[1];
			if(month2.equals(month)) {
				iMTotal+=ir.getIncomenum();
			}
		}
		/*
		 * ������ �����ڽ��и�ʽת��  Ϊ yyyy-MM-dd ���� ���� ǰ�� ���� ����ֵ ֻ���� �� û��ʱ����ĺ���ֵ  ��ô ���� ǰ̨ ת������
		 * System.out.println("json ����ת��"+JSON.toJSONString(new Date()));
		String dataFormat = "yyyy-MM-dd";
        String dateJson = JSON.toJSONStringWithDateFormat(new Date(), dataFormat, 
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println(dateJson);*/
		
		//��� �û� ѡ�� �Ǹ� �µ� ֧����
		for(SpendRecord sr:spendList) {
			month2 = SingleDateFormat.getDateToString(sr.getDate()).split("-")[1];
			if(month2.equals(month)) {
				sMTotal+=sr.getSpendnum();
			}
		}
		int restnum = iMTotal - sMTotal;//��� ������ 
		Map<String,Object> map3 = new HashMap<String,Object>();
		map3.put("spendnum", sMTotal);
		map3.put("incomenum", iMTotal);
		map3.put("restnum", restnum);
		map3.put("incomelist", incomeList);
		map3.put("dateIncomeNum", iDTotal);
		map3.put("dateSpendNum", sDTotal);
		String jsonstr3 = JSON.toJSONString(map3);  //fastjson �� mapת��Ϊ json��ʽ���ַ���  ǿ��ѽ
		
		/*return "{\"spendnum\":\""+sTotal+"\",\"incomenum\":\""+iTotal+"\",\"restnum\":\""+restnum+"\"}";*/
		
		//�� fastjson �������� �� listת��Ϊ json��ʽ�� �ַ��� �Ͳ����Լ� ������ƴ��
		return jsonstr3;
	}
}



















