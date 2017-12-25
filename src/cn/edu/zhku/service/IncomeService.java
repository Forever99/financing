package cn.edu.zhku.service;

import java.util.List;

import cn.edu.zhku.pojo.IncomeCategory;

public interface IncomeService {
	public int addIncomeCate(IncomeCategory incomeCate);

	public List<IncomeCategory> queryAllIncomeCate();
}
