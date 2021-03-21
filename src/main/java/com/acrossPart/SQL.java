package com.acrossPart;

public class SQL {

	public static void main(String[] args) {
		//select distinct CITY from STATION where LOWER(SUBSTR(CITY,LENGTH(CITY),1)) NOT IN ('a','e','i','o','u') ;
		String cityWithNoFirstVOwel="Select DISTINCT city from STATION where LOWER(SUBSTR(CITY,0,1)) NOT IN ('a','e','i','o','u');";//orcle
		//sAME fro mYQL select DISTINCT CITY from STATION where CITY NOT REGEXP '^[aeiou]'; // that do not start with vowels. 
		//SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP '[^aiueo]$';  FOR that do not end with vowels
		//SELECT distinct CITY FROM STATION WHERE CITY LIKE '[^aeiou]%[^aeiou]'; //not start and end with vowel MySQLSERVER
		//    select distinct city from station where city regexp '^[^aeiou].*[^aeiou]$';
		
		//ORDER YOUR OUTPUT BY LAST 3 CHAR in NAME //MYSQL
		//SELECT NAME FROM STUDENTS WHERE MARKS > 75 ORDER BY RIGHT(NAME, 3), ID ASC;
		//SELECT (NAME) FROM STUDENTS WHERE MARKS>75 ORDER BY SUBSTR(NAME,-3,3), ID ASC;  ORACLE
		
		String likeWithAtleast3Chrs="SELECT * FROM Customers WHERE CustomerName LIKE 'a__%';";
		//WIld Cards in like 
		
		//SELECT ROUND(AVG(POPULATION)) FROM CITY;  ROUND IN MYSQL

	/** [] =Represents any single character within the brackets
	 	^ =	Represents any character not in the brackets
	 	__ =Represents a single character
	 	- =	Represents a range of characters
	 	% =	Represents zero or more characters
	 	
	  all customers with a City starting with "a", "b", or "c":
	  	SELECT * FROM Customers
		WHERE City LIKE '[a-c]%';
		
	  customers with a City NOT starting with "b", "s", or "p":
		SELECT * FROM Customers
		WHERE City LIKE '[!bsp]%';
		
		BETWEEN OPERATOR
		SELECT * FROM Products
		WHERE Price BETWEEN 10 AND 20;
		
		*/
		
		/**BASIC JOINS 
		 * SELECT city.name
			FROM city
			INNER JOIN country ON city.countrycode = country.code
			WHERE country.continent = 'Africa';
		 * 
		 */
	}

}
