import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Viene implementata l'interfaccia Comparable - già definità in Java - nella classe Evento tramite la parola chiave implements
// Tra <> viene inserito il tipo di oggetti che sono comparabili
public class Evento implements Comparable <Evento>{
    int id;
    String titolo;
    String descrizione;
    LocalDate data;

    Evento(int id, String titolo, String descrizione, LocalDate data){
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "ID: " + id + " | Titolo: " + titolo + " | Descrizione: " + descrizione + " | Data: " + data.format(formatter);
    }
    
    @Override
    // Si va a definire come confrontare le date di due eventi
    // this.data -> data dell'evento corrente
    // altro.data -> data dell'altro evento
    // compareTo() -> confronta le due date
    /*
     * Il metodo compareTo restituisce:
     * numero negativo se this.data è precedente a altro.data
     * zero se le date sono uguali
     * numero positivo se this.data è successivo a altro.data
     */
    public int compareTo(Evento altro){
        return this.data.compareTo(altro.data);
    }
}
