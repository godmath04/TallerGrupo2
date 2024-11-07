import javax.swing.*;

public class Balanceador {

    private Pila pila;
    private JTextArea textArea;

    public Balanceador(JTextArea textArea) {
        pila = new Pila();
        this.textArea = textArea;
    }

    public String verificarBalanceo(String expresion) {
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(' || caracter == '{' || caracter == '[') {
                pila.apilar(caracter);
                pila.actualizarTextArea(textArea);
            } else if (caracter == ')' || caracter == '}' || caracter == ']') {
                if (pila.estaVacia()) {
                    return "No balanceada";
                }
                char top = pila.desapilar();
                if (!coincidePar(top, caracter)) {
                    return "No balanceada";
                }
                pila.actualizarTextArea(textArea);
            }
        }
        return pila.estaVacia() ? "Balanceada" : "No balanceada";
    }

    private boolean coincidePar(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '{' && cierre == '}') ||
                (apertura == '[' && cierre == ']');
    }
}