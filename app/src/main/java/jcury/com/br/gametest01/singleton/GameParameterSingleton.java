package jcury.com.br.gametest01.singleton;

import android.content.res.AssetManager;

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
    public static AssetManager assetManager;

}
