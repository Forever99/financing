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
		int pagesize = 5;//���� ÿҳ ��ʾ�� 5������
		String userid = request.getParameter("userId");
		String currentpage = request.getParameter("currentPage");
		String pardate = request.getParameter("date");
		System.out.println("ʱ��Ϊ��"+pardate);
		int userId = 0;
		int currentPage = 0;
		Date date = null;
		if(userid!=null && !"".equals(userid.trim())) {
			userId = Integer.parseInt(userid);// �û�id
		}
		if(currentpage!=null && !"".equals(currentpage.trim())) {
			currentPage = Integer.parseInt(currentpage); //��ǰҳ
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
		//��ѯ ��������
		List<RecordInfo> rd = recordInfoService.queryRecordInfoByDatePage(map1);
		int datanum = 0;
		if(rd!=null) {
			datanum = rd.size();
		}
		int totalPages = 0;//��ҳ��
		if(datanum!=0) {
			if(datanum/pagesize==0) {
				totalPages = 1;//���� ���� 5�� ��ô ��ֻ��1ҳ
			}else {
				if(datanum%pagesize==0) {
					totalPages = datanum/pagesize;
				}else {
					totalPages = (datanum/pagesize) + 1;
				}
			}
		}
		
		//�� ��ҳ�� ��Ϊ 0 ��ǰ���� ��ҳ����
		List<RecordInfo> rilist = null;
		if(totalPages!=0) {
			if(currentPage>0) {//��ǰҳ���� Ҳ�� 1
				map1.put("pagesize",pagesize);
				map1.put("start", (currentPage-1)*pagesize);//���ݿ���  limit ��һ������ >=0
				rilist = recordInfoService.queryRecordInfoByDatePage(map1);
			}
			
		}
		//���������� json ���� ���أ���ҳ�� ��ҳ��ѯ ����
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalPages", totalPages);
		map.put("pageResult", rilist);
		return JSON.toJSONString(map);
	}
}
