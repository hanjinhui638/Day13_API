package com.jh.n2;


import java.net.Socket;
import java.util.Scanner;
import com.jh.n2.network.Network;

public class Client3 {

	public static void main(String[] args) {


		// Id 입력
		// pw 입력 //더하기로 같이 전송 //server에서 분리 
		// 서버로 전송 


		Scanner ssc = new Scanner(System.in);
		Network nw = new Network();
		System.out.println("Id를 입력하세요");
		String id = ssc.next();
		System.out.println("Pw를 입력하세요");
		String pw = ssc.next();
		String msg = id+","+pw;
		Socket sk =null;

		try {
			sk = new Socket("211.238.142.27", 8282);
			nw.send(sk, msg);
			msg = nw.receive(sk);

			if(msg.equals("1")) {
				System.out.println(id + "님 환영합니다");
			}else {
				System.out.println("로그인 실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}


