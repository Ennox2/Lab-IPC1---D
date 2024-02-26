package clase5;

import java.util.ArrayList;

public class Clase5 {

    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static int codigo=1;
    public static void main(String[] args) {
        
        // Agregar estudiantes a la lista
        /*listaEstudiantes.add(new Estudiante(1, "Juan", "Pérez", "juan@email.com", "Masculino"));
        listaEstudiantes.add(new Estudiante(2, "María", "Gómez", "maria@email.com", "Femenino"));
        listaEstudiantes.add(new Estudiante(3, "Pedro", "López", "pedro@email.com", "Masculino"));
        */
        Login vtn_login= new Login();

    }

    public static Object[][] convertirDatosEstudiantes_tabla() {
        // Crear el arreglo bidimensional de objetos
        int filas = listaEstudiantes.size();
        Object[][] arreglo = new Object[filas][5];

        for (int i = 0; i < filas; i++) {
            Estudiante estudiante = listaEstudiantes.get(i);
            arreglo[i][0] = estudiante.getCodigo();
            arreglo[i][1] = estudiante.getNombre();
            arreglo[i][2] = estudiante.getApellido();
            arreglo[i][3] = estudiante.getCorreo();
            arreglo[i][4] = estudiante.getGenero();
        }

        return arreglo;
    }
    
    public static void Agegar_estudiante(int codigo, String nombre, String apellido, String correo, String genero){
        Estudiante new_date= new Estudiante(codigo, nombre, apellido,correo, genero);
        listaEstudiantes.add(new_date);
    }

}
