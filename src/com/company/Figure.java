package com.company;

import static sun.applet.AppletViewer.x;


public enum Figure {
    X("❌"),
    O("◯"),
    EMPTY("■");

    private String mark;


    Figure(String newMark) {
        this.mark = newMark;
    }


}
