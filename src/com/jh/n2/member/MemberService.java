package com.jh.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
;

public class MemberService {

	private HashMap<String, Member> map;

	//init 메서드
	//파일의 내용을 읽어서 파싱 작업

	//memberLogin  메서드
	//id, pw 매개변수를 받아서 로그인 유무를 검증.. 	

	/**public static void main(String[] args) {
		MemberService ms = new MemberService();
		try {
			ms.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}**/

	public HashMap<String, Member> init() throws Exception {

		this.map = new HashMap<String, Member>();
		File file = new File("c:\\test","member.txt");
		//System.out.println(file.exists());
		FileReader fr = new FileReader(file);
		BufferedReader br =new BufferedReader(fr);
		boolean check =true;

		while(check) {
			String str = br.readLine();
			if(str ==null) {
				break;
			}
			//System.out.println(str); 
			str.trim();
			StringTokenizer st = new StringTokenizer(str,",");

			while(st.hasMoreTokens()) {
				Member member = new Member();
				member.setId(st.nextToken().trim()); //id
				member.setPw(st.nextToken().trim()); //pw
				map.put(member.getId(), member);
			}

		}//바깥쪽 while 끝

		/**Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String k	= it.next();
				Member	m =	map.get(k);
				System.out.println(m.getId());
				System.out.println(m.getPw());
			}**/

		return map;
	}


	//로그인 실패 null
	public Member memberlogin(Member member) {  // = String id, String pw 
		Member m = map.get(member.getId());
		if(m != null) {
			if(m.getPw().equals(member.getPw())) {
				///////추가정보 대입.. 
			}else {
				m = null;
			}
		}
		return m;
	}
}



