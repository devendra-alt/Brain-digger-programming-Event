import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.crypto.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

class main_291 extends JFrame implements ActionListener {
    TextField tf1, tf2, tf3;
    Label l1, l2, l3;
    JRadioButton b1, b2, b3;
    JButton b;
    int passLength;
    public String password;

    main_291() {
        setTitle("Brain Digger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new Label("Merchant ID");
        l1.setBounds(50, 50, 100, 20);
        tf1 = new TextField();
        tf1.setBounds(160, 50, 150, 20);

        l2 = new Label("Merchant Name");
        l2.setBounds(50, 100, 100, 20);
        tf2 = new TextField();
        tf2.setBounds(160, 100, 150, 20);

        b1 = new JRadioButton("6 digits");
        b1.setBounds(50, 150, 100, 20);

        b2 = new JRadioButton("8 digits");
        b2.setBounds(50, 200, 100, 20);

        b3 = new JRadioButton("10 digits");
        b3.setBounds(50, 250, 100, 20);

        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        l3 = new Label("Password");
        l3.setBounds(50, 300, 100, 20);
        tf3 = new TextField();
        tf3.setBounds(160, 300, 150, 20);

        b = new JButton("Submit");
        b.setBounds(50, 350, 100, 20);

        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b1);
        add(b2);
        add(b3);
        add(l3);
        add(tf3);
        b.addActionListener(this);
        add(b);
        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (b1.isSelected()) {
            passLength = 6;
        } else if (b2.isSelected()) {
            passLength = 8;
        } else {
            passLength = 10;
        }
        String password = "";
        password = tf3.getText();
        if (password.length() != passLength) {
            System.out.println("invalid password");
        } else {
            enrc(password);
        }

    }

    void enrc(String password) {
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair pair = keyPairGen.generateKeyPair();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
            byte[] input = password.getBytes();

            cipher.update(input);
            byte[] cipherText = cipher.doFinal();
            cipherText[0] = '#';
            System.out.println("encrypted Password : " + new String(cipherText, "UTF8"));
            System.out.println("decrypted Password : " + password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new main_291();

    }
}