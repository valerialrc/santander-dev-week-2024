package com.example.sdw2024.domain.ports;

import com.example.sdw2024.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll();

    Optional<Champions> findById(Long id);

}
