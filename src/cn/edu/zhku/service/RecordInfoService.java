package cn.edu.zhku.service;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.pojo.RecordInfo;

public interface RecordInfoService {
	List<RecordInfo> queryAllRecordInfo();
	int addRecordInfo(RecordInfo recordInfo);
	List<RecordInfo> queryRecordInfoByDatePage(Map map);
}
