package com.furkan.maraton4.repository;

import com.furkan.maraton4.repository.entity.Oyuncu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface IOyuncuRepository extends JpaRepository<Oyuncu,Long> {
    Optional<Oyuncu> findOptionalByUsername(String username);
    List<Oyuncu> findByAd(String ad);

    Optional<List<Oyuncu>> findOptionalByPuanGreaterThan(int puan);


}
