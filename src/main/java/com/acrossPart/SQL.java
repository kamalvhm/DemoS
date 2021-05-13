package com.acrossPart;

public class SQL {
	/**
	 * Tip - if consecutive in quetion think of self join or Lead lag 
	 * @param args
	 */
	
	
	
//DATA ENGINEER DOC :-https://docs.google.com/spreadsheets/d/1djhTq4vD72lzuLY2rCMOkkSuNG2rRf_C5PwNMjcIAMk/edit#gid=859146723
	//https://towardsdatascience.com/how-to-prepare-for-your-data-engineering-interview-d245519da45c
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
		
/*	
 * Query the list of CITY names from STATION that either do not start with vowels or do not end with vowels. Your result cannot contain duplicates.
 * 
 	select DISTINCT CITY  from STATION where LOWER(SUBSTR(CITY,0,1)) NOT IN ('a','e','i','o','u')
		OR LOWER(SUBSTR(CITY,LENGTH(CITY),1)) NOT IN ('a','e','i','o','u');*/
		
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
		
		String Delete_Duplicate_Emails_196="delete p2\r\n" + 
				"from Person p1 join Person p2 \r\n" + 
				"on  p1.Email=p2.Email and p1.id < p2.id ;";
		
		//178. Rank Scores  WINDOW FUNCTION DENSE_RANK will assign continues ranks without gaps
		//Templete :- AGGREGATE() OVER(PARTITION BY ORDER BY)  :- partition is like group by 
		//SELECT Score, DENSE_RANK() OVER(ORDER BY SCORE DESC)  AS "Rank" FROM Scores
		
		/**https://www.youtube.com/watch?v=l_Zn5sdkamM  | https://www.oracletutorial.com/oracle-analytic-functions/oracle-dense_rank/#:~:text=The%20DENSE_RANK()%20is%20an,rank%20in%20case%20of%20ties.
		* CREATE TABLE Employee (  
				name  VARCHAR2(50 BYTE) NOT NULL,  
				gender VARCHAR2(10 BYTE) NOT NULL, 
				salary NUMBER NOT NULL  
				); 
				INSERT INTO Employee (name,gender,salary)   
				VALUES ('Mira','Female',4000);
				
		****************AGGREGATE WINDOW FUNCTIONS***********
				  	select name,gender,salary ,
					AVG(salary) OVER (partition BY(gender) ORDER BY(Salary) ROWS BETWEEN UNBOUNDED preceding AND unbounded following) as average,
					SUM(salary) OVER (partition BY(gender) ORDER BY(Salary) ROWS BETWEEN UNBOUNDED preceding AND unbounded following) as summ,
					COUNT(salary) OVER (partition BY(gender) ORDER BY(Salary) ROWS BETWEEN UNBOUNDED preceding AND unbounded following) as countt
					FROM Employee;
	    ****************Last_VALUE***********
					select name,gender,salary ,
					last_value(name) OVER (ORDER BY(Salary)) as "Last_value"
					FROM Employee;
			
	    ***********************LEAD AND LAG***************
			*--default offset is 1 we looking one down by one 
					select name,gender,salary ,
					LEAD(salary) OVER (ORDER BY Salary) as "Lead"
					FROM Employee;
				
				
				with offset and default value LAG will look up
					select name,gender,salary ,
					LEAD(salary,2,-1) OVER (ORDER BY Salary) as "Lead",
					LAG(salary,2,-1) OVER (ORDER BY Salary) as "LAG"
					FROM Employee;
					
		**********************RANK AND DENSE_RANKE*****************
					select name,gender,salary ,
					RANK() OVER (ORDER BY salary DESC) as "Rank",
					DENSE_RANK() OVER (ORDER BY salary DESC) as "Dense_Rank"
					FROM Employee;
					
					
		***********************N TH Highest salary using window functions*********************
						WITH response AS 
				(
				              select salary ,gender,
				              DENSE_RANK() OVER (PARTITION BY gender ORDER BY salary DESC) as salary_Rank
				              from Employee
				)
				select * from response where salary_Rank=2 and  gender ='Female' and rownum=1;
				
	   ***********************ROW NUMBER *********************
			  select name,salary ,gender,
              row_number() over (partition by gender order by Gender ) as rowNumber
              from Employee;
        *************************DELETE DUPLICATE ROW IN ***********************
        *https://www.youtube.com/watch?v=ynWgSZBoUkU
				       			with EmployeeCTE as (
											  Select firstname,lastname,gender,salary,
											  row_number() over (partition by id order by id ) as rowNumber
											  from Employees
												)
							   Delete from  EmployeeCTE where rowNumber > 1;
         *************************Employee Hierarchy ***********************
         *https://www.youtube.com/watch?v=GGoV0wTMCg0 and https://www.youtube.com/watch?v=Kd3HTph0Mds
			       		WITH EmployeeCTE AS
							(
							--Anchor
							 Select EmployeeId, EmployeeName, ManagerID
							 From Employees
							 Where EmployeeId = 7
							 
							 UNION ALL
							 --Recursive Member
							 Select Employees.EmployeeId , Employees.EmployeeName, Employees.ManagerID
							 From Employees
							 JOIN EmployeeCTE
							 ON Employees.EmployeeId = EmployeeCTE.ManagerID
							)
			
						Select E1.EmployeeName, ISNULL(E2.EmployeeName, 'No Boss') as ManagerName
						From EmployeeCTE E1
						LEFT Join EmployeeCTE E2
						ON E1.ManagerID = E2.EmployeeId
		 */
	}
	
	
	

}
