package mini;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
		MemberDB memberDB = new MemberDB();
		memberDB.loadingDBMethod();
		System.out.println(memberDB.getListDB());
		
		lf.initialize1();
		//
//				Scanner sc = new Scanner(System.in);
//				MemberDB memberDB = new MemberDB();
//				MemberManager memberManager = new MemberManager();
//				
//				memberDB.loadingDBMethod();
//				System.out.println(memberDB.getListDB());
				
//				mainFrame mainframe = new mainFrame();
				
		
				
//				while(true) {
//					System.out.println("======회원관리 프로그램======");
//					System.out.println("1.로그인");
//					System.out.println("2.회원 가입");
//					System.out.println("3.개인정보확인 ");
//					System.out.println("4.회원탈퇴");
//					System.out.println("5.비번변경");
//					System.out.println("9.프로그램 종료");
//					System.out.print("메뉴 선택 :");
//		
//					int no = sc.nextInt();
//					sc.nextLine();
//					
//					switch(no) {
//					case 1 : memberManager.login(); break;
//					case 2 : memberManager.Join(); break;
//					case 3 : memberManager.Info(); break;
//					case 4 : memberManager.MemberDelete(); break;
//					case 5 : memberManager.EditInfo(); break;
//					
//					case 9 : return ;
//					default: 
//					}
//				}
				
				
				
//				MemberDB memberDB = new MemberDB();	
//				memberDB.loadingDBMethod();
//				memberDB.menberUpdate();
//				System.out.println(MemberDB.getListDB());
//				MemberDB.listDB.get(0).setName("박광복");
//				MemberDB.listDB.remove(2);
//				System.out.println(MemberDB.getListDB());
//				

//				System.out.println(MemberDB.getListDB());
				
				

			}

}
