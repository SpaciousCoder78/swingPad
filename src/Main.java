import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        app obj = new app();
    }
}

class app extends JFrame  {
    JTextArea t1;
    JButton b;
    public app(){
        t1 = new JTextArea(20,30);
        b= new JButton("Save File");
        add (t1);
        add (b);

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String body = t1.getText();
                filesaver fs = new filesaver(body);
            }
        };

        b.addActionListener(al);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class filesaver {
    String body;
    JFrame frame;

    public filesaver(String body) {
        this.body = body;
        frame = new JFrame();

        JLabel l2= new JLabel("Enter the file name: ");
        JTextField t3 = new JTextField(20);
        JButton b= new JButton("Save file");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filepath=t3.getText();
                try {
                    FileWriter fw = new FileWriter(filepath, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(body);
                    pw.flush();
                    pw.close();
                    JOptionPane.showMessageDialog(null,"Record Saved");

                }
                catch (Exception x){
                }
            }
        });
        frame.add(l2);
        frame.add(t3);
        frame.add(b);
    }
}

