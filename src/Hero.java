public class Hero extends Character {
    private int maxhealth;
    private int defense;
    private int level;
    private double health;
    private double attack;
    private HeroClass heroClass;

    public Hero(String name, int level, String heroClass) {
        super(name, 8, 6);
        this.maxhealth = (int) (this.Body() * level);
        this.defense = (int) this.Body() + level;
        this.level = level;
        this.health = this.maxhealth;
        this.attack = this.Power() * Math.ceil(level / 3);
        this.heroClass = new HeroClass(heroClass);
    }

    public void GetAttacked(int attack, double damage) {
        if (attack >= this.defense) {
            this.health -= damage;
        }
        if (this.health <= 0) {
            this.isDead();
        }
    }

    public double Attack() {
        return this.attack;
    }

    public int AttackTry() {
        return (int) (Math.random() * 20 + 7);
    }

    public double AttackWithAbility(int i) {
        double damage = heroClass.GetAbilityDamage(i);
        if (damage == 0) {
            System.err.println("Ability does not exist...");
            return 0;
        }
        return damage;
    }

    public int Defense() {
        return this.defense;
    }

    public int MaxHealth() {
        return this.maxhealth;
    }

    public void ShowStatus() {
        System.out.println(this.Name() + ": " + this.maxhealth + "/" + this.health);
    }

    public void ShowAblities() {
        if (heroClass.CheckIfHasAbilities()) {
            heroClass.AllAbilities();
        }
    }
}
