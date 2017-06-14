package jtp.c.dendai.ac.jp.adventuregame.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import jtp.c.dendai.ac.jp.adventuregame.R;

public class FightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        Fight game = new Fight(this);
    }
}
