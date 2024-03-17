package clase8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Clase8 {

    static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {

        Ventana vent = new Ventana();       
        
        //Lectura del archivo serializado si ya existe
        animals = (ArrayList<Animal>) LeerArchivo();
        if (animals != null) {
            for (Animal animal_x : animals) {
                System.out.println(animal_x.toString());
            }
        } else {
            System.out.println("Aun no existe un archivo serializado.");
        }
        
        
    }
    
    
    
    public static void serializacion(){        
        animals = new ArrayList<>(); // Inicializa la lista si es nula
        Animal animal1 = new Animal("Labrador", "Mike", 12);
        Animal animal2 = new Animal("Pastor aleman", "Max", 5);
        Animal animal3 = new Animal("Chihuahua", "Jinx", 9);
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        EscribirArchivo();
        
        EscribirArchivoCSV();
    
    }

    public static void lecturaCSV(JFrame frame) {
       
        JFileChooser fileChooser = new JFileChooser();
        
        //Filtro para que unicamente deje seleccionar archivos CSV 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);
        
        // Mostrar el diálogo de selección de archivos
        int result = fileChooser.showOpenDialog(frame);

        // Verificar si se seleccionó un archivo
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());

            // Leer el archivo CSV y mostrar su contenido como tabla
            try {
                Scanner scanner = new Scanner(selectedFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        System.out.print(part + "\t | \t");
                    }
                    System.out.println();
                }
                scanner.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void EscribirArchivo() {
        // Serialización de la lista
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Archivos/Animals.bin"));
            out.writeObject(animals);
            out.close();
            System.out.println("Lista de animales serializada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object LeerArchivo() {
        // Deserialización de la lista
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("./Archivos/Animals.bin"));
            ArrayList<Animal> animals = (ArrayList<Animal>) in.readObject();
            in.close();
            System.out.println("Lista de animales deserializada correctamente.");
            return animals;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void EscribirArchivoCSV() {
        String csvFile = "./Archivos/ListaAnimales.csv";
        try (PrintWriter writer = new PrintWriter(new File(csvFile))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Id,raza,nombre,edad\n");
            int id = 1;

            sb.append(id++).append(",");
            sb.append("Beagle").append(",");
            sb.append("Luky").append(",");
            sb.append(8).append("\n");

            sb.append(id++).append(",");
            sb.append("Caniche").append(",");
            sb.append("Dexter").append(",");
            sb.append(7).append("\n");

            sb.append(id++).append(",");
            sb.append("Dalmata").append(",");
            sb.append("Pepe").append(",");
            sb.append(3).append("\n");

            writer.write(sb.toString());
            System.out.println("Archivo CSV creado correctamente.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
