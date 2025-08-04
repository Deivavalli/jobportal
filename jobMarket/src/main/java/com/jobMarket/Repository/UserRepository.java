package com.jobMarket.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobMarket.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserEmail(String email);

	boolean existByUserName(String name);

	boolean existByUserEmail(String email);

}
