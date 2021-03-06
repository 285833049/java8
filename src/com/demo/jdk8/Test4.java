package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test4 {

	public static void main(String[] args) {
		Predicate<String> p = s -> s.length() > 3;
		
		System.out.println(p.test("hello"));
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println("part1------------------");
		findOdd(list);
		System.out.println("part2------------------");
		conditionFilter(list, ppp -> ppp % 2 == 1);
		System.out.println("part3------------------");
		and(list, p1 -> p1 > 3, p2 -> p2 < 7);
		System.out.println("part4------------------");
		or(list,  p1 -> p1 > 3, p2 -> p2 % 2 == 1);
		System.out.println("part5------------------");
		negate(list, p1 -> p1 > 3);
		System.out.println("part6------------------");
		System.out.println(isEqual("abc").test("abcd"));
		
	}
	
	//找到集合中的奇数
	public static void findOdd(List<Integer> list){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 1){
				System.out.println(list.get(i));
			}
		}
	}
	
	public static void conditionFilter(List<Integer> list,Predicate<Integer> p){
		for (int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i))){
				System.out.println(list.get(i));
			}
		}
	}
	
	public static void and(List<Integer> list,Predicate<Integer> p1,Predicate<Integer> p2){
		for (int i = 0; i < list.size(); i++) {
			if(p1.and(p2).test(list.get(i))){
				System.out.println(list.get(i));
			}
		}
	}
	
	public static void or(List<Integer> list,Predicate<Integer> p1,Predicate<Integer> p2){
		for (int i = 0; i < list.size(); i++) {
			if(p1.or(p2).test(list.get(i))){
				System.out.println(list.get(i));
			}
		}
	}
	
	public static void negate(List<Integer> list,Predicate<Integer> p1){
		for (int i = 0; i < list.size(); i++) {
			if(p1.negate().test(list.get(i))){
				System.out.println(list.get(i));
			}
		}
	}
	
	public static Predicate isEqual(Object obj){
		return Predicate.isEqual(obj);
	}
}
