class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class Pila {
    private Nodo tope;

    public Pila() {
        tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }


    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }


    public int sacar() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía");
            return -1;  //  error si la pila está vacía
        }
        int valor = tope.valor;
        tope = tope.siguiente;  // Actualizamos el tope al siguiente nodo
        return valor;
    }
}
