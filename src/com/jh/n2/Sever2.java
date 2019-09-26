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

import com.jh.n2.food.MenuMaker;
import com.jh.n2.network.Network;

public class Sever2 {


	public static void main(String[] args) {
		Network network = new Network();
		MenuMaker m = new MenuMaker();
		m.init();
		String menu = m.selectMenu("");
		System.out.println(menu);

		Scanner ssc = new Scanner(System.in);
		FileReader fr = null;
		ArrayList<String> ar = new ArrayList<String>();
		Random random = new Random();
		boolean check =true;

		try {
			ServerSocket ss = new ServerSocket(8282);
			Socket sc = ss.accept();
			String select = network.receive(sc);
			
			menu = m.selectMenu(select);
			
			network.send(sc, menu);
			
			} catch (Exception e) {

				e.printStackTrace();
			}
		}


	}


