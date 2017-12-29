package cn.edu.zhku.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.edu.zhku.pojo.RecordInfo;
import cn.edu.zhku.service.RecordInfoService;
import cn.edu.zhku.util.SingleDateFormat;

@Controller
@RequestMapping("/recordInfo")
public class RecordInfoController {
	@Autowired
	private RecordInfoService recordInfoService;
	
	@RequestMapping(value="queryAllrecord")
	@ResponseBody
	public String queryAllrecord(HttpServletRequest request) {
		int pagesize = 5;//定义 每页 显示满 5条数据
		String userid = request.getParameter("userId");
		String currentpage = request.getParameter("currentPage");
		String pardate = request.getParameter("date");
		System.out.println("时间为："+pardate);
		int userId = 0;
		int currentPage = 0;
		Date date = null;
		if(userid!=null && !"".equals(userid.trim())) {
			userId = Integer.parseInt(userid);// 用户id
		}
		if(currentpage!=null && !"".equals(currentpage.trim())) {
			currentPage = Integer.parseInt(currentpage); //当前页
		}
		if(pardate!=null && !"".equals(pardate.trim())) {
			date = SingleDateFormat.getStringToDate(pardate);
		}
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("user_id", userId);
		map1.put("pagesize", null);
		if(date!=null) {
			map1.put("date", date);
		}
		//查询 数据总量
		List<RecordInfo> rd = recordInfoService.queryRecordInfoByDatePage(map1);
		int datanum = 0;
		if(rd!=null) {
			datanum = rd.size();
		}
		int totalPages = 0;//总页数
		if(datanum!=0) {
			if(datanum/pagesize==0) {
				totalPages = 1;//数据 不到 5条 那么 就只有1页
			}else {
				if(datanum%pagesize==0) {
					totalPages = datanum/pagesize;
				}else {
					totalPages = (datanum/pagesize) + 1;
				}
			}
		}
		
		//在 总页数 不为 0 的前提下 分页查找
		List<RecordInfo> rilist = null;
		if(totalPages!=0) {
			if(currentPage>0) {//当前页最少 也是 1
				map1.put("pagesize",pagesize);
				map1.put("start", (currentPage-1)*pagesize);//数据库中  limit 第一个参数 >=0
				rilist = recordInfoService.queryRecordInfoByDatePage(map1);
			}
			
		}
		//接下来返回 json 数据 返回：总页数 分页查询 数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalPages", totalPages);
		map.put("pageResult", rilist);
		return JSON.toJSONString(map);
	}
}
