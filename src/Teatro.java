import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private String nombre;
    private List<Sala> salas;

    public Teatro(String nombre) {
        this.nombre = nombre;
        this.salas = new ArrayList<>();
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public List<Sala> getSalas() {
        return salas;
    }
}



