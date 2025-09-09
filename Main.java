import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.time.LocalDate; //è una classe che rappresenta una data (gg/mm/aa)
import java.time.format.DateTimeFormatter; //classe che viene utilizata per convertire oggetti data e ora in stringhe e viceversa

public class Main {
    public static void main (String[] args){
        ArrayList<Evento> eventi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int prossimoId = 1;

        while(true){

            System.out.println("\n--- TO-DO LIST ---");
            System.out.println("1. Aggiungi evento");
            System.out.println("2. Mostra eventi");
            System.out.println("3. Elimina evento");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            switch (scelta){
                case 1: 
                scanner.nextLine();

                System.out.print("Titolo: ");
                String titolo = scanner.nextLine();

                System.out.print("Descrizione: ");
                String descrizione = scanner.nextLine();
                
                System.out.print("Data (gg-mm-aaaa): ");
                String localData = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(localData, formatter);

                Evento nuovoEvento = new Evento(prossimoId, titolo, descrizione, data);

                eventi.add(nuovoEvento);

                prossimoId++;
                break;

                case 2:
                if(eventi.isEmpty()){
                    System.out.println("Nessun evento presente");
                } else {
                for(int i = 0; i < eventi.size(); i++){
                    Evento elemento = eventi.get(i);
                    System.out.println(elemento);
                }
              }
              break; //Altrimenti vengono eseguiti anche gli altri case successivi

                case 3:
                System.out.print("Digitare ID evento da eliminare: ");
                int idEliminare = scanner.nextInt();

                for (int i = 0; i < eventi.size(); i++){
                    if(eventi.get(i).id == idEliminare){
                        eventi.remove(i);
                    }
                }
                break;

                case 4:
                System.out.print("Chiusura del programma");
                System.exit(0);
                break;

                case 5:
                //Chiedere quale ID modificare
                System.out.print("Digitare ID Evento da modificare: ");
                int idModificare = scanner.nextInt();
                scanner.nextLine(); //È necessario inserirlo perché il nextInt() non consuma l'invio, infatti l'invio rimane nel buffer e sara invece letto immediatamente da scanner.nextLine()  come una stringa vuota e non ci darà il tempo all'utente di scrivere

                boolean trovato = false;

                //Scorrere l'arrayList per trovare l'ID
                for (int i = 0; i < eventi.size(); i++){
                    if(eventi.get(i).id == idModificare){
                        trovato = true;
                        System.out.print("Inserire nuovo Titolo: ");
                        eventi.get(i).titolo = scanner.nextLine();
                        System.out.print("Inserire nuova Descrizione: ");
                        eventi.get(i).descrizione = scanner.nextLine();
                        System.out.print("Inserire nuova Data: ");
                        localData = scanner.nextLine();
                        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        eventi.get(i).data = LocalDate.parse(localData, formatter);
                    }
                }
                    if (!trovato){
                        System.out.print("ID non trovato");
                    }
                break;

                case 6:
                if(eventi.isEmpty()){
                    System.out.println("Nessun evento presente");
                } else {
                // collections.sort va ad utilizzare il metodo compareTo, fa questo perchè funziona solo con liste di oggetti che implementano Comparable
                Collections.sort(eventi);
                for(int i = 0; i < eventi.size(); i++){
                    Evento elemento = eventi.get(i);
                    System.out.println(elemento);
                }
              }
              break;
            }
        }
    }
}