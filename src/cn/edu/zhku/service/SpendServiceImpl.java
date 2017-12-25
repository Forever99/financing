package cn.edu.zhku.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zhku.mapper.SpendMapper;
import cn.edu.zhku.pojo.SpendCategory;
import cn.edu.zhku.pojo.SpendRecord;

@Service
public class SpendServiceImpl implements SpendService{
	@Autowired
	private SpendMapper spendMapper;
	@Override
	public int addSpendCate(SpendCategory spendCate) {
    	return spendMapper.addSpendCate(spendCate);
	}

	@Override
	public int deleteSpendCate(int id) {
		return spendMapper.deleteSpendCate(id);
	}

	@Override
	public List<SpendCategory> queryAllSpendCate() {
		return spendMapper.queryAllSpendCate();
	}

	@Override
	public int addSpendRecord(SpendRecord spendRecord) {
		return spendMapper.addSpendRecord(spendRecord);
	}

	@Override
	public List<SpendRecord> queryAllSpendRecord() {
		return spendMapper.queryAllSpendRecord();
	}

	@Override
	public List<SpendRecord> queryApendRecordDate(Date date, int start, int end) {
		return spendMapper.querySpendRecordDate(date,start,end);
	}

	@Override
	public List<SpendRecord> queryApendRecordDate2(Date date) {
		return spendMapper.querySpendRecordDate2(date);
	}

	@Override
	public SpendRecord querySpendRecord(int id) {
		return spendMapper.querySpendRecord(id);
	}

}
