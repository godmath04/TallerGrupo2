public class Nodo {
    public String paciente;
    public Nodo siguiente;
    public int prioridad;

    public Nodo(String paciente, int prioridad){
        this.paciente = paciente;
        this.prioridad = prioridad;
        //Se apunta a null para que la lista sea enlazada
        this.siguiente = null;
    }
}
