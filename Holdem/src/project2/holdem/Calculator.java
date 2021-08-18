package project2.holdem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    ArrayList<ArrayList<Card>> allRivers;

    public Calculator() {

    }

    public ArrayList<ArrayList<Card>> generateOpponentHands(Card playerCard1, Card playerCard2) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        Card card;
        ArrayList<ArrayList<Card>> pairs = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            card = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1,playerCard2);
            for(int j = 0; j < 5; j++) {
                ArrayList<Card> pair = new ArrayList<>();
                pair.add(card);
                pair.add(deck2.deal());
                if(hasDuplicate(pair) == false) { pairs.add(pair); }
            }
        }
        return pairs;
    }

    public ArrayList<ArrayList<Card>> generateOpponentHands(Card playerCard1, Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        deck1.removeRiverCard(riverCard1);
        deck1.removeRiverCard(riverCard2);
        deck1.removeRiverCard(riverCard3);
        Card card;
        ArrayList<ArrayList<Card>> pairs = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            card = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1,playerCard2);
            deck2.removeRiverCard(riverCard1);
            deck2.removeRiverCard(riverCard2);
            deck2.removeRiverCard(riverCard3);
            for(int j = 0; j < 5; j++) {
                ArrayList<Card> pair = new ArrayList<>();
                pair.add(card);
                pair.add(deck2.deal());
                if(hasDuplicate(pair) == false) { pairs.add(pair); }
            }
        }
        return pairs;
    }

    public ArrayList<ArrayList<Card>> generateOpponentHands(Card playerCard1, Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3, Card riverCard4) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        deck1.removeRiverCard(riverCard1);
        deck1.removeRiverCard(riverCard2);
        deck1.removeRiverCard(riverCard3);
        deck1.removeRiverCard(riverCard4);
        Card card;
        ArrayList<ArrayList<Card>> pairs = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            card = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1,playerCard2);
            deck2.removeRiverCard(riverCard1);
            deck2.removeRiverCard(riverCard2);
            deck2.removeRiverCard(riverCard3);
            deck2.removeRiverCard(riverCard4);
            for(int j = 0; j < 5; j++) {
                ArrayList<Card> pair = new ArrayList<>();
                pair.add(card);
                pair.add(deck2.deal());
                if(hasDuplicate(pair) == false) { pairs.add(pair); }
            }
        }
        return pairs;
    }

    public ArrayList<ArrayList<Card>> generateOpponentHands(Card playerCard1, Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3, Card riverCard4, Card riverCard5) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        deck1.removeRiverCard(riverCard1);
        deck1.removeRiverCard(riverCard2);
        deck1.removeRiverCard(riverCard3);
        deck1.removeRiverCard(riverCard4);
        deck1.removeRiverCard(riverCard5);
        Card card;
        ArrayList<ArrayList<Card>> pairs = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            card = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1,playerCard2);
            deck2.removeRiverCard(riverCard1);
            deck2.removeRiverCard(riverCard2);
            deck2.removeRiverCard(riverCard3);
            deck2.removeRiverCard(riverCard4);
            deck2.removeRiverCard(riverCard5);
            for(int j = 0; j < 5; j++) {
                ArrayList<Card> pair = new ArrayList<>();
                pair.add(card);
                pair.add(deck2.deal());
                if(hasDuplicate(pair) == false) { pairs.add(pair); }
            }
        }
        return pairs;
    }

    public ArrayList<ArrayList<Card>> generateRivers(Card playerCard1 , Card playerCard2) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        ArrayList<ArrayList<Card>> allRivers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Card card1 = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1, playerCard2);
            for(int j = 0; j < 4; j++) {
                Card card2 = deck2.deal();
                Deck deck3 = new Deck();
                deck3.removeCard(playerCard1, playerCard2);
                for(int k = 0; k < 4; k++) {
                    Card card3 = deck3.deal();
                    Deck deck4 = new Deck();
                    deck4.removeCard(playerCard1, playerCard2);
                    for(int l = 0; l < 4; l++) {
                        Card card4 = deck4.deal();
                        Deck deck5 = new Deck();
                        deck5.removeCard(playerCard1, playerCard2);
                        for(int m = 0; m < 4; m++) {
                            ArrayList<Card> riverCards = new ArrayList<>();
                            riverCards.add(card1);
                            riverCards.add(card2);
                            riverCards.add(card3);
                            riverCards.add(card4);
                            riverCards.add(deck5.deal());
                            if(hasDuplicateRiver(riverCards, allRivers) == false) {
                                allRivers.add(riverCards);
                                this.allRivers = allRivers;
                            }
                        }
                    }
                }
            }
        }
        return this.allRivers;
    }

    public ArrayList<ArrayList<Card>> generateRivers(Card playerCard1 , Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        deck1.removeRiverCard(riverCard1);
        deck1.removeRiverCard(riverCard2);
        deck1.removeRiverCard(riverCard3);
        ArrayList<ArrayList<Card>> allRivers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Card card1 = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1, playerCard2);
            deck2.removeRiverCard(riverCard1);
            deck2.removeRiverCard(riverCard2);
            deck2.removeRiverCard(riverCard3);
            for(int j = 0; j < 4; j++) {
                Card card2 = deck2.deal();
                Deck deck3 = new Deck();
                deck3.removeCard(playerCard1, playerCard2);
                deck3.removeRiverCard(riverCard1);
                deck3.removeRiverCard(riverCard2);
                deck3.removeRiverCard(riverCard3);
                for(int k = 0; k < 4; k++) {
                    Card card3 = deck3.deal();
                    Deck deck4 = new Deck();
                    deck4.removeCard(playerCard1, playerCard2);
                    deck4.removeRiverCard(riverCard1);
                    deck4.removeRiverCard(riverCard2);
                    deck4.removeRiverCard(riverCard3);
                    for(int l = 0; l < 4; l++) {
                        Card card4 = deck4.deal();
                        Deck deck5 = new Deck();
                        deck5.removeCard(playerCard1, playerCard2);
                        deck5.removeRiverCard(riverCard1);
                        deck5.removeRiverCard(riverCard2);
                        deck5.removeRiverCard(riverCard3);
                        for(int m = 0; m < 4; m++) {
                            ArrayList<Card> riverCards = new ArrayList<>();
                            riverCards.add(card1);
                            riverCards.add(card2);
                            riverCards.add(card3);
                            riverCards.add(card4);
                            riverCards.add(deck5.deal());
                            if(hasDuplicateRiver(riverCards, allRivers) == false) {
                                allRivers.add(riverCards);
                                this.allRivers = allRivers;
                            }
                        }
                    }
                }
            }
        }
        return this.allRivers;
    }

    public ArrayList<ArrayList<Card>> generateRivers(Card playerCard1 , Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3, Card riverCard4) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        deck1.removeRiverCard(riverCard1);
        deck1.removeRiverCard(riverCard2);
        deck1.removeRiverCard(riverCard3);
        deck1.removeRiverCard(riverCard4);
        ArrayList<ArrayList<Card>> allRivers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Card card1 = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1, playerCard2);
            deck2.removeRiverCard(riverCard1);
            deck2.removeRiverCard(riverCard2);
            deck2.removeRiverCard(riverCard3);
            deck2.removeRiverCard(riverCard4);
            for(int j = 0; j < 4; j++) {
                Card card2 = deck2.deal();
                Deck deck3 = new Deck();
                deck3.removeCard(playerCard1, playerCard2);
                deck3.removeRiverCard(riverCard1);
                deck3.removeRiverCard(riverCard2);
                deck3.removeRiverCard(riverCard3);
                deck3.removeRiverCard(riverCard4);
                for(int k = 0; k < 4; k++) {
                    Card card3 = deck3.deal();
                    Deck deck4 = new Deck();
                    deck4.removeCard(playerCard1, playerCard2);
                    deck4.removeRiverCard(riverCard1);
                    deck4.removeRiverCard(riverCard2);
                    deck4.removeRiverCard(riverCard3);
                    deck4.removeRiverCard(riverCard4);
                    for(int l = 0; l < 4; l++) {
                        Card card4 = deck4.deal();
                        Deck deck5 = new Deck();
                        deck5.removeCard(playerCard1, playerCard2);
                        deck5.removeRiverCard(riverCard1);
                        deck5.removeRiverCard(riverCard2);
                        deck5.removeRiverCard(riverCard3);
                        deck5.removeRiverCard(riverCard4);
                        for(int m = 0; m < 4; m++) {
                            ArrayList<Card> riverCards = new ArrayList<>();
                            riverCards.add(card1);
                            riverCards.add(card2);
                            riverCards.add(card3);
                            riverCards.add(card4);
                            riverCards.add(deck5.deal());
                            if(hasDuplicateRiver(riverCards, allRivers) == false) {
                                allRivers.add(riverCards);
                                this.allRivers = allRivers;
                            }
                        }
                    }
                }
            }
        }
        return this.allRivers;
    }

    public ArrayList<ArrayList<Card>> generateRivers(Card playerCard1 , Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3, Card riverCard4, Card riverCard5) {
        Deck deck1 = new Deck();
        deck1.removeCard(playerCard1, playerCard2);
        deck1.removeRiverCard(riverCard1);
        deck1.removeRiverCard(riverCard2);
        deck1.removeRiverCard(riverCard3);
        deck1.removeRiverCard(riverCard4);
        deck1.removeRiverCard(riverCard5);
        ArrayList<ArrayList<Card>> allRivers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Card card1 = deck1.deal();
            Deck deck2 = new Deck();
            deck2.removeCard(playerCard1, playerCard2);
            deck2.removeRiverCard(riverCard1);
            deck2.removeRiverCard(riverCard2);
            deck2.removeRiverCard(riverCard3);
            deck2.removeRiverCard(riverCard4);
            deck2.removeRiverCard(riverCard5);
            for(int j = 0; j < 4; j++) {
                Card card2 = deck2.deal();
                Deck deck3 = new Deck();
                deck3.removeCard(playerCard1, playerCard2);
                deck3.removeRiverCard(riverCard1);
                deck3.removeRiverCard(riverCard2);
                deck3.removeRiverCard(riverCard3);
                deck3.removeRiverCard(riverCard4);
                deck3.removeRiverCard(riverCard5);
                for(int k = 0; k < 4; k++) {
                    Card card3 = deck3.deal();
                    Deck deck4 = new Deck();
                    deck4.removeCard(playerCard1, playerCard2);
                    deck4.removeRiverCard(riverCard1);
                    deck4.removeRiverCard(riverCard2);
                    deck4.removeRiverCard(riverCard3);
                    deck4.removeRiverCard(riverCard4);
                    deck4.removeRiverCard(riverCard5);
                    for(int l = 0; l < 4; l++) {
                        Card card4 = deck4.deal();
                        Deck deck5 = new Deck();
                        deck5.removeCard(playerCard1, playerCard2);
                        deck5.removeRiverCard(riverCard1);
                        deck5.removeRiverCard(riverCard2);
                        deck5.removeRiverCard(riverCard3);
                        deck5.removeRiverCard(riverCard4);
                        deck5.removeRiverCard(riverCard5);
                        for(int m = 0; m < 4; m++) {
                            ArrayList<Card> riverCards = new ArrayList<>();
                            riverCards.add(card1);
                            riverCards.add(card2);
                            riverCards.add(card3);
                            riverCards.add(card4);
                            riverCards.add(deck5.deal());
                            if(hasDuplicateRiver(riverCards, allRivers) == false) {
                                allRivers.add(riverCards);
                                this.allRivers = allRivers;
                            }
                        }
                    }
                }
            }
        }
        return this.allRivers;
    }

    /*public ArrayList<ArrayList<Card>> getPairs() {
        return this.pairs;
    }*/

    /*public ArrayList<ArrayList<Card>> getRivers() {
        return this.allRivers;
    }*/

    public void getProbability() {

    }

    /*public void printOpponentHands() {
        System.out.println(pairs.get(0).get(0).getFace());
    }*/

    /*public ArrayList<ArrayList<Card>> getOpponentHands() {
        return pairs;
    }*/

    public static <T> boolean hasDuplicate(Iterable<T> cards) {
        Set<T> set = new HashSet<T>();
        // Set#add returns false if the set does not change, which
        // indicates that a duplicate element has been added.
        for (T each: cards) if (!set.add(each)) return true;
        return false;
    }

    public static <T> boolean hasDuplicateRiver(ArrayList<Card> currentRiver, ArrayList<ArrayList<Card>> allRivers) {
        for(ArrayList r : allRivers) if (r.containsAll(currentRiver)) {
            return true;
        }
        return false;
    }
}
