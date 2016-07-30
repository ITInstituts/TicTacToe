package com.company;

import java.util.Scanner;

import static com.company.Field.printField;

/**
 * Created by Maxim on 25.07.2016.
 */
public class Move {
    static char[][] field = new char[3][3];


    public static void initMove() {

        char currentUserSymbol = 'X';
        while (true) {

            int x;
            int y;
            while (true) {
                x = getCoordinate('X');
                y = getCoordinate('Y');

                if (field[x][y] == '*') {
                    break;
                }
            }

            field[x][y] = currentUserSymbol;
           printField(field);

            if (isWin(field, currentUserSymbol)
                    || isDraw(field)) {
                break;
            }


            if (currentUserSymbol == 'X') {
                currentUserSymbol = '0';
            } else currentUserSymbol = 'X';
        }
    }


    private static boolean isDraw(char[][] field) {
        boolean isWin = isWin(field, 'X') || isWin(field, 'Y');
        if (isWin) {
            return false;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '*') {
                    return false;
                }
            }
        }

        System.out.println("DRAW");
        return true;
    }



    private static int getCoordinate(char xORy) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter " + xORy + ":");
            int coordinate = scanner.nextInt();
            if (coordinate < 0 || coordinate > 2) {
                System.out.println("Not valid");
                continue;
            } else return coordinate;
        }
    }


    public static boolean isWin(char[][] field, char symbol) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == symbol
                    && field[i][1] == symbol
                    && field[i][2] == symbol) {
                System.out.println("WIN");
                return true;
            }
        }
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == symbol
                    && field[1][i] == symbol
                    && field[2][i] == symbol) {
                System.out.println("WIN");
                return true;
            }
        }
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            System.out.println("WIN");
            return true;
        }

        if (field[2][0] == symbol && field[1][1] == symbol && field[0][2] == symbol) {
            System.out.println("WIN");
            return true;
        }

        return false;
    }


}
