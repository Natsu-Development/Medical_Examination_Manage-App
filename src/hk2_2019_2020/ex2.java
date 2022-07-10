package hk2_2019_2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class ex2 extends JFrame {

	List<bookDTO> accountList = new ArrayList<bookDTO>();
	ex2_BUS bus = new ex2_BUS();
	public JFrame f = new JFrame();
	private JPanel contentPane;
	private JTextField tfBookName, tfId, tfAmount, tfPrice;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	
	public static void main(String args[]) {
		new ex2();
	}
	public ex2() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Book Manager");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 399, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lCode = new JLabel("Book Name:");
		lCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lCode.setForeground(new Color(0, 0, 0));
		lCode.setBounds(25, 42, 90, 28);
		panel.add(lCode);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(125, 45, 209, 28);
		panel.add(tfBookName);
		tfBookName.setColumns(10);
		
		JLabel lName = new JLabel("Amount:");
		lName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lName.setForeground(new Color(0, 0, 0));
		lName.setBounds(25, 97, 101, 28);
		panel.add(lName);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(125, 99, 209, 28);
		panel.add(tfAmount);
		tfAmount.setColumns(10);
		
		JLabel lPrice = new JLabel("Price:");
		lPrice.setFont(new Font("SansSerif", Font.BOLD, 12));
		lPrice.setForeground(new Color(0, 0, 0));
		lPrice.setBounds(25, 150, 101, 28);
		panel.add(lPrice);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(125, 151, 209, 28);
		panel.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lId = new JLabel("Id:");
		lId.setFont(new Font("SansSerif", Font.BOLD, 12));
		lId.setForeground(new Color(0, 0, 0));
		lId.setBounds(25, 200, 101, 28);
		panel.add(lId);
		
		tfId = new JTextField();
		tfId.setBounds(125, 200, 209, 28);
		panel.add(tfId);
		tfId.setColumns(10);
		
		JButton btnEdit = new JButton("Sá»­a");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(218, 282, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("ThÃªm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(320, 282, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("XÃ³a");
		btnRemove.setBounds(10, 282, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(113, 282, 75, 28);
		panel.add(btnReset);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 108, 961, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();  
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Book Code");
		model.addColumn("Book Name");
		model.addColumn("Amount");
		model.addColumn("Price");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				jTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		Panel panel1 = new Panel();
		panel1.setBackground(new Color(50, 205, 50));
		panel1.setBounds(0, 0, 1364, 111);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lbTitle = new JLabel("Danh SÃ¡ch TÃ i Khoáº£n");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lbTitle.setBounds(315, 6, 372, 57);
		panel1.add(lbTitle);
		
		JButton btnSearch = new JButton("TÃ¬m kiáº¿m");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(1252, 12, 90, 38);
		panel1.add(btnSearch);
		
		tfFind = new JTextField();
		tfFind.setBounds(934, 12, 319, 38);
		panel1.add(tfFind);
		tfFind.setColumns(10);
		JButton btnTrLi = new JButton("");
		btnTrLi.setBounds(10, 0, 50, 50);
		panel1.add(btnTrLi);
		btnTrLi.setBackground(new Color(50, 205, 50));
		btnTrLi.setIcon(new ImageIcon("Image\\return-24-48.png"));
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTotalAmount(e);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setResizable(false);
		f.setVisible(true);
		JLabel lblNewLabel = new JLabel("(TÃ¬m kiáº¿m theo mÃ£ tÃ i khoáº£n)");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(1013, 60, 309, 29);
		panel1.add(lblNewLabel);
 	}
	
	private void btnTotalAmount(ActionEvent e) {
		tfFind.setText(String.valueOf(bus.getAllAmount()));
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfBookName.setText("");
		tfId.setText("");
		tfAmount.setText("");
		tfPrice.setText("");
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {    
        	tfId.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
        	tfId.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
        	tfId.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfId.getText().trim().equals("") && !tfBookName.getText().trim().equals("") && !tfAmount.getText().trim().toString().equals("") && !tfPrice.getText().trim().toString().equals("")) {
			try {
				// id vÃ  phÃ¢n quyá»�n chÆ°a thÃªm
				int id = Integer.parseInt(tfId.getText().toString());
				String name = tfBookName.getText().toString();
				int amount = Integer.parseInt(tfAmount.getText().toString());
				int price = Integer.parseInt(tfPrice.getText().toString());
				
				bookDTO p = new bookDTO(id, name,amount, price);
				
				JOptionPane.showMessageDialog(null, bus.insert(p));
				
				displayList();
				btnResetActionPerformed(e);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Price and amount must be number");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Fill the form be full, please");
		}
	}
	
	private void displayList() {
		model.setRowCount(0);
		accountList = bus.getAllBook();
    	int i = 0;
		while(i < accountList.size()) {
			bookDTO p = accountList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getBookCode(), p.getBookName(), p.getAmount(), p.getPrice()
			});
			i++;
		}
		
	}
}