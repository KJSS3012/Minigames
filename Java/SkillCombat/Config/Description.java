package Config;

import Characters.Character;

public class Description {

    public void status(Character character) {
        System.out.println("\n|---"+character.getName()+"---");
        System.out.println("|Life: "+character.getLife());
        System.out.println("|Damage: "+character.getAtkDamage());
        System.out.println("|Stamina: "+character.getStamina());
        System.out.println("|Armor: "+character.getDefense());
        System.out.println("\n|Passive: "+character.getDescription()[0]);
        System.out.println("\n|First Skill: "+character.getDescription()[1]);
        System.out.println("\n|Second Skill: "+character.getDescription()[2]);
        System.out.println("\n|Third Skill: "+character.getDescription()[3]);
        System.out.println("\n|Fourth Skill: "+character.getDescription()[4]);
        
    }
}
