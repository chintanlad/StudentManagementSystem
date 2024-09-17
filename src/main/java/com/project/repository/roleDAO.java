package com.project.repository;

import java.util.List;

import com.project.entities.authorities;

public interface roleDAO
{
	
	List<authorities> getAllRoles();
	void addRole(authorities role);
	boolean deleteAllRole();
	public boolean deleteRoleById(int user_id);
	public boolean updateRoleById(int user_id, authorities role);

}
