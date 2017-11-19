package core_framework;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {
	public static ExtentReports report;
	
	public static ExtentReports getInstance(){
		if(report==null){
		Date d=new Date();
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
		String reportpath= Global.REPORTS_PATH+fileName;
		report= new ExtentReports(reportpath,true,DisplayOrder.NEWEST_FIRST);
		report.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		}
		return report;
	
	}
}
