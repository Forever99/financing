package cn.edu.zhku.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.pojo.RecordInfo;

public interface RecordInfoMapper {
	List<RecordInfo> queryAllRecordInfo();
	//分页查询 数据
	List<RecordInfo> queryRecordInfoByDate(Map map);
	int addRecordInfo(RecordInfo recordInfo);
	
}
