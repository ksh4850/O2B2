package mini;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MemberManager {

	public static int memberNumber = 0;

	public void Join(String id, String pwd, String name, String adrr, String birthDate, String gender) { // 회원가입

		MemberDB memberDB = new MemberDB();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String signupDate = date.format(new Date());

		Member user = new Member(id, pwd, name, adrr, birthDate, gender, signupDate, null, null, 0);
		System.out.println(user.toString());

		memberDB.menberUpdate(user);
		memberDB.loadingDBMethod();
		System.out.println("저장 디비" + memberDB.getListDB());

	}

	public void idCheck(String id) { // 아이디체크

		boolean isTrue = true;
		for (int j = 0; j < MemberDB.listDB.size(); j++) {
			if (id.equals(MemberDB.listDB.get(j).getId())) {
				JOptionPane.showInternalMessageDialog(null, "동일한 아이디가 존재합니다.");
				isTrue = false;
				break;
			}

		}

		if (isTrue) {
			JOptionPane.showInternalMessageDialog(null, "사용 가능한 아이디입니다.");
		}
//			
	}

	public boolean pwdCheck(String pwd1, String pwd2) { // 비번체크

		boolean isTrue = true;
		if (!(pwd1.equals(pwd2))) {
			JOptionPane.showInternalMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			isTrue = false;
		}
		return isTrue;

	}

	public boolean birthDateCheck(String BirthDate) { // 생년월일 체크

		boolean isTrue = true;
		for (int j = 0; j < BirthDate.length(); j++) {
			char ch = BirthDate.charAt(j);
			if (!((ch >= '0' && ch <= '9') && BirthDate.length() == 8)) {

				JOptionPane.showInternalMessageDialog(null, "생년월일을 잘못입력하셧습니다. ex)19920513");
				isTrue = false;
				break;
			}
		}

		return isTrue;

	}

	public boolean login(String id, String pwd) { // 로그인

		boolean login = false;

		for (int i = 0; i < MemberDB.listDB.size(); i++) {

			// ArrayList 에 저장한 회원정보에서 아이디 비교
//				0번 인덱스는 미리 가입해둔 마스터 계정 => 마스터 계정 로그인 화면 출력

			if (i == 0) { //0번 인덱스에 마스터 계정 생성
				if (id.equals(MemberDB.listDB.get(0).getId()) && pwd.equals(MemberDB.listDB.get(0).getPwd())) {
					JOptionPane.showInternalMessageDialog(null, "마스터 계정에서 로그인 되었습니다.");
					login = true;
					MemberManager.memberNumber = i;
					break;
				}else if (id.equals(MemberDB.listDB.get(0).getId()) && !pwd.equals(MemberDB.listDB.get(0).getPwd())) {
					JOptionPane.showInternalMessageDialog(null, "마스터 계정에서 비밀번호가 틀렸습니다.");
					break;
				}
			} else {
				if (id.equals(MemberDB.listDB.get(i).getId()) && pwd.equals(MemberDB.listDB.get(i).getPwd())) {
					MemberManager.memberNumber = i;
					login = true;
					break;
				} 
				if (id.equals(MemberDB.listDB.get(i).getId()) && !pwd.equals(MemberDB.listDB.get(i).getPwd())) {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 확인해주세요.");
					break;
				}
				if (!id.equals(MemberDB.listDB.get(i).getId())) {
					JOptionPane.showMessageDialog(null, "가입된 아이디가 없습니다. 회원가입 후 이용해주세요.");
					break;
				}

			}


		}
		return login;
	}

	public void Info() {

//			infoFrame.setInfoNameT(MemberDB.listDB.get(MemberManager.memberNumber).getName()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getName());
//			infoFrame.setInfoBirthDateT(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate());
//			infoFrame.setInfoAdrrTMemberDB.(listDB.get(MemberManager.memberNumber).getAdrr()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getAdrr());
//			infoFrame.setInfoSignupDate(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate()); //.setText(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate());

//			infoFrame.setInfoNameT("안녕하세요");
//			infoFrame.setInfoBirthDateT()

	}

	public void MemberDelete() { // 회원 탈퇴

		MemberDB memberDB = new MemberDB();

		MemberDB.listDB.remove(MemberManager.memberNumber);
		memberDB.informationChang();
		JOptionPane.showInternalMessageDialog(null, "탈퇴되었습니다. 다시오지마세요");

	}

	public boolean EditInfopwd(String id, String BirthDate) {// 비번 변경전 정보확인

		boolean isTrue = false;
		if (id.equals(MemberDB.listDB.get(MemberManager.memberNumber).getId())) {
			if (BirthDate.equals(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate())) {
				isTrue = true;
			} else {
				JOptionPane.showInternalMessageDialog(null, "생년월일이 틀렸습니다.");

			}

		} else {
			JOptionPane.showInternalMessageDialog(null, "아이디가 틀렸습니다.");

		}

		return isTrue;

	}

	public boolean changedPwd(String pwd1, String pwd2) { // 비번변경

		boolean isTrue = false;

		if (pwd1.equals(pwd2)) {

			MemberDB.listDB.get(MemberManager.memberNumber).setPwd(pwd1);
			MemberDB memberDB = new MemberDB();
			memberDB.informationChang();
			isTrue = true;

			JOptionPane.showInternalMessageDialog(null, "비밀번호가 변경되었습니다.");

		} else {
			JOptionPane.showInternalMessageDialog(null, "비밀번호가 일치하지 않습니다.");

		}

		return isTrue;

	}

	public void resvervation(int sum) {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String revDate = date.format(new Date());
		MemberDB memberDB = new MemberDB();

		MemberDB.listDB.get(MemberManager.memberNumber).setPrice(sum * 1000);
		MemberDB.listDB.get(MemberManager.memberNumber).setRevDate(revDate);
		;
		memberDB.informationChang();
		System.out.println(MemberDB.listDB.get(MemberManager.memberNumber));

	}

}
