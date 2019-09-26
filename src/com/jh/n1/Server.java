package com.jh.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		//ServerSocket
		//Socket 
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow =null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);

		try {
			boolean check = true;

			ss = new ServerSocket(8282);
			while(check) {
				System.out.println("클라이언트 접속 받을 준비중");
				sc = ss.accept();
				is = sc.getInputStream(); //byte
				ir = new InputStreamReader(is);//char
				br = new BufferedReader(ir); //String 
				String str =br.readLine();
				if(str.equals("q")) {
					check=false;
					System.out.println("상대방이 프로그램 종료");
					break;

				}
				System.out.println(str);

				os = sc.getOutputStream(); //byte
				ow = new OutputStreamWriter(os); //char 
				bw = new BufferedWriter(ow);
				System.out.println("클라이언트로 보낼 메세지 입력");
				str = ssc.next();
				bw.write(str+"\r\n");
				bw.flush();
				if(str.equals("q")) {
					check=false;
					System.out.println("프로그램 종료");
					break;

				}
			}



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
