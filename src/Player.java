import java.util.ArrayList;

public class Player {
    //store player names, which depends on the number of the players
    private ArrayList<Card> playerHand;
    private String playerName;

    Player (String name){
        playerHand = new ArrayList<>();
        playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Card getPlayerCard(int c){
        return playerHand.get(c);
    }

    public void drawPlayerCard(Card card){
        playerHand.add(card);
    }
}
