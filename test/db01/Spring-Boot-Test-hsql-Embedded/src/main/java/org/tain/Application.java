package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.domain.Address;
import org.tain.domain.Name;
import org.tain.domain.User;
import org.tain.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Cleanup the users table
		this.userRepository.deleteAllInBatch();
		
		// Insert a new user in the database
		Name name = new Name("Rajeev", "Kumar", "Signh");
		Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
		User user = new User(name, "rajeev@callicoder.com", address);
		
		this.userRepository.save(user);
		
		this.userRepository.findAll().forEach(System.out::println);
	}
}
