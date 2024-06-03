package com.sds.foodadmin.domain;

import lombok.Data;

@Data
public class Notice {
  
	private int noticeIdx;
	private String title;
	private String writer;
	private String content;
	private String regdate; //LocalDateTime  
	private int hit;
}
