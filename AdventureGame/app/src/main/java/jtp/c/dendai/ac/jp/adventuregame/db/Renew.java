package jtp.c.dendai.ac.jp.adventuregame.db;

import android.widget.TextView;
import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/05.
 */

public class Renew {

    public void  choice(int select, TextView choice){
        switch (select){
            case 0 :
                choice.setText("溜め！");
                break;
            case 1 :
                choice.setText("攻撃！");
                break;
            case 2 :
                choice.setText("防御！");
                break;
        }
    }

    public void  syokika(ResID resID){
        resID.getMyCharge().setText("チャージ数:0");
        resID.getEnemyCharge().setText("チャージ数:0");
        resID.getMyChoice().setText(R.string.default_my_choice);
        resID.getEnemyChoice().setText(R.string.default_enemy_choice);
        resID.getResult().setText(R.string.default_result);
        resID.getAttack().setEnabled(false);
    }
}
