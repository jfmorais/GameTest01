package jcury.com.br.gametest01.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.InputStream;

import jcury.com.br.gametest01.R;
import jcury.com.br.gametest01.singleton.GameParameterSingleton;

import static java.security.AccessController.getContext;

/**
 * Created by jcury on 04/09/2017.
 */

public class InfiniteBackground{
    private Bitmap figura;
    private int h;
    private int w;
    private Rect src;
    private Rect first;
    private Rect second;

    private final  int STEP=5;

    private static final String TAG="GAMETEST_InfiniteBG";

    public InfiniteBackground(Context c){

        try{
            figura = BitmapFactory.decodeResource(c.getResources(),R.drawable.bg1);
            h = figura.getHeight();
            w = figura.getWidth();

            src = new Rect(0,0, w, h);
            first = new Rect();
            second = new Rect();

        }catch (Exception e){
            Log.d(TAG,"Erro ao montar BG");
        }
    }

    public void updateDistortion(){
        setH((int) (getH() * GameParameterSingleton.DISTORTION));
        setW((int) (getW() * GameParameterSingleton.DISTORTION));

        first.left = 0;
        first.top = 0;
        first.right = w;
        first.bottom = h;

        second.top = 0;
        second.left = w;
        second.right = second.left+w;
        second.bottom = h;
    }

    public void update(){
        //como se move
//        first.left = 0;
//        first.right = w;
//        first.top = 0;
//        first.bottom = h;
        int passoDistorcido = (int) (STEP * GameParameterSingleton.DISTORTION);
        first.left  -= passoDistorcido;
        first.right -= passoDistorcido;
        first.top    = 0;
        first.bottom = getH();

        second.top    = 0;
        second.bottom = getH();
        second.left  -= passoDistorcido;
        second.right -= passoDistorcido;


        if(first.right<=0){
            first.right = second.right;
            first.left = second.right + w;
        }

        if(second.right <=0){
            second.left = first.right;
            second.right = first.right + w;
        }


    }

    public void  draw (Canvas c){
        c.drawBitmap(figura,src,first,null);
        c.drawBitmap(figura,src,second,null);
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
