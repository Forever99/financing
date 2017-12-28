package cn.edu.zhku.service;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;

public interface IncomeService {
	public int addIncomeCate(IncomeCategory incomeCate);
	public List<IncomeCategory> queryAllIncomeCate();
	public int addIncomeRecord(IncomeRecord incomeRecord);
	IncomeCategory queryIncomeCategoryName(int id);
	List<IncomeRecord> queryIncomeRecordByDateId(Map map);
	List<IncomeRecord> queryIncomeRecordByUserId(int id);
}
