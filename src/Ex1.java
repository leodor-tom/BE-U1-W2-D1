import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    private static Logger log = LoggerFactory.getLogger(Ex1.class);

    public static void main(String[] args) {
        int[] array = new int[5];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }
        System.out.println("questo è l'array: ");
        stampaArray(array);

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("inserisci un numero, (0 per terminare):");
                int numero = Integer.parseInt(input.nextLine());

                if (numero == 0) {
                    System.out.println("programma terminato.");
                    input.close();
                    break;
                }

                System.out.println("inserisci la posizione in cui inserire il numero (tra 0 e 4)");
                int posizione = Integer.parseInt(input.nextLine());

                if (posizione < 0 || posizione >= array.length) {
                    throw new ArrayIndexOutOfBoundsException("posizione non valida!");
                }

                array[posizione] = numero;
                System.out.println("Nuovo stato array:");
                stampaArray(array);
            } catch (InputMismatchException ex) {
                System.out.println("per favore, inserisci un numero intero valido.");
                input.nextLine();
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println(ex.getMessage());
            }
        }
        input.close();
    }

    private static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }


}