public class Ability {
    private String name;
    private double damage;

    public Ability(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }

    public String AbilityName() {
        return this.name;
    }

    public double AbilityDamage() {
        return this.damage;
    }
}
