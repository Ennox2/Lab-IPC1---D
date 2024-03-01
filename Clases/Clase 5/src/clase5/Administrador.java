package clase5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class Administrador extends JFrame implements ActionListener {

    JButton btnRegistro, btn_salir, btn_eliminar;
    JTable table_estudiante;

    public Administrador() {

        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        // Crear tres paneles para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);
        JPanel pest3 = new JPanel(null);

        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.addTab("Estudiantes", pest1);
        tabbedPane.addTab("Pestaña 2", pest2);
        tabbedPane.addTab("Pestaña 3", pest3);

        //============================Vista Estudiantes==================================0
        //BTN1	
        btnRegistro = new JButton("Crear");
        btnRegistro.setBounds(800, 25, 180, 50);
        btnRegistro.setVisible(true);
        btnRegistro.setEnabled(true);
        btnRegistro.addActionListener(this);
        pest1.add(btnRegistro);
        
        //BTN2	
        btn_salir = new JButton("Salir");
        btn_salir.setBounds(1000, 25, 180, 50);
        btn_salir.setVisible(true);
        btn_salir.addActionListener(this);
        pest1.add(btn_salir);
        
        btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setBounds(1200, 25, 180, 50);
        btn_eliminar.setVisible(true);
        btn_eliminar.setEnabled(true);
        btn_eliminar.addActionListener(this);
        pest1.add(btn_eliminar);
        
        // Titulo
        // Crear un nuevo JLabel con el texto "Listado Oficial"
        JLabel lbl4 = new JLabel("Listado Oficial");
        // Estable_estudiantecer la posición y el tamaño del JLabel en el JPanel
        lbl4.setBounds(25, 25, 750, 50);
        // Estable_estudiantecer un borde alrededor del JLabel con un grosor de 2 píxeles y color negro
        lbl4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        // Estable_estudiantecer el color de fondo del JLabel como GRIS CLARO
        lbl4.setBackground(Color.LIGHT_GRAY);
        // Hacer que el JLabel sea opaco para que se pueda ver el color de fondo
        lbl4.setOpaque(true);
        // Alinear vertical y horizontalmente el texto del JLabel al centro
        lbl4.setVerticalAlignment(SwingConstants.CENTER);
        lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        // Estable_estudiantecer el tamaño de la fuente del JLabel, negrita y tamaño 24
        lbl4.setFont(new Font(lbl4.getFont().getFontName(), Font.BOLD, 24));
        // Hacer que el JLabel sea visible
        lbl4.setVisible(true);

        // Agregar el JLabel al JPanel llamado pest1
        pest1.add(lbl4);

        //Tabla
        // Crear un modelo de tabla y agregar datos de ejemplo
        String[] columnNames = {"Codigo", "Nombre", "Apellido", "Correo", "Genero", "Nota"};

        // Crear una instancia de JTable con los datos y nombres de columna
        table_estudiante = new JTable(Clase5.convertirDatosEstudiantes_tabla(), columnNames);

        /*// Centrar el contenido de las celdas de la tabla horizontalmente
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Aplicar el renderizador de celdas centrado a todas las columnas de la tabla
        for (int i = 0; i < table_estudiante.getColumnCount(); i++) {
            table_estudiante.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        //table_estudiante.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
         */
        // Crear un JScrollPane para la tabla (permite desplazarse por la tabla si es necesario)
        JScrollPane scrollPane = new JScrollPane(table_estudiante);
        scrollPane.setBounds(25, 80, 750, 570);

        // Agregar el JScrollPane (que contiene la tabla) al panel pest1
        pest1.add(scrollPane);
        
        
        
        // Gráficas
        // Estilos de graficas: http://www.java2s.com/Code/Java/Chart/CatalogChart.htm
        // Insertar nuestra data (valor, "categoria", "Leyenda de la columna")
        DefaultCategoryDataset datos = new DefaultCategoryDataset(); 
        ArrayList<Estudiante> lista_ordenada = Clase5.bubblesortNotaEstudiante(); 
        
        for(int i = 0; i < Math.min(3,lista_ordenada.size()) ; i++){
            datos.setValue(lista_ordenada.get(i).getNota(), "IPC 1", lista_ordenada.get(i).getNombre());
        }
        
        
        // Instancear gráfica de barras 3D
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "Top 3 mejores notas",
                "Estudiantes de IPC1",
                "Calificacion",
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                false        
        );
        
        // Creación de un ChartPanel el cual almacenará nuestro gráfico
        ChartPanel cPanel = new ChartPanel(grafico_barras); 
        // Habilitamos es scroll
        cPanel.setMouseWheelEnabled(true);
        // Asignamos la posición y las dimensiones de nuestro ChartPanel
        cPanel.setBounds(800, 100, 450, 300);
        // Agregamos a nuestra pestaña el ChartPanel con nuestro gráfico
        pest1.add(cPanel);
        
        
         // Ejemplo 2 (Gráfica de pie)
        DefaultPieDataset datos2 = new DefaultPieDataset(); 
        datos2.setValue("Java", 43.2);
        datos2.setValue("Visual Basic", 10.0);
        datos2.setValue("C++", 17.5);
        datos2.setValue("PHP", 32.5);
        datos2.setValue("Perl", 1.5);
        
         // Instancear gráfica de pie 3D
        JFreeChart grafico_pie = ChartFactory.createPieChart3D(
                "Lenguajes de programacion mas usados",
                datos2,
                true,
                true,
                false        
        );
        
        // Configuraciones adicionales a nuestro gráfico de pie
        PiePlot3D plot = (PiePlot3D) grafico_pie.getPlot(); 
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("No data to display");
        
        // Creación de un ChartPanel el cual almacenará nuestro gráfico
        ChartPanel cPanel2 = new ChartPanel(grafico_pie); 
        // Habilitamos es scroll
        cPanel2.setMouseWheelEnabled(true);
         // Asignamos la posición y las dimensiones de nuestro ChartPanel
        cPanel2.setBounds(800, 100, 450, 300);
        // Agregamos a nuestra pestaña 2 el ChartPanel con nuestro gráfic
        pest2.add(cPanel2);
        
        //============================Vista ==================================
         JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20)); // Establece el tipo de letra y el tamaño
        titleLabel.setBounds(200, 10, 100, 30); 
        pest2.add(titleLabel);
        
        //==================================================================================0
        // Agregar el JTabbedPane al contenido del JFrame
        getContentPane().add(tabbedPane);
        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible
        
        
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistro) {
            Register vtn_registro= new Register();
            this.dispose();
        }
        
        if (e.getSource() == btn_salir) {
            Login vtn_login = new Login();
            this.dispose();
        }
        
        if (e.getSource() == btn_eliminar) {
            
            //Metodo para eliminar un estudiante segun su codigo
            //Pedirle al usuario un codigo y parsearlo a int 
            //showInputDialog es el cuadro de texto
            int idInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario: ")); 
            
            //Recorrer todo el arraylist de los estudiantes 
            for(int i = 0; i < Clase5.listaEstudiantes.size() ; i++){
                
                //comparar si el elemento de la posicion actual es igual al que el usuario ingreso
                if (Clase5.listaEstudiantes.get(i).getCodigo()  == idInput){
                    //Eliminar de la lista (se le envia el indice del elemento que se quiere eliminar)
                    Clase5.listaEstudiantes.remove(i);
                }
            }
            // Cierra la ventana actual
            this.dispose();

            // Crea y muestra una nueva instancia de la ventana Administrador
            Administrador nuevaVentana = new Administrador();
            nuevaVentana.setVisible(true);
            
            
        }
    }

}
