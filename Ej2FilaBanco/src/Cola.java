import javax.swing.*;

public class Cola {
    //Nodo que actue como frente, final cola y tamano
    public Nodo frente;
    public Nodo finalCola;
    public int tamano;

    //Vacio porque es cola dinamica
    public Cola() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }
    //Comprobamos si esta vacia
    public boolean estaVacia(){
        return  frente == null;
    }
    //Mostramos la cola
    public void mostrarCola(JTextArea textArea){
        if (estaVacia()){
            textArea.setText("La cola esta vacia");

        }else{
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual!=null){
                colaStr.append(actual.nombre).append("\n");
                actual=actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    //Actualizaar pantalla
    public void actualizarCola(JTextArea textArea){
        mostrarCola(textArea);
    }
    //Metodo para encolar
    public void encolar(String nombre, JTextArea textArea) {
        Nodo nuevoCliente = new Nodo(nombre);
       if (estaVacia()){
           frente = nuevoCliente;
           finalCola = nuevoCliente;
       }else {
           finalCola.siguiente = nuevoCliente;
           finalCola = nuevoCliente;
       }
       tamano++;
       actualizarCola(textArea);
    }
    //Metodo para desencolar
    public String desencolar(JTextArea textArea){
        if (estaVacia()){
            JOptionPane.showMessageDialog(null, "La cola se encuentra vacia");
            return "";
        }
        String nombreSale = frente.nombre;
        frente = frente.siguiente;
        tamano--;

        //Debo verificar si verdaderamtne esta vacio
        if (frente == null){
            finalCola=null;
        }
        actualizarCola(textArea);

        return nombreSale + " ha sido atendido/a";
    }

}
