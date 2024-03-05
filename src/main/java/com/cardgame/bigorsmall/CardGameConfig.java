package com.cardgame.bigorsmall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardGameConfig {

    @Bean
    public CardGame cardGame() {
        return new CardGame();
    }
}