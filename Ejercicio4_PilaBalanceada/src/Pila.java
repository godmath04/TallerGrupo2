import javax.swing.*;

class Nodo {
    public char dato;
    public Nodo siguiente;

    public Nodo(char dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class Pila {
    public Nodo cima;
    public int tamano;

    public Pila() {
        cima = null;
        tamano = 0;
    }

    public void apilar(char dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public char desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        char dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        return dato;
    }

    public void actualizarTextArea(JTextArea textArea) {
        StringBuilder contenido = new StringBuilder();
        Nodo actual = cima;
        while (actual != null) {
            contenido.append(actual.dato).append("\n");
            actual = actual.siguiente;
        }
        textArea.setText(contenido.toString());
    }
}