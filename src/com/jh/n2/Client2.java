package com.jh.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.jh.n2.network.Network;


public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 점심메뉴 
		//2. 저녁메뉴 
		
		Scanner ssc = new Scanner(System.in);
		Network network = new Network();
		
		try {
			Socket sc = new Socket("211.238.142.27", 8282); //localhost //127.0.0.1
			System.out.println("1. 점심메뉴");
			System.out.println("2. 저녁메뉴");
			String select = ssc.next();
			network.send(sc, select);
			
			select = network.receive(sc);
			System.out.println(select);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
			
			
		
		
	}

}
