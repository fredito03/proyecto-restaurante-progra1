import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);

    public void menu(){
        int opcion;
        System.out.println("---- Menu ----");
        System.out.println("Caldo de Gallina");
        System.out.println("Chilaquiles Guatemaltecos" );
        System.out.println("Pollo Rostizado");
        System.out.println("---- Opciones ----");
        System.out.println("1. Ingresos");
        System.out.println("2. Estado");
        System.out.println("3. Recursos");
        opcion = input.nextInt();
        switch (opcion) {
           case 1:
                ingresos();
                break;
            case 2:
               estado();
                break;
           case 3:
                recursos();
        }
    }

    public void ingresos(){
        System.out.println("Ingresos");

    }

    public void estado(){
        System.out.println("Estoy en Estado");
    }

    public void recursos(){
        System.out.println("Estoy en recursos");
    }

    public static void main(String[] args) {
        Main instancia = new Main();
        instancia.menu();
    }
}