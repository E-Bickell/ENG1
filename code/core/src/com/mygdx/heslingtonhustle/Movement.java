package com.mygdx.heslingtonhustle;

public class Movement {
    int x;
    int y;

    public Movement(){
        int x = 0;
        int y = 0;
    }

    public Movement(int X, int Y) {
        x = X;
        y = Y;
    }

    public void Move(int X, int Y) {
        x += X;
        y += Y;
    }

    public void calculatePath() {

    }

    public void checkObstacle() {

    }
}
