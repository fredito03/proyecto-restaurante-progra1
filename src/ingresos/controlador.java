package ingresos;

public class controlador {
    Cola cola = new Cola();
    Pila pila = new Pila();
    public void agregaMenu(int menu){
        cola.agregar(menu);
        pila.insertar(menu);
        System.out.println("Cola:");
        cola.imprimirCola();
        System.out.println("Pila:");
        pila.imprimir();
    }

}

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Pila {
    Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public void imprimir() {
        Nodo actual = tope;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

class Cola {
    private Nodo primerNodo;
    private Nodo ultimoNodo;

    public void agregar(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);

        if (estaVacia()) {
            primerNodo = nuevoNodo;
        } else {
            ultimoNodo.siguiente = nuevoNodo;
        }

        ultimoNodo = nuevoNodo;
    }

    public int imprimir() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }

        int elemento = primerNodo.elemento;
        primerNodo = primerNodo.siguiente;

        if (primerNodo == null) {
            ultimoNodo = null;
        }

        return elemento;
    }

    // create a method to print the elements of the queue
    public void imprimirCola() {
        Nodo temp = primerNodo;
        while (temp != null) {
            System.out.println(temp.elemento);
            temp = temp.siguiente;
        }
    }

    public boolean estaVacia() {
        return primerNodo == null;
    }

    private static class Nodo {
        private final int elemento;
        private Nodo siguiente;

        public Nodo(int elemento) {
            this.elemento = elemento;
        }
    }
}
