package net.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.app.registration.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

		public User findByEmailId(String email);
		public User finByEmailIdAndPassword(String email, String Password);
	}