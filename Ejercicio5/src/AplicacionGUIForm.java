import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicacionGUIForm {
    private JPanel pGeneral;
    private JTextField campoTxt;
    private JLabel etiResultado;
    private CalculadoraRPN calculadora;
    private JButton calcularButton;
    private JLabel titulo;


    // Constructor
    public AplicacionGUIForm() {
        calculadora = new CalculadoraRPN();
        // Acción a plasto el botón de calcular

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

    }

    // calcular el resultado cuando se aplasto el botón
    private void calcularResultado() {
        String expresion = campoTxt.getText(); // expresión del campo de txt
        try {
            // Revisar la expresion
            int resultado = calculadora.evaluar(expresion);
            etiResultado.setText("Resultado: " + resultado);
        } catch (Exception ex) {
            etiResultado.setText("Error: Expresión inválida");
        }
    }

    // Cosasa basicas para poder tener la app
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora RPN");
        frame.setContentPane(new AplicacionGUIForm().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
