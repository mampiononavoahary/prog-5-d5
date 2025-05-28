import java.util.Scanner;

public class CoffeeMachineApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue à la machine à café automatique !");

        PaymentProcessor payment = new PaymentProcessor(scanner);
        if (!payment.process()) {
            System.out.println("Échec du paiement. Fin du programme.");
            return;
        }

        DrinkSelector drinkSelector = new DrinkSelector(scanner);
        String drink = drinkSelector.select();
        if (drink == null) {
            System.out.println("Échec de la sélection. Fin du programme.");
            return;
        }

        DrinkDispenser dispenser = new DrinkDispenser(scanner);
        dispenser.dispense(drink);

        scanner.close();
    }
}
