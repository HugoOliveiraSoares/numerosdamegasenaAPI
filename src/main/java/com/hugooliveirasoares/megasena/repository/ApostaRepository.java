package com.hugooliveirasoares.megasena.repository;

import com.hugooliveirasoares.megasena.entity.ApostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApostaRepository extends JpaRepository<ApostaEntity, Long> {

    List<ApostaEntity> findByEmail(String email);

}
