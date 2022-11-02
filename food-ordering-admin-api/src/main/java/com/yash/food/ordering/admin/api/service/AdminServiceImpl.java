package com.yash.food.ordering.admin.api.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.food.ordering.admin.api.entity.Admin;
import com.yash.food.ordering.admin.api.repository.AdminRepository;


/**
 * the class AdminServiceImpl
 * @author obula.reddy
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public void saveAdmin(Admin admin) {
		try {
		adminRepository.save(admin);
		}catch(Exception exception) {
			logger.info("saveAdmin :: "+exception.getMessage());
		}
	}

	/**
	 * @return Admin
	 */
	@Override
	public Admin findAdminByEmail(String email) {
		Admin admin=new Admin();
		try {
			admin= adminRepository.findByAdminEmail(email);
		}catch(Exception exception) {
			logger.info("findAdminByEmail :: "+exception.getMessage());
		}
		return admin;
	}

	@Override
	public Admin findAdminByEmailAndPassword(String email, String password) {
		Admin admin=new Admin();
		try {
		admin= adminRepository.findByAdminEmailAndAdminPassword(email, password);
		}catch(Exception exception) {
			logger.info("findAdminByEmailAndPassword :: "+exception.getMessage());
		}
		return admin;
	}


}
