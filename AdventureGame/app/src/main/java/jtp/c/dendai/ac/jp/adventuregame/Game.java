package jtp.c.dendai.ac.jp.adventuregame;
import jtp.c.dendai.ac.jp.adventuregame.scene.GameState;
import jtp.c.dendai.ac.jp.adventuregame.scene.Scene;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
public class Game implements Handler {
    private ActionBarActivity activity;
    private Title title;
    private Scene scene;
    public Game(ActionBarActivity mainActivity) {
        this.activity = mainActivity;
        title = new Title();
    }
    @Override
    public void step(Scene s) {
        scene = s;
        start();
    }
    public void start() {
        if(scene==null) {
            activity.setContentView(title.getContentView());
            title.init(activity,new OnStartButtonClickListener(true), new OnStartButtonClickListener(false));
        }else{
            activity.setContentView(R.layout.activity_main);
            scene.start(this);
        }
    }
    class OnStartButtonClickListener implements OnClickListener {
        private boolean intialize;
        public OnStartButtonClickListener(boolean b) {
            intialize = b;
        }
        @Override
        public void onClick(View v) {
            if(intialize || scene==null){
                scene=GameState.getInitialScene();
            }
            start();
        }
    }

    public Scene getScene()
    {
        return scene;
    }
}