package jtp.c.dendai.ac.jp.adventuregame.db;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/05.
 */

public class Fight implements View.OnClickListener{

    Activity activity;
    ResID resID;
    Renew renew;

    int myNum = 0;
    int enemyNum = 0;

    int mySelect = 0; //0がチャージ、1が攻撃、2が防御
    int enemySelect = 0;

    Fight(Activity activity)
    {
        this.activity = activity;
        resID = new ResID(activity);
        renew = new Renew();

        resID.getAttack().setOnClickListener(this);
        resID.getAttack().setEnabled(false);
        resID.getGuard().setOnClickListener(this);
        resID.getCharge().setOnClickListener(this);
    }

    public void enemyTurn(){
        if(myNum == 1 && enemyNum == 0){ //最初の時とか
            enemySelect = 0;
            enemyNum += 1;
            resID.getEnemyCharge().setText("チャージ数:" + enemyNum);
        }
        else if(enemyNum == 0){ //こちらにチャージがあるが相手にチャージが無い場合
            enemySelect = (int)(Math.random() * 2);
            switch(enemySelect)
            {
                case 0:
                    enemyNum += 1;
                    resID.getEnemyCharge().setText("チャージ数:" + enemyNum);
                    break;
                case 1:
                    enemySelect = 2;
                    break;
            }

        }
        else if(myNum == 1){ //こちらにチャージが無いが相手にチャージがある場合
            enemySelect = (int)(Math.random() * 2);
            switch (enemySelect){
                case 0 :
                    enemyNum += 1;
                    resID.getEnemyCharge().setText("チャージ数:" + enemyNum);
                    break;
                case 1 :
                    enemyNum -= 1;
                    resID.getEnemyCharge().setText("チャージ数:" + enemyNum);
                    break;
            }
        }
        else{
            enemySelect = (int)(Math.random() * 3);
            switch (enemySelect){
                case 0 :
                    enemyNum += 1;
                    resID.getEnemyCharge().setText("チャージ数:" + enemyNum);
                    break;
                case 1:
                    enemyNum -= 1;
                    resID.getEnemyCharge().setText("チャージ数:" + enemyNum);
                    break;
            }
        }
        renew.choice(enemySelect, resID.getEnemyChoice());
    }

    public void judge(){
        if(mySelect == 1 && enemySelect == 0){
            finish(0);
        }
        else if(mySelect == 0 && enemySelect == 1){
            finish(1);
        }
        else if(mySelect == 1 && enemySelect ==1){
            resID.getResult().setText("相殺！");
        }
        else{
            resID.getResult().setText("見合って見合って……");
        }
    }

    public void syokika(){
        myNum = 0;
        enemyNum = 0;
        renew.syokika(resID);
    }

    public void  finish(int result){
        AlertDialog.Builder ad = new AlertDialog.Builder(activity);
        ad.setTitle("決着！");

        switch(result)
        {
            case 0 :
                ad.setMessage("あなたの勝ち！");
                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = activity.getIntent();
                        intent.putExtra("result",0);
                        activity.setResult( Activity.RESULT_OK, intent );
                        activity.finish();
                    }
                });
                break;
            case 1 :
                ad.setMessage("敵の勝ち！");
                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = activity.getIntent();
                        intent.putExtra("result",100000);
                        activity.setResult( Activity.RESULT_OK, intent );
                        activity.finish();
                    }
                });
                break;
            default:
                ad.setMessage("これエラーだよ");
                break;
        }
        ad.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.charge :
                myNum += 1;
                mySelect = 0;
                resID.getMyCharge().setText("チャージ数:" + myNum);
                break;
            case R.id.attack :
                myNum -= 1;
                mySelect = 1;
                resID.getMyCharge().setText("チャージ数:" + myNum);
                break;
            case R.id.guard :
                mySelect = 2;
                break;
        }
        if(myNum == 0){
            resID.getAttack().setEnabled(false);
        }
        else{
            resID.getAttack().setEnabled(true);
        }
        enemyTurn();
        renew.choice(mySelect, resID.getMyChoice());
        judge();
    }
}
