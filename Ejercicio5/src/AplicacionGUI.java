import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicacionGUI extends AplicacionGUIForm {

    private JTextField campoTxt;
    private JLabel etiResultado;
    private CalculadoraRPN calculadora;

    public AplicacionGUI() {



        // Crear los componentes de la GUI
        JLabel titulo = new JLabel("Ingrese expresion RPN:");
        campoTxt = new JTextField(20); // Campo de texto para la expresión
        JButton botCalcular = new JButton("Calcular"); // Botón para calcular
        etiResultado = new JLabel("Resultado: "); // Etiqueta para el resultado



        //  botón de calcular funcion
        botCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
    }

    // Calcular el resultado  botón
    private void calcularResultado() {
        String expresion = campoTxt.getText(); // Obtener la expresión del campo de texto

        try {
            // Revisar si las expresiones son correctas
            int resultado = calculadora.evaluar(expresion);
            etiResultado.setText("Resultado: " + resultado);
        } catch (Exception ex) {
            etiResultado.setText("Error: Expresión inválida");
        }
    }

}
