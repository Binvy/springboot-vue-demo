package com.binvi.springboot.demo03.book.effectivejava.item58;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import javax.smartcardio.Card;
import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author binvi
 * @version 1.0
 * @Description: for-each循环优先于传统的for循环
 * @date 2019/9/5 21:54
 */
public class ForEachTest {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	enum Suit {CLUB, DIAMOND, HEART, SPADE}
	enum Rank {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

	enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}

	static Collection<Suit> suits =  Arrays.asList(Suit.values());
	static Collection<Rank> ranks =  Arrays.asList(Rank.values());

	static Collection<Face> faces = EnumSet.allOf(Face.class);

	public static void main(String[] args) throws JsonProcessingException {

		System.out.println("================ for each one list ================");
		for (Face i : faces) {
			for (Face j : faces) {
				System.out.println(i + " " + j);
			}
		}

		System.out.println("================ for each two list ================");
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				System.out.println(suit + " " + rank);
			}
		}

		System.out.println("================ for same list's iterator ================");
		for (Iterator<Face> i = faces.iterator(); i.hasNext();) {
			for (Iterator<Face> j = faces.iterator(); j.hasNext();) {
				System.out.println(i.next() + " " + j.next());
			}
		}

		List<Card> cards = Lists.newArrayList();
		System.out.println("================ fix for two different list's iterator from outside ================");
		for (Iterator<Rank> i = ranks.iterator(); i.hasNext();) {
			Rank rank = i.next();
			for (Iterator<Suit> j = suits.iterator(); j.hasNext();) {
				Suit suit = j.next();
				Card card = new Card(suit, rank);
				System.out.printf("%10s%10s:%20s\n", rank, suit, card);
				cards.add(card);
			}
		}

		System.out.println("================ fix for two different list's iterator from inside ================");
		for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
			Suit suit = i.next();
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
				Rank rank = j.next();
				Card card = new Card(suit, rank);
				System.out.printf("%10s%10s:%20s\n", rank, suit, card);
				cards.add(card);
			}
		}

		/**
		 * 从外部循环调用
		 */
		System.out.println("================ for two different list's iterator from outside ================");
		for (Iterator<Rank> i = ranks.iterator(); i.hasNext();) {
			for (Iterator<Suit> j = suits.iterator(); j.hasNext();) {
				Rank rank = i.next();
				Suit suit = j.next();
				Card card = new Card(suit, rank);
				System.out.printf("%10s%10s:%20s\n", rank, suit, card);
				cards.add(card);
			}
		}

		/**
		 * 从内部循环调用
		 */
		System.out.println("================ for two different list's iterator from inside ================");
		for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
 				cards.add(new Card(i.next(), j.next()));
			}
		}
		System.out.println(cards);
	}

	private static class Card {
		private Suit suit;
		private Rank rank;
		public Card(Suit suit, Rank rank) {
			this.suit = suit;
			this.rank = rank;
		}

		@Override
		public String toString() {
			return "card[" + this.suit.toString() + "," + this.rank.toString() + "]";
		}
	}

}

