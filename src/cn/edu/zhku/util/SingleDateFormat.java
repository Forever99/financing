package cn.edu.zhku.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//���� ���� Ϊ�� ������ �ַ��� ֮���ת��
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
	//���� ת��  �� �� ʱ����� ʱ�� ת��Ϊ  ֻ�� ���ڵ� ʱ�� 
	public static Date exchangeDate(Date date) {
		//��ת Ϊ yyyy-MM-ddʱ�� �ַ���  
		String datestr = getDateToString(date);
		//��ת��Ϊ ʱ������
		return getStringToDate(datestr);
	}
}
