package jtp.c.dendai.ac.jp.adventuregame.scene;

import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/12.
 */

public class Chapter3_win extends AbstractScene {
    @Override
    public int getImageId() {
        return R.drawable.buisnessman_money_niyake;
    }
    @Override
    public int getMessageId() {
        return R.array.chapter3_win;
    }
    @Override
    public boolean getFightFlag() {
        return false;
    }
    @Override
    public GameState next(int no) {
        return GameState.chapter4;
    }
    @Override
    public int getDateId() {
        return R.string.date1;
    }
}
