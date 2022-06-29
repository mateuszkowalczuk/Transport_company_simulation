package pl.programowanie;

import java.util.Random;

public class Baloon {
    static long number;
    BaloonColor color;
    int x;
    int y;

    public Baloon(){
        this.number++;
        this.color = BaloonColor.values()[new Random().nextInt(color.values().length)];
        this.x = (int)(Math.random()*400+20);
        this.y = (int)(Math.random()*150+200);
    }
}
