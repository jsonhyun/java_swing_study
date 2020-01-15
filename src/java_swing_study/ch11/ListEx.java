package java_swing_study.ch11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListEx extends JFrame implements ListSelectionListener, ActionListener {

	private JPanel contentPane;
	private ArrayList<String> listFruits;
	private ArrayList<ImageIcon> listImg;
	private JPanel p1;
	private JList<String> strList;
	private JPanel pBtns1;
	private JButton btnOk1;
	private JButton btnSet1;
	private JPanel p2;
	private JPanel panel;
	private JButton btnOk2;
	private JButton btnSet2;
	private JScrollPane scrollPane;
	private JList imgList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEx frame = new ListEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListEx() {
		loadListData();
		initialize();
	}

	private void loadListData() {
		listFruits = new ArrayList<String>();
		listFruits.add("apple");
		listFruits.add("bananna");
		listFruits.add("kiwi");
		listFruits.add("mango");
		listFruits.add("pear");
		listFruits.add("peach");
		listFruits.add("berry");
		listFruits.add("strawberry");
		listFruits.add("blacckberry");
		
		String imgDirPath = System.getProperty("user.dir") + "\\images\\";
		listImg = new ArrayList<ImageIcon>();
		listImg.add(new ImageIcon(imgDirPath + "icon1.png"));
		listImg.add(new ImageIcon(imgDirPath + "icon2.png"));
		listImg.add(new ImageIcon(imgDirPath + "icon3.png"));
		listImg.add(new ImageIcon(imgDirPath + "icon4.png"));
	}
	
	private void initialize() {
		setTitle("JList & JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 10, 10));
		
		p1 = new JPanel();
		p1.setBorder(new TitledBorder(null, "JList \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		
		strList = new JList<>(new Vector<>(listFruits));
		strList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		strList.addListSelectionListener(this);
		p1.add(strList, BorderLayout.CENTER);
		
		pBtns1 = new JPanel();
		p1.add(pBtns1, BorderLayout.NORTH);
		pBtns1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk1 = new JButton("확인");
		btnOk1.addActionListener(this);
		pBtns1.add(btnOk1);
		
		btnSet1 = new JButton("선택하기");
		btnSet1.addActionListener(this);
		pBtns1.add(btnSet1);
		
		p2 = new JPanel();
		p2.setBorder(new TitledBorder(null, "JList-Icon", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		p2.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk2 = new JButton("확인");
		btnOk2.addActionListener(this);
		panel.add(btnOk2);
		
		btnSet2 = new JButton("선택하기");
		btnSet2.addActionListener(this);
		panel.add(btnSet2);
		
		scrollPane = new JScrollPane();
		p2.add(scrollPane, BorderLayout.CENTER);
		
		imgList = new JList<>(new Vector<>(listImg));
		imgList.addListSelectionListener(this);
		scrollPane.setViewportView(imgList);
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == imgList) {
			imgListValueChanged(e);
		}
		if (e.getSource() == strList) {
			strListValueChanged(e);
		}
	}
	
	protected void strListValueChanged(ListSelectionEvent e) {
		String selectValue = strList.getSelectedValue();
		JOptionPane.showMessageDialog(null, "valueChanged - 선택한 과일은?" + selectValue);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk2) {
			btnOk2ActionPerformed(e);
		}
		if (e.getSource() == btnSet2) {
			btnSet2ActionPerformed(e);
		}
		if (e.getSource() == btnSet1) {
			btnSet1ActionPerformed(e);
		}
		if (e.getSource() == btnOk1) {
			btnOk1ActionPerformed(e);
		}
	}
	
	protected void btnOk1ActionPerformed(ActionEvent e) {
		int[] selIndexs = strList.getSelectedIndices();
		for(int idx : selIndexs) {
			System.out.println(idx);
		}
		System.out.println(strList.getSelectedIndex() + listFruits.get(strList.getSelectedIndex()));
		
		JOptionPane.showMessageDialog(null, "actionPerformed - 선택한 과일은?" + strList.getSelectedValue());
	}
	
	protected void btnSet1ActionPerformed(ActionEvent e) {
		strList.setSelectedIndex(listFruits.indexOf("peach"));
		strList.setSelectedValue("peach", true);
	}
	
	protected void imgListValueChanged(ListSelectionEvent e) {
		ImageIcon icon = (ImageIcon) imgList.getSelectedValue();
		String fullName = icon.getDescription();
		System.out.println(fullName);
		JOptionPane.showMessageDialog(null, fullName.substring(fullName.lastIndexOf("\\")+1));
	}
	protected void btnSet2ActionPerformed(ActionEvent e) {
		imgList.setSelectedIndex(2);
	}
	protected void btnOk2ActionPerformed(ActionEvent e) {
		ImageIcon icon = listImg.get(imgList.getSelectedIndex());
		String fullName = icon.getDescription();
		JOptionPane.showMessageDialog(null, fullName.substring(fullName.lastIndexOf("\\")+1));
	}
}










