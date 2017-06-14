package jtp.c.dendai.ac.jp.adventuregame.db;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/05.
 */

public class ResID {

    private Button attack,guard,charge;
    private TextView myCharge,enemyCharge,myChoice,enemyChoice,result;

    ResID(Activity activity)
    {
        attack = (Button)activity.findViewById(R.id.attack);
        guard = (Button)activity.findViewById(R.id.guard);
        charge = (Button)activity.findViewById(R.id.charge);

        myCharge = (TextView)activity.findViewById(R.id.myCharge);
        enemyCharge = (TextView)activity.findViewById(R.id.enemyCharge);

        myChoice = (TextView)activity.findViewById(R.id.myChoice);
        enemyChoice = (TextView)activity.findViewById(R.id.enemyChoice);

        result = (TextView)activity.findViewById(R.id.result);
    }

    public Button getAttack() {
        return attack;
    }

    public Button getGuard() {
        return guard;
    }

    public Button getCharge() {
        return charge;
    }

    public TextView getMyCharge() {
        return myCharge;
    }

    public TextView getEnemyCharge() {
        return enemyCharge;
    }

    public TextView getMyChoice() {
        return myChoice;
    }

    public TextView getEnemyChoice() {
        return enemyChoice;
    }

    public TextView getResult() {
        return result;
    }
}
