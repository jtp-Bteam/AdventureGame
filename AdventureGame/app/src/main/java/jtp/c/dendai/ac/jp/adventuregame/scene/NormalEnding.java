package jtp.c.dendai.ac.jp.adventuregame.scene;

import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/12.
 */

public class NormalEnding extends AbstractScene {
    @Override
    public int getImageId() {
        return R.drawable.gutspose_man;
    }
    @Override
    public int getMessageId() {
        return R.array.normalending;
    }
    @Override
    public boolean getFightFlag() {
        return false;
    }
    @Override
    public GameState next(int no) {
        resetMoney();
        return null;
    }
    @Override
    public int getDateId() {
        return R.string.date1;
    }
}
