package cn.edu.zhku.pojo;

import java.util.Date;

//月消费记录
public class MonthSpendRecord {
	private int id;
	private int totalnum;
	private Date date;
	private int user_id;
	private int s_category_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getS_category_id() {
		return s_category_id;
	}
	public void setS_category_id(int s_category_id) {
		this.s_category_id = s_category_id;
	}
	
}
