package Characters;

import Players.Player;

public class Kaique extends Character {

    public Kaique() {
        // Skills definition
        setPassive("Gym Mouse");
        skills = new String[4];
        skills[0] = "Headbutt 5000L";
        skills[1] = "Offend Minority";
        skills[2] = "Isolation";
        skills[3] = "Wear Hood";
    }

    @Override
    protected void passive() {
        // At the beginning of the round Kaique is in the "pump" and receives +10 attack
        System.out.println("\nGym mouse passive activated, kaique got stronger");
        setAtkDamage(getAtkDamage() + 10);
    }

    @Override
    protected void skillOne(Player player) {
        // Kaique attacks with his head dealing 10+20% atkdamage, has a 50% chance to stun
        System.out.println("Kaique attacked with "+skills[0]);
        return (float) (10+(0.2*getAtkDamage()));
    }

    @Override
    protected void skillTwo(Player player) {
        // Kaique makes jokes that offend minorities, whoever listens suffers 30+5% of atkdamage
        System.out.println("Kaique attacked with "+skills[1]);
        return (float) (30+(0.05*getAtkDamage()));
    }

    @Override
    protected void skillThree(Player player) {
        // Kaique isolates herself by gaining 40% armor and restoring 50% of his stamina

    }

    @Override
    protected void skillFour(Player player) {
        // Kaique dons his hood and becomes more focused, gaining 20 atkdamage, 20 armor and recovering 40 stamina per round. Lasts 3 rounds

    }

}
