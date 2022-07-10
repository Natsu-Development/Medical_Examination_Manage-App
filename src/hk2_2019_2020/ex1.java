package hk2_2019_2020;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ex1 {
	private static double result;
	JLabel l1, l2, l3;
	JTextField j1, j2, j3;
	public ex1() {
		JFrame f = new JFrame("SimpleCalculator");
		f.setSize(400, 300);
		
		j1 = new JTextField();
		j2 = new JTextField();
		j3 = new JTextField();
		
		l1 = new JLabel("Enter x:");
		l1.setPreferredSize(new Dimension(100, 20));
//		l1.setBounds(0, 5, 130, 30);
		j1.setPreferredSize(new Dimension(250, 20));
//		j1.setBounds(230, 5, 130, 30);
		
		l2 = new JLabel("Enter n:");
		l2.setPreferredSize(new Dimension(100, 20));
		j2.setPreferredSize(new Dimension(250, 20));
		
		l3 = new JLabel("Result:");
		l3.setPreferredSize(new Dimension(100, 20));
		j3.setPreferredSize(new Dimension(250, 20));
		j3.setEditable(false);
		
		f.add(l1);
		f.add(j1);
		f.add(l2);
		f.add(j2);
		f.add(l3);
		f.add(j3);
		
		JButton b = new JButton("Action");
		
		f.add(b);
		
		f.setLayout(new FlowLayout());
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//event
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = Integer.parseInt(j1.getText());
				int n = Integer.parseInt(j2.getText());
				double result = 0;
				for(int i=0; i<=n; i++) {
					result = result + (i+1)*Math.pow(x, i);
				}
				j3.setText(String.valueOf(result)); 
			}
		});
	}
	
	public void check() {
		if(j1.getText()=="" || j2.getText()=="") {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu vào ô dữ liệu");
		}
		if(j1.getText()!="" && j2.getText()!="") {
			try {
				int num = Integer.parseInt(j1.getText());
				int num1 = Integer.parseInt(j2.getText());
			} 
			catch(InputMismatchException ex) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu");
			}
			catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu");
			}
		}
	}
	
	public static void main(String []args) {
		ex1 simpleCalculator = new ex1();
		
	}
}
