package com.samsung.IMS.db.repository;

import com.samsung.IMS.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
