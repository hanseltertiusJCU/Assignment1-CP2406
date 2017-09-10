public class SuperTrumps extends Card{
    //talk about the supertrump card

    SuperTrumps (String n){
        //constructor
        super (n);
    }

    public String cardEffect()
    {
        String cardEffect = "";
        String n = getCardName();
        if (n.equals("The Mineralogist")){
            cardEffect = "CLE";
        }
        else if (n.equals("The Geologist")){
            cardEffect = "CHOICE";
        }
        else if (n.equals("The Geophysicist")){
            cardEffect = "GRAV/MAG";
        }
        else if (n.equals("The Gemmologist")){
            cardEffect = "HARD";
        }
        else if (n.equals("The Miner")){
            cardEffect = "ECO";
        }
        else if (n.equals("The Petrologist")){
            cardEffect = "ABU";
        }
        return cardEffect;
    }

    public String effectDescription()
    {
        String desc = "";
        String n = getCardName();
        if (n.equals("The Mineralogist")){
            desc = "changes the trumps category to Cleavage";
        }
        else if (n.equals("The Geologist")){
            desc = "changes the trumps category of your choice";
        }
        else if (n.equals("The Geophysicist")){
            desc = "changes the trumps category to Specific Gravity (or throw magnetite to win the hand)";
        }
        else if (n.equals("The Gemmologist")){
            desc = "changes the trumps category to Hardness";
        }
        else if (n.equals("The Miner")){
            desc = "changes the trumps category to Economic Value";
        }
        else if (n.equals("The Petrologist")){
            desc = "changes the trumps category to Crystal Abundance";
        }
        return desc;
    }
}
