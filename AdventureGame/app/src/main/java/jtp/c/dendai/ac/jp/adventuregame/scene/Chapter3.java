package jtp.c.dendai.ac.jp.adventuregame.scene;

import jtp.c.dendai.ac.jp.adventuregame.R;

/**
 * Created by PCUser on 2017/06/12.
 */

public class Chapter3 extends AbstractScene {
    @Override
    public int getImageId() {
        return R.drawable.first;
    }
    @Override
    public int getMessageId() {
        return R.array.chapter3;
    }
    @Override
    public boolean getFightFlag() {
        return true;
    }
    @Override
    public GameState next(int no) {
        switch(no){
            case 0:
                return GameState.chapter3_win;
            case 1:
                return GameState.chapter3_lose;
        }
        return null;
    }
    @Override
    public int getDateId() {
        return R.string.date1;
    }
}
