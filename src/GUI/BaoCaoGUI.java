package GUI;

import java.awt.BorderLayout;
import base.*;
import DAL.*;
import DTO.ThongKeDTO;
import BLL.*;
import BUS.ThongKeBUS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import Dungchung.Tester;
import base.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class BaoCaoGUI extends JFrame {
	khamBenhBLL kbBLL = new khamBenhBLL();
	List<ThongKeDTO> benhnhanList = new ArrayList<ThongKeDTO>();
	List<hsba> hsbaList = new ArrayList<hsba>();
	
	List<benhNhan_DichVu> bndv = new ArrayList<benhNhan_DichVu>();
	hsbaBLL hsbaBLL = new hsbaBLL();
	benhNhan_DichVuBLL bndvBLL = new benhNhan_DichVuBLL();
	
	private JPanel contentPane;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	private JTable table,table1 ;
	private JTextField tfketqua;
	public JFrame f = new JFrame();
	JLabel countKhongkhoi;
	JLabel countKhoibenh;
	JComboBox cbthongke;
	String tk[] = {"Th???ng k??","H??? S?? B???nh ??n","D???ch V??? B???nh Nh??n S??? D???ng"};
	public BaoCaoGUI() {
		initComponent();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Qu???n l?? h??? s?? b???nh ??n");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 108, 1360, 516);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("M?? h??? s??");
		model.addColumn("Ng??y b???t ?????u");
		model.addColumn("Ng??y k???t th??c");
		model.addColumn("K???t qu???");
		model.addColumn("T??n b??c s?? ??i???u tr???");
		model.addColumn("T??n b???nh nh??n");
		
		table1 = new JTable();
		table1.setModel(model1);
		model1.addColumn("STT");
		model1.addColumn("M?? B???nh Nh??n");
		model1.addColumn("M?? D???ch V??? ");
//		model1.addColumn("T??n D???ch V???");
		model1.addColumn("Ng??y S??? D???ng");
//		model1.addColumn("????n Gi??");
		model1.addColumn("S??? L???n");		

		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(0, 63, 1364, 48);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		Date now = new Date();
    	String ft = new SimpleDateFormat("MM/yyyy").format(now);
    	String dateNow = ft.formatted(now);
		JLabel lDSNCC = new JLabel("B??o c??o th??ng: " + dateNow);
		lDSNCC.setForeground(Color.WHITE);
		lDSNCC.setFont(new Font("SansSerif", Font.BOLD, 26));
		lDSNCC.setBounds(533, 4, 350, 36);
		panel1.add(lDSNCC);
		
		JButton btnSearch = new JButton("T??m ki???m");
		btnSearch.setBounds(1252, 12, 90, 28);
		panel1.add(btnSearch);
		
		tfFind = new JTextField();
		tfFind.setBounds(1010, 12, 243, 28);
		panel1.add(tfFind);
		tfFind.setColumns(10);
		
		cbthongke = new JComboBox(tk);
		cbthongke.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbthongke.setBounds(22, 10, 260, 29);
		panel1.add(cbthongke);
		JLabel lPhantramkhoibenh = new JLabel();
		lPhantramkhoibenh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lPhantramkhoibenh.setForeground(new Color(255, 255, 255));
		lPhantramkhoibenh.setBounds(10, 634, 400, 59);
		contentPane.add(lPhantramkhoibenh);
		JLabel lPhantramtuvong = new JLabel();
		lPhantramtuvong.setForeground(Color.WHITE);
		lPhantramtuvong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lPhantramtuvong.setBounds(500, 634, 400, 59);
		contentPane.add(lPhantramtuvong);
		cbthongke.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x=0,i=0,y=0;
				double ck=0, kck=0;
				if(cbthongke.getSelectedItem()=="H??? S?? B???nh ??n") {
					scrollPane.setViewportView(table);
					try {
						displayList();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					while(true) {
						if(i==hsbaList.size()) {
							break;
						}
						if(String.valueOf(model.getValueAt(i, 4)).equals("Ch???a kh???i")) x++;
						if(String.valueOf(model.getValueAt(i, 4)).equals("Kh??ng ch???a kh???i")) y++;
						i++;
					}
					if(x!=0 || y!=0) {
						ck = (x*100)/(x+y);
						kck = 100.0 - ck;
					}
					lPhantramkhoibenh.setText("Ph???n tr??m b???nh nh??n kh???i b???nh: " + ck + "%");
					lPhantramtuvong.setText("Ph???n tr??m b???nh nh??n kh??ng kh???i b???nh: " + kck + "%");
				}
				else if(cbthongke.getSelectedItem()=="D???ch V??? B???nh Nh??n S??? D???ng") {
					scrollPane.setViewportView(table1);
					displayList1();
					int bestService = 0;
					int amount = 0, max = 0, key = 0;
					for(int j=0; j<bndv.size(); j++) {
						int code = bndv.get(i).getMaDV();
						int a = bndv.get(i).getSoluongDV();
						for(int k=j+1; k<bndv.size(); k++) {
							if(code == bndv.get(k).getMaDV()) {
								a = a + bndv.get(k).getSoluongDV();
							}
							if(a>max) {
								max = a;
								bestService = k;
							}
							if(a==max) {
								key = k;
							}
						}
					}
					int worstService = 0;
					int amount1 = 0, min = 999999, key1 = 0;
					for(int j=0; j<bndv.size(); j++) {
						int code1 = bndv.get(i).getMaDV();
						int b = bndv.get(i).getSoluongDV();
						for(int k=j+1; k<bndv.size(); k++) {
							if(code1 == bndv.get(k).getMaDV()) {
								b = b + bndv.get(k).getSoluongDV();
							}
							if(b<min) {
								min = b;
								worstService = k;
							}
							if(b==min) {
								key = k;
							}
						}
					}
					String maDv = String.valueOf(bndv.get(bestService).getMaDV());
		    		String tenDv = kbBLL.getData1("dich_vu", "TENDV", maDv, "MADV");
		    		String maDv1 = String.valueOf(bndv.get(worstService).getMaDV());
		    		String tenDv1 = kbBLL.getData1("dich_vu", "TENDV", maDv1, "MADV");
					lPhantramkhoibenh.setText("D???ch v??? ???????c s??? d???ng nhi???u nh???t: " + tenDv);
					lPhantramtuvong.setText("D???ch v??? ???????c s??? d???ng ??t nh???t: " + tenDv1);
				}
			}
		});
		
		JButton btnTrLi = new JButton("Tr??? l???i");
		btnTrLi.setBounds(10, 10, 91, 47);
		contentPane.add(btnTrLi);
		
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginGUI.permission.equals("Gi??m ?????c")) {
					adminGUI p = new adminGUI();
					p.f.setVisible(true);
				}
				else if(loginGUI.permission.equals("Qu???n tr??? h??? th???ng")) {
					quantriGUI p = new quantriGUI();
					p.f.setVisible(true);
				}
				else if(loginGUI.permission.equals("B??c s??")) {
					doctorGUI p = new doctorGUI(loginGUI.code);
					p.f.setVisible(true);
				}
				else {
					employeeGUI p = new employeeGUI(loginGUI.code);
					p.f.setVisible(true);;
				}
				f.setVisible(false);
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnSearchActionPerformed(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setVisible(true);
	}

	
	private void btnSearchActionPerformed(ActionEvent e) throws ParseException {
		String hsbaName = tfFind.getText();
        if(hsbaName != null && hsbaName.length() > 0) {
            hsbaList = hsbaBLL.searchhsbaByName(hsbaName);
            
            if(hsbaList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Kh??ng c?? h??? s?? b???n c???n t??m");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < hsbaList.size()) {
	    			hsba p = hsbaList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMahs() , p.getNgaybd(),p.getNgaykt(),p.getKetqua(),p.getTenbs(),p.getTenbn()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n h??? s?? c???p ????? t??m ki???m");
        }
	}
	
	private void displayList() throws ParseException {
		model.setRowCount(0);
		hsbaList = hsbaBLL.getBaoCao1();
    	int i = 0;
		while(i < hsbaList.size()) {
			hsba p = hsbaList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMahs() , p.getNgaybd(),p.getNgaykt(),p.getKetqua(),p.getTenbs(),p.getTenbn()
			});
			i++;
		}
	}
	
	private void displayList1() {
		model1.setRowCount(0);
		try {
			bndv = bndvBLL.baoCao();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int i = 0;
		while(i < bndv.size()) {
			benhNhan_DichVu p = bndv.get(i);
			model1.addRow(new Object [] {
					model1.getRowCount()+1, p.getMaBN(), p.getMaDV(), p.getNgaySD(), p.getSoluongDV()
			});
			i++;
		}
	}

}