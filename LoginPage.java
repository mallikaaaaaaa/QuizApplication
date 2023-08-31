import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

  public class LoginPage extends JFrame implements ActionListener
{
    JButton rules,back;   //globally define
    JTextField tfname;

    LoginPage()        //create constructor
    {
        getContentPane().setBackground(Color.WHITE);   //frame color set
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/loginpage.jpg"));  //pick image
        JLabel image =new JLabel(i1);
        image.setBounds(20,0,600,700);
        add(image);

        JLabel heading =new JLabel("Quiz Time");
        heading.setBounds(800,100,500, 100);
        heading.setFont(new Font("Wide Latin",Font.BOLD,40));
        heading.setForeground(new Color(20,20,100));           //set heading color
        add(heading);


        JLabel name =new JLabel("Enter Your Name");
        name.setBounds(850,200,500, 50);
        name.setFont(new Font("Arial",Font.BOLD,30));
        name.setForeground(Color.BLACK);           //set heading color
        add(name);

         tfname = new JTextField();   ///TEXT FIELD
        tfname.setBounds(830,250,300, 30);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);

         rules =new JButton("RULES");      //create rules button
        rules.setBounds(870,290,130,40);
        rules.setForeground(Color.WHITE);
        rules.setBackground(new Color(30,70,180));
        rules.setFont(new Font("Arial",Font.BOLD,22));
        add(rules);
        rules.addActionListener(this);     //click event


        back =new JButton("<<BACK");      //create back button
        back.setBounds(800,500,130,40);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(30,70,180));
        back.setFont(new Font("Arial",Font.BOLD,22));
        back.addActionListener(this);      //click event
        add(back);


        setSize(1340,800);   //frame size
        //setLocation(100,100);   //frame location set
        setVisible(true);  //frame visible

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {                                     //afer clicking
        if(ae.getSource()==rules)
        {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);

        }
        else if(ae.getSource()==back)
        {
            setVisible(false);   //After clicking frame close
        }

    }
    public static void main(String[] args)
    {
        new LoginPage();//create obj of login class

    }
}
