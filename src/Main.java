/**
 * Created by Emina on 9/14/2016.
 */



import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import java.nio.charset.Charset;


import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {

        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(Terminal.Color.WHITE);
        terminal.applyForegroundColor(Terminal.Color.RED);
        //at location
        terminal.moveCursor(8,8);
        //show this
        terminal.putCharacter('\u263a');


        //iterate 8 rows
        for(int j=0;j<8;j++) {
            //if the row is even
            if (j % 2 == 0) {
                //iterate 8 columns
                for (int i = 0; i < 8; i++) {
                    //if column is even
                    if (i % 2 == 0) {
                        //print O at this even column and even row
                        terminal.moveCursor(j, i);
                        terminal.putCharacter('O');
                        //else print X at this odd column and even row
                    } else {
                        terminal.moveCursor(j, i);
                        terminal.putCharacter('X');
                    }
                }
               //if the row is odd
            } else {
                for (int i = 0; i < 8; i++) {
                    //iterate 8 columns(0-7)
                    if (i % 2 == 0) {
                        //print X at this even column and odd row
                        terminal.moveCursor(j, i);
                        terminal.putCharacter('X');
                        //print O at this odd column and odd row
                    } else {
                        terminal.moveCursor(j, i);
                        terminal.putCharacter('O');
                    }

                }
            }
        }




        boolean [][] board = new boolean[8][8];
        /*Put logic here to fill the board array with the chess pattern*/

        /*
        * Same logic as above only difference is
        * that we use an extra String array to
        * add X and O but we use the boolean array
        * to determine if its an X or O in a false
        * or true position
        * */
        boolean X=true,O=false;

        for(int i=0;i<board.length;i++){
            if(i%2==0){
                for(int j = 0; j < board[i].length; j++){
                    //if even row and even column set the value true
                    if (j % 2 == 0){
                        board[i][j]=X;
                    }
                    //if even row and odd column set value false
                    else{
                        board[i][j]=O;
                    }
                }
            }else{
                for(int j = 0; j < board[i].length; j++){
                    //if odd row and even column set value false
                    if (j % 2 == 0){
                        board[i][j]=O;
                    }
                    //if odd row and odd column set value true
                    else{
                        board[i][j]=X;
                    }
                }

            }
        }
        //string array with same matrix as boolean array
        String [][]chessX=new String[8][8];
        for(int i =0;i<chessX.length;i++){
            for (int j = 0; j < chessX[i].length; j++){
                //if value false at this position
                if(board[i][j])
                    chessX[i][j] = "O";
                //else value true at this position
                else
                    chessX[i][j]="X";
            }

        }

        //Put logic here to output the board to the screen
        //for each row in this array
        for(String[] rows:chessX){
            //for each column in this row
            for (String column:rows){
                //print column
                System.out.print(column);
            }
            //print next line after the end of all columns in this row
            System.out.println();
        }

    }

}
