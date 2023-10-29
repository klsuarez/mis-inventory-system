package com.samsung.IMS.repository;

import com.samsung.IMS.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
