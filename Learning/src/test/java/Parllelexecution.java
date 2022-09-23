
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.edge.EdgeDriver;

        import org.testng.Assert;
        import org.testng.annotations.*;

public class Parllelexecution{

    public WebDriver driver;

    @BeforeTest
    @Parameters("browserType")
    public void setDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\CODOID--PC\\Desktop\\chromedriver.exe");
             driver=new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\CODOID--PC\\Desktop\\msedgedriver.exe");
             driver=new EdgeDriver();

        } else {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\CODOID--PC\\Desktop\\msedgedriver.exe");
            driver=new ChromeDriver();

        }
    }

    @Test
    public void Test1()throws NullPointerException
    {

        driver.get("https://codoid.com/");
        driver.manage().window().maximize();

        String A=driver.getTitle();
        System.out.println(A);
        try {
            Assert.assertTrue(A.contains("Best"));
        } catch (AssertionError e) {
            System.out.println("False");
            throw e;
        }
        System.out.println("True");

    }
@AfterTest
public void close(){
        driver.quit();
}
}








