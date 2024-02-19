/*
 * La clase "gato" es una subclase de la clase "Animal". Extiende la funcionalidad de Animal
 * para incluir características específicas de un gato, como la colección de juguetes.
 */
package poo;

import java.util.ArrayList;

/**
 * Clase que representa a un gato, hereda de la clase Animal.
 */
public class gato extends Animal {
    // Atributo adicional para almacenar la colección de juguetes del gato
    private ArrayList<String> juguetes; 

    // Constructor que utiliza el constructor de la clase padre (Animal) y inicializa la colección de juguetes
    public gato(String nombre, int edad, String sonido) {
        super(nombre, edad, sonido); // Llama al constructor de la clase padre (Animal)
        this.juguetes = new ArrayList<>(); // Inicialización del ArrayList de juguetes
    }

    // Método getter para obtener la colección de juguetes del gato
    public ArrayList<String> getJuguetes() {
        return juguetes;
    }

    // Método específico del gato que simula el acto de arañar muebles
    public void ArañarMuebles() {
        System.out.println("El gato está arañando los muebles");
    }

    // Método para imprimir los juguetes del gato
    public void ImprimirJuguetes() {
        for (int i = 0; i < juguetes.size(); i++) {
            System.out.println(juguetes.get(i));
        }
    }
}
