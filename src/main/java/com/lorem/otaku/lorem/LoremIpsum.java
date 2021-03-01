package com.lorem.otaku.lorem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LoremIpsum implements Lorem{
    
    /*
	 * this command was useful:
	 * 
	 * cat lorem.txt | sed -e 's/[,;.]//g' | sed -e 's/ /\n/g' | sed -e \
	 * 'y/ABCDEFGHIJKLMNOPQRSTUVWXYZ/abcdefghijklmnopqrstuvwxyz/' | sort | \
	 * uniq > lorem.txt.2
	 */
	private static LoremIpsum instance;

	private List<String> words = new ArrayList<String>();
	private Random random = new Random();

	public static LoremIpsum getInstance(String data) {
		instance = new LoremIpsum(new Random(),data);
		return instance;
	}

	public LoremIpsum(String data) {
		this(new Random(),data);
	}
	
	public LoremIpsum(Long seed,String data) {
		this(seed == null ? new Random() : new Random(seed),data);
	}

	public LoremIpsum(Random random,String data) {
		this.random = random;
		words = readLines(data);
	}

	private List<String> readLines(String file) {
		List<String> ret = new ArrayList<String>();
		BufferedReader br = null;
		try {
		
			//no funciona FFFF
			/*br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(file), "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				ret.add(line.trim());
			}*/
			
			//este si funciona
			Scanner s = new Scanner(new File(file));
			while (s.hasNext()){
				ret.add(s.next());
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getTitle(int)
	 */
	@Override
	public String getTitle(int count) {
		return getWords(count, count, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getTitle(int, int)
	 */
	@Override
	public String getTitle(int min, int max) {
		return getWords(min, max, true);
	}

	private int getCount(int min, int max) {
		if (min < 0)
			min = 0;
		if (max < min)
			max = min;
		int count = max != min ? random.nextInt(max - min) + min : min;
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getHtmlParagraphs(int, int)
	 */
	@Override
	public String getHtmlParagraphs(int min, int max) {
		int count = getCount(min, max);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("<p>");
			sb.append(getParagraphs(1, 1));
			sb.append("</p>");
		}
		return sb.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getParagraphs(int, int)
	 */
	@Override
	public String getParagraphs(int min, int max) {
		int count = getCount(min, max);
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < count; j++) {
			int sentences = random.nextInt(5) + 2; // 2 to 6
			for (int i = 0; i < sentences; i++) {
				String first = getWords(1, 1, false);
				first = first.substring(0, 1).toUpperCase()
						+ first.substring(1);
				sb.append(first+" ");

				sb.append(getWords(2, 20, false));
				sb.append(".  ");
			}
			sb.append("\n");
		}
		return sb.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getUrl()
	 */

	private String getWords(int min, int max, boolean title) {
		int count = getCount(min, max);
		return getWords(count, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getWords(int)
	 */
	@Override
	public String getWords(int count) {
		return getWords(count, count, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thedeanda.lorem.Lorem#getWords(int, int)
	 */
	@Override
	public String getWords(int min, int max) {
		return getWords(min, max, false);
	}

	private String getWords(int count, boolean title) {
		StringBuilder sb = new StringBuilder();
		int size = words.size();
		int wordCount = 0;
		while (wordCount < count) {
			String word = words.get(random.nextInt(size));
			if (title) {
				if (wordCount == 0 || word.length() > 3) {
					word = word.substring(0, 1).toUpperCase()
							+ word.substring(1);
				}
			}
			sb.append(word);
			sb.append(" ");
			wordCount++;
		}
		return sb.toString().trim();
	}

	/*private String getRandom(List<String> list) {
		int size = list.size();
		return list.get(random.nextInt(size));
	}*/

}
