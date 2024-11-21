public class Reserva {
    private Cliente cliente;
    private Asiento asiento;

    public Reserva(Cliente cliente, Asiento asiento) {
        this.cliente = cliente;
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Reserva de " + cliente + " para el asiento: Fila " + asiento.getFila() + ", Asiento " + asiento.getNumero();
    }
}