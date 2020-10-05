package com.example;

import java.io.Serializable;

import scala.Tuple4;

public class Key implements Serializable{
	public int one,two,three;

	public Key(int one, int two, int three) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	public static Key create(Tuple4<Integer ,Integer,Integer, Integer> t) {
		return new Key(t._1(),t._2(),t._3());
	}
	
	
	 @Override
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + (int) (one ^ (one >>> 32));
	      result = prime * result + (int) (two ^ (two >>> 32));
	      result = prime * result + (int) (three ^ (three >>> 32));
	      return result;
	   }
	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      Key other = (Key) obj;
	      if (one != other.one)
	         return false;
	      if (two != other.two)
	         return false;
	      if (three != other.three)
	         return false;
	      return true;
	   }
	
}
