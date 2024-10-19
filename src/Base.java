import java.util.*;

public class Base {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the name of your character:");
        String name = scan.nextLine();
        System.out.println("Choose your class:\n1 - Warrior\n2 - Mage\n3 - Assassin\n4 - Monk");
        int number = 5;
        String heroClass = "";
        while (number < 1 || number > 4) {
            number = scan.nextInt();

            switch (number) {
                case 1:
                    heroClass = "Warrior";
                    break;

                case 2:
                    heroClass = "Mage";
                    break;

                case 3:
                    heroClass = "Assassin";
                    break;

                case 4:
                    heroClass = "Monk";
                    break;

                default:
                    System.out.println("This choice does not exist. Choose again:");
                    System.out.println("Choose your class:\n1 - Warrior\n2 - Mage\n3 - Assassin\n4 - Monk");
                    break;
            }
        }
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
                    System.out.println("The " + hero.ClassName() + " attacked using " + hero.DamageType() + " damage!");
                    enemy.GetAttacked(hero.AttackTry(), hero.Attack());
                    break;

                case 2:
                    System.out.println("Hero Status:\nLevel: " + hero.ShowLevel() + "\nClass Name: " + hero.ClassName()
                            + "\nAttack Damage: " + hero.Attack() + "\nDefense: " + hero.Defense()
                            + "\nDamage type: " + hero.DamageType() + "\nAblities:");
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
