
package poo;

import java.util.ArrayList;


public class POO {

 
    public static void main(String[] args) {
        
        
        // Definición de la clase "perro" con atributos y métodos
        // La clase se convierte como un "tipo de dato" por ejemplo un arraylist podria almacenar este tipo de dato
        // Datos que recibe la clase: String raza, boolean tieneCollar, String nombre, int edad, String sonido
        
        perro wiskas = new perro("Labrador", true, "Wiskas", 4, "guau");

        // Definición de la clase "gato" con atributos y métodos
        // String nombre, int edad, String sonido
        gato minimo = new gato("Minino", 13, "miau");

        // Imprimir acciones para el perro "wiskas"
        System.out.println("Acciones para " + wiskas.getNombre());
        wiskas.hacerSonido(); // Método que imprime el sonido del perro
        wiskas.perseguirCola(); // Método que simula que el perro persigue su cola

        // Verificar si el ArrayList de juguetes del gato "minimo" está vacío
        if(minimo.getJuguetes().isEmpty()){
            System.out.println("El ArrayList de juguetes esta vacio");
        }

        // Agregar juguetes al ArrayList de juguetes del gato "minimo"
        minimo.getJuguetes().add("pelota"); 
        minimo.getJuguetes().add("raton"); 

        // Imprimir los juguetes del gato "minimo"
        minimo.ImprimirJuguetes();
        
        
        
        //Ejemplo principales funciones de un ArrayList (Para almacenar objetos) 
        //Se podria realizar de la misma manera con doctores
        System.out.println("-----------------");
        System.out.println("Ejemplo de Arraylist");
        // Creación de un ArrayList para almacenar objetos de la clase "perro"
        ArrayList<perro> perros = new ArrayList<>(); 

        // Agregando el perro "wiskas" al ArrayList
        perros.add(wiskas);

        // Accediendo al primer perro en el ArrayList
        perro primerPerro = perros.get(0);
        System.out.println(primerPerro.getNombre());

        // Verificando si el ArrayList de perros contiene al perro "wiskas"
        if (perros.contains(wiskas)) {
            System.out.println("El ArrayList de perros contiene a Wiskas");
        }

        // Obteniendo la cantidad de perros en el ArrayList
        int cantidadDePerros = perros.size();
        System.out.println("Cantidad de perros en el ArrayList: " + cantidadDePerros);

        // Removiendo el perro "wiskas" del ArrayList
        perros.remove(wiskas);

        // Verificando si el ArrayList de perros está vacío después de remover
        if (perros.isEmpty()) {
            System.out.println("El ArrayList de perros esta vacio despues de remover a Wiskas");
        }

        // Limpiando completamente el ArrayList de perros
        perros.clear();
        System.out.println("El ArrayList de perros ha sido limpiado");

        
        perros.add(new perro("Golden Retriever", false, "Max", 3, "woof"));
        perro max = new perro("Bulldog", true, "Rocky", 5, "bark");
        perros.add(max);
        
        // Iterando a través de todos los perros en el ArrayList
        System.out.println("Listado de perros en el ArrayList:");
        for (perro p : perros) {
            System.out.println("Nombre: " + p.getNombre() + ", Raza: " + p.getRaza());
        }
    }
    
}
