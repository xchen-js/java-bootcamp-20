package homework6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



public class TeslaReportApp {

	public static void main(String[] args) {
	    String dirname = "data";
		List<String> filenames = Arrays.asList(
				"model3.csv",
				"modelS.csv",
				"modelX.csv");
		
		for (String filename: filenames) {
			String type = filename.substring(0, filename.indexOf("."));
			System.out.println();
			System.out.println(type
					+" Yearly Sales Report\n *****************");
			List<SalesReport> reportList = readLinesFromFile(dirname, filename);		
			//printSorted(reportList, Comparator.comparing(SalesReport::getAmount));
			Set<Integer> yearSet = reportList.stream()
					                .map(e->e.getMonth().getYear())
					                .collect(Collectors.toSet());
			yearSet.forEach(e-> printYearlyReport (e, reportList));
			
			printMinimum(type, reportList, Comparator.comparing(SalesReport::getAmount) );
			printMaximum(type, reportList, Comparator.comparing(SalesReport::getAmount) );	
			
		}

	}
	private static List<SalesReport> readLinesFromFile(String dirname, String filename) {
		Path fn = Paths.get(dirname+File.separator+filename);
		List<SalesReport> reportList = new ArrayList<>();	 
		try {
			Files.lines(fn)
					.skip(1)
					.forEach(line -> {						
						List<String> lineStr = Arrays.asList(line.split(","));						
						SalesReport sr = new SalesReport(
								YearMonth.parse((String)lineStr.get(0), DateTimeFormatter.ofPattern("MMM-yy")),
								Integer.parseInt(((String)lineStr.get(1))));
				    	reportList.add(sr);	
					});
			 
			
		} catch (IOException e) {
			System.out.println("oops. I/O excetioon");
			e.printStackTrace();
		}
		return reportList;
		
	
	}
	public static void printSorted (List<SalesReport> reportList, Comparator<SalesReport> comparator) {
		reportList.stream()
		      .sorted(comparator)
		      .map(sales -> sales.getMonth()+" "+sales.getAmount())
		      .forEach(System.out::println);
		      
		
	}
	public static void printYearlyReport (Integer year, List<SalesReport> reportList) {
	 Integer sum = reportList.stream()
				.filter (e->e.getMonth().getYear()==year)
				.map(a -> a.getAmount())
				.reduce (0, (a,c)->a+c);
	 System.out.println(year+"--> "+sum);
	}
	
	public static void printMinimum (String type, List<SalesReport> reportList, Comparator<SalesReport> comparator) {
		 Optional<SalesReport> min = reportList.stream()
		      .min(comparator);
		System.out.println ("the worst month for "+type+" is: "+min.get().getMonth()+", the sales is "+min.get().getAmount());
		       	
	}
	
	public static void printMaximum (String type, List<SalesReport> reportList, Comparator<SalesReport> comparator) {
		 Optional<SalesReport> max = reportList.stream()
		      .max(comparator);
		System.out.println ("the best month for "+type+" is: "+max.get().getMonth()+", the sales is "+max.get().getAmount());
		       	
	}

}
