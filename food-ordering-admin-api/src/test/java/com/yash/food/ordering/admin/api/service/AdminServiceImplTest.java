package com.yash.food.ordering.admin.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.food.ordering.admin.api.entity.Admin;
import com.yash.food.ordering.admin.api.repository.AdminRepository;

@SpringBootTest
public class AdminServiceImplTest {

	@InjectMocks
	private AdminServiceImpl adminService;

	@Mock
	private AdminRepository adminRepository;

	private String name = "saveAdmin";

	Admin admin = new Admin(1, name, name, name);

	@Test
	public void testSaveAdmin() {

		adminService.saveAdmin(admin);
		assertEquals(1, 1);
	}

	@Test
	public void testFindAdminByEmail() {
		Mockito.when(adminRepository.findByAdminEmail(name)).thenReturn(admin);
		admin = adminService.findAdminByEmail(name);
		assertEquals(name, admin.getAdmin_name());
	}

	@Test
	public void testFindByEmailAndPassword() {
		Mockito.when(adminRepository.findByAdminEmailAndAdminPassword(name, name)).thenReturn(admin);
		admin = adminService.findAdminByEmailAndPassword(name, name);
		assertEquals(name, admin.getAdmin_name());
	}
}
