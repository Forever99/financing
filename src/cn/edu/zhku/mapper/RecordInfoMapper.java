package cn.edu.zhku.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.pojo.RecordInfo;

public interface RecordInfoMapper {
	List<RecordInfo> queryAllRecordInfo();
	//��ҳ��ѯ ����
	List<RecordInfo> queryRecordInfoByDate(Map map);
	int addRecordInfo(RecordInfo recordInfo);
	
}
