package Config;

import Characters.Character;

public class Description {

    public void status(Character character) {
        System.out.println("\n|---"+character.getName()+"---");
        System.out.println("|Life: "+character.getLife());
        System.out.println("|Damage: "+character.getAtkDamage());
        System.out.println("|Stamina: "+character.getStamina());
        System.out.println("|Armor: "+character.getDefense());
        System.out.println("\n|Passive ("+character.getPassive()+"): "+character.getDescription()[0]);
        System.out.println("\n|First Skill ("+character.getSkills()[0]+"): "+character.getDescription()[1]);
        System.out.println("\n|Second Skill ("+character.getSkills()[1]+"): "+character.getDescription()[2]);
        System.out.println("\n|Third Skill ("+character.getSkills()[2]+"): "+character.getDescription()[3]);
        System.out.println("\n|Fourth Skill ("+character.getSkills()[3]+"): "+character.getDescription()[4]);
        
    }
}
