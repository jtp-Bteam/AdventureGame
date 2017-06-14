package jtp.c.dendai.ac.jp.adventuregame.scene;
import jtp.c.dendai.ac.jp.adventuregame.Handler;
import jtp.c.dendai.ac.jp.adventuregame.R;
import jtp.c.dendai.ac.jp.adventuregame.db.FightActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public abstract class AbstractScene implements Scene {
    private int index;
    private Handler handler;
    private static Activity activity;
    private static int money = 300000;
    protected int size(){
        return getMessage().length;
    };
    public static void setActivity(Activity _activity){
        activity = _activity;
    }

    @Override
    public void onClick(View v){
        index++;

        if(index<size()){
            writeMessage();
        }else{
            if(getFightFlag()) {
                Intent intent = new Intent(activity, FightActivity.class);
                activity.startActivityForResult(intent, 1);
            }else{
                GameState n = next(0);
                Scene scene = n==null ? null : n.getScene();
                handler.step(scene);
            }
        }
    }

    @Override
    public void start(Handler h){
        handler = h;
        index=0;
        activity.setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) activity.findViewById(R.id.imageView1);
        imageView.setOnClickListener(this);
        imageView.setImageResource(getImageId());
        writeMessage();
    }

    private void writeMessage() {
        TextView textView = (TextView) activity.findViewById(R.id.textarea);
        textView.setText(getMessage()[index]);
        TextView textdate = (TextView) activity.findViewById(R.id.textdate);
        textdate.setText("所持金 : "+ NumberFormat.getInstance().format(money) + "円");

    }
    protected String[] getMessage() {
        return getStringArrayById(getMessageId());
    }
    protected String[] getStringArrayById(int id) {
        return activity.getResources().getStringArray(id);
    }

    @Override
    public void endFight(int dMoney) {
        if (dMoney == 0) handler.step(next(0).getScene());
        else {
            money -= dMoney;
            System.out.println(money);
            handler.step(next(1).getScene());
        }
    }

    public int getMoney()
    {
        return money;
    }

    public void resetMoney()
    {
        money = 300000;
    }
}