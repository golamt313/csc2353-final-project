package project2.holdem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Project2Holdem {

    static int playerMoney = 100;
    static int computerMoney = 100;
    static Scanner keyboard = new Scanner(System.in);
    static boolean playerBetsFirst = true;
    static int pot;
    static Random random = new Random();
    static double odds = 0;

    public static void main(String[] args) {


        while (playerMoney > 1 && computerMoney > 1) {
            boolean computerNotFolded = true;
            System.out.println("Player has $" + playerMoney);
            System.out.println("Computer has $" + computerMoney);

            pot = 3;

            if (playerBetsFirst) {
                System.out.println("Player bets first, $2");
                System.out.println("Computer bets $1");
                playerMoney -= 2;
                computerMoney--;
            } else {
                System.out.println("Computer bets first, $2");
                System.out.println("Player bets $1");
                computerMoney -= 2;
                playerMoney--;
            }

            Deck deck = new Deck();
            HoldemHand computerHand = new HoldemHand(deck.deal(), deck.deal());

            //System.out.println(opponentHands.get(0).get(0).getSuit() + " " + opponentHands.get(0).get(0).getFace());

            Card playerCard1 = deck.deal();
            Card playerCard2 = deck.deal();
            HoldemHand playerHand = new HoldemHand(playerCard1, playerCard2);

            System.out.println("Players Hand: " + playerHand.toString());
            odds = winOdds(playerCard1, playerCard2);
            if (bettingRoundDidSomeoneFold(1)) {
                continue;
            }

            Card sharedCard1 = deck.deal();
            Card sharedCard2 = deck.deal();
            Card sharedCard3 = deck.deal();

            playerHand.addSharedCard(sharedCard1);
            playerHand.addSharedCard(sharedCard2);
            playerHand.addSharedCard(sharedCard3);

            computerHand.addSharedCard(sharedCard1);
            computerHand.addSharedCard(sharedCard2);
            computerHand.addSharedCard(sharedCard3);

            odds = winOdds(playerCard1, playerCard2, sharedCard1, sharedCard2, sharedCard3);

            if (playerBetsFirst && odds < 50 && computerNotFolded) {
                System.out.println("Shared cards: "
                        + sharedCard1 + " "
                        + sharedCard2 + " "
                        + sharedCard3);

                System.out.println("Players Hand: " + playerHand.toString());

                String choice = promptForCallRaiseOrFold();
                if (choice.equalsIgnoreCase("fold")) {
                    System.out.println("You fold!");
                    computerMoney += pot;
                    continue; // ends the round, starts the loop again
                } else if (choice.equalsIgnoreCase("call")) {
                    System.out.println("You call!");
                    System.out.println("Computer calls!");
                } else {
                    int raiseAmount = getRaiseAmount();
                    if (bettingRoundDidSomeoneFold(raiseAmount)) {
                        continue;
                    }
                }
            } else if (odds > 50){
                computerFolds();
                computerNotFolded = false;
            }

            Card sharedCard4 = deck.deal();

            playerHand.addSharedCard(sharedCard4);

            computerHand.addSharedCard(sharedCard4);

            odds = winOdds(playerCard1, playerCard2, sharedCard1, sharedCard2, sharedCard3, sharedCard4);

            if (playerBetsFirst && odds < 50 && computerNotFolded) {
                System.out.println("Shared cards: "
                        + sharedCard1 + " "
                        + sharedCard2 + " "
                        + sharedCard3 + " "
                        + sharedCard4);

                System.out.println("Players Hand: " + playerHand.toString());

                String choice = promptForCallRaiseOrFold();
                if (choice.equalsIgnoreCase("fold")) {
                    System.out.println("You fold!");
                    computerMoney += pot;
                    continue; // ends the round, starts the loop again
                } else if (choice.equalsIgnoreCase("call")) {
                    System.out.println("You call!");
                    System.out.println("Computer calls!");
                } else {
                    int raiseAmount = getRaiseAmount();
                    if (bettingRoundDidSomeoneFold(raiseAmount)) {
                        continue;
                    }
                }
            } else if (odds > 50) {
                computerFolds();
                computerNotFolded = false;
            }

            Card sharedCard5 = deck.deal();

            playerHand.addSharedCard(sharedCard5);

            computerHand.addSharedCard(sharedCard5);

            odds = winOdds(playerCard1, playerCard2, sharedCard1, sharedCard2, sharedCard3, sharedCard4, sharedCard5);

            if (playerBetsFirst && odds < 50 && computerNotFolded) {
                System.out.println("Shared cards: "
                        + sharedCard1 + " "
                        + sharedCard2 + " "
                        + sharedCard3 + " "
                        + sharedCard4 + " "
                        + sharedCard5);

                System.out.println("Players Hand: " + playerHand.toString());

                String choice = promptForCallRaiseOrFold();
                if (choice.equalsIgnoreCase("fold")) {
                    System.out.println("You fold!");
                    computerMoney += pot;
                    continue; // ends the round, starts the loop again
                } else if (choice.equalsIgnoreCase("call")) {
                    System.out.println("You call!");
                    System.out.println("Computer calls!");
                } else {
                    int raiseAmount = getRaiseAmount();
                    if (bettingRoundDidSomeoneFold(raiseAmount)) {
                        continue;
                    }
                }
            } else if (odds > 50) {
                computerFolds();
                computerNotFolded = false;
            }

            System.out.println("Players Hand: " + playerHand.toString());
            System.out.println("Computers Hand: " + computerHand.toString());

            System.out.println("Players Best Hand: " + playerHand.getBestPossibleHand());
            System.out.println("Computers Best Hand: " + computerHand.getBestPossibleHand());

            int result = playerHand.getBestPossibleHand().compareTo(computerHand.getBestPossibleHand());
            if (result > 0) {
                System.out.println("Player wins!");
                playerMoney += pot;
            } else if (result == 0) {
                System.out.println("Draw!");
                playerMoney += pot / 2;
                computerMoney += pot / 2;
            } else {
                System.out.println("Computer wins!");
                computerMoney += pot;
            }

            playerBetsFirst = !playerBetsFirst;

            System.out.println();
        }
    }

    public static double winOdds(Card playerCard1, Card playerCard2) {
        Calculator calc = new Calculator();
        ArrayList<ArrayList<Card>> opponentHands = calc.generateOpponentHands(playerCard1, playerCard2);
        ArrayList<ArrayList<Card>> allRivers = calc.generateRivers(playerCard1, playerCard2);
        int wins = 0;
        int loss = 0;
        int draws = 0;

        for(int i = 0; i < allRivers.size(); i++) {
            for(int j = 0; j < opponentHands.size(); j++) {
                HoldemHand possibleComputerHand = new HoldemHand(opponentHands.get(j).get(0), opponentHands.get(j).get(1), allRivers.get(i));
                HoldemHand currentPlayerHand = new HoldemHand(playerCard1, playerCard2, allRivers.get(i));
                int possibleResult = possibleComputerHand.getBestPossibleHand().compareTo(currentPlayerHand.getBestPossibleHand());
                //System.out.println(possibleComputerHand.getCard1().getFace() + " of " + possibleComputerHand.getCard1().getSuit() + " and " + possibleComputerHand.getCard2().getFace() + " of " + possibleComputerHand.getCard2().getSuit() + " VS " + currentPlayerHand.getCard1().getFace() + " of " + currentPlayerHand.getCard1().getSuit() + " and " + currentPlayerHand.getCard2().getFace() + " of " + currentPlayerHand.getCard2().getSuit());
                switch (possibleResult) {
                    case 1:
                        wins++;
                        break;
                    case 0:
                        draws++;
                    case -1:
                        loss++;
                }
            }
        }
        double sum = wins + loss + draws;
        double winOdds = (wins / sum) * 100;

        return winOdds;
    }

    public static double winOdds(Card playerCard1, Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3) {
        Calculator calc = new Calculator();
        ArrayList<ArrayList<Card>> opponentHands = calc.generateOpponentHands(playerCard1, playerCard2, riverCard1, riverCard2, riverCard3);
        ArrayList<ArrayList<Card>> allRivers = calc.generateRivers(playerCard1, playerCard2, riverCard1, riverCard2, riverCard3);
        int wins = 0;
        int loss = 0;
        int draws = 0;

        for(int i = 0; i < allRivers.size(); i++) {
            for(int j = 0; j < opponentHands.size(); j++) {
                HoldemHand possibleComputerHand = new HoldemHand(opponentHands.get(j).get(0), opponentHands.get(j).get(1), allRivers.get(i));
                HoldemHand currentPlayerHand = new HoldemHand(playerCard1, playerCard2, allRivers.get(i));
                int possibleResult = possibleComputerHand.getBestPossibleHand().compareTo(currentPlayerHand.getBestPossibleHand());
                //System.out.println(possibleComputerHand.getCard1().getFace() + " of " + possibleComputerHand.getCard1().getSuit() + " and " + possibleComputerHand.getCard2().getFace() + " of " + possibleComputerHand.getCard2().getSuit() + " VS " + currentPlayerHand.getCard1().getFace() + " of " + currentPlayerHand.getCard1().getSuit() + " and " + currentPlayerHand.getCard2().getFace() + " of " + currentPlayerHand.getCard2().getSuit());
                switch (possibleResult) {
                    case 1:
                        wins++;
                        break;
                    case 0:
                        draws++;
                    case -1:
                        loss++;
                }
            }
        }
        double sum = wins + loss + draws;
        double winOdds = (wins / sum) * 100;

        return winOdds;
    }

    public static double winOdds(Card playerCard1, Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3, Card riverCard4) {
        Calculator calc = new Calculator();
        ArrayList<ArrayList<Card>> opponentHands = calc.generateOpponentHands(playerCard1, playerCard2, riverCard1, riverCard2, riverCard3, riverCard4);
        ArrayList<ArrayList<Card>> allRivers = calc.generateRivers(playerCard1, playerCard2, riverCard1, riverCard2, riverCard3, riverCard4);
        int wins = 0;
        int loss = 0;
        int draws = 0;

        for(int i = 0; i < allRivers.size(); i++) {
            for(int j = 0; j < opponentHands.size(); j++) {
                HoldemHand possibleComputerHand = new HoldemHand(opponentHands.get(j).get(0), opponentHands.get(j).get(1), allRivers.get(i));
                HoldemHand currentPlayerHand = new HoldemHand(playerCard1, playerCard2, allRivers.get(i));
                int possibleResult = possibleComputerHand.getBestPossibleHand().compareTo(currentPlayerHand.getBestPossibleHand());
                //System.out.println(possibleComputerHand.getCard1().getFace() + " of " + possibleComputerHand.getCard1().getSuit() + " and " + possibleComputerHand.getCard2().getFace() + " of " + possibleComputerHand.getCard2().getSuit() + " VS " + currentPlayerHand.getCard1().getFace() + " of " + currentPlayerHand.getCard1().getSuit() + " and " + currentPlayerHand.getCard2().getFace() + " of " + currentPlayerHand.getCard2().getSuit());
                switch (possibleResult) {
                    case 1:
                        wins++;
                        break;
                    case 0:
                        draws++;
                    case -1:
                        loss++;
                }
            }
        }
        double sum = wins + loss + draws;
        double winOdds = (wins / sum) * 100;

        return winOdds;
    }

    public static double winOdds(Card playerCard1, Card playerCard2, Card riverCard1, Card riverCard2, Card riverCard3, Card riverCard4, Card riverCard5) {
        Calculator calc = new Calculator();
        ArrayList<ArrayList<Card>> opponentHands = calc.generateOpponentHands(playerCard1, playerCard2, riverCard1, riverCard2, riverCard3, riverCard4, riverCard5);
        ArrayList<ArrayList<Card>> allRivers = calc.generateRivers(playerCard1, playerCard2, riverCard1, riverCard2, riverCard3, riverCard4, riverCard5);
        int wins = 0;
        int loss = 0;
        int draws = 0;

        for(int i = 0; i < allRivers.size(); i++) {
            for(int j = 0; j < opponentHands.size(); j++) {
                HoldemHand possibleComputerHand = new HoldemHand(opponentHands.get(j).get(0), opponentHands.get(j).get(1), allRivers.get(i));
                HoldemHand currentPlayerHand = new HoldemHand(playerCard1, playerCard2, allRivers.get(i));
                int possibleResult = possibleComputerHand.getBestPossibleHand().compareTo(currentPlayerHand.getBestPossibleHand());
                //System.out.println(possibleComputerHand.getCard1().getFace() + " of " + possibleComputerHand.getCard1().getSuit() + " and " + possibleComputerHand.getCard2().getFace() + " of " + possibleComputerHand.getCard2().getSuit() + " VS " + currentPlayerHand.getCard1().getFace() + " of " + currentPlayerHand.getCard1().getSuit() + " and " + currentPlayerHand.getCard2().getFace() + " of " + currentPlayerHand.getCard2().getSuit());
                switch (possibleResult) {
                    case 1:
                        wins++;
                        break;
                    case 0:
                        draws++;
                    case -1:
                        loss++;
                }
            }
        }
        double sum = wins + loss + draws;
        double winOdds = (wins / sum) * 100;

        return winOdds;
    }

    private static boolean bettingRoundDidSomeoneFold(int raiseAmount) {

        if (playerBetsFirst) {
            if (odds < 50) {
                System.out.println("Computer calls");
                computerMoney -= raiseAmount;
                pot += raiseAmount;
            } else {
                System.out.println("Computer folds!");
                playerMoney += pot;
                return true; // ends the round, starts the loop again
            }
        } else {
            String choice = promptForCallRaiseOrFold();
            if (choice.equalsIgnoreCase("fold")) {
                System.out.println("You fold!");
                computerMoney += pot;
                return true; // ends the round, starts the loop again
            } else if (choice.equalsIgnoreCase("call")) {
                pot++;
                playerMoney -= raiseAmount;
                System.out.println("You call!");
            } else {
                pot += raiseAmount;
                playerMoney -= raiseAmount;
                raiseAmount = getRaiseAmount();
                pot += raiseAmount;
                playerMoney -= raiseAmount;
                if (odds < 50) {
                    System.out.println("Computer calls");
                    computerMoney -= raiseAmount;
                    pot += raiseAmount;
                } else if (odds > 50){
                    System.out.println("Computer folds!");
                    playerMoney += pot;
                    return true; // ends the round, starts the loop again
                }
            }
        }
        return false;
    }

    private static void computerFolds() {
        System.out.println("Computer folds!");
        playerMoney += pot;
    }

    private static int getRaiseAmount() {

        System.out.println("How much do you want to raise?");
        int raise = Integer.parseInt(keyboard.nextLine());

        while (raise > computerMoney || raise > playerMoney) {
            System.out.println("You can't raise more than $" + Math.min(computerMoney, playerMoney));
            System.out.println("How much do you want to raise?");
            raise = Integer.parseInt(keyboard.nextLine());
        }

        return raise;
    }

    private static String promptForCallRaiseOrFold() {
        String choice = "";

        while (!choice.equalsIgnoreCase("call")
                && !choice.equalsIgnoreCase("raise")
                && !choice.equalsIgnoreCase("fold")) {
            System.out.println("Do you want to call, raise or fold with a winning chance of " + String.format("%.0f", odds) + "%?");
            choice = keyboard.nextLine();
        }
        return choice;

    }

}
