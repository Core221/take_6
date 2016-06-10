package game;

public class Card{

    private int points;
    private int value;

    public Card(int value){

        this.value = value;
        String doubles = value+"";
        if((value%5)==0 && value%10!=0)points=2;
        else if((value%10)==0 && (value%5)!=0 )points=3;
        else if(doubles.length()==2) {
            if (doubles.charAt(0) == doubles.charAt(1)) points = 5;
        }
        else if(value==55)points=7;
        else{
            points =1;
        }
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
