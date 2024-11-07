public class Nodo {
    public Nodo siguiente;
    public String nombre;

    //le hago que apunte a null para que reserve espacio memoria
    public Nodo(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }
}
