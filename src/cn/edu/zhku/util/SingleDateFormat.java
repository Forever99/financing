package cn.edu.zhku.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//日期 单例 为了 日期与 字符串 之间的转换
public class SingleDateFormat {
	private SingleDateFormat() {}
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SingleDateFormat instance = null;
	public static SingleDateFormat getInstance() {
		if(instance==null) {
			instance = new SingleDateFormat();
		}
		return instance;
	}
	public static String getDateToString(Date date) {
		return date!=null ? sdf.format(date) : null;
	}
	public static Date getStringToDate(String datestr) {
		try {
			return (datestr!=null && !"".equals(datestr.trim()))? sdf.parse(datestr):null;
		} catch (ParseException e) {
			throw new RuntimeException();
		}
	}
	//日期 转换  将 带 时分秒的 时间 转换为  只有 日期的 时间 
	public static Date exchangeDate(Date date) {
		//先转 为 yyyy-MM-dd时间 字符串  
		String datestr = getDateToString(date);
		//在转换为 时间类型
		return getStringToDate(datestr);
	}
}
