import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        app obj = new app();
    }
}

class app   {

    public app(){
        JFrame x = new JFrame("swingPad");
        JTextArea textArea = new JTextArea(45,150);

// Add the text area to the center of the layout
        x.add(textArea, BorderLayout.CENTER);

        ActionListener ax = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app newobj = new app();
            }
        };

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String body = textArea.getText();
                filesaver fs = new filesaver(body);
            }
        };



        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu info = new JMenu("Info");
        menuBar.add(fileMenu);

        JMenuItem saveMenuItem = new JMenuItem("Save File");
        JMenuItem newMenuItem = new JMenuItem("New File");
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        x.setJMenuBar(menuBar);
        saveMenuItem.addActionListener(al);
        newMenuItem.addActionListener(ax);
        x.setLayout(new FlowLayout());

// Create a text area


        x.setVisible(true);
        x.setSize(1280,720);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class filesaver {
    //String body;
    JFrame frame;

    public filesaver(String body) {
        //this.body = body;
        frame = new JFrame("swingPad");

        JLabel l2= new JLabel("Enter the file name: ");
        JTextField t3 = new JTextField(20);
        JButton b= new JButton("Save file");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setSize(400,400);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filepath=t3.getText();
                try (FileOutputStream fos = new FileOutputStream(filepath)) {
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

        frame.pack();
        frame.add(l2);
        frame.add(t3);
        frame.add(b);
    }
}

