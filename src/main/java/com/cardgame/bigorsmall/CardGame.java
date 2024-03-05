package com.cardgame.bigorsmall;

import java.util.HashMap;
import java.util.Map;

public class CardGame {
    private final Deck deck;
    private String currentCard = "";
    private int correctGuesses = 0;
    private final Map<String, Integer> cardValues = new HashMap<>();


    public CardGame() {
        this.deck = new Deck();
        initializeCardValues();
    }

    private void initializeCardValues() {
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

    public String drawCard() {
        if (deck.isEmpty()) {
            return "Pakka tyhjä.";
        }
        currentCard = deck.drawCard();
        return currentCard;
    }

    public String makeGuess(String guess) {
        if (!guess.equals("isompi") && !guess.equals("pienempi")) {
            return "Väärä arvaus. Valitse 'isompi' tai 'pienempi'.";
        }
    
        if (deck.isEmpty()) {
            return "Peli ohi. Sinulla meni arvaus oikein " + correctGuesses + " kertaa. Pakka on tyhjä.";
        }
    
        String drawnCard = currentCard.split(" ")[1];
        String nextCardwithSuite = deck.drawCard(); //Nostetaan seuraava kortti
        String nextCard = nextCardwithSuite.split(" ")[1]; // trimmataan pelkkä arvo
    
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
    
        // Tallenna viimeisimpänä nostettu kortti currentCard-attribuuttiin
        currentCard = nextCardwithSuite;
    
        return result + " Olet nyt Arvannut oikein " + correctGuesses + " kertaa. Pakasta nousi: " + nextCard;
    }

    public String startGame() {
        deck.clear();
        currentCard = "";
        correctGuesses = 0;
        deck.generateDeck();
        deck.shuffleDeck();
        String firstCard = drawCard(); 
        return "Uusi peli aloitettu. Pakka sekoitettu. Ensimmäisenä korttina nousi: " + firstCard;
    }

    public String getGuide() {
        return "Arvaa onko seuraava kortti isompi vai pienempi kuin nykyinen. Oikea arvaus, sama numero ja ässä antavat pisteen. Ässän päälle käy mikä vain.";
    }

    public String getCurrentCard() {
        return currentCard;
    }

    public String getCorrectGuesses() {
        return String.valueOf(correctGuesses);
    }
}   