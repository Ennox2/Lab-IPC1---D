package clase5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador extends JFrame implements ActionListener {

    JButton btnRegistro, btn_salir;
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
        String[] columnNames = {"Codigo", "Nombre", "Apellido", "Correo", "Genero"};

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
    }

}
