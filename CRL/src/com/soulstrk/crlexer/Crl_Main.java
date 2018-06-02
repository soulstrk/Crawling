package com.soulstrk.crlexer;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crl_Main {

	public static void main(String[] args) {
		
		Date today = new Date();
		
		new EventGuiTest();
			
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();

			Elements songTitle = doc.select(".lst50").select("td:eq(5)").select(".rank01");
			Elements rank = doc.select(".lst50").select("td:eq(1)");
			/*Elements likeCount = doc.select(".button_etc");*/ // 좋아요 갯수 가져오기
			Elements album = doc.select(".lst50").select("td:eq(6)").select(".rank03");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E요일 기준");
			
			System.out.println("가져오 데이터의 갯수:" + songTitle.size());
			
			System.out.println(sdf.format(today));
			
			//System.out.println(likeCount.text());
			
			for (int i = 0; i < songTitle.size(); i++) {
				Element e1 = songTitle.get(i);
				Element e2 = rank.get(i);
				Element e3 = album.get(i);
				
				System.out.println(e2.text()+"-"+e1.text());
				System.out.println("앨범명:"+e3.text());
				System.out.println();
			}
			
			
			//1위 곡이름 , 2위 곡이름 출력방법
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



class EventGuiTest extends JFrame{
	 private static final long serialVersionUID = -711163588504124217L;
	 
	 public EventGuiTest() {
		  super("Event Firer");
		   
		  setBounds(100 , 100 , 300 , 200);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setVisible(true);
		 }
}


