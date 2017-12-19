package cn.edu.zhku.pojo;

import java.util.Date;

public class SpendRecord {
	private int id;
	private int spendnum;//Ïû·Ñ½ğ¶î
	private Date date;
	private String comment;
	private int user_id;
	private int s_category_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpendnum() {
		return spendnum;
	}
	public void setSpendnum(int spendnum) {
		this.spendnum = spendnum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
