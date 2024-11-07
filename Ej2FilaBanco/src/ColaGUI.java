import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton atendidoButton;
    private JTextArea txtAtendidos;
    private JLabel Cliente;
    public Cola c = new Cola();

    public ColaGUI() {
        atendidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String mensaje = c.desencolar(txtAtendidos);
                    txtAtendidos.setText(mensaje);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al atender al cliente: " + ex.getMessage());
                }}
        });
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                try{
                    c.encolar(input, txtResultado);
                    txtElemento.setText("");

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error de ingreso");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaGUI");
        frame.setContentPane(new ColaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
