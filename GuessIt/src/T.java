//设计猜数游戏程序。（难度系数*）
//被猜的数用密码框形式输入，在文本中输入猜的数字，点击【猜】按钮，
//给出提示：（大了还是小了？或者是恭喜猜中了），直到猜中，记录并输出猜的次数。
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class T extends JFrame implements ActionListener {
	JButton jB1;
	public static int i = 0;
	private JPasswordField passwordField;
	private JTextField textField;

	public T() {
		super("猜数游戏程序");
		Container w1Container = this.getContentPane();
		w1Container.setLayout(null);

		JLabel jL1 = new JLabel("请输入一个被猜数");
		jL1.setBounds(80, 15, 160, 30);
		w1Container.add(jL1);

		passwordField = new JPasswordField();
		passwordField.setBounds(80, 40, 114, 18);
		getContentPane().add(passwordField);

		JLabel jL2 = new JLabel("请输入一个数");
		jL2.setBounds(90, 55, 160, 30);
		w1Container.add(jL2);

		textField = new JTextField();
		textField.setBounds(80, 80, 114, 18);
		getContentPane().add(textField);

		jB1 = new JButton("猜");
		jB1.addActionListener(this);
		jB1.setBounds(95, 100, 80, 30);
		w1Container.add(jB1);

	}

	public static void main(String[] args) {
		T w1 = new T();
		w1.setSize(300, 200);
		w1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		i++;
		int a = Integer.parseInt(passwordField.getText());
		int b = Integer.parseInt(textField.getText());
		JLabel jL1 = new JLabel();
		JDialog dialog = new JDialog();
		dialog.add(jL1);
		dialog.setVisible(true);
		dialog.setBounds(50, 50, 50, 50);
		dialog.setSize(200, 100);
		dialog.setResizable(false);
		if (!(a == b)) {
			if (a > b) {
				jL1.setText("小了");
    
				

			} else {
				jL1.setText("大了");
				 
				
			}
		} else {
			jL1.setText("恭喜您猜了" + i + "次就猜中了");
			

		}
	}

}
