package jtp.c.dendai.ac.jp.adventuregame.scene;

import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/12.
 */

public class Chapter3_lose extends AbstractScene {
    @Override
    public int getImageId() {
        return R.drawable.pose_zasetsu;
    }
    @Override
    public int getMessageId() {
        return R.array.chapter3_lose;
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
