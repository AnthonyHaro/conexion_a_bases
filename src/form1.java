import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    private JButton conectarALaBaseButton;
    private JButton button1;
    public JPanel panel1;
    private JLabel mensajetxt;
    private JTextField nombretextField;
    private JTextField cedulatextField;
    private JTextField cali1textField;
    private JTextField cali2textfield;
    private JLabel nombre;
    private JLabel cedula;
    private JLabel cali1;
    private JLabel cali2;
    private JButton insertarButton;
    private JButton borrarCamposButton;

    public form1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexionBDD miconexion = new conexionBDD();
                miconexion.conexionLocal("jdbc:mysql://localhost/estudiante", "root", "");
                mensajetxt.setText(miconexion.getMensaje());
            }
        });
        borrarCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombretextField.setText("");
                cedulatextField.setText("");
                cali1textField.setText("");
                cali2textfield.setText("");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarDatos insertardatos=new insertarDatos();
                String nombre=nombretextField.getText();
                String cedula=cedulatextField.getText();
                insertardatos.ingresoDatos(nombre,cedula,Integer.parseInt(cali1textField.getText()),Integer.parseInt(cali2textfield.getText()));
            }
        });
    }
}