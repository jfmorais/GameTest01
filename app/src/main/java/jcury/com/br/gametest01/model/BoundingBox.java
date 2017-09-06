package jcury.com.br.gametest01.model;

/**
 * Created by jcury on 06/09/2017.
 */

public class BoundingBox {
    int x;
    int y;
    int h;
    int w;

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

    @Override
    public String toString() {
        return "BoundingBox{" +
                "x=" + x +
                ", y=" + y +
                ", h=" + h +
                ", w=" + w +
                '}';
    }
}
