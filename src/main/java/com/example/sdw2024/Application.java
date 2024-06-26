package com.example.sdw2024;

import com.example.sdw2024.application.AskChampionUseCase;
import com.example.sdw2024.application.ListChampionsUseCase;
import com.example.sdw2024.domain.ports.ChampionsRepository;
import com.example.sdw2024.domain.ports.GenerativeAiApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}

	@Bean
	public AskChampionUseCase provideAskChampionUseCase(ChampionsRepository repository, GenerativeAiApi genAiApi){
		return new AskChampionUseCase(repository, genAiApi);
	}
}
