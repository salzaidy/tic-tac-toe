

package ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> xPos = new ArrayList<Integer>();
    static ArrayList<Integer> oPos = new ArrayList<Integer>();

    static char[][] arr = new char[3][3];

    static boolean isDone;

    public static void main(String[] args) {
//        System.out.println(isWinner());


        printGameBoard(arr);
//        boolean gameStatus = isGameOver();
        while (!isWinner()){
//            System.out.println(xPos.size());
//            System.out.println(oPos.size());
//            System.out.println(isWinner());
//            System.out.println();
            if(xPos.size() + oPos.size() == 9) {
                System.out.println("Draw");
                break;
            }
            validateUserInput();
            if (isDone = true) {
                printUpdatedGameBoard(arr);
            }

//            validateUserInput();
//            if (isDone = true) {
//                printUpdatedGameBoard(arr);
//            }


//            printGameBoard(arr);
        }


    }

    private static void placePiece(char[][] gameBoard, int first, int second) {
        char symbol = ' ';
        int f = first - 1;
        int s = second - 1;


        // chech fro X || O coordinates
        if (xPos.size() == oPos.size()) {
            symbol = 'X';
//            System.out.println(xPos.size());
        } else if (xPos.size() > oPos.size()) {
            symbol = 'O';
//            System.out.println(oPos.size());
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                // check if the cell is empty

                if (i == f && j == s) {
                    if (gameBoard[i][j] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
//                    validateUserInput();
                    } else {
                        gameBoard[i][j] = symbol;
                        // here we add the position of symbol
                        gridIndex(i, j, symbol);
//                        isWinner();
                        isDone = true;
                        break;
                    }
                }
            }
        }
    }

    private static boolean isWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);

        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);

        winning.add(cross1);
        winning.add(cross2);

        boolean isXwinning = false;
        boolean isOwinning = false;

        for(List l : winning) {
            if(xPos.containsAll(l)) {
                isXwinning = true;

            } else if(oPos.containsAll(l)) {
                isOwinning = true;

            }
        }
//        isOwinning = true; // for testing

        if (isXwinning == true && isOwinning != true){
            System.out.println("X wins");
            return true;
        }
        if (isXwinning != true && isOwinning == true){
            System.out.println("O wins");
            return true;
        }


        if(xPos.size() + oPos.size() == 9) {
            System.out.println("Draw");
            return true;
        }

        return false;
    }

    // add the index into the array for
    private static void gridIndex(int row, int col, char sign){
        int index = 0;
//        System.out.println(row + " : " + col + " : " + sign);
        if (row == 0){
            index = row + 1 + col;
        } else if(row == 1){
            index = row + 3 + col;
        } else if (row == 2) {
            index = row + 5 + col;
        }
//        System.out.println(index);
        if (sign == 'X'){
            xPos.add(index);
        } else if (sign == 'O') {
            oPos.add(index);
        }
    }

    private static void validateUserInput() {
        Scanner scanner = new Scanner(System.in);

        int first;
        int second;
        boolean isNumber;

        do {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt()) {

                first = scanner.nextInt();
                second = scanner.nextInt();

                while ((first < 1 || first > 3) || (second < 1 || second > 3)){
                    System.out.println("Coordinates should be from 1 to 3!");
//                    validateUserInput();
                    System.out.print("Enter the coordinates: ");
                    first = scanner.nextInt();
                    second = scanner.nextInt();
                }

                placePiece(arr, first, second);
                isNumber = true;

            } else {
                System.out.println("You should enter numbers!");
                isNumber = false;
                scanner.nextLine();
//                validateUserInput();
            }

        } while (!isNumber);

    }

    private static void printGameBoard(char[][] gameBoard) {

        System.out.println("---------");

        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    private static void printUpdatedGameBoard(char[][] gameBoard){
//        System.out.println("works!");
        System.out.println("---------");

        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }
}
