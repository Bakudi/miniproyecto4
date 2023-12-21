import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Buscar extends JFrame implements ActionListener {

  
    public Buscar() {
        initComponents();
    }
                        
    private void initComponents() {

        JPanel panel = new JPanel();
        setTitle("Hub");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Inserte el nombre de la persona a Buscar");

        jTextField1.setText("");

        jButton1.setText("Volver");
        jButton1.setToolTipText("");
        jButton1.addActionListener(this);

        jButton2.setText("Buscar");
        jButton2.setToolTipText("");
        jButton2.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1)))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        add(panel);
    }// </editor-fold>                        

                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){
            App  frame = new App();
            frame.setVisible(true);
            this.dispose();

        }else if (e.getSource() == jButton2) {
            String nombre = jTextField1.getText();

            LinkedList<Usuario> listaEnlazada = App.geLinkedList();
            Usuario usuarioEncontrado = null;

            // Buscar el usuario por nombre
            for (Usuario usuario : listaEnlazada) {
                if (usuario.getNombre().equals(nombre)) {
                    usuarioEncontrado = usuario;
                    break;
                }
            }

            if (usuarioEncontrado != null) {
                // Mostrar los datos del usuario en una ventana emergente
                JOptionPane.showMessageDialog(this, "Nombre: " + usuarioEncontrado.getNombre()
                        + "\nCédula: " + usuarioEncontrado.getCedula()
                        + "\nID: " + usuarioEncontrado.getId(), "Datos del Usuario", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Limpiar el campo después de buscar
            jTextField1.setText("");
        }
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Buscar gui = new Buscar();
                gui.setVisible(true);
            }
        });
    }
    }