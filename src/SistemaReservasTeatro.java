import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaReservasTeatro {
    private Teatro teatro;

    public SistemaReservasTeatro() {
        teatro = new Teatro("Teatro Principal");
        teatro.agregarSala(new Sala("Sala 1", 10, 10)); // Agregar una sala con 10x10 asientos
        crearGUI();
    }

    private void crearGUI() {
        JFrame frame = new JFrame("Sistema de Reservas de Teatro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        JComboBox<String> salasComboBox = new JComboBox<>();
        for (Sala sala : teatro.getSalas()) {
            salasComboBox.addItem(sala.getNombre());
        }

        JTextField clienteField = new JTextField();
        JTextField filaField = new JTextField();
        JTextField asientoField = new JTextField();
        JButton reservarButton = new JButton("Reservar");

        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String salaNombre = (String) salasComboBox.getSelectedItem();
                int fila = Integer.parseInt(filaField.getText());
                int numeroAsiento = Integer.parseInt(asientoField.getText());
                String nombreCliente = clienteField.getText();

                // Crear cliente
                Cliente cliente = new Cliente(nombreCliente, "Documento"); // Aquí puedes agregar lógica para el documento

                // Buscar la sala correspondiente
                for (Sala sala : teatro.getSalas()) {
                    if (sala.getNombre().equals(salaNombre)) {
                        if (sala.reservarAsiento(fila, numeroAsiento)) {
                            Reserva reserva = new Reserva(cliente, new Asiento(fila, numeroAsiento));
                            JOptionPane.showMessageDialog(frame, "Reserva exitosa: " + reserva);
                        } else {
                            JOptionPane.showMessageDialog(frame, "El asiento ya está reservado.");
                        }
                        break;
                    }
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(new JLabel("Selecciona la sala:"));
        frame.add(salasComboBox);
        frame.add(new JLabel("Nombre del cliente:"));
        frame.add(clienteField);
        frame.add(new JLabel("Fila (1-10):"));
        frame.add(filaField);
        frame.add(new JLabel("Número de asiento (1-10):"));
        frame.add(asientoField);
        frame.add(reservarButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaReservasTeatro::new);
    }
}