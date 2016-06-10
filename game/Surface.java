package game;

public class Surface{
    private Card[][] table;
    private Card[][] playerHand;

    public Surface(){
        table = new Card[4][6];
    }

    public void initialTable(Card[] initialCards){
        for(int i=0; i<4; i++){
            this.table[i][0] = initialCards[i];
        }
    }

    public void addPlayers(Card[][] hand){
        this.playerHand = hand;
    }
}