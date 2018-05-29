package com.soulstrk.crlexer;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Crl_Main {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.tiobe.com/tiobe-index/").get();

			Element rank = doc.select(".table tbody").get(0);
			Elements ranks = rank.select("tr"); 

			for (Element e : ranks) {
				System.out.println(e.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
