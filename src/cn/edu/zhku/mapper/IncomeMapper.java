package cn.edu.zhku.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;

public interface IncomeMapper {
	int addIncomeCate(IncomeCategory incomeCate);

	List<IncomeCategory> queryAllIncomeCate();

	int addIncomeRecord(IncomeRecord incomeRecord);
	
	//�����ֶ�ֵ ��ȡ���� �������
	IncomeCategory queryIncomeCategoryName(int id);

	List<IncomeRecord> queryIncomeRecordByDateId(Map map);

	List<IncomeRecord> queryIncomeRecordByUserId(int id);
}
