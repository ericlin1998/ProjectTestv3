import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test2 extends JFrame implements ActionListener {
	static final long serialVersionUID = 0;
	JTextField textField;
	JTextField jtfInput;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton button0;
	static JTextArea jtAreaOutput;
	String newline = "\n";
	String text = "";
	/*
	boolean repeat= true;
	Scanner console = new Scanner(System.in);
	int total;
	int num = 5;
	final int MIN = 0;
	*/
	public Test2() {
		createGui();
	}
	public void createGui() {
		//things/varaibles...etc
		this.setTitle("Game");
		this.setResizable(false);
		textField = new JTextField(30);
		textField.setText("Input");
		textField.setEditable(false);
		jtfInput = new JTextField(30);
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		button0 = new JButton("0");
		jtfInput.addActionListener(this);
		jtAreaOutput = new JTextArea(10, 30);
		jtAreaOutput.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagLayout gridBag = new GridBagLayout();
		
		Container contentPane = getContentPane();
		
		
		contentPane.setLayout(gridBag);
		
		//sets frid to put stuff
		GridBagConstraints gridCons1 = new GridBagConstraints();
		gridCons1.gridwidth = GridBagConstraints.REMAINDER;
		gridCons1.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints gridCons2 = new GridBagConstraints();
		gridCons2.weightx = 1.0;
		gridCons2.weighty = 1.0;
		gridCons2.gridwidth = GridBagConstraints.REMAINDER;
		gridCons2.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridCons3 = new GridBagConstraints();
		gridCons3.gridwidth = GridBagConstraints.REMAINDER;
		gridCons3.fill = GridBagConstraints.HORIZONTAL;
		GridBagConstraints b1 = new GridBagConstraints();
		b1.gridwidth = 1;
		GridBagConstraints b2 = new GridBagConstraints();
		b2.gridwidth = 2;
		GridBagConstraints b3 = new GridBagConstraints();
		b3.gridwidth = 3;
		GridBagConstraints b4 = new GridBagConstraints();
		b4.gridwidth = 4;
		GridBagConstraints b5 = new GridBagConstraints();
		b5.gridwidth = 5;
		GridBagConstraints b6 = new GridBagConstraints();
		b6.gridwidth = 6;
		GridBagConstraints b7 = new GridBagConstraints();
		b7.gridwidth = 7;
		GridBagConstraints b8 = new GridBagConstraints();
		b8.gridwidth = 8;
		GridBagConstraints b9 = new GridBagConstraints();
		b9.gridwidth = 9;
		GridBagConstraints b0 = new GridBagConstraints();
		b0.gridwidth = 0;
		
		
		//put stuff on jframe
		contentPane.add(scrollPane, gridCons2);
		contentPane.add(textField, gridCons3);
		contentPane.add(jtfInput, gridCons1);
		contentPane.add(button1, b1);
		contentPane.add(button2, b2);
		contentPane.add(button3, b3);
		contentPane.add(button4, b4);
		contentPane.add(button5, b5);
		contentPane.add(button6, b6);
		contentPane.add(button7, b7);
		contentPane.add(button8, b8);
		contentPane.add(button9, b9);
		contentPane.add(button0, b0);
	}
	
	public static void addText(String str){
		jtAreaOutput.append(str);
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument().getLength());
	}
	
	public void actionPerformed(ActionEvent evt) {
		text = jtfInput.getText();
		//jtAreaOutput.append(text);
		//getContentPane().remove(button2);
		//getContentPane().update(getGraphics());
	}
	
	public String returnText(){
		return text;
	}
	
	public void textClear(){
		text = "";
	}
	
	public static void main(String[] args) {
		Test2 jtfTfDemo = new Test2();
		jtfTfDemo.pack();
		jtfTfDemo.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jtfTfDemo.setVisible(true);
	}
}