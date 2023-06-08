package com.erd.schooljpa.repository;

import com.erd.schooljpa.entity.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian,Long> {
}
