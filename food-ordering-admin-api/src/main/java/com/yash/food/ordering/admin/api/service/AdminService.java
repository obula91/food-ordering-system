package com.yash.food.ordering.admin.api.service;

import java.util.List;

import com.yash.food.ordering.admin.api.entity.Admin;
import com.yash.food.ordering.admin.api.model.Food;



public interface AdminService {

	public void saveAdmin(Admin admin);
//
//	public List<Menu> getAllMenus();
//
//	public List<Menu> deleteMenu(int id);
//
//	public void addMenu(Menu menu);
//
	public Admin findAdminByEmail(String email);
	
	public Admin findAdminByEmailAndPassword(String email, String password);

	
}
