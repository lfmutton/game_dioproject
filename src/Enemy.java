import java.lang.Math;

public class Enemy extends Character {
    private int maxhealth;
    private int defense;
    private int level;
    private double health;
    private double attack;

    public Enemy(String name, int level) {
        super(name, 10, 5);
        this.maxhealth = (int) (this.Body() * level);
        this.defense = EnemyDefense(this.Body(), level);
        this.level = level;
        this.health = this.maxhealth;
        this.attack = this.Power() * Math.ceil(level / 3);
    }

    private int EnemyDefense(int body, int level) {
        int defense = body + level;
        if (defense > 20) {
            defense = 20 + level / 5;
        }
        return defense;
    }

    public double Attack() {
        return this.attack;
    }

    public int AttackTry() {
        return (int) (Math.random() * 20 + 4);
    }

    public void GetAttacked(double attack, double damage) {
        if (attack >= this.defense) {
            this.health -= damage;
        }
        if (this.health <= 0) {
            this.isDead();
        }
    }

    public int Defense() {
        return this.defense;
    }

    public double Health() {
        return this.health;
    }

    public int MaxHealth() {
        return this.maxhealth;
    }

    public void ShowStatus() {
        System.out.println(this.Name() + ": " + this.maxhealth + "/" + this.health);
    }

}
