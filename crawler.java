package com.Crawling;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class crawler {

	public static void main(String args[]) {

		/*
		 * 
		 * Document 클래스 : 연결해서 얻어온 HTML 전체 문서
		 * 
		 * Element 클래스 : Document의 HTML 요소
		 * 
		 * Elements 클래스 : Element가 모인 자료형
		 * 
		 */

		String url = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=101&sid2=260";

		Document doc = null;

		try {

			doc = Jsoup.connect(url).get(); // html코드를 doc에 저장

		} catch (Exception e) {

			// TODO: handle exception

			e.printStackTrace();

		}
		System.out.println("===================================== 기사제목 =============================================");

		// 주요 뉴스 태그

		Elements title = doc.select(".content"); // .class명

		for (Element ti : title.select("dt")) { // "태그" 하위 뉴스 기사들을 for문 돌리며 출력
			System.out.println(ti.text());

		}

		System.out.println();
		System.out.println(
				"===================================== 사진 source =============================================");
		System.out.println();

		// 기사 사진 source 뽑아오기

		Elements photo = doc.select(".type06_headline"); // .class명

		for (Element ph : photo.select("a")) {
			System.out.println(ph.getElementsByAttribute("href").attr("href")); // a 태그의 href 속성값 전부 print
		}


		System.out.println();
		System.out
				.println("===================================== 기사 url =============================================");
		System.out.println();

		// href 주소 뽑아오기

		Elements links = doc.select(".type06_headline"); // .class명

		for (Element li : links.select("a")) {
			System.out.println(li.getElementsByAttribute("href").attr("href")); // a 태그의 href 속성값 전부 print
		}

	}
}
