package com.lorem.otaku.lorem;


public interface Lorem {

	public String getTitle(int count);

	public String getTitle(int min, int max);

	public String getHtmlParagraphs(int min, int max);

	public String getParagraphs(int min, int max);

	public String getWords(int count);

	public String getWords(int min, int max);

}
