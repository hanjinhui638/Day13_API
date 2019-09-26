package com.jh.n2.food;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MenuMaker {
	private ArrayList<String> lunchs;
	private ArrayList<String> dinners;

	public String selectMenu(String select) {
		Random random = new Random();
		String menu = null;
		if(select.equals("1")) {
			menu = lunchs.get(random.nextInt(lunchs.size()));
		}else {
			menu = dinners.get(random.nextInt(dinners.size()));
		}

		return menu;
	}

	public void init() {
		this.lunchs	=	this.makeMenu("lunch.txt", "-");
		this.dinners = this.makeMenu("dinner.txt", ",");
	}

	public ArrayList<String> makeMenu(String fileName, String delin) {
		File file = new File("c:\\test", fileName);
		FileReader fr = null;
		BufferedReader br =null;
		boolean check =true;
		ArrayList<String> ar = new ArrayList<String>();		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(check) {
				String str = br.readLine();
				if(str ==null) {
					break;
				}
				StringTokenizer st = new StringTokenizer(str,delin);
				while(st.hasMoreTokens()) {
					String s = st.nextToken();
					ar.add(st.nextToken().trim());
				}
			}//바깥 while

		}catch (Exception e){

			e.printStackTrace();
		}
		return ar;
	}
}
