import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JRadioButton;



public class Quiz extends JFrame implements ActionListener {
    String question[][] = new String[10][5];   //for store the questions
    String answer[][] = new String[10][2];
    String useranswer[][] = new String[10][1];

    JLabel qno;
    JLabel image;
    JLabel ques;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    JButton back, submit, next;
    public static int Timer = 15;   //timer time
    public static int ans_given = 0;   //check answer tick by user
    public static int count = 0;  //take variable
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(0, 0, 1080, 850);  //JfRAMR call by default//set location or size of frame
        getContentPane().setBackground(Color.WHITE);    //change frame color

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz.jpg"));  //pick image
        image = new JLabel(i1);
        image.setBounds(0, 0, 1080, 300);   //set image
        add(image);

        qno = new JLabel();  //create Lable for question no.
        qno.setBounds(60, 320, 50, 40);
        qno.setFont(new Font("Arial", Font.PLAIN, 28));
        add(qno);

        ques = new JLabel();  //create Lable for question
        ques.setBounds(100, 320, 850, 40);
        ques.setFont(new Font("Arial", Font.BOLD, 22));
        add(ques);

////questions
        question[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        question[0][1] = "JVM";
        question[0][2] = "JDB";
        question[0][3] = "JDK";
        question[0][4] = "JRE";

        question[1][0] = "What is the return type of the hashCode() method in the Object class?";
        question[1][1] = "int";
        question[1][2] = "Object";
        question[1][3] = "long";
        question[1][4] = "void";

        question[2][0] = "Which package contains the Random class?";
        question[2][1] = "java.util package";
        question[2][2] = "java.lang package";
        question[2][3] = "java.awt package";
        question[2][4] = "java.io package";

        question[3][0] = "An interface with no fields or methods is known as?";
        question[3][1] = "Runnable Interface";
        question[3][2] = "Abstract Interface";
        question[3][3] = "Marker Interface";
        question[3][4] = "CharSequence Interface";

        question[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        question[4][1] = "Stack";
        question[4][2] = "String memory";
        question[4][3] = "Random storage space";
        question[4][4] = "Heap memory";

        question[5][0] = "Which of the following is a marker interface?";
        question[5][1] = "Runnable interface";
        question[5][2] = "Remote interface";
        question[5][3] = "Readable interface";
        question[5][4] = "Result interface";

        question[6][0] = "Which keyword is used for accessing the features of a package?";
        question[6][1] = "import";
        question[6][2] = "package";
        question[6][3] = "extends";
        question[6][4] = "export";

        question[7][0] = "In java, jar stands for?";
        question[7][1] = "Java Archive Runner";
        question[7][2] = "Java Archive";
        question[7][3] = "Java Application Resource";
        question[7][4] = "Java Application Runner";

        question[8][0] = "Which of the following is a mutable class in java?";
        question[8][1] = "java.lang.StringBuilder";
        question[8][2] = "java.lang.Short";
        question[8][3] = "java.lang.Byte";
        question[8][4] = "java.lang.String";

        question[9][0] = "Which of the following option leads to the portability and security of Java?";
        question[9][1] = "Bytecode is executed by JVM";
        question[9][2] = "The applet makes the Java code secure and portable";
        question[9][3] = "Use of exception handling";
        question[9][4] = "Dynamic binding between objects";

/////answers


        answer[0][1] = "JDB";
        answer[1][1] = "int";
        answer[2][1] = "java.util package";
        answer[3][1] = "Marker Interface";
        answer[4][1] = "Heap memory";
        answer[5][1] = "Remote interface";
        answer[6][1] = "import";
        answer[7][1] = "Java Archive";
        answer[8][1] = "java.lang.StringBuilder";
        answer[9][1] = "Bytecode is executed by JVM";


        opt1 = new JRadioButton();//create radio button 1 for chose ans.
        opt1.setBounds(110, 430, 500, 45);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Arial", Font.PLAIN, 18));
        add(opt1);

        opt2 = new JRadioButton();//create radio button2 for chose ans.
        opt2.setBounds(110, 470, 500, 45);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Arial", Font.PLAIN, 18));
        add(opt2);


        opt3 = new JRadioButton();//create radio button 3 for chose ans.
        opt3.setBounds(110, 510, 500, 45);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Arial", Font.PLAIN, 18));
        add(opt3);

        opt4 = new JRadioButton();//create radio button 4 for chose ans.
        opt4.setBounds(110, 550, 500, 45);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Arial", Font.PLAIN, 18));
        add(opt4);


        options = new ButtonGroup();   //select only one option
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);




        submit = new JButton("SUBMIT");    //CREATE submit BUTTON
        submit.setBounds(760, 640, 130, 40);
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(30, 70, 180));
        submit.setFont(new Font("Arial", Font.BOLD, 22));
        submit.setEnabled(false);   //enable submit
        submit.addActionListener(this);//add actionlistener  //attach an event
        add(submit);


