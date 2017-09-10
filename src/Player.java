import java.util.ArrayList;
import java.util.Scanner;

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

    public void playerTurn(Game game){
        int cardHandNum;
        boolean nextPlayer = false;
        String recentCardDesc;
        if(game.cardPlayed() && !(game.playerGetAnotherTurn(this))){
            if(game.getRecentCard() instanceof Mineral){
                recentCardDesc = "\nRecent card = Name: " + game.getRecentCard().getCardName() + "  " +
                        "Hardness: " + ((Mineral) game.getRecentCard()).getCardHardness() + "  " +
                        "Specific Gravity: " + ((Mineral) game.getRecentCard()).getCardSpecGravity() + "  " +
                        "Cleavage: " + ((Mineral) game.getRecentCard()).getCardCleavage() + "  " +
                        "Crystal Abundance: " + ((Mineral) game.getRecentCard()).getCardCrystalAbundance() + "  " +
                        "Economic Value: " + ((Mineral) game.getRecentCard()).getCardEconomicValue() + "\n";
            }
        else{
                recentCardDesc = "\nThe recent player play the " + ((SuperTrumps) game.getRecentCard()).getCardName() + " card\n";
            }
        }
        else if(game.cardPlayed() && game.playerGetAnotherTurn(this)){
            System.out.println("You are granted to select the trump mode again" + "\n");
            recentCardDesc = "You may pick the card again as you made all of other players pass";
            gameStart(game);
        }
        else {
            recentCardDesc = "There are no recent cards that have been played";
            gameStart(game);
        }
        while (!nextPlayer){
            String playerChoice;
            System.out.println("Game mode: " + game.getGameModeMessage() + "\n" + recentCardDesc + "\n" + showCardInHand() + getPlayerName() + ", enter the card number you want to play or simply enter PASS to pass");
            System.out.print(">>>");
            Scanner options = new Scanner(System.in);
            playerChoice = options.nextLine();
            if (playerChoice.toUpperCase().equals("PASS")){
                drawPlayerCard(game.getCardDeck().drawnCard());
                nextPlayer = true;
            }
            else{
                try {
                    cardHandNum = Integer.parseInt(playerChoice);
                    Card cardPlayed = getPlayerCard(cardHandNum);
                    boolean continueGame = game.gameCard(cardPlayed, this);
                    if(game.getGameMode().equals("CHOICE")){
                        game.putCardToGame(cardPlayed);
                        playerHand.remove((cardHandNum));
                        gameStart(game);
                        game.setRecentPlayer(this.getPlayerName());
                        nextPlayer = true;
                    }
                    else if (game.getGameMode().equals("GRAV/MAG"))
                    {
                        if(lookAtWinCard())
                        {
                            for (Card cardInHand : playerHand)
                            {
                                game.putCardToGame(cardInHand);
                                playerHand.remove((cardInHand));
                                game.setRecentPlayer(this.getPlayerName());
                            }
                            game.setGameMode("SPECGRAV");
                            nextPlayer = true;
                        }
                        else
                        {
                            game.setGameMode("SPECGRAV");
                        }
                        if(continueGame){
                            game.putCardToGame(cardPlayed);
                            playerHand.remove((cardHandNum));
                            game.setRecentPlayer(this.getPlayerName());
                            nextPlayer = true;
                        }
                    }
                    else {
                        if(continueGame){
                            game.putCardToGame(cardPlayed);
                            playerHand.remove((cardHandNum));
                            game.setRecentPlayer(this.getPlayerName());
                            nextPlayer = true;
                        }
                    }
                }
                catch (Throwable e){
                    System.out.println("Invalid input!");
                }
            }
        }
        if (playerHand.size() == 0){
            game.setRecentPlayer(game.getPlayers().get((game.getPlayers().indexOf(this)+1)%game.getPlayers().size()).getPlayerName());
            playerLeft(game);
        }
    }


    public String showCardInHand(){

        String handCard = "";
        int cardNum = 0;
        for(Card cards: playerHand)
        {
            String cardDesc;
            if (cards instanceof Mineral)
            {
                cardDesc = "No: " + cardNum + "  " +
                        "Name: " + cards.getCardName() + "  " +
                        "Hardness: " + ((Mineral) cards).getCardHardness() + "  " +
                        "Specific Gravity: " + ((Mineral) cards).getCardSpecGravity() + "  " +
                        "Cleavage: " + ((Mineral) cards).getCardCleavage() + "  " +
                        "Crystal Abundance: " + ((Mineral) cards).getCardCrystalAbundance() + "  " +
                        "Economic Value: " + ((Mineral) cards).getCardEconomicValue() + "\n";//making the desc works
            }
            else{
                cardDesc = "No: "+ cardNum+ "  " + "Name: " + cards.getCardName()+ "   " + "Description: " +
                        ((SuperTrumps) cards).effectDescription()+ "\n";
            }
            cardNum += 1;
            handCard += cardDesc;
        }
        return handCard;
    }

    public void gameStart(Game starter){
        String getGameMode;
        System.out.println("Enter the mode you want to play. Player: " + getPlayerName() + "\n" + showCardInHand() + "(HARD) Hardness" +"\n(SPECGRAV) Specific Gravity" + "\n(CLE) Cleavage" + "\n(ABU) Crystal Abundance" + "\n(ECO) Economic Value");
        System.out.print(">>>");
        Scanner gameMode = new Scanner(System.in);
        getGameMode = gameMode.nextLine();
        while (!(getGameMode.equals("HARD") || getGameMode.equals("SPECGRAV") || getGameMode.equals("ECO") || getGameMode.equals("ABU") || getGameMode.equals("CLE") || getGameMode .equals("hard") || getGameMode.equals("specgrav") || getGameMode.equals("eco") || getGameMode.equals("abu") || getGameMode.equals("cle"))){
            System.out.println("Invalid game mode!");
            System.out.println("Enter the mode you want to play. Player: " + getPlayerName() + "\n" + showCardInHand() + "(HARD) Hardness" +"\n(SPECGRAV) Specific Gravity" + "\n(CLE) Cleavage" + "\n(ABU) Crystal Abundance" + "\n(ECO) Economic Value");
            System.out.print(">>>");
            getGameMode = gameMode.nextLine();
        }
        starter.setGameMode(getGameMode.toUpperCase());
    }

    public boolean lookAtWinCard(){
        boolean winCard = false;
        for(Card cards: playerHand){
            if(cards.getCardName().equals("Magnetite")){
                winCard = true;
            }
        }
        return winCard;
    }


    public void playerLeft(Game game){
        game.getPlayers().remove(this);
        System.out.println("Player " + this.getPlayerName() + " has left the game");
    }
}
