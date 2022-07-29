package Characters;

import Players.Player;

public class Kaique extends Character {

    public Kaique() {

        // Skills definition
        skills = new String[4];
        description = new String [5];
        setPassive("Gym Mouse");
        skills[0] = "Headbutt 5000L";
        skills[1] = "Offend Minority";
        skills[2] = "Isolation";
        skills[3] = "Wear Hood";

        // StaminaCost definition
        staminaCost = new int[4];
        staminaCost[0] = 30;
        staminaCost[0] = 40;
        staminaCost[0] = 10;
        staminaCost[0] = 80;

        // Status definition
        setName("Kaique");
        setLife(100);
        setAtkDamage(10);
        setStamina(100);
        setDefense(10);
    }

    @Override
    protected void passive() {
        description[0] = "At the beginning of the round Kaique is in the \"pump\" and receives +10 attack";
        System.out.println("\nGym mouse passive activated, kaique got stronger");
        setAtkDamage(getAtkDamage() + 10);
    }

    @Override
    protected void skillOne(Player player) {
        description[1] = "Kaique attacks with his head dealing 10+20% atkdamage, has a 50% chance to stun";
        System.out.println("Kaique attacked with " + skills[0]);
        int chance = rd.nextInt(2);
        if (chance == 0) {
            player.getCharacter().setStunned(true);
        } 
        player.getCharacter().setLife(player.getCharacter().getLife() - 10 + (0.2 * getAtkDamage()));
    }

    @Override
    protected void skillTwo(Player player) {
        description[2] = "Kaique makes jokes that offend minorities, whoever listens suffers 30+5% of atkdamage";
        System.out.println("Kaique attacked with " + skills[1]);
        player.getCharacter().setLife(player.getCharacter().getLife() - (30 + (0.05 * getAtkDamage())));
    }

    @Override
    protected void skillThree(Player player) {
        description[3] = "Kaique isolates herself by gaining 40% armor and restoring 50% of his stamina";
        System.out.println("Kaique attacked with " + skills[2]);
        setDefense(getDefense() + (getDefense() * 0.4));
        setStamina(getStamina() + (getStamina() * 0.5));
    }

    @Override
    protected void skillFour(Player player) {
        description[4] = "Kaique dons his hood and becomes more focused, gaining 20 atkdamage, 20 armor and recovering 40 stamina per round. Lasts 3 rounds";
        System.out.println("Kaique attacked with " + skills[3]);
        setDefense(getDefense() + 20);
        setStamina(getStamina() + 40);
        setAtkDamage(getAtkDamage() + 20);
    }

}
