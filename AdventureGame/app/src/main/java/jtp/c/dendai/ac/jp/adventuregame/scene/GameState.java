package jtp.c.dendai.ac.jp.adventuregame.scene;
public enum GameState {
    chapter1(new Chapter1()),
    chapter2(new Chapter2()),chapter2_win(new Chapter2_win()),chapter2_lose(new Chapter2_lose()),
    chapter3(new Chapter3()),chapter3_win(new Chapter3_win()),chapter3_lose(new Chapter3_lose()),
    chapter4(new Chapter4()),chapter4_win(new Chapter4_win()),chapter4_lose(new Chapter4_lose()),
    trueending(new TrueEnding()),normalending(new NormalEnding()),badending(new BadEnding())
    ;
    private Scene scene;
    public Scene getScene(){
        return scene;
    }
    private GameState(Scene s){
        scene = s;
    }
    public static Scene getInitialScene(){
        return chapter1.getScene();
    }
}