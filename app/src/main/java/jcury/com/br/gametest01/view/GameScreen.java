package jcury.com.br.gametest01.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import jcury.com.br.gametest01.R;
import jcury.com.br.gametest01.model.Goku;
import jcury.com.br.gametest01.model.InfiniteBackground;
import jcury.com.br.gametest01.singleton.GameParameterSingleton;

/**
 * Created by jcury on 01/09/2017.
 */

public class GameScreen extends View implements Runnable{

    private boolean update;
    private int i;
    private Paint paint;

    private InfiniteBackground bg;
    private Goku goku;

    private static String TAG = "GAMETEST_GameScreen";

    public GameScreen(Context context) {
        super(context);
        init();
    }

    public void update(){
        if (update){
            bg.update();
            goku.update();
        }
    }

    public void onDraw(Canvas canvas){
//        canvas.drawText("Valor do i: "+i, 50, 100, paint);
        bg.draw(canvas);
        goku.draw(canvas);
    }

    public void init(){
        i=0;
        update=true;
        paint = new Paint();

        //cria objetos de jogo
        bg = new InfiniteBackground(this.getContext());

        //definindo fator de distorcao
        GameParameterSingleton.DISTORTION = (float) GameParameterSingleton.HEIGHT / bg.getH();

        bg.updateDistortion();

        goku = new Goku(this.getContext());
        goku.setX(50);
        goku.setY(50);
        goku.updateDistortion();

        //ajustando box do goku
        goku.getBoundingBox().setW(goku.getW()/2);
        goku.getBoundingBox().setH(goku.getH()/2);
        goku.getBoundingBox().setX(goku.getX() + (goku.getW() - goku.getBoundingBox().getW())/2);
        goku.getBoundingBox().setY(goku.getY() + (goku.getH() - goku.getBoundingBox().getH())/2);

    }

    public boolean onTouchEvent(MotionEvent evt){
        if (evt.getAction() == MotionEvent.ACTION_DOWN){
            goku.setDirecao(goku.SOBE);

            return true;
        }else if (evt.getAction() == MotionEvent.ACTION_UP) {
            goku.setDirecao(goku.DESCE);


            return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (true){
            try {
                update();
                postInvalidate();
                Thread.sleep(50);
            }catch (Exception e){
                Log.d(TAG,"Erro no loop do jogo");
            }
        }
    }
}
