// detects a win but doest terminate

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;


public class ticTacToe {

    public static void main(String args[]) {

        int debug = 1;
        Scanner scanner = new Scanner(System.in);
        String [] gameBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"}; 
        int [] slotUsed = {0,0,0,0,0,0,0,0,0};
        int userSelection;
        int cpuSelection;
        String userToken;
        String cpuToken;
        
        //user selects X or O

        System.out.println("What do you want to play? X or M?");
        userToken = String.valueOf(scanner.nextLine());
        if (userToken.equals("X")) {
            cpuToken = "M";
        } else {
            cpuToken = "X";
        }

        if (debug == 1) {
            System.out.println("CPU plays as: " + cpuToken);
            System.out.println("User plays as: " + userToken);
        }

        //shows board and gets user choice
        // Pick 1

        displayBoard(gameBoard);
        System.out.println("You are going first");
        System.out.println("pick a number slot to put your " + userToken);
        userSelection = Integer.valueOf(scanner.nextLine());

        //updates and shows updated board and what slots used        

        gameBoard = updateBoard(userToken, userSelection, gameBoard);
        slotUsed = updateUse(userSelection, slotUsed, 4);
        displayBoard(gameBoard);
        displayUse(slotUsed);
        
        //cpu looks for valid boar slot to use and updates board
        //pick2

        cpuSelection = cpuPicks(slotUsed);
        gameBoard = updateBoard(cpuToken, cpuSelection, gameBoard);
        slotUsed = updateUse(cpuSelection, slotUsed, 7);
        displayBoard(gameBoard);
        displayUse(slotUsed);

        //User again
        //Pick 3

        System.out.println("pick a number slot to put your " + userToken);
        userSelection = Integer.valueOf(scanner.nextLine());
        gameBoard = updateBoard(userToken, userSelection, gameBoard);
        slotUsed = updateUse(userSelection, slotUsed, 4);
        displayBoard(gameBoard);
        displayUse(slotUsed);

        //CPU again
        //pic 4

        cpuSelection = cpuPicks(slotUsed);
        gameBoard = updateBoard(cpuToken, cpuSelection, gameBoard);
        slotUsed = updateUse(cpuSelection, slotUsed, 7);
        displayBoard(gameBoard);
        displayUse(slotUsed);

        //User again
        //Pick 5
        //checks for win

        System.out.println("pick a number slot to put your " + userToken);
        userSelection = Integer.valueOf(scanner.nextLine());
        gameBoard = updateBoard(userToken, userSelection, gameBoard);
        slotUsed = updateUse(userSelection, slotUsed, 4);
        displayBoard(gameBoard);
        displayUse(slotUsed);
        checkForWin(slotUsed);
     

        //CPU again
        //pic 6
        //check for win

        cpuSelection = cpuPicks(slotUsed);
        gameBoard = updateBoard(cpuToken, cpuSelection, gameBoard);
        slotUsed = updateUse(cpuSelection, slotUsed, 7);
        displayBoard(gameBoard);
        displayUse(slotUsed);
        checkForWin(slotUsed);

        //User again
        //Pick 7
        //checks for win

        System.out.println("pick a number slot to put your " + userToken);
        userSelection = Integer.valueOf(scanner.nextLine());
        gameBoard = updateBoard(userToken, userSelection, gameBoard);
        slotUsed = updateUse(userSelection, slotUsed, 4);
        displayBoard(gameBoard);
        displayUse(slotUsed);
        checkForWin(slotUsed);

        //CPU again
        //pic 8
        //check for win

        cpuSelection = cpuPicks(slotUsed);
        gameBoard = updateBoard(cpuToken, cpuSelection, gameBoard);
        slotUsed = updateUse(cpuSelection, slotUsed, 7);
        displayBoard(gameBoard);
        displayUse(slotUsed);
        checkForWin(slotUsed);
    }
    
    public static String[] updateBoard(String token, int position, String arr[]) {
        
        arr[position-1] = token;
        return arr;
        
    }
    public static int[] updateUse(int position, int arr[], int token) {
        arr[position-1] = token;
        return arr;
    }
    
    public static void displayBoard(String arr[]) {
        System.out.println("--------------------------");
        System.out.println("This is the current game board");
        for (int i = 1; i <= 9; i++) { 
                System.out.print(arr[i-1]);
                if (i % 3 == 0) {
                    System.out.println();
                }
            }

    }

    public static void displayUse(int arr[]) {
        System.out.println("--------------------------");
        System.out.println("Currently in use: ");
        for (int i = 0; i < 9; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int cpuPicks(int arr[]) {
            while(true) {
                int random = ThreadLocalRandom.current().nextInt(1, 10);
                System.out.println(random);
                //int random = rand.nextInt(10); 
                if (arr[random-1] == 4 || arr[random-1] == 7) {
                    System.out.println(random + " already picked");
                    continue;
                }
                System.out.println(random + " has been picked ");
                return random;
                
            }
       
    }

    public static void checkForWin(int arr[]) {
 
        if (((arr[0] == 4) && (arr[1] == 4) && (arr[2] == 4)) || ((arr[0] == 7) && (arr[1] == 7) && (arr[2] == 7))) {
            System.out.println("Game Over");
        }
        if (((arr[3] == 4) && (arr[4] == 4) && (arr[5] == 4)) || ((arr[3] == 7) && (arr[4] == 7) && (arr[5] == 7))) {
            System.out.println("Game Over");
        }
        if (((arr[6] == 4) && (arr[7] == 4) && (arr[8] == 4)) || ((arr[6] == 7) && (arr[7] == 7) && (arr[8] == 7))) {
            System.out.println("Game Over");
        }

        if (((arr[0] == 4) && (arr[3] == 4) && (arr[6] == 4)) || ((arr[0] == 7) && (arr[3] == 7) && (arr[6] == 7))) {
            System.out.println("Game Over");
        }
        if (((arr[1] == 4) && (arr[4] == 4) && (arr[7] == 4)) || ((arr[1] == 7) && (arr[4] == 7) && (arr[7] == 7))) {
            System.out.println("Game Over");
        }
        if (((arr[2] == 4) && (arr[5] == 4) && (arr[8] == 4)) || ((arr[2] == 7) && (arr[5] == 7) && (arr[8] == 7))) {
            System.out.println("Game Over");
        }

        if (((arr[0] == 4) && (arr[4] == 4) && (arr[8] == 4)) || ((arr[0] == 7) && (arr[4] == 7) && (arr[8] == 7))) {
            System.out.println("Game Over");
        }
        if (((arr[2] == 4) && (arr[4] == 4) && (arr[6] == 4)) || ((arr[2] == 7) && (arr[4] == 7) && (arr[6] == 7))) {
            System.out.println("Game Over");
        }
    }

    
    
}