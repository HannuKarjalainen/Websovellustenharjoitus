package com.cardgame.bigorsmall;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CardGameController {

    private final CardGame cardGame;

    public CardGameController(CardGame cardGame) {
        this.cardGame = cardGame;
    }

    @GetMapping("/") 
    public String index() throws IOException {
        Resource resource = new ClassPathResource("static/index.html");
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }

    @GetMapping("/draw") 
    public String drawCard() {
        return cardGame.drawCard();
    }

    @PostMapping("/guess") 
    public String makeGuess(@RequestBody String guess) {
        return cardGame.makeGuess(guess);
    }

    @GetMapping("/start") 
    public String startGame() {
        return cardGame.startGame();
    }

    @GetMapping("/guide") 
        public String getGuide() {
            return cardGame.getGuide();
        }

    @GetMapping("/currentCard")
    public String getCurrentCard() {
        return cardGame.getCurrentCard();
    }

    @GetMapping("/correctGuesses")
    public String getCorrectGuesses() {
        return cardGame.getCorrectGuesses();
    }
}
