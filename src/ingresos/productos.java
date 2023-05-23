package ingresos;
import java.util.ArrayList;
public class productos {
    private static productos instance;
    private ColaProductos colaProductos;
    private PilaProductos pilaProductos;
    private productos() {
        colaProductos = new ColaProductos();
        pilaProductos = new PilaProductos();
    }
    public static productos obtenerInstancia() {
        if (instance == null) {
            instance = new productos();
        }
        return instance;
    }
    public void agregarProducto(int id, String nombre) {
        colaProductos.agregar(id, nombre);
        pilaProductos.agregar(id, nombre);
    }
    public Object[] obtenerProductosDeCola() {
        try{
            return colaProductos.obtenerProductos();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public Object[] obtenerProductosDePila() {
        try{
            return pilaProductos.obtenerProductos();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}

class ColaProductos {
    private static class Nodo {
        private int id;
        private String nombre;
        private Nodo siguiente;

        public Nodo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    private Nodo primerNodo;
    private Nodo ultimoNodo;

    public ColaProductos() {
        primerNodo = null;
        ultimoNodo = null;
    }

    public void agregar(int id, String nombre) {
        Nodo nuevoNodo = new Nodo(id, nombre);
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            ultimoNodo.siguiente = nuevoNodo;
            ultimoNodo = nuevoNodo;
        }
    }

    public Object[] obtenerProductos() {
        ArrayList<Object> productos = new ArrayList<>();
        Nodo actual = primerNodo;
        while (actual != null) {
            Object[] producto = {actual.id, actual.nombre};
            productos.add(producto);
            actual = actual.siguiente;
        }
        return productos.toArray();
    }

}

class PilaProductos {
    private static class Nodo {
        private int id;
        private String nombre;
        private Nodo siguiente;

        public Nodo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    private Nodo tope;

    public PilaProductos() {
        tope = null;
    }

    public void agregar(int id, String nombre) {
        Nodo nuevoNodo = new Nodo(id, nombre);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public Object[] obtenerProductos() {
        ArrayList<Object> productos = new ArrayList<>();
        Nodo actual = tope;
        while (actual != null) {
            Object[] producto = {actual.id, actual.nombre};
            productos.add(producto);
            actual = actual.siguiente;
        }
        return productos.toArray();
    }

}