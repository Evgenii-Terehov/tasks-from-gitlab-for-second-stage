package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;
import com.epam.tat.listprocessor.exception.ListProcessorException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 *
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 *
 */
public class ListProcessor implements IListProcessor {

	/**
	 * Find the second by length string in a list.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaaaa", "aaaa", "aaa"}
	 * will be return "aaaa"
	 *
	 * @param list - input data
	 * @return second by length string in the input list
	 */

	@Override
	public String getSecondStringByLength(List<String> list){
		if (list == null) throw new ListProcessorException("The input list can't be null!");
		if (list.size() == 1)
			throw new ListProcessorException("There is ONLY ONE value!");
		if (list.isEmpty() || list.contains(""))
			throw new ListProcessorException("There are NO any values! Empty list!");
		if(Collections.frequency(list, list.get(0)) == list.size())
			throw new ListProcessorException("There is ONLY ONE value!");
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		return list.get(list.size() - 2);
	}

	/**
	 * Sort list by string length.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
	 * will be return
	 * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByLength(List<String> list) {
		if(list == null) throw new ListProcessorException("The input list can't be null!");
		if(list.isEmpty() || list.contains("")) throw new ListProcessorException("There are NO any values! Empty list!");
		list.sort(Comparator.comparing(String::length));
		return list;
	}

	/*
	 * Sort list or array by count of vowels in string.
	 * If the number of vowels in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */

	class SortByNumberOfVowels implements Comparator<String>{
		// здесь на основе сортировки по гласным, сортировка по длине слова
		@Override
		public int compare ( String o1, String o2 ) {
			if (o1.length() == 1)
				return -1;
			if (pointsForVowels(o1) == pointsForVowels(o2)){
				if (o1.length() == o2.length()){
					return 0;
				}else if(o1.length() > o2.length()){
					return 1;
				}return -1;
			}else if(pointsForVowels(o1) > pointsForVowels(o2)){
				return 1;
			}return - 1;
		}
	}
	// тут сортировка по гласным в соответствии с ABC < abc
	public int pointsForVowels ( String o1 ) {
		int points = 0;
		for(int i = 0; i < o1.length();i++) {
			if("aeiou".indexOf(o1.charAt(i)) != -1) {
				points += 2;
				if(i > 0 && "aeiou".indexOf(o1.charAt(i - 1)) != -1) {
					points++;
				}else if(i > 0 && "aeiou".indexOf(o1.charAt(i - 1)) != 1)
					points --;
			}
			if ("AEIOU".indexOf(o1.charAt(i)) != -1)
				points ++;
		}
		if(points == 0)	throw new ListProcessorException("There is no one vowels!");
		return points;
	}

	@Override
	public List<String> getSortedListByCountOfVowels(List<String> list) {
		if(list == null) throw new ListProcessorException("The input list can't be null!");
		if(list.isEmpty() || list.contains("")) throw new ListProcessorException("There are NO any values! Empty list!");
		list.sort(new SortByNumberOfVowels());
		return list;
	}

	/*
	 * Sort list or array by count of consonants in string.
	 * If the number of consonants in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */

	class SortByNumberOfConsonants implements Comparator<String>{
		@Override
		public int compare ( String o1, String o2 ) {
			if (pointsForConsonants(o1) == pointsForConsonants(o2)){
				if (o1.length() == o2.length()){
					return 0;
				}else if(o1.length() > o2.length()){
					return 1;
				}return -1;
			}else if(pointsForConsonants(o1) > pointsForConsonants(o2)){
				return 1;
			}return - 1;
		}
	}

	public int pointsForConsonants ( String o1 ) {
		int points = 0;
		for(int i = 0; i < o1.length();i++) {
			if("bcdfghjklmnpqrstvwxyz".indexOf(o1.charAt(i)) != -1) {
				points += 2;
				if(i > 0 && "bcdfghjklmnpqrstvwxyz".indexOf(o1.charAt(i - 1)) != -1) {
					points++;
				}else if(i > 0 && "bcdfghjklmnpqrstvwxyz".indexOf(o1.charAt(i - 1)) != 1)
					points --;
			}
			if ("BCDFGHJKLMNPQRSTVWXYZ".indexOf(o1.charAt(i)) != -1)
				points ++;
		}
		if(points == 0)	throw new ListProcessorException("There is no one consonants!");
		return points;
	}

	@Override
	public List<String> getSortedListByCountOfConsonants(List<String> list) {
		if(list == null) throw new ListProcessorException("The input list can't be null!");
		if(list.isEmpty() || list.contains("")) throw new ListProcessorException("There are NO any values! Empty list!");
		list.sort(new SortByNumberOfConsonants());
		return list;
	}

	/**
	 * Change by places first and last symbols in each second string of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Puma", "eikN", "Timberland", "sdidaA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
		if(list == null) throw new ListProcessorException("The input list can't be null!");
		if (list.size() == 1)
			throw new ListProcessorException("There is ONLY ONE value!");
		if(list.isEmpty())
			throw new ListProcessorException("There are NO any values! Empty list!");
		for (int replaceSymbol = 1; replaceSymbol < list.size(); replaceSymbol += 2){
			StringBuilder word = new StringBuilder(list.get(replaceSymbol));
			if(list.get(replaceSymbol).length() <= 2){
				continue;
			}
			char firstLetter = list.get(replaceSymbol).charAt(0);
			word.setCharAt(0, word.charAt(list.get(replaceSymbol).length() - 1));
			word.setCharAt(list.get(replaceSymbol).length() - 1, firstLetter);
			list.set(replaceSymbol , word.toString());
		}
		return list;
	}

	/*
	 * Revert strings of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */

	@Override
	public List<String> reverseStringsOfList(List<String> list) {
		if(list==null || list.size() == 0)
			throw new ListProcessorException("There are NO any values! Empty list or it's null!");
		for (int reverseWord = 0; reverseWord < list.size(); reverseWord++){
			list.set(reverseWord, new StringBuilder(list.get(reverseWord)).reverse().toString());
		}
		return list;
	}
}
