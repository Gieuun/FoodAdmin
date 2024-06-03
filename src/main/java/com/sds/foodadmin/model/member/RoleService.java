package com.sds.foodadmin.model.member;

import com.sds.foodadmin.domain.Role;

public interface RoleService {

	public Role selectByName(String role_name);
}
