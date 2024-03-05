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

    @GetMapping("/")  //Tämä endpoint oli alunperin tarkoitus näyttää ohjeet, mutta tein sitten kuitenkin graafisen UI:n tehtävänannon vastaisesti. Ohjeet ohjattu /guide.
    public String index() throws IOException {
        Resource resource = new ClassPathResource("static/index.html");
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }

    @GetMapping("/draw")  // Tämä endpoint vetää kortin pakasta ja palauttaa sen. Jos pakka on tyhjä, ilmoitetaan siitä käyttäjälle.
    public String drawCard() {
        return cardGame.drawCard();
    }

    @PostMapping("/guess") // Tämä endpoint ottaa vastaan pelaajan arvauksen ("isompi" tai "pienempi") ja vertaa sitä seuraavaan korttiin pakassa. Se palauttaa viestin, joka ilmoittaa, menikö arvaus oikein vai väärin, ja näyttää myös seuraavan kortin. Lisäksi se pitää kirjaa oikeista arvauksista ja ilmoittaa niiden määrän.
    public String makeGuess(@RequestBody String guess) {
        return cardGame.makeGuess(guess);
    }

    @GetMapping("/start") //Tämä endpoint aloittaa uuden pelin. Se luo täyden pakan, sekoittaa sen uudestaan ja vetää ensimmäisen kortin. Se palauttaa viestin, jossa kerrotaan, että peli on aloitettu, ja näyttää ensimmäisen kortin.
    public String startGame() {
        return cardGame.startGame();
    }

    @GetMapping("/guide") // Tämä endpoint on ohjeita varten pienempi tai isompi kirjoitetaan postmania käyttäessä post bodyyn raw tekstinä
        public String getGuide() {
            return cardGame.getGuide();
        }

    @GetMapping("/currentCard") // Getter currentCard-muuttujalle
    public String getCurrentCard() {
        return cardGame.getCurrentCard();
    }

    @GetMapping("/correctGuesses") // Tämä endpoint on tehty arvausten määrän palauttamiseksi
    public String getCorrectGuesses() {
        return cardGame.getCorrectGuesses();
    }
}
