/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lumbresex4;



/**
 *
 * @author ambherlyzelle
 */
import java.util.Scanner;
public class RockPaperScissors {

    public static void main(String[] args) 
    {
        Move rock = new Move("Rock");
        Move paper = new Move("Paper");
        Move scissors = new Move("Scissors");

        rock.setStrongAgainst(scissors);
        paper.setStrongAgainst(rock);
        scissors.setStrongAgainst(paper);

        int roundsToWin = 2;
        int player = 0;
        int computer = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rock, Paper, Scissors. Please choose an option:");
        while (true) 
        {
            System.out.println("1. Start game");
            System.out.println("2. Change number of rounds");
            System.out.println("3. Exit application");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) 
            {
                System.out.println("This match will be first to " + roundsToWin + " wins.");

                while (player < roundsToWin && computer < roundsToWin) 
                {
                    Move compmove = generatecompmove(rock, paper, scissors);
                    Move playerMove = getplaymove(scanner, rock, paper, scissors);

                    int result = Move.compareMoves(playerMove, compmove);

                    if (result == 0) 
                    {
                        System.out.println("Player wins round!");
                        player++;
                    } 
                    
                    else if (result == 1) 
                    {
                        System.out.println("Computer wins round!");
                        computer++;
                    } 
                    
                    else 
                    {
                        System.out.println("Round is tied!");
                    }

                    System.out.println("Player: " + player + " - Computer: " + computer);
                }

                if (player > computer) 
                {
                    System.out.println("Player wins!");
                } 
                
                else 
                {
                    System.out.println("Computer wins!");
                }

                player = 0;
                computer = 0;
            } 
            
            else if (choice == 2) 
            {
                System.out.println("How many wins are needed to win a match?");
                roundsToWin = scanner.nextInt();
                scanner.nextLine();
                System.out.println("New setting has been saved!");
            } 
            
            else if (choice == 3) 
            {
                System.out.println("Thank you for playing!");
                break;
            }
        }

        scanner.close();
    }

    private static Move generatecompmove(Move rock, Move paper, Move scissors) 
    {
        int random = (int) Math.floor(Math.random() * 3) + 1;

        switch (random) 
        {
            case 1:
                return rock;
            case 2:
                return paper;
            case 3:
                return scissors;
            default:
                return null;
        }
    }

    private static Move getplaymove(Scanner scanner, Move rock, Move paper, Move scissors) 
    {
        System.out.println("The computer has selected its move. Select your move:");
        System.out.println("1. Rock\n2. Paper\n3. Scissors");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) 
        {
            case 1:
                return rock;
            case 2:
                return paper;
            case 3:
                return scissors;
            default:
                return null;
        }
    }
}

