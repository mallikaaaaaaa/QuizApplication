import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton start, back;

    Rules(String name)    // parameterized constructor
    {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("HELLO   " + name + ",   ... WELCOME to Quiz-Quiz...");
        heading.setBounds(50, 30, 600, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        heading.setForeground(new Color(50, 20, 150));           //set heading color
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(70, 60, 600, 350);
        rules.setFont(new Font("Arial", Font.PLAIN, 20));
        rules.setForeground(Color.BLACK);           //set heading color
        add(rules);
        rules.setText(
                "<html>" +
                        "1. There are a total 10 questions. " + "<br><br>" +
                        "2. Each question carries one mark." + "<br><br>" +
                        "3. No negative marking for wrong answers. " + "<br><br>" +
                        "4. Questions are of Multiple Choice. " + "<br><br>" +
                        "5. Click on Next button to move next question." + "<br><br>" +
                        "6. Click on Submit Test button on completion of the quiz. " + "<br><br>" +

                        "<html>"
        );

        start = new JButton("START");      //create rules button
        start.setBounds(600, 500, 130, 40);
        start.setForeground(Color.WHITE);
        start.setBackground(new Color(30, 70, 180));
        start.setFont(new Font("Arial", Font.BOLD, 22));
        add(start);
        start.addActionListener(this);     //click event


        back = new JButton("<< BACK");      //create back button
        back.setBounds(50, 500, 130, 40);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(30, 70, 180));
        back.setFont(new Font("Arial", Font.BOLD, 22));
        back.addActionListener(this);      //click event
        add(back);


        setSize(800, 600);
        setLocation(300, 100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {                                     //afer clicking
        if(ae.getSource()==start)
        {
            setVisible(false);
           new Quiz(name);

        }
        else if(ae.getSource()==back)
        {
            setVisible(false);   //After clicking frame close
            new LoginPage();
        }

    }




        public static void main (String[] args)

        {
            new Rules("user");

        }
    }


