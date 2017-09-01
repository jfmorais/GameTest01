package jcury.com.br.gametest01.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by jcury on 01/09/2017.
 */

public class GameScreen extends View implements Runnable{

    private boolean update;
    private int i;
    private Paint paint;
    private static String TAG = "GameScreen";

    public GameScreen(Context context) {
        super(context);
        init();
    }

    public void update(){
        if (update){
            i++;

        }
    }

    public void onDraw(Canvas canvas){
        canvas.drawText("Valor do i: "+i, 50, 100, paint);
    }

    public void init(){
        i=0;
        update=true;
        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
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
