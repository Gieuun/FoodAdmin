package com.sds.foodadmin.model.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.foodadmin.domain.Member;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	public Member findAdmin() {
		return adminDAO.findAdmin("admin");
	}

}
