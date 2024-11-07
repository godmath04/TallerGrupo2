import javax.swing.*;
public class ColaPrioritaria {
    public Nodo frente;

    public ColaPrioritaria(){
        this.frente = null;
    }
    //Verificar si esta vacia
    public boolean estaVacia(){
        return frente == null;
    }
    //Mostrar cola
    public void mostrarCola(JTextArea textArea){
        if (estaVacia()){
            textArea.setText("Cola vacia");
        }else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual!= null){
                colaStr.append("Paciente: ").append(actual.paciente)
                        .append(", Priodidad: ")
                        .append(actual.prioridad)
                        .append("\n");
                actual =actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }
    //Actualizar cola
    public void actualizarCola(JTextArea textArea){
        mostrarCola(textArea);
    }

    //El numero menor indica mayor prioridad
    public void encolar(String paciente, int prioridad, JTextArea textArea){
        //Se crea el nuevo nodo con el nombre del paciente y prioridad
        Nodo nuevoNodo = new Nodo(paciente, prioridad);
        //Si se requiere mayor prioridad (es decir tiene un numero menor)
        if (estaVacia() || prioridad < frente.prioridad){
            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        }else{
            Nodo actual = frente;
            while (actual.siguiente != null && actual.siguiente.prioridad <= prioridad){
                actual = actual.siguiente;
            }

            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        actualizarCola(textArea);
    }

    //Desencolar
    public String desencolar(JTextArea textArea){
        if (estaVacia()){
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
            return "";
        }else{
            String pacienteSale = frente.paciente;
            int prioridadSale = frente.prioridad;
            frente = frente.siguiente;
            actualizarCola(textArea);
            return   pacienteSale +" ha sido atendido/a. Prioridad: " +
                    prioridadSale +
                    "\nSiguiente: " + frente.paciente;
        }

    }


}
