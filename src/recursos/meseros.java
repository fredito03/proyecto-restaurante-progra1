package recursos;
import java.util.ArrayList;
import java.util.List;

public class meseros {
    private static meseros instancia;
    private MeseroNode cabeza;
    private MeseroNode cola;
    private meseros() {}
    public static meseros obtenerInstancia() {
        if (instancia == null) {
            instancia = new meseros();
        }
        return instancia;
    }
    public void agregarMesero(String nombre, String turno) {
        MeseroNode nuevoMesero = new MeseroNode(nombre, turno);
        if (cabeza == null) {
            cabeza = nuevoMesero;
            cola = nuevoMesero;
        } else {
            nuevoMesero.anterior = cola;
            cola.siguiente = nuevoMesero;
            cola.siguiente_nombre = nuevoMesero.nombre;
            cola = nuevoMesero;
        }
    }
    public Object[] obtenerListaMeseros() {
        ArrayList<Object> lista = new ArrayList<>();
        MeseroNode current = cabeza;
        while (current != null) {
            Object[] mesero = {current.nombre, current.turno, current.siguiente_nombre};
            lista.add(mesero);
            current = current.siguiente;
        }
        return lista.toArray();
    }

    private class MeseroNode {
        private String nombre;
        private String turno;
        private MeseroNode anterior;
        private MeseroNode siguiente;
        private String siguiente_nombre;

        public MeseroNode(String nombre, String turno) {
            this.nombre = nombre;
            this.turno = turno;
            this.anterior = null;
            this.siguiente = null;
            this.siguiente_nombre = null;
        }
    }
}
