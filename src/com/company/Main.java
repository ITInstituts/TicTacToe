package com.company;


public class Main {

    public static void main(String[] args) {
        char [] []  field = new char[3][3];
        Field.initField(field);
        Field.printField(field);
        Move.initMove();
    }


}
