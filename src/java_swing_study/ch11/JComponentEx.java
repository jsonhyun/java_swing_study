package java_swing_study.ch11;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ContainerListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ContainerEvent;

@SuppressWarnings("serial")
public class JComponentEx extends JFrame implements ActionListener, ContainerListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentEx frame = new JComponentEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JComponentEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "11-1\uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		
		b1 = new JButton("Magenta/Yellow Button");
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		b1.setForeground(Color.MAGENTA);
		b1.setBackground(Color.YELLOW);
		pLeft.add(b1);
		
		b2 = new JButton("    Disabled Button    ");
		b2.setEnabled(false);
		pLeft.add(b2);
		
		b3 = new JButton("getX(), getY()");
		b3.addActionListener(this);
		pLeft.add(b3);
		
		b4 = new JButton("Button-Enable Toggle Button");
		b4.addActionListener(this);
		pLeft.add(b4);
		
		btnAdd = new JButton("Right Panel Add Btn");
		btnAdd.addActionListener(this);
		pLeft.add(btnAdd);
		
		btnRemove = new JButton("Right Panel Remove Btn");
		btnRemove.addContainerListener(this);
		btnRemove.addActionListener(this);
		pLeft.add(btnRemove);
		
		pRight = new JPanel();
		pRight.addContainerListener(this);
		pRight.setBorder(new TitledBorder(null, "JComponent \uBA54\uC11C\uB4DC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRemove) {
			btnRemoveActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
		if (e.getSource() == b4) {
			b4ActionPerformed(e);
		}
		if (e.getSource() == b3) {
			b3ActionPerformed(e);
		}
	}
	protected void b3ActionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
		frame.setTitle(b.getX()+", "+b.getY());
	}
	protected void b4ActionPerformed(ActionEvent e) {
		if(b2.isEnabled()) {
			b2.setEnabled(false);
		}else {
			b2.setEnabled(true);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		btnRight = new JButton("Added");
		btnRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Test");
				frame.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						System.out.printf("%s()%n","windowOpened");
						
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						System.out.printf("%s()%n","windowIconified");
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						System.out.printf("%s()%n","windowDeiconified");
						
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						System.out.printf("%s()%n","windowDeactivated");
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						System.out.printf("%s()%n","windowClosing");
						
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						System.out.printf("%s()%n","windowClosed");
						
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						System.out.printf("%s()%n","windowActivated");
						
					}
				});
				frame.setBounds(200,100,450,300);
				frame.setVisible(true);
			}
		});
		pRight.add(btnRight);
		revalidate();
	}
	public void componentAdded(ContainerEvent e) {
		if (e.getSource() == pRight) {
			pRightComponentAdded(e);
		}
	}
	
	protected void pRightComponentAdded(ContainerEvent e) {
		JOptionPane.showMessageDialog(null, "버튼이 추가되었습니다.");
	}
	protected void btnRemoveActionPerformed(ActionEvent e) {
		for(Component c : pRight.getComponents()) {
			if (c instanceof JButton) {
				pRight.remove(c);
				revalidate();
				repaint();
//				break;
			}
//			System.out.println(c);
		}

	}
	public void componentRemoved(ContainerEvent e) {
		if (e.getSource() == btnRemove) {
			btnRemoveComponentRemoved(e);
		}
	}
	protected void btnRemoveComponentRemoved(ContainerEvent e) {
		JOptionPane.showMessageDialog(null, "버튼이 삭제되었습니다.");
	}
}
