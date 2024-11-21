public class Asiento {
    private int fila;
    private int numero;
    private boolean reservado;

    public Asiento(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.reservado = false;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar() {
        this.reservado = true;
    }

    // Getters
    public int getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }
}
