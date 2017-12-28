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
		//����������Ϣ �� Ҫ ���뵽��¼ ��֧ ��Ϣ����
		int num = incomeMapper.addIncomeRecord(incomeRecord);
		
		//���� Ҫ�� IncomeRecord bean�� ������ �ŵ�  RecordInfo bean �� ���� д�� bean ���ݷ�װ �Ĵ��� ���� �д� �Ż�
		//��Ҫ����  i_category_id  ���� ��� 
		String cateName = incomeMapper.queryIncomeCategoryName(incomeRecord.getI_category_id()).getName();
		RecordInfo ri = new RecordInfo();
		ri.setNumber(incomeRecord.getIncomenum());
		ri.setDate(incomeRecord.getDate());
		ri.setCate_name(cateName);
		ri.setComment(incomeRecord.getComment()+"  ����");
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
