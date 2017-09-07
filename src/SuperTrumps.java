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
        if (n == "The Mineralogist"){
            cardEffect = "Cleavage";
        }
        else if (n == "The Geologist"){
            cardEffect = "Choice";
        }
        else if (n == "The Geophysicist"){
            cardEffect = "Gravity/Magnetite";
        }
        else if (n == "The Gemmologist"){
            cardEffect = "Hardness";
        }
        else if (n == "The Miner"){
            cardEffect = "Economy";
        }
        else if (n == "The Petrologist"){
            cardEffect = "Abundance";
        }
        return cardEffect;
    }

    public String EffectDescription()
    {
        String desc = "";
        String n = getCardName();
        if (n == "The Mineralogist"){
            desc = "changes the trumps category to Cleavage";
        }
        else if (n == "The Geologist"){
            desc = "changes the trumps category of your choice";
        }
        else if (n == "The Geophysicist"){
            desc = "changes the trumps category to Specific Gravity (or throw magnetite to win the hand)";
        }
        else if (n == "The Gemmologist"){
            desc = "changes the trumps category to Hardness";
        }
        else if (n == "The Miner"){
            desc = "changes the trumps category to Economic Value";
        }
        else if (n == "The Petrologist"){
            desc = "changes the trumps category to Crustal Abundance";
        }
        return desc;
    }
}
