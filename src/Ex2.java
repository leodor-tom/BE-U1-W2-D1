import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {


                System.out.println("inserisci il numero di km percorsi (oppure un valore negativo per uscire):");
                double km = input.nextDouble();

                if (km < 0) {
                    System.out.println("programma terminato.");
                    input.close();
                    break;
                }

                System.out.println("inserisci il numero di litri di carburante consumati:");
                double litri = input.nextDouble();

                if (litri == 0) {
                    throw new ArithmeticException("non puoi inserire 0 per i litri consumati");
                }
                double kmPerLitro = km / litri;
                System.out.println("l'auto percorre " + kmPerLitro + " km con un litro di carburante. ");
            } catch (InputMismatchException ex) {
                System.out.println("per favore, inserisci un numero valido");
                input.nextLine();
            } catch (ArithmeticException ex) {
                System.err.println("errore: " + ex.getMessage());
            }
        }
        input.close();
    }
}
