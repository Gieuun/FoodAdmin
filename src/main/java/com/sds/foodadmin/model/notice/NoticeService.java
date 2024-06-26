package com.sds.foodadmin.model.notice;

import java.util.List;
import java.util.Map;

import com.sds.foodadmin.domain.Notice;

public interface NoticeService {
	public int getTotalCount();
	int getTotalCountByQuery(String titleKeyword);
	public List<Notice> getAllNotices(Map<String, Integer> map); //모두 가져오기 //리스트타입 선언
	public Notice select(int noticeIdx); //한건 가져오기 
	public void insert(Notice notice);//한건 넣기
	public void update(Notice notice); //한건 수정 
	public void delete(Notice notice); //한건 삭제
	public List<Notice> searchNoticesByTitle(Map<String, Object> map); //검색기능
}

