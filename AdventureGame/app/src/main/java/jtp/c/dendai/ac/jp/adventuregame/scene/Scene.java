package jtp.c.dendai.ac.jp.adventuregame.scene;
import jtp.c.dendai.ac.jp.adventuregame.Handler;
import android.view.View.OnClickListener;
public interface Scene extends OnClickListener {
    GameState next(int no);
    void start(Handler hand);
    int getMessageId();
    int getImageId();
    boolean getFightFlag();
    int getDateId();
    void endFight(int dMoney);
}