package com.sds.foodadmin.model.member;

import com.sds.foodadmin.domain.Sns;

public interface SnsService {

	public Sns selectByName(String sns_name);
}
