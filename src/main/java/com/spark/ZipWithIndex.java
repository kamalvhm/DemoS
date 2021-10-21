package com.spark;

public class ZipWithIndex {
	
	public static void main(String args[]) {
		/*JavaRDD<Reading> readingsRDD = map.filter(r -> r._2 == null).map(r -> r._1);
		int batchSize = 100;
		JavaPairRDD<Reading, Long> readingLongJavaPairRDD = readingsRDD.zipWithIndex();
		JavaPairRDD<Long, Reading> longReadingJavaPairRDD = readingLongJavaPairRDD
				.mapToPair(r -> new Tuple2<>((r._2 / batchSize), r._1));
		List<Reading> list = new ArrayList<>();
		JavaPairRDD<Long, List<Reading>> integerListJavaPairRDD = longReadingJavaPairRDD.aggregateByKey(list,
				(rq0, rq1) -> {
					rq0.add(rq1);
					return rq0;
				}, (rql0, rql1) -> {
					rql0.addAll(rql1);
					return rql0;
				});*/
	}

}
