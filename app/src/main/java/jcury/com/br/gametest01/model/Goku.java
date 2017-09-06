package jcury.com.br.gametest01.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import jcury.com.br.gametest01.R;
import jcury.com.br.gametest01.singleton.GameParameterSingleton;

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

    private int direcao;
    public static final int SOBE=0;
    public static final int DESCE=1;

    private static final int PASSO_SOBE=12;
    private static final int PASSO_DESCE=8;

    private static final String TAG="GAMETEST_Goku";

    private Paint paint;



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
            direcao = DESCE;
            paint = new Paint();
            paint.setColor(Color.BLACK);
        }catch (Exception e){
            Log.d(TAG,"Erro ao montar goku!");
        }
    }



    @Override
    public void update() {

        if (direcao == DESCE){
            if(getBoundingBox().getY()+getBoundingBox().getH()<GameParameterSingleton.HEIGHT ) {
                setY(getY() + (int) (PASSO_DESCE * GameParameterSingleton.DISTORTION));
                getBoundingBox().setY(getBoundingBox().getY() + (int) (PASSO_DESCE * GameParameterSingleton.DISTORTION));
            }
        }else {
            if(getBoundingBox().getY()>0) {
                setY(getY() - (int) (PASSO_SOBE * GameParameterSingleton.DISTORTION));
                getBoundingBox().setY(getBoundingBox().getY() - (int) (PASSO_SOBE * GameParameterSingleton.DISTORTION));
            }
        }
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
        /*debug*/
        c.drawRect(getBoundingBox().getX(),
                getBoundingBox().getY(),
                getBoundingBox().getX() + getBoundingBox().getW(),
                getBoundingBox().getY() + getBoundingBox().getH(),paint);
        c.drawBitmap(figura,src,dest,null);
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public Bitmap getFigura() {
        return figura;
    }

    public void setFigura(Bitmap figura) {
        this.figura = figura;
    }

    public int getSpriteW() {
        return spriteW;
    }

    public void setSpriteW(int spriteW) {
        this.spriteW = spriteW;
    }

    public int getSpriteH() {
        return spriteH;
    }

    public void setSpriteH(int spriteH) {
        this.spriteH = spriteH;
    }

    public int getCurrentSprite() {
        return currentSprite;
    }

    public void setCurrentSprite(int currentSprite) {
        this.currentSprite = currentSprite;
    }
}
