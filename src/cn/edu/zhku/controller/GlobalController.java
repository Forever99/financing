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
		
		//先住转换 日期 
		recordInfo.setDate(SingleDateFormat.exchangeDate(recordInfo.getDate()));
		//查找 该用户 在 具体日期 的收支 
		map2.put("date", recordInfo.getDate());
		map2.put("id", recordInfo.getUser_id());
		
		//查询 该用户 所有的 收入记录 以及 支出记录 在 收入表 支出表 
		List<IncomeRecord> incomeList = incomeService.queryIncomeRecordByDateId(map1);
		List<SpendRecord> spendList = spendService.querySpendRecordByDateUserId(map1);
		
		List<IncomeRecord> incomeList2 = incomeService.queryIncomeRecordByDateId(map2);
		List<SpendRecord> spendList2 = spendService.querySpendRecordByDateUserId(map2);
		
		int iMTotal = 0;//记住 这个月的总收入
		int sMTotal = 0;
		int iDTotal = 0;//记住 这天 的总收入
		int sDTotal = 0;
		
		//统计 那天 收支
		for(IncomeRecord ir:incomeList2) {
			iDTotal+=ir.getIncomenum();
		}
		for(SpendRecord sr:spendList2) {
			sDTotal+=sr.getSpendnum();
		}

		//提取 月份 
		String datestr = SingleDateFormat.getDateToString(recordInfo.getDate());
		String [] dateArray = datestr.split("-");
		String month = dateArray[1];//月份
		//这个 fastjson-1.1.15 如果是 1.1.20的话 eclipse 识别不了！！！  fastjson
		
		String month2 = "";
		//将 前台传过来的 月份 统计 统一月份收入 数据 
		for(IncomeRecord ir:incomeList) {
			month2 = SingleDateFormat.getDateToString(ir.getDate()).split("-")[1];
			if(month2.equals(month)) {
				iMTotal+=ir.getIncomenum();
			}
		}
		/*
		 * 对其中 的日期进行格式转换  为 yyyy-MM-dd 但是 传给 前端 还是 毫秒值 只不过 是 没有时分秒的毫秒值  那么 就在 前台 转换好了
		 * System.out.println("json 日期转换"+JSON.toJSONString(new Date()));
		String dataFormat = "yyyy-MM-dd";
        String dateJson = JSON.toJSONStringWithDateFormat(new Date(), dataFormat, 
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println(dateJson);*/
		
		//获得 用户 选择 那个 月的 支出数
		for(SpendRecord sr:spendList) {
			month2 = SingleDateFormat.getDateToString(sr.getDate()).split("-")[1];
			if(month2.equals(month)) {
				sMTotal+=sr.getSpendnum();
			}
		}
		int restnum = iMTotal - sMTotal;//算的 结余数 
		Map<String,Object> map3 = new HashMap<String,Object>();
		map3.put("spendnum", sMTotal);
		map3.put("incomenum", iMTotal);
		map3.put("restnum", restnum);
		map3.put("incomelist", incomeList);
		map3.put("dateIncomeNum", iDTotal);
		map3.put("dateSpendNum", sDTotal);
		String jsonstr3 = JSON.toJSONString(map3);  //fastjson 将 map转换为 json格式的字符串  强大呀
		
		/*return "{\"spendnum\":\""+sTotal+"\",\"incomenum\":\""+iTotal+"\",\"restnum\":\""+restnum+"\"}";*/
		
		//用 fastjson 第三方包 将 list转换为 json格式的 字符串 就不用自己 很辛苦拼了
		return jsonstr3;
	}
}



















