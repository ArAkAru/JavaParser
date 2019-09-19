package com.arakaru;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public static void main(String[] args) throws IOException {
		List<Items> items = new ArrayList<>();
		Document document = Jsoup.connect("https://ria.ru/politics/").get();
		Elements allElem =document.getElementsByAttributeValue("class", "list-item__content");
		
		allElem.forEach(elements->{
			Element elem= elements.child(1);
			String url = elem.attr("href");
			String title = elem.text();
			items.add(new Items(url,title));
		});

		items.forEach(value->System.out.println(value));
	}

}
