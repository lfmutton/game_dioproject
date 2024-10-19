import java.util.*;

public class HeroClass {
    private String className;
    private String typeDamage;
    private Ability abilities[];

    public HeroClass(String name) {
        this.className = name;
        this.typeDamage = ChoosingDamageType(name);
    }

    public boolean CheckIfHasAbilities() {
        if (this.abilities == null)
            return false;
        return true;
    }

    public void NewAbility() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert the name of the abilitie");
        String name = scan.nextLine();
        Ability a = new Ability(name, 25 * Math.random());
        System.out.println("Your ability " + a.AbilityName() + " have a total damage of: " + a.AbilityDamage());
        if (this.abilities == null)
            this.abilities[0] = a;
        else
            this.abilities[this.abilities.length] = a;
    }

    public String ChoosingDamageType(String type) {
        switch (type.toLowerCase()) {
            case "mage":
                return "magic";

            case "warrior":
                return "slashing";

            case "assassin":
                return "piercing";

            case "monk":
                return "bludgeoning";
        }
        return "";
    }

    public double GetAbilityDamage(int i) {
        if (abilities[i] == null)
            return 0;
        return abilities[i].AbilityDamage();
    }

    public void AllAbilities() {
        if (CheckIfHasAbilities()) {
            for (Ability ability : abilities) {
                System.out.printf(ability.AbilityName() + ": " + ability.AbilityDamage() + "\n");
            }
        }
    }

    public String DamageType() {
        return this.typeDamage;
    }

    public String Name() {
        return this.className;
    }
}
