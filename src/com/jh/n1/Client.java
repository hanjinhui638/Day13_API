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


public class Client {

	public static void main(String[] args) {
		//1 단계 

		Socket sc =null;
		OutputStream os = null;
		OutputStreamWriter ow =null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);
		ServerSocket ss = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {
			boolean check = true;

			sc = new Socket("211.238.142.27", 8282);

			while(check) {
				System.out.println("서버로 전송할 메세지 입력");
				String str = ssc.next();
				os = sc.getOutputStream(); //byte
				ow = new OutputStreamWriter(os); //char 
				bw = new BufferedWriter(ow);
				bw.write(str+"\r\n");
				bw.flush();
				if(str.toUpperCase().equals("Q")) {
					check=false;
					System.out.println("상대방이 프로그램 종료");
					break;
				}
				System.out.println("서버로 전송 완료");

				is = sc.getInputStream(); //byte
				ir = new InputStreamReader(is);//char
				br = new BufferedReader(ir); //String 
				str =br.readLine();
				if(str.toUpperCase().equals("Q")) {
					check=false;
					System.out.println("상대방이 프로그램 종료");
					break;

				}
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
