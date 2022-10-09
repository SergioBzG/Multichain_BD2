import multichain.command.MultichainException;
import org.json.simple.parser.ParseException;

import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, MultichainException {
        int opcion = 0;
        System.out.println("\n¡Bienvenido!");

        while (opcion != 4) {
            System.out.println("Elige una de las siguientes opciones");
            System.out.println(" 1. Registrar Autor");
            System.out.println(" 2. Subir Obra");
            System.out.println(" 3. Ver Obras");
            System.out.println(" 4. Salir");
            System.out.print("Indique su eleccion : ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1: RegistrarAutor();
                break;
                case 2: subirObra();
                break;
                case 3: verObras();
                break;
                case 4: System.out.println("¡Regresa Pronto :D!");
                break;
            }
        }
    }

    public static void RegistrarAutor() throws ParseException, MultichainException {
        System.out.print("Ingrese el nickname del Autor: ");
        String nickname = input.nextLine();

        System.out.print("Ingrese el nombre del Autor: ");
        String nombre = input.nextLine();

        System.out.print("Ingrese el año de nacimiento del Autor ");
        String agno_nacimiento = input.nextLine();

        System.out.print("Ingrese el correo del Autor ");
        String correo = input.nextLine();

        try{
            new Autor(nickname, nombre, agno_nacimiento, correo);
        }catch(MultichainException jose){
            System.out.println(jose.getReason());
        }
    }

    public static void subirObra() throws ParseException, MultichainException {
        System.out.print("Ingrese el nickname del Autor de la obra: ");
        String nickname = input.nextLine();

        System.out.print("Ingrese el nombre de la obra: ");
        String nombre = input.nextLine();

        System.out.print("Ingrese la fecha de creacion de la obra: ");
        String fecha_creacion = input.nextLine();

        System.out.print("Ingrese la obra utilizando un conversor de imagen: ");
        String obra = input.nextLine();

        try{
            new Obra(nickname, nombre, fecha_creacion, obra);
        }catch(MultichainException bolkar){
            System.out.println(bolkar.getReason());
        }

    }

    public static void verObras() throws MultichainException {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("Seleccione la opcion de filtrado de la obra");
            System.out.println("1. Por Autor");
            System.out.println("2. Por Obra");
            System.out.println("3. Por Autor y Obra");
            System.out.println("4. Salir");
            System.out.print("Eleccion : ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1: BuscarAutor();
                break;
                case 2: BuscarObra();
                break;
                case 3: BuscarAutorObra();
                break;
            }
        }
    }

    public static void BuscarAutor() throws MultichainException {
        System.out.print("Ingrese el nickname: ");
        String nickname = input.nextLine();
        Ver filtro = new Ver(nickname,"");
        filtro.BuscarAutor();
    }

    public static void BuscarObra() throws MultichainException {
        System.out.print("Ingrese el nombre: ");
        String nombre = input.nextLine();
        Ver filtro = new Ver("", nombre);
        filtro.BuscarObra();
    }

    public static void BuscarAutorObra() throws MultichainException {
        System.out.print("Ingrese el nickname: ");
        String nickname = input.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = input.nextLine();
        Ver filtro = new Ver(nickname, nombre);
        filtro.BuscarAutorObra();
    }
}





















