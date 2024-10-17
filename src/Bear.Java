import java.lang.Math;

public class Bear extends Enemy{
    private double health;
    private double defense;
    private double attack;
    private int level;
    public Bear(int level){
        super("Bear", 10, 5);
        this.level = level;
        this.health = this.Body() * level;
        this.defense = this.Body() + Math.ceil(level/2);
        this.attack = this.Power() * Math.ceil(level/3); 
    }
}