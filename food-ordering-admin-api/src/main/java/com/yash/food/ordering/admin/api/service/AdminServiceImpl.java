package com.yash.food.ordering.admin.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.food.ordering.admin.api.entity.Admin;
import com.yash.food.ordering.admin.api.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public void saveAdmin(Admin admin) {
		
		adminRepository.save(admin);
	}

	@Override
	public Admin findAdminByEmail(String email) {
		return adminRepository.findByAdminEmail(email);
	}

	@Override
	public Admin findAdminByEmailAndPassword(String email, String password) {
		
		return adminRepository.findByAdminEmailAndAdminPassword(email, password);
	}


}
