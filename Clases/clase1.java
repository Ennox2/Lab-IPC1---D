public class EjemploClase1 {

    public static void main(String[] args) {
        // Declaraciones de variables de tipos primitivos
        int edad = 25;                   // Tipo primitivo: entero
        double altura = 1.70;            // Tipo primitivo: doble (punto flotante)
        char inicial = 'J';              // Tipo primitivo: carácter
        boolean esEstudiante = true;      // Tipo primitivo: booleano

        // Declaraciones de variables de tipos no primitivos (clases)
        String nombreCompleto = "Juan Pérez";  // Tipo no primitivo: String (clase)
    
        // Imprimir los valores de las variables
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Inicial: " + inicial);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Nombre completo: " + nombreCompleto);


        // Casteo implícito (De manera automatica, sin perdida de datos)
        int entero = 10;
        double decimal = entero; // Conversión implícita de int a double

        System.out.println("Casteo implícito:");
        System.out.println("Entero: " + entero);
        System.out.println("Decimal: " + decimal);

        // Casteo explícito (Intervenccion explicita, necesario de especificarlo)
        double otroDecimal = 15.75;
        int otroEntero = (int) otroDecimal; // Conversión explícita de double a int

        System.out.println("\nCasteo explícito:");
        System.out.println("Otro Decimal: " + otroDecimal);
        System.out.println("Otro Entero: " + otroEntero);

        char caracter = 'A';
        int asciiValue = (int) caracter; // Conversión explícita de char a int, se obtiene el valor ASCII 

        float flotante = 3.14f;
        int enteroDesdeFlotante = (int) flotante; // Conversión explícita de float a int

        long largo = 1234567890123456789L;
        int enteroDesdeLargo = (int) largo; // Conversión explícita de long a int (pérdida de precisión)

        System.out.println("\nMás ejemplos de casteo explícito:");
        System.out.println("Caracter a ASCII: " + asciiValue);
        System.out.println("Flotante a Entero: " + enteroDesdeFlotante);
        System.out.println("Largo a Entero: " + enteroDesdeLargo);

        // Conversión de String a int
        String strEntero = "123";
        int entero = Integer.parseInt(strEntero);

        // Conversión de String a double
        String strDecimal = "3.14";
        double decimal = Double.parseDouble(strDecimal);

        // Conversión de String a boolean
        String strBooleano = "true";
        boolean booleano = Boolean.parseBoolean(strBooleano);

        // Imprimir resultados
        System.out.println("Conversión de String a int: " + entero);
        System.out.println("Conversión de String a double: " + decimal);
        System.out.println("Conversión de String a boolean: " + booleano);


        // Ejemplos de operadores
        int numero1 = 10;
        int numero2 = 5;
        int numero3 = 8;

        // Operadores lógicos (&&, ||, !)
        // Estructura de control IF 
        if (numero1 > numero2 && numero1 != numero3) {
            System.out.println("Condición 1: Verdadera");
        } else if (numero2 < numero3 || numero3 == 8) {
            System.out.println("Condición 2: Verdadera");
        } else {
            System.out.println("Ninguna condición es verdadera");
        }


        // Operadores aritméticos (+, -, *, /, %)
        int resultadoSuma = numero1 + numero2;
        int resultadoResta = numero1 - numero2;
        int resultadoMultiplicacion = numero1 * numero2;
        int resultadoDivision = numero1 / numero2;
        int resultadoModulo = numero1 % numero2;     //residuo de la division

        System.out.println("\nOperadores Aritméticos:");
        System.out.println("Suma: " + resultadoSuma);
        System.out.println("Resta: " + resultadoResta);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        System.out.println("División: " + resultadoDivision);
        System.out.println("Módulo: " + resultadoModulo);  



        //Inputs (entradas del usuario por consola)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("\nSeleccione la operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");

        int opcion = scanner.nextInt();

        // Estructura de control switch
        //Evalua los casos de la variable opcion
        switch (opcion) {
            case 1:
                System.out.println("Resultado de la Suma: " + (numero1 + numero2));
                break;
            case 2:
                System.out.println("Resultado de la Resta: " + (numero1 - numero2));
                break;
            case 3:
                System.out.println("Resultado de la Multiplicación: " + (numero1 * numero2));
                break;
            case 4:
                if (numero2 != 0) {
                    System.out.println("Resultado de la División: " + (numero1 / numero2));
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                break;
            default:            // Si ninguno de los casos anteriores se cumple
                System.out.println("Opción no válida");
        }

        // Ejemplo de ciclo for
        
        System.out.println("\nCiclo For:");

        /*   Estructura: 
             int i = 1   Declaracion e inicio de la variable
             i <= 5      Indica el valor donde se va a detener 
             i++         Aumentara la variable de 1 en 1   */
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteración " + i);
        }

        // Ejemplo de ciclo while
        System.out.println("\nCiclo While:");
        int j = 1;
        // Se realiza una iteracio mientras j menor o igual que 5
        while (j <= 5) {
            System.out.println("Iteración " + j);
            j++;  // es igual a     j = j + 1;
        }

        // Ejemplo de ciclo do-while
        // Funciona igual que el ciclo while pero primero ejecuta lo que esta dentro del do y despues verfica la condicion
        System.out.println("\nCiclo Do-While:");
        int k = 1;
        do {
            System.out.println("Iteración " + k);
            k++;
        } while (k <= 5);

    }
}