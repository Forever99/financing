package cn.edu.zhku.pojo;
//创建 该 pojo 是为了 封装 从数据库中 查询到的数据
public class SelectSumPojo {
	private int totalNum;
	private String cate_name;
	private int month_num;
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public int getMonth_num() {
		return month_num;
	}
	public void setMonth_num(int month_num) {
		this.month_num = month_num;
	}
	
	
}
