package com.shahed.instaservice.repository;

import com.shahed.instaservice.schema.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getByUserId(Long userId);
}
