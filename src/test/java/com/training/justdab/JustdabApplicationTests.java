package com.training.justdab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class JustdabApplicationTests {

	@Container
	private static final MySQLContainer<?> SQL_CONTAINER = new MySQLContainer<>()
			.withDatabaseName("just_dab_db");

	@DynamicPropertySource
	static void configureMySqlProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", SQL_CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", SQL_CONTAINER::getUsername);
		registry.add("spring.datasource.password", SQL_CONTAINER::getPassword);
	}

	@Test
	void contextLoads() {
	}

}