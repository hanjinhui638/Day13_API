package com.jh.n2;

import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.jh.n2.member.Member;
import com.jh.n2.member.MemberService;
import com.jh.n2.network.Network;

public class Server3 {

	public static void main(String[] args) {


		// init -> socket
		// id, pw를 분리 
		// 파싱 클레스 
		ServerSocket ss = null;
		Socket sc = null;
		MemberService ms = new MemberService();
		Network nw = new Network();

		Scanner ssc = new Scanner(System.in);
		System.out.println();

		try {
			ms.init();
			ss = new ServerSocket(8282);
			sc = ss.accept();
			String msg = nw.receive(sc); //id,pw
			String[] info = msg.split(",");
			Member member = new Member();
			member.setId(info[0]);
			member.setPw(info[1]);

			member = ms.memberlogin(member);
			msg = "0"; //로그인 실패

			if(member !=null) {
				msg ="1";//로그인 성공
			}
			nw.send(sc,msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
