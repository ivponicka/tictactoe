import java.util.Scanner;

public class TicTacToe{

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to TIC TAC TOE game!");
        char[][] board = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
        };

        showBoard(board);

        for(int i = 0; i < 9;  i++){
            if(i % 2 == 0) {
                System.out.print("Turn X: ");
               int[] spot = playerChoice(board);
               board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.print("Turn Y: ");
                int[] spot = playerChoice(board);
                 board[spot[0]][spot[1]] = 'Y';
            }
            showBoard(board);
        }
         

    }

    public static void showBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[i].length; j++){
                    System.out.print(board[i][j] + " ");
                   
           }
            System.out.print('\n');
        }
    }


    public static int[] playerChoice(char[][] board){
        System.out.print("Choose the position (row and column): ");
        int row = input.nextInt();
        int column = input.nextInt();
        if(board[row][column] == 'X' || board[row][column] == 'Y'){
            System.out.println("Ups! This spot is already taken! Choose another one: ");
             row = input.nextInt();
             column = input.nextInt();
        }
        return new int[] {row, column};
    }
}