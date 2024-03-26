package com.example.sdw2024.application;

import com.example.sdw2024.domain.model.Champions;
import com.example.sdw2024.domain.ports.ChampionsRepository;
import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champions> findAll(){
        return repository.findAll();
    }
}
