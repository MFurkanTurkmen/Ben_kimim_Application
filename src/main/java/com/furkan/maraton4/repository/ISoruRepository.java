package com.furkan.maraton4.repository;

import com.furkan.maraton4.repository.entity.Soru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ISoruRepository extends JpaRepository<Soru,Long> {

    Optional<Soru> findOptionalByDogrucevap(String dogruCevap);

}
