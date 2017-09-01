package jcury.com.br.gametest01.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;

import jcury.com.br.gametest01.view.GameScreen;

/**
 * Created by jcury on 01/09/2017.
 */

public class MainActivity extends GameActivity{
    private GameScreen gs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gs = new GameScreen(this);
        setContentView(gs);

        Thread t = new Thread(gs);
        t.start();
    }
}
