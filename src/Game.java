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
    public boolean gameCard(Card card, Player play){
        boolean higherScore = false;
        int difference = 0;
        if(cardUsed.size() == 0 || this.playerGetAnotherTurn(play)){
            if (card instanceof SuperTrumps){
                gameMode = ((SuperTrumps) card).cardEffect();
            }
            higherScore = true;
        }
        else{
            if (card instanceof Mineral){
                if (getRecentCard() instanceof Mineral){
                    if (gameMode == "Hardness"){
                        Float now = new Float(((Mineral) card).getCardHardness());
                        Float prev = new Float(((Mineral) getRecentCard()).getCardHardness());
                        difference = now.compareTo(prev);
                    }
                    else if (gameMode == "SpecGrav"){
                        Float now = new Float(((Mineral) card).getCardSpecGravity());
                        Float prev = new Float(((Mineral) getRecentCard()).getCardSpecGravity());
                        difference = now.compareTo(prev);
                    }
                    else if (gameMode == "Economy"){
                        Float now = new Float(((Mineral) card).getCardEconomicValueScore());
                        Float prev = new Float(((Mineral) getRecentCard()).getCardEconomicValueScore());
                        difference = now.compareTo(prev);
                    }
                    else if (gameMode == "Abundance"){
                        Float now = new Float(((Mineral) card).getCardCrystalAbundanceScore());
                        Float prev = new Float(((Mineral) getRecentCard()).getCardCrystalAbundanceScore());
                        difference = now.compareTo(prev);
                    }
                    else if (gameMode == "Cleavage"){
                        Float now = new Float(((Mineral) card).getCardCleavageScore());
                        Float prev = new Float(((Mineral) getRecentCard()).getCardCleavageScore());
                        difference = now.compareTo(prev);
                    }
                    if (difference > 0){
                        higherScore = true;
                    }
                    else{
                        System.out.println("Invalid choice, your card doesn't have enough value compared to the recent card in the game");
                    }
                } else {
                    higherScore = true;
                }
            }
            else {
                setGameMode(((SuperTrumps) card).cardEffect());
                higherScore = true;
            }
        }
        return higherScore;
    }

    public void putCardToGame(Card card){
        cardUsed.add(card);
    }

    public String getRecentPlayer() {
        return recentPlayer;
    }


    public void setRecentPlayer(String recentPlayerTurn){
        this.recentPlayer = recentPlayerTurn;
    }

    public boolean playerGetAnotherTurn(Player playerGame){
        boolean another = false;
        if (getRecentPlayer().equals(playerGame.getPlayerName())){
            another = true;
        }
        return another;
    }

}
