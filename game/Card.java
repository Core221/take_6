package game;

public class Card{

    private String colour;
    private int value;

    public Card(String colour, int value){
        this.colour = colour;
        this.value = value;
    }

    public String getColour(){
        return this.colour;
    }

    public int getValue(){
        return this.value;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public void setValue(int value){
        this.value = value;
    }
}
