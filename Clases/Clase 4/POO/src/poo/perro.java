/*
 * La clase "perro" es otra subclase de la clase "Animal". Extiende la funcionalidad de Animal
 * para incluir características específicas de un perro, como la raza y la posesión de un collar.
 */
package poo;

/**
 * Clase que representa a un perro, hereda de la clase Animal.
 */
public class perro extends Animal {
    // Atributos adicionales específicos de un perro
    private String raza;        // Raza del perro
    private boolean tieneCollar; // Indica si el perro lleva collar o no

    // Constructor que utiliza el constructor de la clase padre (Animal) y asigna valores específicos del perro
    public perro(String raza, boolean tieneCollar, String nombre, int edad, String sonido) {
        super(nombre, edad, sonido); // Llama al constructor de la clase padre (Animal)
        this.raza = raza;
        this.tieneCollar = tieneCollar;
    }

    // Métodos getter y setter para acceder y modificar los atributos específicos del perro
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isTieneCollar() {
        return tieneCollar;
    }

    public void setTieneCollar(boolean tieneCollar) {
        this.tieneCollar = tieneCollar;
    }

    // Método específico del perro que simula el acto de perseguir la cola
    public void perseguirCola() {
        System.out.println("El perro persigue su cola.");
    }
}
