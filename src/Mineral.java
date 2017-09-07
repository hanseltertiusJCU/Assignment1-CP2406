public class Mineral extends Card{

    //the class is about mineral cards on the deck
    private float cardHardness;
    private float cardSpecGravity;
    private String cardCleavage;
    private int cardCleavageScore;
    private String cardCrystalAbundance;
    private int cardCrystalAbundanceScore;
    private String cardEconomicValue;
    private int cardEconomicValueScore;

    Mineral(String n, float hardness, float specificGravity, String cleavage, String crystalAbundance, String economicValue)
    {
        //constructor
        super(n);
        cardHardness = hardness;
        cardSpecGravity = specificGravity;
        cardCleavage = cleavage;
        cardCrystalAbundance = crystalAbundance;
        cardEconomicValue = economicValue;
        cardCleavageScore = convertCleavageScore();
        cardCrystalAbundanceScore = convertAbundanceScore();
        cardEconomicValueScore = convertEconomicScore();

    }

    public int getCardCleavageScore() {
        return cardCleavageScore;
    }

    public int getCardCrystalAbundanceScore() {
        return cardCrystalAbundanceScore;
    }

    public int getCardEconomicValueScore() {
        return cardEconomicValueScore;
    }

    public float getCardHardness() {
        return cardHardness;
    }

    public float getCardSpecGravity() {
        return cardSpecGravity;
    }

    public String getCardCleavage() {
        return cardCleavage;
    }

    public String getCardCrystalAbundance() {
        return cardCrystalAbundance;
    }

    public String getCardEconomicValue() {
        return cardEconomicValue;
    }
    public int convertCleavageScore(){
        int cleavageScore = 0;
        String c = getCardCleavage();
        if(c == "none"){
            cleavageScore = 1;
        }
        else if(c == "poor/none"){
            cleavageScore = 2;
        }
        else if (c == "1 poor"){
            cleavageScore = 3;
        }
        else if (c == "2 poor"){
            cleavageScore = 4;
        }
        else if (c == "1 good"){
            cleavageScore = 5;
        }
        else if (c == "1 good/1 poor"){
            cleavageScore = 6;
        }
        else if (c == "2 good"){
            cleavageScore = 7;
        }
        else if (c == "3 good"){
            cleavageScore = 8;
        }
        else if (c == "1 perfect"){
            cleavageScore = 9;
        }
        else if (c == "1 perfect/1 good"){
            cleavageScore = 10;
        }
        else if (c == "1 perfect/2 good"){
            cleavageScore = 11;
        }
        else if (c == "2 perfect/1 good"){
            cleavageScore = 12;
        }
        else if (c == "3 perfect"){
            cleavageScore = 13;
        }
        else if (c == "4 perfect"){
            cleavageScore = 14;
        }
        else if (c == "6 perfect"){
            cleavageScore = 15;
        }
        return cleavageScore;

    }

    public int convertAbundanceScore(){
        int abundanceValue = 0;
        String a = getCardCrystalAbundance();
        if (a == "ultratrace"){
            abundanceValue = 1;
        }
        else if (a == "trace"){
            abundanceValue = 2;
        }
        else if (a == "low"){
            abundanceValue = 3;
        }
        else if (a == "moderate"){
            abundanceValue = 4;
        }
        else if (a == "high"){
            abundanceValue = 5;
        }
        else if (a == "very high"){
            abundanceValue = 6;
        }
        return abundanceValue;
    }

    public int convertEconomicScore(){
        int economicValue = 0;
        String e = getCardEconomicValue();
        if (e == "trivial"){
            economicValue = 1;
        }
        else if (e == "low"){
            economicValue = 2;
        }
        else if (e == "moderate"){
            economicValue = 3;
        }
        else if (e == "high"){
            economicValue = 4;
        }
        else if (e == "very high"){
            economicValue = 5;
        }
        else if (e == "I'm rich!"){
            economicValue = 6;
        }
        return economicValue;
    }
}
