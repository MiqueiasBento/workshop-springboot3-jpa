package com.example.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

@Configuration		// Especifica uma classe de configuracao
@Profile("test")	// Especifica perfil para teste
public class TestConfig implements CommandLineRunner {
	
	@Autowired		// Resolve a dependencia e associa a dependencia de userRepository
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {		// Executado quando aplicacao iniciada
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));	// Cria um array com os Users e salva no repositorio
	}
	
	
}
