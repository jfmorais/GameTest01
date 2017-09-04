package jcury.com.br.gametest01.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import jcury.com.br.gametest01.model.InfiniteBackground;
import jcury.com.br.gametest01.singleton.GameParameterSingleton;

/**
 * Created by jcury on 01/09/2017.
 */

public class GameScreen extends View implements Runnable{

    private boolean update;
    private int i;
    private Paint paint;

    public InfiniteBackground bg;

    private static String TAG = "GAMETEST_GameScreen";

    public GameScreen(Context context) {
        super(context);
        init();
    }

    public void update(){
        if (update){
            bg.update();
        }
    }

    public void onDraw(Canvas canvas){
//        canvas.drawText("Valor do i: "+i, 50, 100, paint);
        bg.draw(canvas);
    }

    public void init(){
        i=0;
        update=true;
        paint = new Paint();
//       paint.setColor(Color.BLACK);

        //cria objetos de jogo
        bg = new InfiniteBackground(this.getContext());
        //definindo fator de distorcao
        GameParameterSingleton.DISTORTION = (float) GameParameterSingleton.HEIGHT / bg.getH();
//        bg.setW((int) ( bg.getW() * GameParameterSingleton.DISTORTION));
//        bg.setH((int) ( bg.getH() * GameParameterSingleton.DISTORTION));
        bg.updateDistortion();
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
