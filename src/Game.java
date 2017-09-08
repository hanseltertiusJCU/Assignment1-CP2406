import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // about the game, which specify the flow of it
    private ArrayList<Card> cardUsed;
    private Deck cardDeck;
    private ArrayList<Player> players;
    private String gameMode;
    private String recentPlayer;

    Game(int playerNum, Deck deck){
        gameMode = "";
        cardUsed = new ArrayList<>();
        players = new ArrayList<>();
        cardDeck = deck;
        recentPlayer = "";
        for(int p = 0; p < playerNum; p++){
            System.out.println("Enter player name\n>>>"); // add while loop when the name input is empty
            Scanner playerName = new Scanner(System.in);
            String getPlayerName = playerName.nextLine();
            players.add(new Player(getPlayerName));//to be fixed later on
        }
        for (int h = 0; h < 8; h++){
            for (Player player : players){
                //drawcard from deck (to be added in player class)
            }
        }
    }

    public String getGameMode(){
        return gameMode;
    }

    public String getGameModeMessage(){
        String gameMsg = "";
        if (gameMode == "Hardness"){
            gameMsg = "This is a game of hardness";
        }
        else if (gameMode == "SpecGrav"){
            gameMsg = "This is a game of specific gravity";
        }
        else if (gameMode == "Economy"){
            gameMsg = "This is a game of economic value";
        }
        else if (gameMode == "Abundance"){
            gameMsg = "This is a game of crystal abundance";
        }
        else if (gameMode == "Cleavage"){
            gameMsg = "This is a game of cleavage";
        }
        return gameMsg;
    }

    public void setGameMode(String gameMode){
        this.gameMode = gameMode;
    }

    public void restoreDeck(){
        ArrayList<Card> reset = new ArrayList<>();
        for (Card cards: cardUsed){
            reset.add(cards);
        }
        setCardDeck(new Deck(reset));
        cardUsed.clear();
        cardUsed.add(reset.get(reset.size()-1));
    }

    public void setCardDeck(Deck cardDeck){
        this.cardDeck = cardDeck;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Card getRecentCard(){
        return cardUsed.get(cardUsed.size()-1);
    }

    public boolean cardPlayed(){
        boolean played = false;
        if (cardUsed.size() > 0){
            played = true;
        }
        return played;
    }

    public Deck getCardDeck() {
        return cardDeck;
    }

    // TO DO: add the flow of the card played after creating player constructor

    public void putCardToTable(Card card){
        cardUsed.add(card);
    }

    public String getRecentPlayer() {
        return recentPlayer;
    }


    public void setRecentPlayer(String recentPlayerTurn){
        this.recentPlayer = recentPlayerTurn;
    }

    //TO DO: add a method to check whether all other players passed or not



}
