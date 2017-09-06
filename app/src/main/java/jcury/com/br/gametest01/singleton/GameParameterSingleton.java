package jcury.com.br.gametest01.singleton;

import android.content.res.AssetManager;

import jcury.com.br.gametest01.model.GameObject;

/**
 * Created by jcury on 04/09/2017.
 */

public class GameParameterSingleton {

    public static final int PORTRAIT = 1;
    public static final int LANDSCAPE = 0;

    public static int ORIENTATION;
    public static int WIDTH;
    public static int HEIGHT;
    public static float DISTORTION =1.0f;

    public static boolean detectColision(GameObject coiso1, GameObject coiso2){
        int coiso1Left, coiso1Right, coiso1Top, coiso1Bot;
        int coiso2Left, coiso2Right, coiso2Top, coiso2Bot;

        coiso1Left  = coiso1.getBoundingBox().getX();
        coiso1Right = coiso1.getBoundingBox().getX() + coiso1.getBoundingBox().getW();
        coiso1Top   = coiso1.getBoundingBox().getY();
        coiso1Bot   = coiso1.getBoundingBox().getY() + coiso1.getBoundingBox().getH();


        coiso2Left  = coiso2.getBoundingBox().getX();
        coiso2Right = coiso2.getBoundingBox().getX() + coiso2.getBoundingBox().getW();
        coiso2Top   = coiso2.getBoundingBox().getY();
        coiso2Bot   = coiso2.getBoundingBox().getY() + coiso2.getBoundingBox().getH();

        return (coiso1Left  <= coiso2Right &&
                coiso1Right >= coiso2Left  &&
                coiso1Top   <= coiso2Bot   &&
                coiso1Bot   >= coiso2Top);

    }

}
