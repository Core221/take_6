package game;

public class Card{

    private int points;
    private int value;

    public Card(int value, int points){
        this.points = points;
        this.value = value;
    }

    public int getPoints(){
        return this.points;
    }

    public int getValue(){
        return this.value;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void setValue(int value){
        this.value = value;
    }
}