        next = new JButton("NEXT >>");    //CREATE NEXT BUTTON
        next.setBounds(900, 640, 130, 40);
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(30, 70, 180));
        next.setFont(new Font("Arial", Font.BOLD, 22));
        next.addActionListener(this);   //add action listener
        add(next);


        setLayout(null);
        setVisible(true);

        start(count);//create a function  //pass count
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ".");  //("" + count + 1 + ".")  convert integer to string
        ques.setText(question[count][0]);
        opt1.setText(question[count][1]);
        opt1.setActionCommand(question[count][1]);//SET VALUE

        opt2.setText(question[count][2]);
        opt2.setActionCommand(question[count][2]);

        opt3.setText(question[count][3]);
        opt3.setActionCommand(question[count][3]);

        opt4.setText(question[count][4]);
        opt4.setActionCommand(question[count][4]);


        options.clearSelection();
    }


    //action performed method
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();

            ans_given = 1;
            if (options.getSelection() == null)   //copy paste
            {
                useranswer[count][0] = "";  //empty string
            } else {
                useranswer[count][0] = options.getSelection().getActionCommand();
            }

            if (count == 8)   //enabeled ,disabled
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        }
        else if (ae.getSource() == submit)    //submit button
        {
            ans_given = 1;
            if (options.getSelection() == null) {
                useranswer[count][0] = "";  //empty string
            } else {
                useranswer[count][0] = options.getSelection().getActionCommand();
            }


            for (int i = 0; i < useranswer.length; i++) {
                if (useranswer[i][0].equals(answer[i][1])) {
                    score += 1;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);    //call score class

        }
    }



//paint method
    public void paint(Graphics g)//for timer//paint method call by default
    {
        super.paint(g);

        String Time = "Time Left - " + Timer + " sec"; //15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 22));

        if (Timer > 0)
        {
            g.drawString(Time, 820, 650);
        }
        else
        {
            g.drawString("Time up ..", 820, 650);

        }
        Timer--;

        try
        {
          Thread.sleep(1000);
          repaint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




        if (ans_given==1)
        {
            ans_given=0;
            Timer=15;
        }

        else if (Timer<0)
        {
            Timer=15;



            if(count==8)   //enabeled ,disabled
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }if(count==9)   //submit case
             {
                 if (options.getSelection() == null) {
                     useranswer[count][0] = "";  //empty string
                 } else {
                     useranswer[count][0] = options.getSelection().getActionCommand();
                 }


                 for(int i=0;i<useranswer.length;i++)
                 {
                     if (useranswer[i][0].equals(answer[i][1]))
                     {
                         score +=1;
                     }else
                        {
                         score+=0;
                        }
                 }
                   setVisible(false);
                 new Score(name,score);

             }else  //next case

              {
                if (options.getSelection() == null) {
                useranswer[count][0] = "";  //empty string
                } else {
                useranswer[count][0] = options.getSelection().getActionCommand();
                }
                count++;   //0//1//next questions
                 start(count);
              }
        }

    }



        public static void main(String[] args)  //main method

        {
            new Quiz("user");//create obj
        }
    }


