package com.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.entities.User;
import com.blog.repository.UserRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	@Order(1)
	public void testCreate() {

		assertNotNull(userRepo.findById(2).get());

	}

	@Test
	@Order(2)
	public void testReadAll() {

		List<User> list = userRepo.findAll();

		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleProduct() {

		User user = userRepo.findById(2).get();

		assertEquals("vedant111", user.getPassword());

	}

	@Test
	@Order(4)
	public void testUpdateUser() {

		User user = userRepo.findById(2).get();

		user.setName("vedu");
		userRepo.save(user);

		assertNotEquals("vedant", userRepo.findById(2).get());
	}

	@Test
	@Order(5)
	public void testDeleteUser() {

		userRepo.deleteById(3);

		assertThat(userRepo.existsById(3)).isFalse();
	}
}
