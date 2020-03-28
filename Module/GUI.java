package Module;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    static int a=0;
    static   JFrame frame = new JFrame();
    static   JPanel jPanel = new JPanel();
    logics logics =new logics();
    JLabel label =new JLabel("введіть довжину масиву");
    JTextField  jTextField1 =new JTextField("",2);
    JButton button = new JButton("ввести");
    GUI(){
        frame = getFrame();
        frame.add(jPanel);
        jPanel.setBackground(Color.CYAN);
        button.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC, 20));
        jTextField1.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC, 20));
        label.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC, 20));

        //jPanel.setLayout(null);
      jPanel.setLayout(new GridLayout(3,0,1,1));
        jPanel.add(label);
        jPanel.add(jTextField1);
        jPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(a==0) {
                    if(logics.getcheck(jTextField1.getText())==true) {
                        logics.setM(jTextField1.getText());
                        label.setText("введіть висоту масиву");
                        a++;
                    }else
                        label.setText( "помилка, введіть довжину масиву,тільки цілі числа ");
                }else if(a==1) {
                    if(logics.getcheck(jTextField1.getText())==true) {
                        logics.setN(jTextField1.getText());
                        label.setText("введіть елементи масиву через пробіл ");
                        a++;
                    } else
                        label.setText( "помилка, введіть висоту масиву,тільки цілі числа ");
                }
               else if(a==2){
                logics.TranslationArray(jTextField1.getText());
                a++;
                }
               if(a==3){
                   String message = "";
                   message += logics.getMessage();
                   JOptionPane.showMessageDialog(null, message, "Complete!", JOptionPane.PLAIN_MESSAGE);
               }
                jTextField1.setText("");
            }
        });
        jPanel.revalidate();
    }
    static JFrame getFrame(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("my app");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 125, 400, 250);
        return frame;
    }
}
