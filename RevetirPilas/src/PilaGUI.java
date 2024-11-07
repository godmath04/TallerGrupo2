import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JTextArea txtResultado;
    private JButton invertirSecuenciaButton;
    private JButton desapilarButton;
    private JPanel pGeneral;
    private JButton ingresarSecuenciaButton;
    private JTextArea txtInvertido;

    private Pila pila = new Pila();
    public PilaGUI() {
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila.desapilar(txtResultado);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al desapilar: " + ex.getMessage());
                }
            }
        });
        ingresarSecuenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PedirNumeros solicitar = new PedirNumeros(0);
                    solicitar.pedirNumero(pila, txtResultado);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar la secuencia: " + ex.getMessage());
                }

            }
        });
        invertirSecuenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila.invertirPila(txtInvertido);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al invertir la pila: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("PilaGUI");
        frame.setContentPane(new PilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
