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
                String body= t1.getText();
                String filepath="textfile.txt";
                try {
                    FileWriter fw = new FileWriter(filepath, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(body);
                    pw.flush();
                    pw.close();
                }
                catch (Exception x){

                }
            }
        };


        b.addActionListener(al);



        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
