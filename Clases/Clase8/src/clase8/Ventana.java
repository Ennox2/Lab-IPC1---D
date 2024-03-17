package clase8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame implements ActionListener {
    
    private JButton button;
    private JButton button2;

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Lectura CSV");
        button2 = new JButton("Serializacion y Escribe CSV");

        button.setBounds(20, 20, 240, 20);
        button2.setBounds(20, 60, 240, 20);

        button.addActionListener(this);
        button2.addActionListener(this);

        add(button);
        add(button2);
        setLayout(null);
        setBounds(400, 200, 300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            Clase8.lecturaCSV(this);
        } else if (e.getSource() == button2) {
            Clase8.serializacion();
        }
    }
}
