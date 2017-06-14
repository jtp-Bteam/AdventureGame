package jtp.c.dendai.ac.jp.adventuregame;
import android.support.v7.app.ActionBarActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Title {
    public void init(ActionBarActivity activity, OnClickListener onStartButtonClickListener, OnClickListener onContinueButtonClickListener) {
        Button startButton = (Button) activity.findViewById(R.id.startbutton);
        startButton.setOnClickListener(onStartButtonClickListener);
    }
    public int getContentView() {
        return R.layout.title;
    }
}