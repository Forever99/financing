package cn.edu.zhku.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zhku.mapper.RecordInfoMapper;
import cn.edu.zhku.mapper.SpendMapper;
import cn.edu.zhku.pojo.RecordInfo;
import cn.edu.zhku.pojo.SelectSumPojo;
import cn.edu.zhku.pojo.SpendCategory;
import cn.edu.zhku.pojo.SpendRecord;

@Service
public class SpendServiceImpl implements SpendService{
	@Autowired
	private SpendMapper spendMapper;
	
	@Autowired
	private RecordInfoMapper recordInfoMapper;
	
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
		//增加完消费记录后要 将消费信息 记录到 收支表 
		int num = spendMapper.addSpendRecord(spendRecord);
		String cateName = spendMapper.querySpendCateName(spendRecord.getS_category_id()).getName();
		RecordInfo ri = new RecordInfo();
		ri.setNumber(spendRecord.getSpendnum());
		ri.setDate(spendRecord.getDate());
		ri.setCate_name(cateName);
		ri.setComment(spendRecord.getComment()+"  支出");
		ri.setUser_id(spendRecord.getUser_id());
		recordInfoMapper.addRecordInfo(ri);
		return num;
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

	@Override
	public List<SpendRecord> querySpendRecordByDateUserId(Map map) {
		return spendMapper.querySpendRecordByDateUserId(map);
	}

	@Override
	public List<SelectSumPojo> queryMonthNumdata(Map map) {
		return spendMapper.queryMonthNumdata(map);
	}

	@Override
	public List<SelectSumPojo> querySpendCateData(Map map) {
		return spendMapper.querySpendCateData(map);
	}

}
