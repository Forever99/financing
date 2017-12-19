package cn.edu.zhku.pojo;

import java.util.Date;

public class IncomeRecord {
	private int id;
	private int incomenum;//ÊÕÈë½ğ¶î
	private Date date;
	private int user_id;
	private int i_category_id;
	private String comment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIncomenum() {
		return incomenum;
	}
	public void setIncomenum(int incomenum) {
		this.incomenum = incomenum;
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
	public int getI_category_id() {
		return i_category_id;
	}
	public void setI_category_id(int i_category_id) {
		this.i_category_id = i_category_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
