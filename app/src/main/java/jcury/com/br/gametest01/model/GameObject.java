package jcury.com.br.gametest01.model;

import android.graphics.Canvas;

import jcury.com.br.gametest01.singleton.GameParameterSingleton;

/**
 * Created by jcury on 04/09/2017.
 */

public abstract class GameObject {
    private int x;
    private int y;
    private int h;
    private int w;

    public abstract void update();
    public abstract void draw(Canvas c);

    public void updateDistortion(){
        w = (int) (w * GameParameterSingleton.DISTORTION);
        h = (int) (h * GameParameterSingleton.DISTORTION);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
