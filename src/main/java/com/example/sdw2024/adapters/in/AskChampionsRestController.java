package com.example.sdw2024.adapters.in;

import com.example.sdw2024.application.AskChampionUseCase;
import com.example.sdw2024.application.ListChampionsUseCase;
import com.example.sdw2024.domain.model.Champions;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do LOL")
@RestController
@RequestMapping("/champions")
public record AskChampionsRestController(AskChampionUseCase useCase) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampionResponse(@PathVariable Long championId, @RequestBody AskChampionRequest request){
        String answer = useCase.askChampion(championId, request.question());
        
        return new AskChampionResponse(answer);
    }
    
    public record  AskChampionRequest(String question){}
    public record  AskChampionResponse(String answer){}

}
