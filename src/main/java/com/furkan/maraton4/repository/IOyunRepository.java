package com.furkan.maraton4.repository;

import com.furkan.maraton4.repository.entity.Oyun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IOyunRepository extends JpaRepository<Oyun,Long> {
}
