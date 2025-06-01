package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        int[][] board = createBoard();
        printBoard(board);

        Scanner input = new Scanner(System.in);

        playerMove(input, board);

    }

    static int[][] createBoard() {

        // Multidimensional array declaration
        // int[][] board;
        // Initializing the size of row and column respectively
        int[][] board = new int[3][3];

        int value = 1;

        // Assigning the values to array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }

        return board;

    }

    //board for game
    static void printBoard(int[][] board) {

        System.out.println("Current Board:");

        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }

    }

    //Tack payer's move
    static void playerMove(Scanner input, int[][] board) {
        System.out.print("Your Turn : ");
        int row = input.nextInt();
        int column = input.nextInt();

        //move by Player 1 (X)


    }

}
