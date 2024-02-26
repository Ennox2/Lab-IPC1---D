package clase5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton loginButton;

    // Constructor de la clase Login
    public Login() {
        initComponents();
    }

    // Método para inicializar y configurar los componentes de la interfaz de usuario
    private void initComponents() {

        // Etiqueta con el título "Login"
        JLabel titleLabel = new JLabel("Welcome");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20)); // Establece el tipo de letra y el tamaño
        titleLabel.setBounds(200, 10, 100, 30); 
        this.add(titleLabel);

        // Carga la imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imgs/login.png"));
        // Ajusta el tamaño de la imagen (puedes cambiar los valores según tus necesidades)
        Image imageDimension = imageIcon.getImage().getScaledInstance(120, 110, Image.SCALE_SMOOTH);
        // Crea un nuevo ImageIcon con la imagen ajustada
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension);
        // Crea un JLabel para mostrar la imagen
        JLabel imageLabel = new JLabel(adjustedImageIcon);
        imageLabel.setBounds(190, 30, 120, 110); // (x, y, width, height) aqui el ancho y la altura deben ser las mismas que cuando redimensionamos
        this.add(imageLabel);

        
        // Etiqueta de texto para el nombre de usuario
        JLabel usernameLabel = new JLabel("Codigo:");
        usernameLabel.setBounds(70, 140, 80, 25);
        this.add(usernameLabel);

        // Campo de texto para el nombre de usuario
        usernameField = new JTextField();
        usernameField.setBounds(130, 140, 260, 25);
        this.add(usernameField);
        
        
        // Etiqueta para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 180, 80, 25);
        this.add(passwordLabel);

        //Campo de texto para la contraseña
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 180, 260, 25);
        this.add(passwordField);

        // Botón de inicio de sesión
        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(180, 220, 150, 25); //Ajuste de posición
        loginButton.setForeground(Color.WHITE); // Ajuste de color de letra
        loginButton.setBackground(new Color(5, 193, 31)); // Ajuste de color de boton, con color en RGB
        loginButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(loginButton); 
        
        
        // Botón de Registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 260, 150, 25); //Ajuste de posición
        registerButton.setBackground(new Color(214, 225, 50)); // Ajuste de color de boton, con color en RGB
        registerButton.addActionListener(this); // Agregamos un ActionListener al botón
        this.add(registerButton); 
        
        
        //Creación de la ventana iniciar sesión
        this.setTitle("Login");  // Título de la ventana
        this.setBounds(650, 400, 500, 350); // Posición y tamaño de la ventana (x, y, width, height)
        /*
        x: La posición horizontal de la esquina superior izquierda de la ventana en píxeles desde el borde izquierdo de la pantalla.
        y: La posición vertical de la esquina superior izquierda de la ventana en píxeles desde la parte superior de la pantalla.
        width: El ancho de la ventana en píxeles.
        height: La altura de la ventana en píxeles.
         */
        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setVisible(true); // Hace visible la ventana
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Obtenemos que evento es por medio del texto del botón
        if (e.getActionCommand().equals("Iniciar Sesión")) {
           
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            String pwd = new String(password);

            System.out.println("Usuario: " + username);
            System.out.println("Contraseña: " + pwd);
            if (username.equals("admin") && pwd.equals("admin")) {
                Administrador vtn_admin = new Administrador();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User and/or password incorrect.", "Error con el LOGIN", 0);
            }
        }
        System.out.println("===================================================");
            
        //Obtenemos el evento verificando si viene del boton "loginButton"
        /*if (e.getSource() == loginButton) {

            // Aquí puedes agregar la lógica de autenticación
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            System.out.println("Usuario: " + username);
            System.out.println("Contraseña: " + new String(password));

        }*/
        
        if (e.getActionCommand().equals("Registrarse")) {
            System.out.println("Abrir la ventana para el registro");
            
        }
    }

}
