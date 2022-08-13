package Characters;

import Players.Player;

public class JoaoVictor extends Character {
    
    public JoaoVictor() {

        // Skills definition
        skills = new String[4];
        description = new String[5];
        setPassive("Anarchy");
        skills[0] = "Xenofobic";
        skills[1] = "Whash Dish";
        skills[2] = "Words of Truth";
        skills[3] = "God Vult";

        // StaminaCost definition *
        staminaCost = new int[4];
        staminaCost[0] = 30;
        staminaCost[1] = 40;
        staminaCost[2] = 30;
        staminaCost[3] = 100;

        // Status definition *
        setName("João Victor");
        setLife(130);
        setAtkDamage(6);
        setStamina(100);
        setDefense(40);
        setRegeneration(10);

        // Description definition
        description[0] = "Jv regenerate 10 life points per round, but if charlon is your enemy, he regenerate 15 heal points";
        description[1] = "Jv goes into Defense Position and gains 10 armor and 5% reflected damage";
        description[2] = "Jv obeys his mother and washes the dishes, gaining 2+20% ("+Math.round((2+(0.2*40)))+") armor";
        description[3] = "Jv speaks the hards truths and deal 2+60% ("+Math.round((2+(0.6*getAtkDamage())))+") atkdamage of true damage";
        description[4] = "God Vult bless Jv and give divine regeneration, Anarchy buffed in the 15%";
    }

    @Override
    protected void passive() {
        System.out.println("\nAnarchy passive activated, Jv regenerate 10 life points");
        setLife(getLife()+getRegeneration());
    }

    @Override
    protected void skillOne(Player player) {
        System.out.println("Jv attacked with " + skills[0]);
        setDefense(getDefense()+10);
        //reflect damage
        setStamina(getStamina() - staminaCost[0]);
    }

    @Override
    protected void skillTwo(Player player) {
        System.out.println("Jv attacked with " + skills[1]);
        setDefense(getDefense()+Math.round((2+(0.2*40))));
        setStamina(getStamina() - staminaCost[1]);
    }

    @Override
    protected void skillThree(Player player) {
        System.out.println("Jv attacked with " + skills[2]);
        player.getCharacter().setLife(player.getCharacter().getLife()-Math.round((2+(0.6*getAtkDamage()))));
        setStamina(getStamina() - staminaCost[2]);
    }

    @Override
    protected void skillFour(Player player) {
        System.out.println("Jv attacked with " + skills[3]);
        setRegeneration(12);;
        System.out.println("\nAnarchy was blessed");
        setStamina(getStamina() - staminaCost[3]);
    }
}
