// Declaración del paquete "poo" que agrupa las clases relacionadas con la programación orientada a objetos
package poo;

// Definición de la clase Animal
public class Animal {
    // Atributos privados que almacenan información sobre el animal
    private String nombre; // Nombre del animal
    private int edad;      // Edad del animal
    private String sonido; // Sonido que hace el animal

    // Constructor con parámetros: Se utiliza para crear un objeto Animal con valores iniciales específicos
    public Animal(String nombre, int edad, String sonido) {
        this.nombre = nombre;
        this.edad = edad;
        this.sonido = sonido;
    }

    // Constructor por defecto: Se utiliza para crear un objeto Animal con valores predeterminados
    public Animal() {
        this.nombre = "";
        this.edad = 0;
        this.sonido = "";
    }

    // Métodos getter y setter para acceder y modificar los atributos (encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    // Método para imprimir el sonido que hace el animal
    public void hacerSonido() {
        System.out.println("El animal hace " + sonido);
    }
}
