import java.util.Random;
import java.util.Scanner;

public class PaymentProcessor {
    private Scanner scanner;

    public PaymentProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean process() {
        System.out.println("Méthodes de paiement :");
        System.out.println("1. Carte de crédit / débit");
        System.out.println("2. Paiement mobile (Mobile Money)");
        System.out.print("Choisissez une option (1 ou 2) : ");
        int choice = scanner.nextInt();

        Random rand = new Random();
        boolean success = rand.nextBoolean();

        if (!success) {
            System.out.println("Erreur : Paiement refusé ou problème de connexion.");
            return false;
        }

        System.out.println("Paiement accepté.");
        return true;
    }
}
