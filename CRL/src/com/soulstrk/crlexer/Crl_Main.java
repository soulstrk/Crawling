package com.soulstrk.crlexer;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crl_Main {

	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();

			Elements songTitle = doc.select(".lst50").select("td:eq(5)").select(".rank01");
			Elements rank = doc.select(".lst50").select("td:eq(2)");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


