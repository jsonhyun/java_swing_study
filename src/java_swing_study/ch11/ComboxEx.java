package java_swing_study.ch11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java_swing_study.ch11.exam.Student;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class ComboxEx extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> model;
	private DefaultComboBoxModel<String> modelStd;
	private JTextField tfFruit;
	private JLabel lblFruit;
	private JButton btnOk;
	private JComboBox<String> cmbStudent;
	private JButton btnConfirm;
	private JPanel pSearch;
	private JLabel lblNum;
	private JTextField tfNum;
	private JButton btnSearch;
	private JLabel lblStudent;
	private ArrayList<Student> stds;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboxEx frame = new ComboxEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboxEx() {
		
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		initialize();
	}
	private void initialize() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uC608\uC81C 11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		cmbFruit = new JComboBox<>();
		cmbFruit.addItemListener(this);
		cmbFruit.setMaximumRowCount(5);
		
		pLeft.add(cmbFruit);
		
		tfFruit = new JTextField();
		tfFruit.addActionListener(this);
		pLeft.add(tfFruit);
		tfFruit.setColumns(10);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC608\uC81C 11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		cmbStudent = new JComboBox<>();
		cmbStudent.addItemListener(this);
		pRight.add(cmbStudent);
		
		lblStudent = new JLabel("학생정보");
		lblStudent.setForeground(Color.RED);
		lblStudent.setFont(new Font("굴림", Font.BOLD, 12));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblStudent);
		
		btnConfirm = new JButton("학생 확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
		
		pSearch = new JPanel();
		pRight.add(pSearch);
		pSearch.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		pSearch.add(lblNum);
		
		tfNum = new JTextField();
		tfNum.setHorizontalAlignment(SwingConstants.CENTER);
		pSearch.add(tfNum);
		tfNum.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pSearch.add(btnSearch);
		
		cmbFruit.setModel(getModel());
		cmbFruit.setSelectedIndex(-1);
		
		cmbStudent.setModel(getModelStudent());
		cmbStudent.setSelectedIndex(-1);
		
		lblFruit = new JLabel("과일");
		lblFruit.setFont(new Font("굴림", Font.BOLD, 12));
		lblFruit.setForeground(Color.RED);
		lblFruit.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblFruit);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pLeft.add(btnOk);
	}

	private ComboBoxModel<String> getModelStudent() {
		modelStd = new DefaultComboBoxModel<String>();
		for(int i=0;i<stds.size();i++) {
			modelStd.addElement(stds.get(i).toString());
		}
		return modelStd;
	}

	private ComboBoxModel<String> getModel() {
		model = new DefaultComboBoxModel<String>();
		
		String[] fs = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
		for(String f : fs) {
			model.addElement(f);
		}
		
		return model;
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == tfFruit) {
			textFieldActionPerformed(e);
		}
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		model.addElement(tfFruit.getText().trim());
		tfFruit.setText("");
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbStudent) {
			cmbStudentItemStateChanged(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitItemStateChanged(e);
		}
	}
	protected void cmbFruitItemStateChanged(ItemEvent e) {
		String selfruit = (String) model.getSelectedItem();
		if(e.getStateChange() == 1) {
			lblFruit.setText(selfruit);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		String selfruit = (String) model.getSelectedItem();
		JOptionPane.showMessageDialog(null, "선택한 과일은 "+selfruit+"입니다.");
	}
	protected void cmbStudentItemStateChanged(ItemEvent e) {
		String selStd = (String) modelStd.getSelectedItem();
		if(e.getStateChange()==1) {
			lblStudent.setText(selStd);
		}
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		String selStd = (String) modelStd.getSelectedItem();
		JOptionPane.showMessageDialog(null, selStd);
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		int selNum = Integer.parseInt(tfNum.getText().trim());
		String result = stds.get(selNum-1).toString();
		lblStudent.setText(result);
		cmbStudent.setSelectedItem(result);
		tfNum.setText("");
//		System.out.println(e);
	}
}
