package basepackage;
import java.io.File;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	static ExtentHtmlReporter htmlReport;
	
	public static ExtentReports createInstance()
	{
		String fileName = getReportName();
		String directory = System.getProperty("user.dir")+"/reports/";
		new File(directory).mkdir();
		String path = directory + fileName;
		htmlReport = new ExtentHtmlReporter(path);
		htmlReport.config().setEncoding("uft-8");
		htmlReport.config().setDocumentTitle("Automation Result");
		htmlReport.config().setReportName("Automation Test Result");
		htmlReport.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		
		return extent;
		
	}
	
	public static String getReportName()
	{
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		LocalDateTime date = LocalDateTime.now();
		String fileName = "Automation_Report_" + dft.format(date).toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

}
