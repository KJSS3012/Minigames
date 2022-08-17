package Characters;

import Players.Player;

public class Charlon extends Character {
    
    public Charlon() {

        // Skills definition
        skills = new String[4];
        description = new String[5];
        setPassive("Ressurrection of Monarchy");
        skills[0] = "Ghost of Communism";
        skills[1] = "Division of Power";
        skills[2] = "French Revolution";
        skills[3] = "For Athen!";

        // StaminaCost definition *
        staminaCost = new int[4];
        staminaCost[0] = 30;
        staminaCost[1] = 40;
        staminaCost[2] = 30;
        staminaCost[3] = 100;

        // Status definition *
        setName("Charlon");
        setLife(110);
        setAtkDamage(12);
        setStamina(100);
        setDefense(15);

        // Description definition
        description[0] = "Jv regenerate 10 life points per round, but if charlon is your enemy, he regenerate 15 heal points";
        description[1] = "Jv goes into Defense Position and gains 10 armor and 5% reflected damage";
        description[2] = "Jv obeys his mother and washes the dishes, gaining 2+20% ("+Math.round((2+(0.2*40)))+") armor";
        description[3] = "Jv speaks the hards truths and deal 2+60% ("+Math.round((2+(0.6*getAtkDamage())))+") atkdamage of true damage";
        description[4] = "God Vult bless Jv and give divine regeneration, Anarchy buffed in the 15%";
    }

    @Override
    public void passive() {
        System.out.println("\nAnarchy passive activated, Jv regenerate 10 life points");
    }

    @Override
    public void skillOne(Player player) {
    }

    @Override
    public void skillTwo(Player player) {
    }

    @Override
    public void skillThree(Player player) {
    }

    @Override
    public void skillFour(Player player) {
    }

    public void reset(){
        setLife(110);
        setAtkDamage(12);
        setStamina(100);
        setDefense(15);
    }
}
