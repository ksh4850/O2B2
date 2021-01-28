package mini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame {
	
	private JTextField loginIdT;
	private JPasswordField loginPwdT;
	


	public static void main(String[] args) {
		LoginFrame jf = new LoginFrame();
		MemberDB memberDB = new MemberDB();
		memberDB.loadingDBMethod();
		System.out.println(memberDB.getListDB());
//		
		jf.initialize1(); 

	}
	
	
	public void initialize1() {
		MemberManager memberManager = new MemberManager();
		
		JFrame1 logframe = new JFrame1();
		ImagePanel panel1 = new ImagePanel(new ImageIcon("C:/image/1.jpg").getImage());
		logframe.add(panel1);
		logframe.pack();
		

		
		loginIdT = new JTextField();
		loginIdT.setBounds(95, 487, 568, 62);
		panel1.add(loginIdT);
		loginIdT.setColumns(10);
		
		loginPwdT = new JPasswordField();
		loginPwdT.setBounds(95, 577, 568, 62);
		panel1.add(loginPwdT);
		loginPwdT.setColumns(10);
		
		
		JButton loginBtn = new JButton("");
		loginBtn.setIcon(new ImageIcon("C:\\버튼이미지\\로그인.jpg"));
		loginBtn.setBounds(98, 660, 565, 62);
		panel1.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {	//로그인버튼
			public void actionPerformed(ActionEvent e) {
				if(memberManager.login(loginIdT.getText(), loginPwdT.getText())) {
				logframe.setVisible(false);
				initialize2();
				}
			}
		});
		
		JButton loginJoinBtn = new JButton("");
		loginJoinBtn.setIcon(new ImageIcon("C:\\버튼이미지\\새계정만들기.jpg"));
		loginJoinBtn.setBounds(95, 744, 178, 23);
		panel1.add(loginJoinBtn);
		loginJoinBtn.addActionListener(new ActionListener() {	//회원가입 버튼
			public void actionPerformed(ActionEvent e) {
				logframe.setVisible(false);
				JoinFrame joinframe = new JoinFrame();
				joinframe.initialize3();
				
			}
		});
	
	}
	
	
	public void initialize2() {
		
		JFrame1 logframe = new JFrame1();
		ImagePanel panel2 = new ImagePanel(new ImageIcon("C:/image/2.jpg").getImage());
		logframe.add(panel2);
		logframe.pack();
		
		JLabel homeMemberL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName()+"님 환영합니다.");
		homeMemberL.setFont(new Font("굴림", Font.BOLD, 28));
		homeMemberL.setForeground(Color.WHITE);
		homeMemberL.setBounds(196, 530, 362, 32);
		panel2.add(homeMemberL);
		
		
		JButton homeRevBtn = new JButton("");
		homeRevBtn.setForeground(Color.BLACK);
		homeRevBtn.setIcon(new ImageIcon("C:\\버튼이미지\\예약하기.jpg"));
		homeRevBtn.setBounds(101, 638, 254, 50);
		panel2.add(homeRevBtn);
		homeRevBtn.addActionListener(new ActionListener() {	//예약하기 버튼
			public void actionPerformed(ActionEvent e) {
				
				ResvervationFrame revframe = new ResvervationFrame();
				revframe.initialize6();
				logframe.setVisible(false);
			}
		});
		
		
		JButton homeinfoBtn = new JButton("");
		homeinfoBtn.setIcon(new ImageIcon("C:\\버튼이미지\\개인정보확인.png"));
		homeinfoBtn.setBounds(392, 631, 254, 62);
		panel2.add(homeinfoBtn);
		homeinfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfoFrame infoframe = new InfoFrame();
				infoframe.initialize4();
				logframe.setVisible(false);
				
			}
		});
		
		
		JButton homeLogoutBtn = new JButton("");
		homeLogoutBtn.setIcon(new ImageIcon("C:\\버튼이미지\\h로그아웃.jpg"));
		homeLogoutBtn.setBounds(101, 698, 154, 37);
		panel2.add(homeLogoutBtn);
		homeLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				logframe.setVisible(false);
				initialize1();
				
			}
		});
		
		
		
	}
	
	
	
	
}
