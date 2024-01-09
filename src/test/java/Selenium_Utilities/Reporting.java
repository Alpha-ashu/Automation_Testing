package Selenium_Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentSparkReporter report;

	@BeforeTest
	public void onStart(ITestContext testcontext) {
		// TimeStamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";
		extent = new ExtentReports();
		// Specfic Location Reports
		report = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extend-config.xml" + repName);
		//report.loadXMLConfig(System.getProperty("user.dir")+"/extend-config.xml");

		extent.attachReporter(report);
		extent.setSystemInfo("Host name, localhost", repName);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "pavan");
		// Title of report
		report.config().setDocumentTitle("e-banking Test Project");
		// Name of Report
		report.config().setReportName("Functional Test Automation Report");
		// Location of the Chart
		report.config().setTheme(Theme.DARK);

	}

	public void onTestSucess(ITestResult tr) {
		// Create New Empty in the Report
		logger = extent.createTest(tr.getName());
		// Send the passed Information
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr)
	{
		// Create New entry in the Report
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, "Failure");
		logger.log(Status.INFO, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir:") + "\\Screenshots\\" + tr.getName() + ".png";
		File f = new File(screenshotPath);
		if(f.exists()) 
		{
			logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
	
		}
	}
	
	

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
@AfterTest
	public void onFinish(ITestContext testContext) {
		extent.flush();

	}

}
