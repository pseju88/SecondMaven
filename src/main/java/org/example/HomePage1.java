//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of selenium WbDriver
import org.openqa.selenium.WebDriver;
//importing a package of ChromeDriver
import org.openqa.selenium.chrome.ChromeDriver;
//importing a package of AfterMethod
import org.testng.annotations.AfterMethod;
//importing a package of BeforeMethod
import org.testng.annotations.BeforeMethod;
//importing a package of Test
import org.testng.annotations.Test;
//It allows for formatting (date -> text), parsing (text -> date), and normalization.
import java.text.SimpleDateFormat;

public class HomePage1 {

    // method simulates a mouse-click on an element
    public void ClickonElement(By by) {
        driver.findElement(by).click();

    }

    // verifying messages, errors, asserting WebElements, and many more.
//findElement command is used to uniquely identify a web element within the web page
    public String GettextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    //to input content in editable text fields or password fields in a webpage.
//findElement command is used to uniquely identify a web element within the web page
    public void EnterText(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }

    @BeforeMethod//Executes before each test method
    public void openBrowser() {
        //.setProperty command is used for sets the property of the system which is indicated by a key
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        // To communicate test scripts with Google Chrome
        driver = new ChromeDriver();
        // To maximize the browser
        driver.manage().window().maximize();
        //.get() method is used to open URL and it will wait till the whole page gets loaded
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod//Executes after each test method
    public void CloseBrowser()
    {
        driver.close();
    }
    //imported selenium web driver interface using maven dependency to perform automation task
    protected static WebDriver driver;
    @Test //This annotated method will be run after each method
    public void Registration ()
    {
        //returns timeStamp value corresponding to the given string
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        // printing output for timeStamp
        System.out.println(timeStamp);
        //ClickonElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        ClickonElement(By.className("ico-register"));
        ClickonElement(By.id("gender-female"));//EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        EnterText(By.id("FirstName"),"Sejal");
        EnterText(By.id("LastName"),"Patel");
        EnterText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[1]"), "7");
        EnterText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[2]") , "May");
        EnterText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[3]") , "1994");
        EnterText(By.id("Email"),"seju_patel81"+timeStamp+"@yahoo.com");
        EnterText(By.id("Company"), " SAP Consultancy Ltd. ");
        EnterText(By.id("Password"),"Test123");
        ClickonElement(By.id("Newsletter"));
        EnterText(By.id("ConfirmPassword"),"Test123");
        ClickonElement(By.id("register-button"));
        //for better space
        System.out.println();
        //regMsg is local variable to store the find element through gettext command
        String regMsg = GettextFromElement(By.className("result"));
        //Printing output for regMsg
        System.out.println(regMsg);

    }
    @Test  //This annotated method will be run after each method
    public void Product()
    {
        //ClickonElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        ClickonElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
        ClickonElement(By.xpath("//div[@class=\"category-grid sub-category-grid\"]//img[@alt=\"Picture for category Desktops\"]"));
        //regMsg,regMsg1,regMsg2is local variable to store the find element through gettext command
        String regMsg = GettextFromElement(By.xpath("//div[@class=\"details\"]/h2/a[@href=\"/build-your-own-computer\"]"));
        String regMsg1 = GettextFromElement(By.xpath("//div[@class=\"details\"]/h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        String regMsg2 = GettextFromElement(By.xpath("//div[@class=\"details\"]/h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
        //Printing output for regMsg,regMsg1,regMsg2
        System.out.println(regMsg);
        System.out.println(regMsg1);
        System.out.println(regMsg2);
    }
    @Test //This annotated method will be run after each method
    public void NewsComment()
    {
        //ClickonElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        ClickonElement(By.className("read-more"));
        EnterText(By.className("enter-comment-title"),"demo nopCommerce Website");
        EnterText(By.className("enter-comment-text"),"It's very nice website");
        ClickonElement(By.name("add-comment"));
        //Local variable regMsg introduced
        String regMsg = GettextFromElement(By.className("result"));
        // to printout in console
        System.out.println(regMsg);
    }
    @Test //This annotated method will be run after each method
    public void Homepagecategories()
    {
        //local variable regMsg Declared to store the value get from reusable method GettextFromElement through Xpath,Id or by Class
        String regMsg = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
        String regMsg1 = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/electronics\"]"));
        String regMsg2 = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/apparel\"]"));
        String regMsg3 = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/digital-downloads\"]"));
        String regMsg4 = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/books\"]"));
        String regMsg5 = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/jewelry\"]"));
        String regMsg6 = GettextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/gift-cards\"]"));
        // local variable regMsg,regMsg1,regMsg2,regMsg4,regMsg5,regMsg6 introduced to store the find element through .gettext command
        System.out.println(regMsg);
        System.out.println(regMsg1);
        System.out.println(regMsg2);
        System.out.println(regMsg3);
        System.out.println(regMsg4);
        System.out.println(regMsg5);
        System.out.println(regMsg6);

    }
    @Test //This annotated method will be run after each method
    public void EmailAFriend(){

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        // printing output for timeStamp
        System.out.println(timeStamp);
        //ClickonElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        ClickonElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/apple-macbook-pro-13-inch\"]"));
        ClickonElement(By.xpath("//div[@class=\"email-a-friend\"]"));
        EnterText(By.id("FriendEmail"),"sejarp88"+timeStamp+"@gmail.com");
        EnterText(By.className("your-email"),"sejarp88"+timeStamp+"@gmail.com");
        EnterText(By.id("PersonalMessage"),"how r you");
        ClickonElement(By.name("send-email"));
        //regMsg is local variable to store the find element through gettext command
        String regMsg = GettextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
        //Printing output for regMsg
        System.out.println(regMsg);
    }



}