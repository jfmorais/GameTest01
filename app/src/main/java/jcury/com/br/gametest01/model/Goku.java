package jcury.com.br.gametest01.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import jcury.com.br.gametest01.R;

/**
 * Created by jcury on 05/09/2017.
 */

public class Goku extends GameObject {
    private Bitmap figura;
    private Rect src;
    private Rect dest;

    private int spriteW;
    private int spriteH;

    private int  currentSprite;

    private static final String TAG="GAMETEST_Goku";

    public Goku(Context c){
        try{
            figura = BitmapFactory.decodeResource(c.getResources(), R.drawable.goku_fly);

            spriteW = figura.getWidth()/4;
            spriteH = figura.getHeight();

            setH(spriteH);
            setW(spriteW);
            currentSprite = 0;

            src = new Rect(0,0, getW(),getH());
            dest = new Rect();
        }catch (Exception e){
            Log.d(TAG,"Erro ao montar goku!");
        }
    }



    @Override
    public void update() {
        src.top = 0;
        src.bottom = spriteH;
        src.left = currentSprite * spriteW;
        src.right = src.left + spriteW;

        dest.top = getY();
        dest.bottom = getY() + getH();
        dest.left = getX();
        dest.right = getX() + getW();

        currentSprite = (currentSprite+1)%4;
    }

    @Override
    public void draw(Canvas c) {
        c.drawBitmap(figura,src,dest,null);
    }
}
