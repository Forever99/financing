package cn.edu.zhku.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;
import cn.edu.zhku.pojo.SpendCategory;
import cn.edu.zhku.pojo.SpendRecord;
import cn.edu.zhku.pojo.User;
import cn.edu.zhku.service.IncomeService;
import cn.edu.zhku.service.SpendService;
import cn.edu.zhku.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext-*.xml"})
public class TestMybatis {
	@Resource
	private UserService userService;
	@Resource
	private SpendService spendService;
	@Resource
	private IncomeService incomeService;
	@Test
	public void testuser1() {
		@SuppressWarnings("unused")
		List<User> list = userService.queryAllUser();
	}
	@Test
	public void test2() {
		User user = new User();
		user.setUsername("wowo");
		user.setPassword("123123");
		User user2 = userService.singin(user);
		System.out.println(user2.getEmail());
	}
	@Test
	public void test3() {
		User user = new User();
		user.setId(1);
		
		user.setUsername("wowo");
		int num = userService.updateUserName(user);
		System.out.println(num);
	}
	@Test
	public void test4() {
		User user = new User();
		user.setId(1);
		user.setPassword("123123");
		
		int num = userService.updateUserPassword(user);
		System.out.println(num);
	}
	@Test
	public void test5() {
		String password = "222111";
		//以下 输入 2 说明 返回的值就是 被影响的 行数！!
		/*System.out.println(userService.updateTestreturn(password));*/
	}
	@SuppressWarnings("unused")
	@Test
	public void test6() {
		int id = 5;
		User user = userService.queryUserById(id);
	}
	@Test//测试  消费类别 表 
	public void testInsertS_cate() {
		/*插入 成功
		 * SpendCategory s_cate = new SpendCategory();
		s_cate.setName("生活用品");
		spendService.addSpendCate(s_cate);*/
		//测试删除  删除 通过测试
		/*int id = 3;
		int num = spendService.deleteSpendCate(id);
		System.out.println(num);*/
		
		//查询所有 测试  通过测试！ 
		List<SpendCategory> list = spendService.queryAllSpendCate();
		for(SpendCategory cate:list) {
			System.out.print(cate.getName()+" ");
		}
	}
	@Test//测试 插入 消费记录 表 
	public void testInsertS_record() {
		SpendRecord s_record = new SpendRecord(); 
		s_record.setSpendnum(300);
		System.out.println(new Date());
		s_record.setDate(new Date());
		s_record.setS_category_id(4);
		s_record.setComment("测试时间");
		s_record.setUser_id(3);
		spendService.addSpendRecord(s_record);
	}
	@Test
	public void testQueryS_record() {
		List<SpendRecord> list = spendService.queryAllSpendRecord();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		Date date1 = new Date();
		String datestr = sdf.format(date1);
		Date date;
		try {
			date = sdf.parse(datestr);
			spendService.queryApendRecordDate2(date);
			for(SpendRecord spendRecord:list) {
				System.out.print(sdf.format(spendRecord.getDate())+"时间条件 ");
			}
			SpendRecord sr = spendService.querySpendRecord(4);
			System.out.println(sdf.format(sr.getDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testQueryS_recordDate() {
		/*HashMap<String,String> map = new HashMap<String,String>();*/
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sdf.format(new Date());*/
		Date date = new Date();
		System.out.println(date);
		/*map.put("date", date);*/
		List<SpendRecord> list = spendService.queryApendRecordDate2(date);
		for(SpendRecord spendRecord:list) {
			System.out.print(spendRecord.getComment()+" ");
		}
	
	}
	
	//测试 收入类别
	@Test
	public void testI_cate() {
		/*IncomeCategory incomeCate = new IncomeCategory();
		incomeCate.setName("工资收入");
		int num = incomeService.addIncomeCate(incomeCate);
		System.out.println(num);*/
		List<IncomeCategory> list = incomeService.queryAllIncomeCate();
		for(IncomeCategory incomeCate2:list) {
			System.out.print(incomeCate2.getName()+" ");
		}
		IncomeRecord i = new IncomeRecord();
		Date date = new Date();
		i.setIncomenum(90);
		i.setComment("国考报名费");
		i.setDate(date);
		i.setUser_id(2);
		i.setI_category_id(5);
		incomeService.addIncomeRecord(i);
	}
	
	
}
