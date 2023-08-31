import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Score extends JFrame implements ActionListener

{
    JButton submit;

    Score(String name ,int score)
    {
        setBounds(0, 0, 800, 900);  //JfRAMR call by default//set location or size of frame
        getContentPane().setBackground(Color.WHITE);    //change frame color
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/score.jpg"));  //pick image
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 800, 300);   //set image
        add(image);

         JLabel heading = new JLabel("THANKYOU , " +name+ "...");  //create Lable for question no.
         heading.setBounds(40, 320, 350, 40);
         heading.setFont(new Font("Arial", Font.BOLD, 28));
         add(heading);


        JLabel Score = new JLabel("Your score is " + score);  //create Lable for display score
        Score.setBounds(250, 500, 350, 40);
        Score.setFont(new Font("Arial", Font.BOLD, 28));
        add(Score);

        submit = new JButton("PLAY AGAIN");
        submit.setBounds(250, 550, 200, 40);
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(30, 70, 180));
        submit.setFont(new Font("Arial", Font.BOLD, 22));
        submit.addActionListener(this);
        add(submit);


         setVisible(true);


    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            setVisible(false);
            new LoginPage();
        }


    }


    public static void main(String[] args)
    {
        new Score("user",0);
    }

}
