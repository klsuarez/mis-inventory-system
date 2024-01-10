package com.samsung.IMS.db.repository;

import com.samsung.IMS.db.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request save(Request request);

    Request findByUserId(Long userId);
}
