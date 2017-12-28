package cn.edu.zhku.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zhku.mapper.IncomeMapper;
import cn.edu.zhku.mapper.RecordInfoMapper;
import cn.edu.zhku.pojo.IncomeCategory;
import cn.edu.zhku.pojo.IncomeRecord;
import cn.edu.zhku.pojo.RecordInfo;
@Service
public class IncomeServiceImpl implements IncomeService{
	@Autowired
	private IncomeMapper incomeMapper;
	@Autowired
	private RecordInfoMapper recordInfoMapper;
	
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
		//插入输入信息 后 要 插入到记录 收支 信息表中
		int num = incomeMapper.addIncomeRecord(incomeRecord);
		
		//这里 要将 IncomeRecord bean中 的数据 放到  RecordInfo bean 中 可以 写个 bean 数据封装 的代码 这里 有待 优化
		//还要根据  i_category_id  查找 类别 
		String cateName = incomeMapper.queryIncomeCategoryName(incomeRecord.getI_category_id()).getName();
		RecordInfo ri = new RecordInfo();
		ri.setNumber(incomeRecord.getIncomenum());
		ri.setDate(incomeRecord.getDate());
		ri.setCate_name(cateName);
		ri.setComment(incomeRecord.getComment()+"  收入");
		ri.setUser_id(incomeRecord.getUser_id());
		recordInfoMapper.addRecordInfo(ri);
		
		return num;
	}
	@Override
	public IncomeCategory queryIncomeCategoryName(int id) {
		return incomeMapper.queryIncomeCategoryName(id);
	}
	@Override
	public List<IncomeRecord> queryIncomeRecordByDateId(Map map) {
		return incomeMapper.queryIncomeRecordByDateId(map);
	}
	@Override
	public List<IncomeRecord> queryIncomeRecordByUserId(int id) {
		return incomeMapper.queryIncomeRecordByUserId(id);
	}
	
}
