package com.project.service;

import java.util.List;

import com.project.entities.authorities;
import com.project.entities.users;

public interface RoleService {
	List<authorities> getAllRoles();

	void addRole(authorities role);


	boolean deleteAllRole();

}
