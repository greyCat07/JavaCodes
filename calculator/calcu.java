
//Import required package of java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//clss definition
class SimpleCalculator extends JFrame implements ActionListener {
    // Declare buttons
    JButton jb1, jb2, jb3, jb4;
    // Declare input text fields
    JTextField jt1, jt2;
    // declare labels
    JLabel lbl, lb2, lb3, lb4, lb5;

    // class constructor
    SimpleCalculator() {
        // define first label
        lbl = new JLabel("Simple Calculator:");
        lbl.setBounds(20, 20, 150, 30);
        add(lbl);
        // define second label
        lb2 = new JLabel("First No:");
        lb2.setBounds(20, 50, 150, 30);
        add(lb2);
        // define first input text box
        jt1 = new JTextField();
        jt1.setBounds(90, 50, 150, 30);
        add(jt1);
        // define first button
        jb1 = new JButton("+");
        jb1.setBounds(260, 50, 60, 30);
        add(jb1);
        jb1.addActionListener(this);
        // define second button
        jb2 = new JButton("*");
        jb2.setBounds(320, 50, 60, 30);
        add(jb2);
        jb2.addActionListener(this);
        // define the third level
        lb3 = new JLabel("Second No:");
        lb3.setBounds(20, 80, 150, 30);
        add(lb3);
        // define the second input text box
        jt2 = new JTextField();
        jt2.setBounds(90, 80, 150, 30);
        add(jt2);
        // define third button
        jb3 = new JButton("-");
        jb3.setBounds(260, 80, 60, 30);
        add(jb3);
        jb3.addActionListener(this);
        // define fourth button
        jb4 = new JButton("/");
        jb4.setBounds(320, 80, 60, 30);
        add(jb4);
        jb4.addActionListener(this);
        // define fifth label result
        lb5 = new JLabel("Result:");
        lb5.setBounds(20, 120, 150, 30);
        add(lb5);
        /// define fourth label for output
        lb4 = new JLabel();
        lb4.setBounds(90, 120, 150, 30);
        add(lb4);
        // set screen specification
        setLayout(null);
        setSize(700, 500);
        setVisible(true);
    }

    // method to define events/actions
    public void actionPerformed(ActionEvent e) {
        // input first number
        int a = Integer.parseInt(jt1.getText());
        // input second number
        int b = Integer.parseInt(jt2.getText());
        int c = 0;
        // action for + button or first button
        if (e.getSource().equals(jb1)) {
            c = a + b;
            lb4.setText(String.valueOf(c));
        }
        // action for multiplication button or second button
        if (e.getSource().equals(jb2)) {
            c = a * b;
            lb4.setText(String.valueOf(c));
        }
        // action for subtraction button or third button
        if (e.getSource().equals(jb3)) {
            c = a - b;
            lb4.setText(String.valueOf(c));
        }
        // action for division button or fourth button
        if (e.getSource().equals(jb4)) {
            c = a / b;
            lb4.setText(String.valueOf(c));
        }
    }

    // main method definition
    public static void main(String args[]) {
        SimpleCalculator obj = new SimpleCalculator();
    }
}