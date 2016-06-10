package game;

public class Card{

    private int bulls;
    private int value;

    public Card(int value){

        this.value = value;

        //individual amount of bulls is calculated
        String doubles = value+"";
       bulls = 1;
        if(doubles.length()==1){
            if(doubles.charAt(0)=='5')bulls=2;
        }
        else if(doubles.length()==2) {
            if(doubles.charAt(1)=='5')bulls=2;
            else if(doubles.charAt(1)=='0')bulls=3;
            else if(doubles.charAt(0) == doubles.charAt(1))bulls = 5;
        }
        if(value==55)bulls=7;
    }

    public int getBulls(){
        return this.bulls;
    }

    public int getValue(){
        return this.value;
    }

    public void setBulls(int bulls){
        this.bulls =bulls;
    }

    public void setValue(int value){
        this.value = value;
    }
}
