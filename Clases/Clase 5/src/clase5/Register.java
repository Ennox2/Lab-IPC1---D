package clase5;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {
        
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField notaField;
    private JComboBox<String> genderComboBox;

    private JButton registerButton;
    
    public Register() {
         initComponents();
    }
    
    private void initComponents() {
        JLabel titleLabel = new JLabel("Registro");
        titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 100, 30);
        this.add(titleLabel);

        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(70, 50, 80, 25);
        this.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(130, 50, 260, 25);
        this.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(70, 90, 80, 25);
        this.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(130, 90, 260, 25);
        this.add(lastNameField);

        JLabel emailLabel = new JLabel("Correo:");
        emailLabel.setBounds(80, 130, 80, 25);
        this.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 130, 260, 25);
        this.add(emailField);

        JLabel genderLabel = new JLabel("Género:");
        genderLabel.setBounds(80, 170, 80, 25);
        this.add(genderLabel);

        String[] genders = {"Masculino", "Femenino"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(130, 170, 150, 25);
        this.add(genderComboBox);
        
        
        JLabel notaLabel = new JLabel("Nota:");
        notaLabel.setBounds(80, 200, 80, 25);
        this.add(notaLabel);

        notaField = new JTextField();
        notaField.setBounds(130, 200, 260, 25);
        this.add(notaField);

        registerButton = new JButton("Registrarse");
        registerButton.setBounds(180, 240, 150, 25);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(214, 225, 50));
        registerButton.addActionListener(this);
        this.add(registerButton);

        this.setTitle("Registro");
        this.setBounds(650, 400, 500, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Registrarse")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            int nota = Integer.parseInt(notaField.getText());
            String selectedGender = (String) genderComboBox.getSelectedItem();

            System.out.println("Nombre: " + firstName);
            System.out.println("Apellido: " + lastName);
            System.out.println("Correo: " + email);
            System.out.println("Género: " + selectedGender);
            System.out.println("Nota: " + nota);
            
            Clase5.Agegar_estudiante(Clase5.codigo, firstName, lastName, email, selectedGender, nota);
            Clase5.codigo++;
            this.dispose();
            
            Administrador vtn_admin= new Administrador();
        }
        
        
        
    }

    
}
