import java.util.Random;
import java.util.Scanner;

public class DrinkSelector {
    private Scanner scanner;

    public DrinkSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public String select() {
        System.out.println("Sélectionnez votre boisson :");
        System.out.println("1. Espresso");
        System.out.println("2. Latte");
        System.out.print("Votre choix (1 ou 2) : ");
        int choice = scanner.nextInt();

        Random rand = new Random();
        if (rand.nextInt(10) < 2) {
            System.out.println("Erreur : Capsule manquante.");
            return null;
        }

        if (rand.nextInt(10) < 2) {
            System.out.println("Erreur : Réservoir d'eau vide.");
            return null;
        }

        if (rand.nextInt(10) < 1) {
            System.out.println("Erreur : Panne technique.");
            return null;
        }

        return choice == 1 ? "Espresso" : "Latte";
    }
}
