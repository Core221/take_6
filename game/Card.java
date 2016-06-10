package game;

public class Card{

    private int points;
    private int value;

    public Card(int value){

        this.value = value;
        String doubles = value+"";
//        System.out.println((value/5)%2+"");
        points = 1;
        if(doubles.length()==1){
            if(doubles.charAt(0)=='5')points=2;

        }
        else if(doubles.length()==2) {
            if(doubles.charAt(1)=='5')points=2;
            else if(doubles.charAt(1)=='0')points=3;
            else if(doubles.charAt(0) == doubles.charAt(1)) points = 5;
        }
        if(value==55)points=7;
        System.out.println(points);
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
