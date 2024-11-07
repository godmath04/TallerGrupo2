import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientesPrioridadGUI {
    private JTextField txtElemento;
    private JTextArea txtResultado;
    private JTextArea txtSalida;
    private JButton ingresoDePacienteButton;
    private JButton salidaDePacienteButton;
    private JPanel pGeneral;
    private JTextField txtPrioridad;

    public ColaPrioritaria c = new ColaPrioritaria();


    public PacientesPrioridadGUI() {
        //Implementar un try y catch
        salidaDePacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String msj = c.desencolar(txtSalida);
                    txtSalida.setText(msj);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al dar salida al paciente: " + ex.getMessage());
                }
            }
        });
        ingresoDePacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp = txtElemento.getText();
                String pri = txtPrioridad.getText();
                try{
                    String pacienteN = inp;
                    int prioridad = Integer.parseInt(pri);
                    c.encolar(pacienteN, prioridad, txtResultado);
                    txtElemento.setText("");
                    txtPrioridad.setText("");
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PacientesPrioridadGUI");
        frame.setContentPane(new PacientesPrioridadGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
