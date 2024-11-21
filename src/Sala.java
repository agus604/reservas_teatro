
import java.util.ArrayList;
import java.util.List;

public class Sala {
    private String nombre;
    private List<Asiento> asientos;
    private int cantidadFilas;
    private int cantidadAsientosPorFila;

    public Sala(String nombre, int filas, int asientosPorFila) {
        this.nombre = nombre;
        this.cantidadFilas = filas;
        this.cantidadAsientosPorFila = asientosPorFila;
        this.asientos = new ArrayList<>();
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= asientosPorFila; j++) {
                asientos.add(new Asiento(i, j));
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public int getCantidadAsientosPorFila() {
        return cantidadAsientosPorFila;
    }

    public Asiento getAsiento(int fila, int numero) {
        for (Asiento asiento : asientos) {
            if (asiento.getFila() == fila && asiento.getNumero() == numero) {
                return asiento;
            }
        }
        return null; // En caso de que no se encuentre el asiento
    }

    public boolean reservarAsiento(int fila, int numero) {
        Asiento asiento = getAsiento(fila, numero);
        if (asiento != null && !asiento.isReservado()) {
            asiento.reservar();
            return true;
        }
        return false; // El asiento ya está reservado o no existe
    }
}
