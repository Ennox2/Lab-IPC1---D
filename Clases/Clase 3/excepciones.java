public class Excepciones {

    public static void main(String[] args) {
        System.out.println("---------------ArithmeticException---------------");
        //Se produce a dividir numeros por 0 
        try {
            double division = 21 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("Error: " + ae.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Null Pointer Exception---------------");
        // Hacer referencia a un elemeto nulo 
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException ne) {
            System.out.println("Error: " + ne.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Array Index Out Of Bounds Exception---------------");
        // Fuera de los limites del arreglo 
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Something went wrong: " + aioobe.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Class Cast Exception---------------");
        // Casteo de objetos que no son compatibles entre si
        try {
            Object obj = "Hola";
            Integer num = (Integer) obj;
        } catch (ClassCastException ce) {
            System.out.println("Error: " + ce.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Exception---------------");
        //Captura todos los tipos de errores
        try {
            double division1 = 21 / 0;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}