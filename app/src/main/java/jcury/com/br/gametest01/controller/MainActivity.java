package jcury.com.br.gametest01.controller;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import jcury.com.br.gametest01.singleton.GameParameterSingleton;
import jcury.com.br.gametest01.view.GameScreen;

/**
 * Created by jcury on 01/09/2017.
 */

public class MainActivity extends GameActivity{
    private GameScreen gs;
    private static final String TAG="GAMETEST_MAIN";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setupParameters();
        gs = new GameScreen(this);
        setContentView(gs);

        Thread t = new Thread(gs);
        t.start();
    }

    public void setupParameters(){
        GameParameterSingleton.ORIENTATION = GameParameterSingleton.PORTRAIT;
        GameParameterSingleton.HEIGHT = getWindowManager().getDefaultDisplay().getHeight();
        GameParameterSingleton.WIDTH = getWindowManager().getDefaultDisplay().getWidth();

        //GameParameterSingleton.assetManager = getAssets();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //tela cheia
        requestWindowFeature(Window.FEATURE_NO_TITLE);//sem titulo
    }
}
