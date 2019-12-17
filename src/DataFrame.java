import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataFrame extends JFrame {
    private Container cp;
    private JButton all=new JButton("All");
    private JButton add=new JButton("新增");
    private JButton fix=new JButton("修改");
    private JButton delete=new JButton("刪除");
    private JButton search=new JButton("查詢");
    private JPanel jpN=new JPanel(new GridLayout(1,6,3,3));

    private JTextArea jta=new JTextArea();
    private JScrollPane jsp=new JScrollPane();

    private JLabel jlblight=new JLabel();
    private JButton connect=new JButton("連線");
    private  JLabel space=new JLabel();
    private  JLabel spacel=new JLabel();
    private JButton exit=new JButton("Exit");
    private JPanel jpS=new JPanel(new GridLayout(1,8,3,3));

    private int n=0;

    public DataFrame(){
        init();
    }
    private void init(){
        cp=this.getContentPane();
        this.setDefaultCloseOperation(DataFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,500,500);
        cp.setLayout(new BorderLayout(3,3));

        cp.add(jpN,BorderLayout.NORTH);
        jpN.add(all);
        jpN.add(add);
        jpN.add(fix);
        jpN.add(delete);
        jpN.add(search);

        cp.add(jsp,BorderLayout.CENTER);
        jta.add(jsp);
        jta.setBackground(new Color(235,70,70));

        cp.add(jpS,BorderLayout.SOUTH);
        jpS.add(jlblight);
        jpS.add(connect);
        jpS.add(space);
        jpS.add(spacel);
        jpS.add(exit);

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (n==0) {
                    connect.setText("disconnect");
                    jlblight.setBackground(new Color(255, 0, 0));
                    n+=1;
                }else if (n==1){
                    connect.setText("connect");
                    jlblight.setBackground(new Color(0,0,255));
                    n+=1;
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
