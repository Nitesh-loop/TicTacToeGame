package com.tictactoe;

import java.util.Scanner;

public class TicTacToeBoardGame {
    public static void main(String[] args) {
        char[][] board = createBoard();
        Scanner input = new Scanner(System.in);

        char currentPlayer = 'X';
        boolean gameEnded = false;

        while(!gameEnded){
            printBoard(board);
            playerMove(input, board, currentPlayer);

            if(checkWin(board, currentPlayer)){
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if(checkDraw(board)){
                printBoard(board);
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        input.close();

    }

    // Create an empty board
    static char[][] createBoard(){
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }

        return board;
    }

    // Print the board
    static void printBoard(char[][] board){
        System.out.println("Current Baord");
        for(int i = 0; i < 3; i++) {
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }

    }

    // Player makes a move
    static void playerMove(Scanner input, char[][] board, char player) {
        int row, col;

        while(true){
            System.out.println("Player " + player + "'s turn");

            System.out.print("Enter row (0-2) : ");
            row = input.nextInt();

            System.out.print("Enter col (0-2) : ");
            col = input.nextInt();

            // Validate input
            if(row > 2 || row < 0 || col > 2 || col < 0){
                System.out.println("Invalid position. Try again.");
            } else if (board[row][col] != ' '){
                System.out.println("Cell already taken. Try again.");
            } else {
                board[row][col] = player;
                break;
            }
        }

    }

    // Check if the current player has won
    static boolean checkWin(char[][] board, char player){
        // Check rows, columns, diagonals
        for(int i = 0; i < 3; i++){
            //row
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }

            //col
            if(board[0][i] == player && board[1][i] == player && board[2][0] == player){
                return true;
            }
        }

        // Diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;

    }

    // Check for a draw
    static boolean checkDraw(char[][] board){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' ')
                    return false;
            }
        }

        return true;
    }


}
