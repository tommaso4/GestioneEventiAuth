package app.GestioneEvento.model.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq",sequenceName = "user_sequence",allocationSize = 1)
    private int Id;
    private String title;
    private String description;
    private LocalDate date;
    private String location;
    private int nrPlace;
    private List<Integer> postiDisponibili;
    @ManyToMany(mappedBy = "prenotazioni")
    private List<User> partecipanti;

    public Event(String title, String description, LocalDate date, String location, int nrPlace) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.nrPlace = nrPlace;
        this.postiDisponibili = creaPosti(nrPlace);
    }
    private static List<Integer> creaPosti(int posti){
        List<Integer> listaPosti = new ArrayList<>();
        for (int i = 0; i<= posti; i++){
            listaPosti.add(i);
        }
        return listaPosti;
    }
}
