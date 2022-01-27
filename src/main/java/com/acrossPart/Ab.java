package com.acrossPart;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Ab {

	public static void main(String[] args) throws IOException {
		ZonedDateTime usage = ZonedDateTime.parse("2018-07-01T16:01:00.000+03:00");
		ZonedDateTime cut = ZonedDateTime.parse("2018-07-01T16:01:00.000+03:00");
		//System.out.println((usage.isBefore(cut)));
		System.out.println(usage.isAfter(cut));
		//System.out.println(t1.isEqual(t2));
		
//		int[] a= {1,0,2,1,0,2};
//		partition(a,0,a.length-1);
//		System.out.print(Arrays.toString(a));
		
		/*Long enumSixtyToFifteen=new Long(1);
		int i=1;
		Long.valueOf(i);
		System.out.print("EQ "+(enumSixtyToFifteen.equals(Long.valueOf(i))));

		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.indexOf(1);*/	
		
		/*//print(5);
		//System.out.println("A".compareTo("Z"));
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		Dataset<Row> weatherDataset = spark.read().option("header", true).csv("src/main/resources/weather.txt");
		JavaRDD<Weather> wheatherRDD = weatherDataset.toJavaRDD().repartition(2).map(line -> {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String[] parts = line.split(",");
			Weather w = new Weather();
			w.setId(Integer.parseInt(parts[0].trim()));
			w.setDate(formatter.parse(parts[1].trim()));
			w.setTemp(Integer.parseInt(parts[2].trim()));
			return w;
		});
		Dataset<Row> NewweatherDataset=weatherDataset.withColumn("Centi", functions.lit(col("TEMP")));
		NewweatherDataset.printSchema();
		NewweatherDataset.show(10,false);
		List<Weather> result1=wheatherRDD.take(2);
		result1.forEach(v->System.out.println(v));
		
		//Now transforming F to C formula C=(F-32)*5/9 

		//dF.write.format("parquet").save("<<location>>");
*/
		
		
	}
	public static String[] codes = {"","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

	public static ArrayList<String> getKPC(String str){
		if(str.length()==0) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		char ch=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> rres=getKPC(ros);
		ArrayList<String> mres=new ArrayList<>();
		for(char c:codes[ch-'0'].toCharArray()) {
			for(String s:rres)
				mres.add(c+s);
		}
		return mres;
	}
	
	public static ArrayList<String> getStairsPath(int n){
		if(n==0) {
			ArrayList<String> path=new ArrayList<>();
			path.add("");
			return path;
		}else if(n<0) {
			ArrayList<String> path=new ArrayList<>();
			return path;
		}
		ArrayList<String> p1=getStairsPath(n-1);
		ArrayList<String> p2=getStairsPath(n-2);
		ArrayList<String> p3=getStairsPath(n-3);
		ArrayList<String> path=new ArrayList<>();
		for(String p:p1)
			path.add(1+p);
		for(String p:p2)
			path.add(2+p);
		for(String p:p3)
			path.add(3+p);
		return path;
	}
	
	private static void partition(int[] a, int start, int end) {
		int pivot=a[end];
		int pIndex=start;
		for(int i=start;i<end;i++) {
			if(a[i]<pivot) {
				swap(a, pIndex, i);
				pIndex++;
			}
		}
		swap(a,pIndex, end);
	}
	
	public static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static void reverse(int a[]){
        int i=0,j=a.length-1;
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }
	

	private static void print(int n) {
		if(n==0)
			return;
		System.out.println(n);
		print(n-1);
	}

	public static void solve() {
		Scanner s = new Scanner(System.in);
		long row = s.nextLong();
		long column = row;
		HashSet<Long> rowcount = new HashSet();
		HashSet<Long> coulumncount = new HashSet();

		long testcase = s.nextLong();

		for (long x = 0; x < testcase; x++) {
			long r = s.nextLong();
			long c = s.nextLong();
			if (!rowcount.contains(r)) {
				row--;
				rowcount.add(r);
			}

			if (!coulumncount.contains(c)) {
				column--;
				coulumncount.add(c);
			}

			System.out.print(row * column + " ");
		}
	}
	
	
	
}
