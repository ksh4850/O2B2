package mini;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;


public class ResvervationFrame implements ItemListener {
	
	private JCheckBox[] revPriceCk = new JCheckBox[7];
	private JCheckBox[] rveTimeck = new JCheckBox[6];
	private int sum;
	private JLabel rvePriceL = new JLabel();

	
	
	public static void main(String[] args) {
		ResvervationFrame jf = new ResvervationFrame();
		MemberDB memberDB = new MemberDB();
		memberDB.loadingDBMethod();
		System.out.println(memberDB.getListDB());
//		
		jf.initialize6();
//		jf.initialize9();

		
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void initialize6() {
		
		JFrame1 rveframe = new JFrame1();
		ImagePanel panel6 = new ImagePanel(new ImageIcon("src/images/61.jpg").getImage());
		rveframe.add(panel6);
		rveframe.pack();
		
		JLabel revMemberL = new JLabel( MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");
		revMemberL.setFont(new Font("굴림", Font.BOLD, 20));
		revMemberL.setBounds(1272, 40, 224, 32);
		panel6.add(revMemberL);
		
//		rvePriceL = new JLabel();
		rvePriceL.setFont(new Font("굴림", Font.BOLD, 20));
		rvePriceL.setBounds(1406, 662, 119, 32);
		panel6.add(rvePriceL);
		
		
		JButton revHomeBtn = new JButton("");
		revHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		revHomeBtn.setBounds(1193, 30, 49, 42);
		panel6.add(revHomeBtn);
		revHomeBtn.addActionListener(new ActionListener() {  //홈버튼
			public void actionPerformed(ActionEvent e) {
				
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.initialize2();
				rveframe.setVisible(false);
				
				
			}
		});
		
		JButton revResvervationBtn = new JButton("New button");
		revResvervationBtn.setIcon(new ImageIcon("src/buttonImages/예약하기.jpg"));
		revResvervationBtn.setBounds(1272, 802, 252, 49);
		panel6.add(revResvervationBtn);
		revResvervationBtn.addActionListener(new ActionListener() {  //예약하기 버튼
			public void actionPerformed(ActionEvent e) {
				System.out.println(sum);
				
				MemberManager membermanager = new MemberManager();
				membermanager.resvervation(sum);
				System.out.println(rvePriceL.getText());
				sum = 0;
				rveframe.setVisible(false);
				initialize9();
				
			}
		});
		

		for(int i = 0 ; i < 7 ; i++) {
			revPriceCk[i] = new JCheckBox("");
			panel6.add(revPriceCk[i]);
		}
		revPriceCk[0].setBounds(1231, 213, 21, 23);
		revPriceCk[1].setBounds(1231, 261, 21, 23);
		revPriceCk[2].setBounds(1232, 305, 21, 23);
		revPriceCk[3].setBounds(1231, 360, 21, 23);
		revPriceCk[4].setBounds(1232, 409, 21, 23);
		revPriceCk[5].setBounds(1232, 459, 21, 23);
		revPriceCk[6].setBounds(1232, 506, 21, 23);
	
		revPriceCk[0].addItemListener(this);
		revPriceCk[1].addItemListener(this);
		revPriceCk[2].addItemListener(this);
		revPriceCk[3].addItemListener(this);
		revPriceCk[4].addItemListener(this);
		revPriceCk[5].addItemListener(this);
		revPriceCk[6].addItemListener(this);
		
//		System.out.println(sum);
		
		//=====================================================
		
		
		for(int i = 0 ; i < 6 ; i++) {
			rveTimeck[i] = new JCheckBox("");
			panel6.add(rveTimeck[i]);
		}
		
//		rveTimeck[0].setBounds(388, 710, 21, 23);
//		rveTimeck[1].setBounds(609, 710, 21, 23);
//		rveTimeck[2].setBounds(838, 710, 21, 23);
//		rveTimeck[3].setBounds(388, 778, 21, 23);
//		rveTimeck[4].setBounds(609, 778, 21, 23);
//		rveTimeck[5].setBounds(838, 778, 21, 23);
		

		
	}
	
	
	
	
	
	
	public void initialize9() {
		JFrame1 frame = new JFrame1();
		JoinFrame joinframe = new JoinFrame();
		
		boolean is = false;
		if(is) {
			ImagePanel panel9 = new ImagePanel(new ImageIcon("src/images/9.jpg").getImage());
			frame.add(panel9);		
			frame.pack();
			
			
			JButton revnoBtn = new JButton("New button");
			revnoBtn.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
			revnoBtn.setBounds(898, 486, 177, 53);
			panel9.add(revnoBtn);
			revnoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					initialize6();
					
					
				}
			});
			
			
			JButton revyesBtn = new JButton("New button");
			revyesBtn.setIcon(new ImageIcon("src/buttonImages/예.png"));
			revyesBtn.setBounds(572, 486, 185, 53);
			panel9.add(revyesBtn);
			revyesBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.initialize2();
					
				}
			});
			
		}else {
			ImagePanel panel10 = new ImagePanel(new ImageIcon("src/images/10.jpg").getImage());
			frame.add(panel10);
			frame.pack();
			
			JButton rvenoBtn1 = new JButton("New button");
			rvenoBtn1.setIcon(new ImageIcon("src/buttonImages/예.png"));
			rvenoBtn1.setBounds(731, 484, 184, 49);
			panel10.add(rvenoBtn1);
			rvenoBtn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					initialize6();
					
				}
			});
			
			
		}
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		int sum1 = 0 ;
//		int sum2 = 0;
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if(e.getItem() == revPriceCk[0]) {
				sum += 10;
			}else if(e.getItem() == revPriceCk[1]) {
				sum += 30;
			}else if(e.getItem() == revPriceCk[2]) {
				sum += 25;
			}else if(e.getItem() == revPriceCk[3]) {
				sum += 110;
			}else if(e.getItem() == revPriceCk[4]) {
				sum += 110;
			}else if(e.getItem() == revPriceCk[5]) {
				sum += 70;
			}else if(e.getItem() == revPriceCk[6]) {
				sum += 130;
			}
//			System.out.println(sum);
		}else {
			if(e.getItem() == revPriceCk[0]) {
				sum -= 10;
			}else if(e.getItem() == revPriceCk[1]) {
				sum -= 30;
			}else if(e.getItem() == revPriceCk[2]) {
				sum -= 25;
			}else if(e.getItem() == revPriceCk[3]) {
				sum -= 110;
			}else if(e.getItem() == revPriceCk[4]) {
				sum -= 110;
			}else if(e.getItem() == revPriceCk[5]) {
				sum -= 70;
			}else if(e.getItem() == revPriceCk[6]) {
				sum -= 130;
			}
			
		}
		
		rvePriceL.setText(sum + ",000원");
		
		
		
	}

}
