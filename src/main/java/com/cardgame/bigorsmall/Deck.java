package com.cardgame.bigorsmall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<String> deck = new ArrayList<>();

    public Deck() {
        generateDeck();
        shuffleDeck();
    }

    public void generateDeck() {
        String[] suits = {"Hertta", "Ruutu", "Risti", "Pata"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jatka", "Rouva", "Kuningas", "Assa"};

        for (String suit : suits) {
            for (String value : values) {
                deck.add(suit + " " + value);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public String drawCard() {
        if (deck.isEmpty()) {
            return "Pakka tyhjä.";
        }
        String currentCard = deck.remove(deck.size() - 1);
        return currentCard;
    }

    public void clear() {
        deck.clear();
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }
}

