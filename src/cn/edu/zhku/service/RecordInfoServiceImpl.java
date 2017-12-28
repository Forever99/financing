package cn.edu.zhku.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zhku.mapper.RecordInfoMapper;
import cn.edu.zhku.pojo.RecordInfo;
@Service
public class RecordInfoServiceImpl implements RecordInfoService{
	@Autowired
	private RecordInfoMapper recordInfoMapper;
	
	@Override
	public List<RecordInfo> queryAllRecordInfo() {
		return recordInfoMapper.queryAllRecordInfo();
	}

	@Override
	public int addRecordInfo(RecordInfo recordInfo) {
		return recordInfoMapper.addRecordInfo(recordInfo);
	}

	@Override
	public List<RecordInfo> queryRecordInfoByDatePage(Map map) {
		return recordInfoMapper.queryRecordInfoByDate(map);
	}

}
