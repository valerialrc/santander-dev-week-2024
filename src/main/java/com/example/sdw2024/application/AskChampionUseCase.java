package com.example.sdw2024.application;

import com.example.sdw2024.domain.exception.ChampionNotFoundException;
import com.example.sdw2024.domain.model.Champions;
import com.example.sdw2024.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {
    public String askChampion(Long championId, String question) {
        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        return championContext;
    }
}
