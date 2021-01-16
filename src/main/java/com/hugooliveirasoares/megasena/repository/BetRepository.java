package com.hugooliveirasoares.megasena.repository;

import com.hugooliveirasoares.megasena.entity.BetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<BetEntity, Long> {

    List<BetEntity> findByEmail(String email);

}
