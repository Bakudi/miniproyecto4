import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Actualizar extends JPanel implements ActionListener {

    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JTextField jTextField1;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

    public Actualizar() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("actualizar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);


        jComboBox2 = new JComboBox<>();
        for (Usuario usuario : App.geLinkedList()) {
            jComboBox2.addItem(usuario.getNombre());
        }
        jComboBox1 = new JComboBox<>();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Nombre", "Cédula","id"}));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel1.setText("Seleccione el atributo a editar");

        jButton1.setText("Atrás");
        jButton1.addActionListener(this);

        jButton2.setText("Actualizar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jLabel2.setText("Escriba el nuevo dato para el usuario");

        jLabel3.setText("Actualizar valor de usuario");

        jLabel4.setText("Seleccione el usuario");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jTextField1)
                                                                        .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(92, 92, 92))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(181, 181, 181)
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(55, 55, 55))
        );

        frame.add(this);
        frame.setVisible(true);
    }

    public void jButton2ActionPerformed(ActionEvent evt) {
        LinkedList<Usuario> listaEnlazada = App.geLinkedList();
        int selectedIndex2 = jComboBox2.getSelectedIndex();

        if (selectedIndex2 >= 0 && selectedIndex2 < listaEnlazada.size()) {
            Usuario usuario = listaEnlazada.get(selectedIndex2);
            String atributo = (String) jComboBox1.getSelectedItem();
            String nuevoValor = jTextField1.getText();

            switch (atributo) {
                case "Nombre":
                    usuario.setNombre(nuevoValor);
                    break;
                case "Cédula":
                    usuario.setCedula(Integer.parseInt(nuevoValor));
                    break;
                case "id":
                    usuario.setId(Integer.parseInt(nuevoValor));
                    break;
            }

            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
        }
    }

    public void jComboBox2ActionPerformed(ActionEvent evt) {
        int selectedIndex = jComboBox2.getSelectedIndex();
    
        if (selectedIndex >= 0) {
            Usuario selectedUser = App.geLinkedList().get(selectedIndex);
            jTextField1.setText(selectedUser.getNombre()); // Mostrar nombre en jTextField1, adaptar a otros campos si necesario
        }
    }
    

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            App ventana = new App();
            ventana.setVisible(true);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        }
    }


    public static void main(String[] args) throws Exception {
        LinkedList<String> listaEnlazada = new LinkedList<>();
        Actualizar ventana = new Actualizar();
        new Actualizar();
    }
}
