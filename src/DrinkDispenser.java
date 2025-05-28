import java.util.Random;
import java.util.Scanner;

public class DrinkDispenser {
    private Scanner scanner;

    public DrinkDispenser(Scanner scanner) {
        this.scanner = scanner;
    }

    public void dispense(String drink) {
        System.out.print("Veuillez placer un gobelet sous le distributeur... (appuyez sur Entrée)");
        scanner.nextLine();
        scanner.nextLine();

        Random rand = new Random();
        if (rand.nextInt(10) < 2) {
            System.out.println("Erreur : Gobelet manquant. Distribution annulée.");
            return;
        }

        System.out.println("Préparation de votre " + drink + "...");
        System.out.println("Votre " + drink + " est prêt. Bonne dégustation !");
    }
}