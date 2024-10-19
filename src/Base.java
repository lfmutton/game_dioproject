import java.util.*;

public class Base {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the name of your character:");
        String name = scan.nextLine();
        System.out.println("Write any class you want and write it down:");
        String heroClass = scan.nextLine();
        System.out.println("What level is  your character?");
        int level = scan.nextInt();
        Hero hero = new Hero(name, level, heroClass);
        Enemy enemy = new Enemy("Bear", 13);
        while (hero.Alive()) {
            int choice;
            enemy.ShowStatus();
            System.out.println("\n");
            hero.ShowStatus();
            System.out.println("1- Attack\n2- Check\n3- Run");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    enemy.GetAttacked(hero.AttackTry(), hero.Attack());
                    break;

                case 2:
                    System.out.println("Hero Status:\nAttack Damage: " + hero.Attack() + "\nDefense: " + hero.Defense()
                            + "\nAblities:");
                    hero.ShowAblities();
                    break;
                case 3:
                    System.out.println("Coward... You deserve to DIE!");
                    hero.isDead();
                    break;
                default:
                    System.out.println("There are no choices that match yours...\nHmmm, you just lost your turn lol.");
            }
            if (choice == 1 && (choice != 2 && choice != 3)) {
                hero.GetAttacked(enemy.AttackTry(), enemy.Attack());
            }
            if (!hero.Alive())
                System.out.println("You are dead...");
            if (!enemy.Alive()) {
                System.out.println("Congratulations, you won the battle, but not the war...\n wait for more...");
                hero.isDead();
            }
        }
    }
}
