package com.jh.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
;

public class MemberService {
	//init 메서드
	//파일의 내용을 읽어서 파싱 작업

	//memberLogin  메서드
	//id, pw 매개변수를 받아서 로그인 유무를 검증.. 	
	ArrayList<Member> ar = new ArrayList<Member>();
	public ArrayList<Member> init() {

		File file = new File("c:\\test","member.txt");
		FileReader fr = null;
		BufferedReader br =null;
		StringTokenizer st =null;
		String str = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			boolean check =true;
			while(check) {
				str =br.readLine();
				if(str ==null) {
					break;
				}
				st = new StringTokenizer(str,",");
				while(st.hasMoreTokens()) {
					Member member = new Member();
					member.setId(st.nextToken().trim());
					member.setPw(st.nextToken().trim());
					ar.add(member);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ar;
	}
	
	
	
	public boolean memberlogin(String id, String pw) {
		boolean check = false;
		for(int i=0; i<ar.size();i++) {
			if(id.equals(ar.get(i).getId()) && 
					pw.equals(ar.get(i).getPw())) {
				System.out.println(ar.get(i).getId()+"확인");
				check = true;
				break;
			}
		
		}
		return check;
	}
}



