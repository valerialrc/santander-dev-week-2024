package com.example.sdw2024.application;

import com.example.sdw2024.domain.exception.ChampionNotFoundException;
import com.example.sdw2024.domain.model.Champions;
import com.example.sdw2024.domain.ports.ChampionsRepository;
import com.example.sdw2024.domain.ports.GenerativeAiApi;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiApi genAiApi) {
    public String askChampion(Long championId, String question) {
        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
                Responda perguntas incorporando a personalidade e estilo de determinado campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore (história).
                
                """;

        return genAiApi.generateContent(objective, context);
    }
}
