package clase5;

import java.util.ArrayList;

public class Clase5 {

    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static int codigo = 1;

    public static void main(String[] args) {

        // Agregar estudiantes a la lista
        /*listaEstudiantes.add(new Estudiante(1, "Juan", "Pérez", "juan@email.com", "Masculino"));
        listaEstudiantes.add(new Estudiante(2, "María", "Gómez", "maria@email.com", "Femenino"));
        listaEstudiantes.add(new Estudiante(3, "Pedro", "López", "pedro@email.com", "Masculino"));
         */
        Login vtn_login = new Login();

    }

    public static Object[][] convertirDatosEstudiantes_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaEstudiantes.size();
        Object[][] arreglo = new Object[filas][6];

        for (int i = 0; i < filas; i++) {
            Estudiante estudiante = listaEstudiantes.get(i);
            arreglo[i][0] = estudiante.getCodigo();
            arreglo[i][1] = estudiante.getNombre();
            arreglo[i][2] = estudiante.getApellido();
            arreglo[i][3] = estudiante.getCorreo();
            arreglo[i][4] = estudiante.getGenero();
            arreglo[i][5] = estudiante.getNota();
        }

        return arreglo;
    }

    public static void Agegar_estudiante(int codigo, String nombre, String apellido, String correo, String genero, int nota) {
        Estudiante new_date = new Estudiante(codigo, nombre, apellido, correo, genero, nota);
        listaEstudiantes.add(new_date);
    }

    //Metodo de ordenamiento burbuja 
    public static ArrayList<Estudiante> bubblesortNotaEstudiante() {
        // Crear una copia de la lista para no modificar la lista original
        ArrayList<Estudiante> copiaLista = new ArrayList<>(listaEstudiantes);

        // Obtener la cantidad de elementos en la lista
        int n = copiaLista.size();

        // Variable para controlar si se ha realizado algún intercambio en la iteración
        boolean cambiado;

        // Ciclo principal del algoritmo de ordenamiento burbuja
        do {
            // Inicializar la variable 'cambiado' en falso al principio de cada iteración
            cambiado = false;

            // Iterar a través de la lista
            for (int i = 1; i < n; i++) {
                // Comparar elementos adyacentes en la lista por sus notas
                if (copiaLista.get(i - 1).getNota() < copiaLista.get(i).getNota()) {
                    // Intercambiar los elementos si el elemento anterior tiene una nota menor que el siguiente
                    Estudiante temp = copiaLista.get(i - 1);
                    copiaLista.set(i - 1, copiaLista.get(i));
                    copiaLista.set(i, temp);

                    // Marcar que se ha realizado un intercambio en esta iteración
                    cambiado = true;
                }
            }

            // Decrementar el valor de 'n' para reducir el rango de la lista en cada iteración
            n--;
        } while (cambiado); // Continuar el ciclo mientras se sigan realizando intercambios

        // Devolver la lista ordenada
        return copiaLista;
    }

}
