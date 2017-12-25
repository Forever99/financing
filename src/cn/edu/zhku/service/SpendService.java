package cn.edu.zhku.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.pojo.SpendCategory;
import cn.edu.zhku.pojo.SpendRecord;

public interface SpendService {
	public int addSpendCate(SpendCategory spendCate);
	public int deleteSpendCate(int id);
	public List<SpendCategory> queryAllSpendCate();
	public int addSpendRecord(SpendRecord spendRecord);
	public List<SpendRecord> queryAllSpendRecord();
	public List<SpendRecord> queryApendRecordDate(Date date,int start,int end);
	public List<SpendRecord> queryApendRecordDate2(Date date);
	public SpendRecord querySpendRecord(int id);
}
