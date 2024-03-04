package com.cardgame.bigorsmall;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class BigorsmallApplication {
    public static void main(String[] args) {
        SpringApplication.run(BigorsmallApplication.class, args);
    }

    @RestController
    public static class CardGameController {

        private List<String> deck = new ArrayList<>();
        private String currentCard = "";
        private int correctGuesses = 0;

        private Map<String, Integer> cardValues = new HashMap<>();

        public CardGameController() { //controlleri
            generateDeck();
            initializeCardValues();
        }

        private void initializeCardValues() { //metodi kortin arvojen määrittämiselle
            cardValues.put("2", 2);
            cardValues.put("3", 3);
            cardValues.put("4", 4);
            cardValues.put("5", 5);
            cardValues.put("6", 6);
            cardValues.put("7", 7);
            cardValues.put("8", 8);
            cardValues.put("9", 9);
            cardValues.put("10", 10);
            cardValues.put("Jatka", 11);
            cardValues.put("Rouva", 12);
            cardValues.put("Kuningas", 13);
            cardValues.put("Assa", 14);
        }

        private void generateDeck() { //medoti pakan luomiselle ja sekoittamiselle
            String[] suits = {"Hertta", "Ruutu", "Risti", "Pata"};
            String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jatka", "Rouva", "Kuningas", "Assa"};

            for (String suit : suits) {
                for (String value : values) {
                    deck.add(suit + " " + value);
                }
            }
            Collections.shuffle(deck);
        }

        @GetMapping("/") //Tämä endpoint oli alunperin tarkoitus näyttää ohjeet, mutta tein sitten kuitenkin graafisen UI:n tehtävänannon vastaisesti. Ohjeet ohjattu /guide.
        public String index() throws IOException {
            Resource resource = new ClassPathResource("static/index.html");
            return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
        }

        @GetMapping("/draw") // Tämä endpoint vetää kortin pakasta ja palauttaa sen. Jos pakka on tyhjä, ilmoitetaan siitä käyttäjälle.
        public String drawCard() {
            if (deck.isEmpty()) {
                return "Pakka tyhjä.";
            }
            currentCard = deck.remove(deck.size() - 1);
            return currentCard;
        }

        @PostMapping("/guess") // Tämä endpoint ottaa vastaan pelaajan arvauksen ("isompi" tai "pienempi") ja vertaa sitä seuraavaan korttiin pakassa. Se palauttaa viestin, joka ilmoittaa, menikö arvaus oikein vai väärin, ja näyttää myös seuraavan kortin. Lisäksi se pitää kirjaa oikeista arvauksista ja ilmoittaa niiden määrän.
        public String makeGuess(@RequestBody String guess) {
            if (!guess.equals("isompi") && !guess.equals("pienempi")) {
                return "Väärä arvaus. Valitse 'isompi' tai 'pienempi'.";
            }
        
            if (deck.isEmpty()) {
                return "Peli ohi. Sinulla meni arvaus oikein " + correctGuesses + " kertaa. Pakka on tyhjä.";
            }
        
            String drawnCard = currentCard.split(" ")[1];
            String printCard = deck.get(deck.size() - 1);
            String nextCard = deck.get(deck.size() - 1).split(" ")[1];
            
           // Hae korttien todelliset arvot          
           int drawnCardValue = cardValues.get(drawnCard);
           int nextCardValue = cardValues.get(nextCard);

            String result;
            if (drawnCardValue == nextCardValue) {
                result = "Uuden kortin arvo on sama kuin edellisen, oikein meni!";
                correctGuesses++;
            } else if (drawnCardValue == 14 || nextCardValue == 14) {
                result = "Ässä on 1 tai 14, eli oikein meni!";
                correctGuesses++;
            } else {
                boolean higher = nextCardValue > drawnCardValue;
                if ((guess.equals("isompi") && higher) || (guess.equals("pienempi") && !higher)) {
                    result = "Oikein meni!";
                    correctGuesses++;
                } else {
                    result = "Metsään meni!";
                }
            }
            // Vedä uusi kortti
            drawCard();
            return result + " Olet nyt Arvannut oikein " + correctGuesses + " kertaa. Pakasta nousi: " + printCard;
        }
        

        @GetMapping("/start") //Tämä endpoint aloittaa uuden pelin. Se luo täyden pakan, sekoittaa sen uudestaan ja vetää ensimmäisen kortin. Se palauttaa viestin, jossa kerrotaan, että peli on aloitettu, ja näyttää ensimmäisen kortin.
        public String startGame() {
            deck.clear();
            currentCard = "";
            correctGuesses = 0;
            generateDeck();
            String firstCard = drawCard(); // Vedä ensimmäinen kortti
            return "Uusi peli aloitettu. Pakka sekoitettu. Ensimmäisenä korttina nousi: " + firstCard;
        }
        
        @GetMapping("/guide") // Tämä endpoint on ohjeita varten
        public String getGuide() {
            return "Arvaa onko seuraava kortti isompi vai pienempi kuin nykyinen. Oikea arvaus, sama numero ja ässä antavat pisteen. Ässän päälle käy mikä vain.";
        }

		@GetMapping("/currentCard")
		public String getCurrentCard() { // Getter currentCard-muuttujalle
			return currentCard;
		}
		
		@GetMapping("/correctGuesses")
		public String getCorrectGuesses() { // Tämä endpoint on tehty arvausten määrän palauttamiseksi
			return String.valueOf(correctGuesses);
		}
    }
}
