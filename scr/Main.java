import java.util.Scanner;

public class main{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //== DATOS (ARRAYS PARA COMPARTIR POR TODO EL EQUIPO)==
        String[] titulos = new String[100];
        String[] directores = new String[100];
        String[] generos = new String[100];
        int[] anios = new int[100];
        double[] = new double[100];
        int cantidad = 0; // MIRA CUANTAS PELICULAS ESTAN HAY O ESTAN REGISTRADAS :)

        int opcion = 0;

        // CICLO PRINCIPAL (BRAYAN SANCHEZ)
        do {
            System.out.println("=============================");
            System.out.println("   CATÁLOGO DE PELICULAS");
            System.out.println("=============================");
            System.out.println("1. Agregar una pelicula");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Buscar pelicula");
            System.out.println("4. Modificar una pelicula");
            System.out.println("5. Eliminar una pelicula");
            System.out.println("6. MOstrar información");
            System.out.println("7. Salir");
            System.out.print("Seleccione alguna de las 7 opciones:  ");
            
            //VALIDACION (BRAYAN SANCHEZ): Funcion para que solo acepte numeros que sean enteros
            while (!scanner.hasNextInt()) {
                System.out.print("Opcion no valida. Digite un numero del 1 al 7:  ");

                scanner.next()
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Lo que hace es que limpia el salto de linea

        }
    }
}