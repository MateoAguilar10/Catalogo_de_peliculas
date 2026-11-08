import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // == DATOS (ARRAYS PARA COMPARTIR POR TODO EL EQUIPO)==
        String[] titulos = new String[100];
        String[] directores = new String[100];
        String[] generos = new String[100];
        int[] anios = new int[100];
        double[] calificacion = new double[100];
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
            System.out.println("6. Mostrar información");
            System.out.println("7. Mostrar pelicula con mayor calificacion");
            System.out.println("8. Mostrar pelicula con menor calificacion");
            System.out.println("9. Salir");
            System.out.print("Seleccione alguna de las 9 opciones:  ");

            // VALIDACION (BRAYAN SANCHEZ): Funcion para que solo acepte numeros que sean
            // enteros
            while (!scanner.hasNextInt()) {
                System.out.print("Opcion no valida. Digite un numero del 1 al 9:  ");

                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Lo que hace es que limpia el salto de linea

            switch (opcion) {

                case 1:
                    if (cantidad < 100) {
                        scanner.nextLine(); // Limpia el buffer
                        System.out.print("Ingrese el titulo: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese el director: ");
                        String director = scanner.nextLine();
                        System.out.print("Ingrese el genero: ");
                        String genero = scanner.nextLine();
                        System.out.print("Ingrese el año: ");
                        int anio = scanner.nextInt();
                        System.out.print("Ingrese la calificacion: ");
                        double cf = scanner.nextDouble();
                        scanner.nextLine(); // limpia el buffer

                        titulos[cantidad] = titulo;
                        directores[cantidad] = director;
                        generos[cantidad] = genero;
                        anios[cantidad] = anio;
                        calificacion[cantidad] = cf;
                        cantidad++;

                        System.out.println("Pelicula agregada correctamente.");
                    } else {
                        System.out.println("El catalogo esta lleno.");
                    }
                    break;

                case 2:
                    // TODO Yohan Julio: mostrar peliculas
                    System.out.println("========================================");
                    System.out.println("Peliculas registradas");
                    System.out.println("========================================");
                    if (cantidad == 0) {
                        System.out.println("No hay peliculas registradas.");
                    } else {
                        for (int i = 0; i < cantidad; i++) {
                            System.out.println("Pelicula #" + (i + 1));
                            System.out.println("Titulo: " + titulos[i]);
                            System.out.println("Director: " + directores[i]);
                            System.out.println("Genero: " + generos[i]);
                            System.out.println("Año: " + anios[i]);
                            System.out.println("Calificacion: " + calificacion[i]);
                            System.out.println("----------------------------------------");
                        }
                    }

                    // si cantidad == 0 -> "No hay peliculas registradas"
                    break;

                case 3:
                    // TODO Mateo Aguilar: Buscar pelicula
                    System.out.println("Ingrese el nombre de la pelicula");
                    String titulo = scanner.nextLine();

                    boolean encontrada = false;
                    for (int i = 0; i < cantidad; i++) {
                        if (titulos[i].equalsIgnoreCase(titulo.trim())) {
                            System.out.println("La pelicula se encuentra en el catalogo");
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        System.out.println("La pelicula no se encontró");
                    }
                    break;

                case 4:
                    // TODO Mateo Aguilar: Modificar pelicula
                    System.out.println("Ingrese el nombre de la pelicula que quiere modificar");
                    String tituloModificar = scanner.nextLine();
                    boolean encontrarModificar = false;
                    for (int i =0; i< cantidad; i++) {
                        if (titulos[i].equalsIgnoreCase(tituloModificar.trim())){
                            System.out.println("Ingrese el nombre de la nueva pelicula");
                            String nuevoTitulo = scanner.nextLine();
                            titulos[i] = nuevoTitulo;
                            System.out.println("Ingrese el nombre del nuevo director");
                            String nuevoDirector = scanner.nextLine();
                            directores[i] = nuevoDirector;
                            System.out.println("Ingrese el nuevo genero");
                            String nuevoGenero = scanner.nextLine();
                            generos[i] = nuevoGenero;
                            System.out.println("Ingrese el nuevo año");
                            int nuevoAnio = scanner.nextInt();
                            anios[i] = nuevoAnio;
                            System.out.println("Ingrese la nueva calificacion");
                            double nuevaCalificacion = scanner.nextDouble();
                            calificacion[i] = nuevaCalificacion;
                            encontrarModificar = true;
                            System.out.println("Pelicula modificada con exito.");
                            break;
                        }
                    }
                    if (!encontrarModificar) {
                        System.out.println("La pelicula no se encontro.");
                    }

                    break;

                case 5:
                    // ===ELIMINAR PELICULA (BRAYAN SANCHEZ)===
                    if (cantidad == 0) {
                        System.out.println(" No hay peliculas registradas.");
                        break;
                    }

                    System.out.println("Ingrese el titulo de la pelicula que quiere eliminar:  ");
                    String tituloEliminar = scanner.nextLine();

                    // Busca la posicion de la pelicula
                    int posicion = -1;
                    for (int i = 0; i < cantidad; i++) {
                        if (titulos[i].equalsIgnoreCase(tituloEliminar.trim())) {
                            posicion = i;
                            break;
                        }
                    }
                    if (posicion == -1) {
                        System.out.println(" No se encontro la pelicula.");
                        break;
                    }

                    // CONFIRMACION A LA HORA DE ELIMINAR UNA PELICULA
                    int confirmacion = 0;
                    do {
                        System.out.println("¿Esta segur@ al querer eliminar la pelicula?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        System.out.println("Seleccione: ");

                        while (!scanner.hasNextInt()) {
                            System.out.println("ENTRADA INVALIDA. Escriba 1 o 2: ");
                            scanner.next();
                        }
                        confirmacion = scanner.nextInt();
                        scanner.nextLine();

                        if (confirmacion != 1 && confirmacion != 2) {
                            System.out.println("Opcion invalida.");

                        }

                    } while (confirmacion != 1 && confirmacion != 2);

                    if (confirmacion == 1) {
                        // mueve todas las peliculas siguientes a una posicion a la izquierda
                        for (int i = posicion; i < cantidad - 1; i++) {
                            titulos[i] = titulos[i + 1];
                            directores[i] = directores[i + 1];
                            generos[i] = generos[i + 1];
                            anios[i] = anios[i + 1];
                            calificacion[i] = calificacion[i + 1];
                        }
                        // Limpia la ultima posicion y baja el contador
                        cantidad--;
                        titulos[cantidad] = null;
                        directores[cantidad] = null;
                        generos[cantidad] = null;
                        anios[cantidad] = 0;
                        calificacion[cantidad] = 0;

                        System.out.println("Pelicula eliminada correctamente...");
                    } else {
                        System.out.println("OPERACION CANCELADA.");
                    }
                    break;

                case 6:
                    // ==========INFORMACION==========
                    System.out.println("================================");
                    System.out.println("            INFORMACIÓN");
                    System.out.println("================================");
                    System.out.println("Nombre: MECHIAVELLIAN INDEX");
                    System.out.println("Lenguaje: Java");
                    System.out.println("Tipo: Programa en consola");
                    System.out.println("Proyecto realizado por:");
                    System.out.println("Proyecto realizado por:.");
                    System.out.println("Los tres mosqueteros.");
                    System.out.println("INTEGRANTES:");
                    System.out.println("Yohan Julio Tobón");
                    System.out.println("Brayan Alejandro Sanchez Orozco");
                    System.out.println("Mateo Aguilar Ramirez");
                    break;

                case 7:
                    // PELICULA CON MAYOR CALIFICACION
                    System.out.println("========================================");
                    System.out.println("Pelicula con mayor calificacion");
                    System.out.println("========================================");
                    if (cantidad == 0) {
                        System.out.println("No hay peliculas registradas.");
                    } else {
                        // Primero busca1 la calificacion mas alta
                        double mayorCalif = calificacion[0];
                        for (int i = 1; i < cantidad; i++) {
                            if (calificacion[i] > mayorCalif) {
                                mayorCalif = calificacion[i];
                            }
                        }
                        // Luego muestra las que tengan esa calificacion (por si hay bastantes)
                        for (int i = 0; i < cantidad; i++) {
                            if (calificacion[i] == mayorCalif) {
                                System.out.println("Titulo: " + titulos[i]);
                                System.out.println("Director: " + directores[i]);
                                System.out.println("Genero: " + generos[i]);
                                System.out.println("Año: " + anios[i]);
                                System.out.println("Calificacion: " + calificacion[i]);
                                System.out.println("----------------------------------------");
                            }
                        }
                    }
                    break;

                case 8:
                    // PELICULA CON MENOR CALIFICACION
                    System.out.println("========================================");
                    System.out.println("Pelicula con menor calificacion");
                    System.out.println("========================================");
                    if (cantidad == 0) {
                        System.out.println("No hay peliculas registradas.");
                    } else {
                        // Primero busca la calificacion mas baja
                        double menorCalif = calificacion[0];
                        for (int i = 1; i < cantidad; i++) {
                            if (calificacion[i] < menorCalif) {
                                menorCalif = calificacion[i];
                            }
                        }
                        // Luego muestra todas las que tengan la misma calificacion (por si hay muchas)
                        for (int i = 0; i < cantidad; i++) {
                            if (calificacion[i] == menorCalif) {
                                System.out.println("Titulo: " + titulos[i]);
                                System.out.println("Director: " + directores[i]);
                                System.out.println("Genero: " + generos[i]);
                                System.out.println("Año: " + anios[i]);
                                System.out.println("Calificacion: " + calificacion[i]);
                                System.out.println("----------------------------------------");
                            }
                        }
                    }
                    break;

                case 9:
                    System.out.println("!!!FUE UN GUSTO SABER QUE TE GUSTO NUESTRO CATALOGO...¡¡¡¡");
                    break;

                default:
                    System.out.println("Opcion invalida. Elija un numero del 1 a 9.");

            }

            System.out.println();

        } while (opcion != 9);

        scanner.close();
    }
}