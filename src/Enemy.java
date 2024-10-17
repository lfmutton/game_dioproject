public class Enemy {
    private String name;
    private int body;
    private double power;
    private boolean alive;

    public Enemy(String name, int body, double power) {
        this.name = name;
        this.body = body;
        this.power = power;
        this.alive = false;
    }

    public int Body() {
        return this.body;
    }

    public String Name() {
        return this.name;
    }

    public double Power() {
        return this.power;
    }

    public void isDead() {
        this.alive = false;
    }

    public boolean Alive() {
        return this.alive;
    }
}
