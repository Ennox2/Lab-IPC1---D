package javaapplication5;

import java.util.Random;
import java.util.Scanner;

public class JavaApplication5 {
    //Ejemplo para impresion de tablero, lanzamiento de dado

    //Tablero
    public static String[][] tablero = new String[8][8];
    public static String[][] penalizaciones = new String[8][8];
    //Scanner global para numeros
    public static Scanner inputData = new Scanner(System.in);
    //Scanner global para letras
    public static Scanner inputString = new Scanner(System.in);
    //Jugador
    public static String simbolo = " @";
    //Posicion del jugador
    public static int position = 1;

    // NivelPenalizacion
    public static int nivelPenalizacion = -99;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("==============Menu Principal============");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Salir");
            System.out.println("=======================================");
            System.out.print("Elige una opcion: ");
            opcion = inputData.nextInt();
            menu_opciones(opcion);
        } while (opcion != 4);

    }

    public static void menu_opciones(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println(" Partida Iniciada");
                llenarMatriz();
                llenarPenalizaciones();

                elegirOpcion();

                break;
            case 2:
                System.out.println("Retomar juego");
                break;
            case 3:
                System.out.println("Cerrando el juego...");
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public static void llenarMatriz() {
        int contador = 1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = String.valueOf(contador);
                contador++; 
            }
        }

        
        for (int i = 0; i < penalizaciones.length; i++) {
            for (int j = 0; j < penalizaciones[i].length; j++) {
                penalizaciones[i][j] = "";
            }
        }

    }

    public static void llenarPenalizaciones() {
        // Se crea una instancia de la clase Random para generar números aleatorios.
        Random random = new Random();

        // Variables para almacenar la cantidad de penalizaciones y la posición aleatoria.
        int cantidadPenalizaciones;
        int posicionAleatoria;

        // Recorre las filas de la matriz penalizaciones.
        for (int i = 0; i < penalizaciones.length; i++) {

            // Se elige aleatoriamente la cantidad de penalizaciones para la fila actual (entre 2 y 4).
            // random.nextInt(3) genera un número random (aleatorio) entre 0 (incluido) y 3 (excluido) osea da los resultados 0, 1 o 2.
            // al numero random obtenido se le suma 2 lo que da un número de 2 a 4
            cantidadPenalizaciones = random.nextInt(3) + 2;

            // Se realiza un bucle mientras aún haya penalizaciones por agregar.
            while (cantidadPenalizaciones != 0) {

                // Se elige aleatoriamente una posición en la fila actual.
                while (true) {
                    posicionAleatoria = random.nextInt(penalizaciones[i].length);

                    // Si la posición no contiene ya una penalización (#), se rompe el bucle.
                    if (!penalizaciones[i][posicionAleatoria].contains("#")) {
                        break;
                    }
                }

                // Se agrega la penalización (precedida por #) en la posición aleatoria.
                penalizaciones[i][posicionAleatoria] = "#" + penalizaciones[i][posicionAleatoria];

                // Se reduce la cantidad de penalizaciones restantes.
                cantidadPenalizaciones--;
            }
        }

    }

    public static void imprimirInferiorDerecha() {
        System.out.println("=================================================");
        //Para imprimirlo en el otro sentido solo cambiar este booleano a true o false
        boolean bandera = false;
        String casilla;
        for (int i = tablero.length - 1; i >= 0; i--) {
            //Solo para mas estetica del tablero
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("+------");
            }

            System.out.println("+");
            //---------------------------------------

            for (int j = tablero.length - 1; j >= 0; j--) {

                if (bandera == true) {
                    casilla = penalizaciones[i][j] + tablero[i][j];
                    // ""+64 = ""64

                    System.out.printf("| %4s ", casilla);
                } else {
                    casilla = penalizaciones[i][(tablero.length - 1) - j] + tablero[i][(tablero.length - 1) - j];
                    //8-1= 7 
                    System.out.printf("| %4s ", casilla);
                }

                //System.out.print("| "+tablero[i][j] );
            }
            System.out.println("|");

            for (int j = tablero.length - 1; j >= 0; j--) {
                if (bandera == true) {
                    if (position == Integer.parseInt(tablero[i][j])) {
                        System.out.printf("| %4s ", simbolo);

                        if (penalizaciones[i][j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }

                    } else {
                        System.out.printf("| %4s ", " ");
                    }
                } else {

                    if (position == Integer.parseInt(tablero[i][(tablero.length - 1) - j])) {
                        System.out.printf("| %4s ", simbolo);
                        if (penalizaciones[i][(tablero.length - 1) - j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }
                    } else {
                        System.out.printf("| %4s ", " ");
                    }

                }
            }

            System.out.println("|");
            bandera = !bandera;

        }
        //Solo para mas estetica del tablero
        for (int j = 0; j < 8; j++) {

            System.out.print("+------");
        }
        System.out.println("+");
        //-----------------------------------------------
    }

    public static void elegirOpcion() {
        String elegir;
        Random random = new Random();
        int dado;
        do {

            if (position > 64) {
                System.out.println(" Ganaste el juego");
                break;
            }
            
            imprimirInferiorDerecha();

            niveles_Penalizacion();
            System.out.println(" Lanzar dado (d)");
            System.out.println(" Pausar Juego (p)");
            elegir = inputString.nextLine();

            if (elegir.equals("d")) {
                //1-6
                dado = random.nextInt(6) + 1;
                System.out.println("El dado cayo en: " + dado);
                position += dado; //position=position+dado;

            } else if (elegir.equals("p")) {
                System.out.println("Juego pausado");
            } else {
                System.out.println("Opcion no valida");
            }
        } while (!elegir.equals("p"));
    }

    public static void niveles_Penalizacion() {

        if (nivelPenalizacion == 1 || nivelPenalizacion == 2) {

            //Imlementar logica de penalizaciones
            
            System.out.println("Estoy en nivel facil de penalizacion");
        } else if (nivelPenalizacion == 3 || nivelPenalizacion == 4 || nivelPenalizacion == 5) {
            System.out.println("Estoy en nivel intermedio de penalizacion");
        } else if (nivelPenalizacion == 6 || nivelPenalizacion == 7 || nivelPenalizacion == 8) {
            System.out.println("Estoy en nivel dificil de penalizacion");
        }

        nivelPenalizacion = -99;
    }
    
}
