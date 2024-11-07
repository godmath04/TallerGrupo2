import javax.swing.*;

public class Pila {
    public Nodo cima;
    public int tamano;

    // Dado que es una pila dinámica el constructor es vacio
    public Pila() {
        cima = null;
        tamano = 0;
    }

    //Metodo para ver si esta vacia
    public boolean estaVacia(){
        return cima == null;
    }

    //Metodo para apilar con el dato y el area que se visualiza
    public void apilar(int dato, JTextArea textArea){
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
        actualizarTextArea( textArea);
    }

    //Metodo para invertir pila
    public void invertirPila(JTextArea textArea){
        Pila pilaAuxiliar = new Pila();
        Nodo actual = cima;

        //Recorremos la pila original  y la almacenamos en la auxiliar para luego darle la vuelta
        while (actual != null){
            pilaAuxiliar.apilar(actual.dato, textArea);
            actual=actual.siguiente;
        }
        // Crear el string de la pila invertida
        StringBuilder pilaStrInvertida = new StringBuilder();
        while (!pilaAuxiliar.estaVacia()) {
            // Desapilar de la auxiliar para invertir el orden
            pilaStrInvertida.append(pilaAuxiliar.desapilar(textArea)).append("\n");
        }
        // Mostrar la pila invertida en el nuevo JTextArea
        textArea.setText(pilaStrInvertida.toString());
    }

    // Metodo para desapilar
    public int desapilar(JTextArea textArea){
        if (estaVacia()){
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
            return -1;
        }
        //Se obtiene el valor de la cima
        int dato = cima.dato;

        //La cima se actualiza para que apunte al siguiente y se elimina
        cima = cima.siguiente;
        tamano--;
        actualizarTextArea(textArea);
        return dato;
    }

    //Metodos mostrar pila
    public void mostrarPila(JTextArea textArea){
        if(estaVacia()){
            textArea.setText(("La pila esta vacia"));
        }else{
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while (actual != null){
                pilaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(pilaStr.toString());
        }
    }

    //Actualizar el text area
    public void actualizarTextArea(JTextArea textArea){
        mostrarPila(textArea);
    }
}
