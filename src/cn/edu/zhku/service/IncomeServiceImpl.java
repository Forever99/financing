package cn.edu.zhku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zhku.mapper.IncomeMapper;
import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;
@Service
public class IncomeServiceImpl implements IncomeService{
	@Autowired
	private IncomeMapper incomeMapper;
	@Override
	public int addIncomeCate(IncomeCategory incomeCate) {
		return incomeMapper.addIncomeCate(incomeCate);
	}
	@Override
	public List<IncomeCategory> queryAllIncomeCate() {
		return incomeMapper.queryAllIncomeCate();
	}
	@Override
	public int addIncomeRecord(IncomeRecord incomeRecord) {
		return incomeMapper.addIncomeRecord(incomeRecord);
	}
	
}
