package com.jh.n2;

import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.jh.n2.member.Member;
import com.jh.n2.member.MemberService;
import com.jh.n2.network.Network;

public class Server3 {

	public static void main(String[] args) {
		//init -> socket
		// id, pw를 분리 
		//파싱 클레스 
		Network network = new Network();
		MemberService m = new MemberService();
		ArrayList<Member> ar = new ArrayList<Member>();
		ar = m.init();
		Scanner ssc = new Scanner(System.in);
		System.out.println();
		
		try {
			
			ServerSocket ss = new ServerSocket(8282);
			Socket sc = ss.accept();
			String login = network.receive(sc);
			
			String[] w = login.split(",");
			
			boolean check = m.memberlogin(w[0], w[1]);
			
			if(check ==true) {
				login = "로그인성공";
			}else {
				login ="로그인실패";
			}
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
			
	}

}
