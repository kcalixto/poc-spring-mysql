package com.kcalixto.poc.mysql.repo;

import com.kcalixto.poc.mysql.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
