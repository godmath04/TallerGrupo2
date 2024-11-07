import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JPanel pGeneral;
    private JTextField txtEntrada;
    private JTextArea txtResultado;
    private JButton balancearButton;

    private Balanceador balanceador;


    public PilaGUI() {
        balanceador = new Balanceador(txtResultado);
        balancearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = txtEntrada.getText();
                String resultado = balanceador.verificarBalanceo(expresion);
                txtResultado.setText(resultado);
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
