import java.util.Scanner;

public class UIMain {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {

            System.out.println("\nBienvenido al Programa");
            System.out.println("¿Que deseas hacer?");
            System.out.println(" 1. Registrar Autor");
            System.out.println(" 2. Subir Obra");
            System.out.println(" 3. Ver Obras");
            System.out.println(" 4. Salir");
            System.out.print("Indique su eleccion : ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1: RegistrarAutor();break;
                case 2: subirObra(); break;
                case 3: verObras(); ; break;
                case 4: System.out.println("Gracias por utilizar Multichain") ; break;
            }

        } while (opcion != 4);
    }

    public static void RegistrarAutor() {

        System.out.println("Ingrese el nickname del autor ");
        System.out.print("Nickname: ");
        String nickname = input.nextLine();

        System.out.println("Ingrese el nombre del autor ");
        System.out.print("Nombre: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese el año nacimiento del autor ");
        System.out.print("Año: ");
        String agno_nacimiento = input.nextLine();

        System.out.println("Ingrese el correo autor ");
        System.out.print("Correo: ");
        String correo = input.nextLine();

        //Aqui va el codigo para ingresar el autor a la multichain Art


        System.out.println("Autor registrado con exito");

    }

    public static void subirObra() {

        System.out.println("Ingrese el nickname del autor al cual pertenece la obra ");
        System.out.print("Nickname del Autor: ");
        String autorNickname = input.nextLine();

        System.out.println("Ingrese el nombre de la obra ");
        System.out.print("Nombre de la obra: ");
        String nombreObra = input.nextLine();

        System.out.println("Ingrese fecha de creacion de la obra ");
        System.out.print("Fecha creacion: ");
        String fecha_creacion = input.nextLine();

        System.out.println("Ingrese la obra (Utilice image to base64 image converter) ");
        System.out.println("https://codebeautify.org/image-to-base64-converter");
        System.out.print("Texto imagen convertida: ");
        String obra = input.nextLine();

        //Aqui va el codigo para ingresar el autor a la multichain Art

        System.out.println("Obra registrada con exito");

    }

    public static void verObras() {

        int opcion;

        do {

            System.out.println("Seleccione por que condicion desea ver la obras");
            System.out.println(" 1. Por Autor");
            System.out.println(" 2. Por Nombre de la Obra");
            System.out.println(" 3. Por Autor y Nombre de la Obra");
            System.out.println(" 4. Volver al menú principal");
            System.out.print("Indique su eleccion : ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1: verObrasPorAutor();break;
                case 2: varObrasPorNombreObra(); break;
                case 3: verObrasPorAutorObra() ; break;
            }

        } while (opcion != 4);

    }

    public static void verObrasPorAutor() {

        System.out.println("Ingrese el nickname del autor  ");
        System.out.print("Nickname del Autor: ");
        String autorNickname = input.nextLine();

        //Aqui va el codigo para ver las obras por autor
    }

    public static void varObrasPorNombreObra() {

        System.out.println("Ingrese el nombre de la obra ");
        System.out.print("Nombre de la obra: ");
        String nombreObra = input.nextLine();

        //Aqui va el codigo para ver las obras por nombre de la obra

    }

    public static void verObrasPorAutorObra() {

        System.out.println("Ingrese el nickname del autor  ");
        System.out.print("Nickname del Autor: ");
        String autorNickname = input.nextLine();

        System.out.println("Ingrese el nombre de la obra ");
        System.out.print("Nombre de la obra: ");
        String nombreObra = input.nextLine();

        //Aqui va el codigo para ver las obras por autor y nombre de la obra
    }
}
