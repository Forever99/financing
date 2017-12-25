package cn.edu.zhku.mapper;

import java.util.List;

import cn.edu.zhku.pojo.IncomeCategory;

public interface IncomeMapper {
	int addIncomeCate(IncomeCategory incomeCate);

	List<IncomeCategory> queryAllIncomeCate();

}
