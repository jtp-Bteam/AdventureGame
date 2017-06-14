package jtp.c.dendai.ac.jp.adventuregame.scene;

import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/12.
 */

public class Chapter4_lose extends AbstractScene {
    @Override
    public int getImageId() {
        return R.drawable.first;
    }
    @Override
    public int getMessageId() {
        return R.array.chapter4_lose;
    }
    @Override
    public boolean getFightFlag() {
        return false;
    }
    @Override
    public GameState next(int no) {
        switch(getMoney()){
            case 300000:
                return GameState.trueending;
            case 200000:
            case 100000:
                return GameState.normalending;
            case 0:
                return GameState.badending;
        }
        return null;
    }
    @Override
    public int getDateId() {
        return R.string.date1;
    }
}
