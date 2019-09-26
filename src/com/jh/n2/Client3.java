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
		Network network = new Network();
		String id = null;
		String pw = null;
		String login = id+","+pw;
		
		try {
			Socket sc = new Socket("211.238.142.27", 8282);
			System.out.println("Id 입력");
			System.out.println("Pw 입력");
			id = ssc.next();
			pw = ssc.next();
			network.send(sc, login);
			
			login = network.receive(sc);
			System.out.println(login);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
			

	}


