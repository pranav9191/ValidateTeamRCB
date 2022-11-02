package basepackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class TestListner implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		ExtentTest test = extent.createTest(result.getTestClass().getName()+ "::" + result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		String logTest = "<b> Test method " + result.getMethod().getMethodName() + " Successfull<b>";
		Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}
	
	public void onFinish(ITestContext context)
	{
		if(extent!=null) extent.flush();
	}
}
