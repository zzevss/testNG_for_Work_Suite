package FornovaTestSuite;

/**
 * Created by zzevss on 25.05.16.
 */


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestSuite {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

    }
    ////////////////////////CAMPAIGN MANAGEMENT////////////////////////////////
    @Test(groups = "CampaignManagement")
    public void CMChangeClusterHotel_1() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://fornova.itsanes.com";
        baseUrl = "http://localhost:3000";

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();

        Thread.sleep(6500);
        System.gc();

        driver.findElement(By.id("typeahead")).click();
        Thread.sleep(3500);
        System.gc();
        ((JavascriptExecutor) driver).executeScript("$('.tt-suggestion.tt-selectable').last().click()");

        driver.findElement(By.linkText("Hello Test Test")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "CampaignManagement")
    public void CMduplicateDelete_2() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        System.gc();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(3000);
        ExpectedConditions.elementToBeClickable(By.linkText("Hello Test Test"));
        System.gc();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("$('.ojqgrow ui-row-ltr').first().click()");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a.duplicate-input > span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("actionAcceptButton")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.xpath("//tr[2]/td[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("actionAcceptButton")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "CampaignManagement")
    public void CMeditCampaign_3() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        Actions act = new Actions(driver);
        driver.manage().window().maximize();


        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();
        driver.findElement(By.xpath("//tr[2]/td[5]")).click();
        driver.findElement(By.cssSelector("a.edit-campaign > span > i.icon.icon-edit")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//form[@id='popupCampaignEdit']/div/div/div/div/div[4]/div[2]/div/div/div/label[2]")).click();
        Thread.sleep(3500);
        System.gc();
        new Select(driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > select[name=\"channel\"]"))).selectByVisibleText("Criteo");
        new Select(driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > select[name=\"rate\"]"))).selectByVisibleText("LIR");
        new Select(driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > select[name=\"geoTarget\"]"))).selectByVisibleText("Barbados");
        new Select(driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > select[name=\"order\"]"))).selectByVisibleText("2");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"package\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"package\"]")).sendKeys("Test Cluster ADD1");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"occupancyThreshold\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"occupancyThreshold\"]")).sendKeys("1");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"occupancyThreshold\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"occupancyThreshold\"]")).sendKeys("2");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedLocation\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedLocation\"]")).sendKeys("xcv1");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedRate\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedRate\"]")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"promoCode\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"promoCode\"]")).sendKeys("qwerty");
        driver.findElement(By.name("imageUrl")).clear();
        driver.findElement(By.name("imageUrl")).sendKeys("test.com.uk");
        driver.findElement(By.cssSelector("#editPopup > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-primary")).click();
        Thread.sleep(3000);
        act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"promoCode\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"promoCode\"]")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"occupancyThreshold\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"occupancyThreshold\"]")).sendKeys("1");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedRate\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedRate\"]")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedLocation\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"displayedLocation\"]")).sendKeys("xcv");
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"package\"]")).clear();
        driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > input[name=\"package\"]")).sendKeys("Test Cluster ADD");
        new Select(driver.findElement(By.cssSelector("div.col-md-6 > div.form-group > select[name=\"order\"]"))).selectByVisibleText("None");
        driver.findElement(By.xpath("//form[@id='popupCampaignEdit']/div/div/div/div/div[4]/div[2]/div/div/div/label[4]")).click();
        driver.findElement(By.cssSelector("#editPopup > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-primary")).click();
        Thread.sleep(6000);
        System.gc();
        driver.findElement(By.linkText("Hello Test Test")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "CampaignManagement")
    public void CMgroupBy_4() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        new Select(driver.findElement(By.id("group-by"))).selectByVisibleText("Channel");
        driver.findElement(By.cssSelector("option[value=\"channel\"]")).click();
        Thread.sleep(3500);
        new Select(driver.findElement(By.id("group-by"))).selectByVisibleText("Package");
        driver.findElement(By.cssSelector("option[value=\"package\"]")).click();
        Thread.sleep(3500);
        System.gc();
        new Select(driver.findElement(By.id("group-by"))).selectByVisibleText("None");
        driver.findElement(By.cssSelector("option[value=\"none\"]")).click();
        driver.findElement(By.linkText("Hello Test Test")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "CampaignManagement")
    public void CMmasterDetailOnOff_5() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6000);
        ExpectedConditions.elementToBeClickable(By.linkText("Hello Test Test"));

        //click to open master detail//////////////////////////////////////////////////////////////////////////////////
        ((JavascriptExecutor) driver).executeScript("$('.onoffswitch-label').first().click()");

        WebDriverWait wait = new WebDriverWait(driver, 10);  // you can reuse this one
        WebElement elem = driver.findElement(By.cssSelector("h4"));
        elem.click();
        wait.until(ExpectedConditions.visibilityOf(elem));
        System.gc();
        Thread.sleep(2000);

//        try {
//
//            assertEquals(driver.findElement(By.cssSelector("h4")).getText(), "Campaign Details");
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }

        //click to open master detail//////////////////////////////////////////////////////////////////////////////////
        ((JavascriptExecutor) driver).executeScript("$('.onoffswitch-label').first().click()");

        driver.quit();
    }

    @Test(groups = "CampaignManagement")
    public void CMsearchInputClear_6() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();

//        try {
//            Thread.sleep(4500);
//            assertEquals(driver.findElement(By.cssSelector("td[title=\"Test Cluster ADD\"]")).getText(), "Test Cluster ADD");
//        } catch (Error e) {
//            verificationErrors.append(e.toString());
//        }
        Thread.sleep(6500);
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("1");
        driver.findElement(By.id("customSearch")).sendKeys(Keys.RETURN);
        Thread.sleep(3500);
        System.gc();
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys(Keys.RETURN);
        driver.findElement(By.linkText("Hello Test Test")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "CampaignManagement")
    public void CMtypeSymb_7() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        driver.findElement(By.id("typeahead")).clear();
        driver.findElement(By.id("typeahead")).sendKeys("qwerty");
        Thread.sleep(4500);
        driver.findElement(By.linkText("Hello Test Test")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    ////////////////////////CHAIN MANAGEMENT ////////////////////////////////
    @Test(groups = "ChainManagement")
    public void ChainManagementComboboxTest_8() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();
        ((JavascriptExecutor) driver).
                executeScript("$('#selectChain').val($('.select2-results__option')." +
                        "first().attr('id').split('-').pop()).change();$('#selectChain').trigger('select2:select')");

        Thread.sleep(3500);
        System.gc();
        driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();
        //driver.findElement(By.id("select2-selectChain-result-lhs7-NekwD48s88TaoZ2pv")).click();
        ((JavascriptExecutor) driver).
                executeScript("$('#selectChain').val($('.select2-results__option')." +
                        "last().attr('id').split('-').pop()).change();$('#selectChain').trigger('select2:select')");
        Thread.sleep(6500);
        System.gc();
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "ChainManagement")
    public void ChainManagementEditChangeLogo_9() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions act = new Actions(driver);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(3500);

        //CREATE CHAIN TO TEST CHANGES//////////////////////////////////////////////////////
        driver.findElement(By.linkText("New")).click();
        Thread.sleep(3500);
        System.gc();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("VinnitsaCity");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Vinnitsa");
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).clear();
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed.png");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        //SELECT CREATED CHAIN To EDIT////////////////////////////////////////////////////
        Thread.sleep(3000);
        System.gc();
        act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789_new");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine_new");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("VinnitsaCity_new");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Vinnitsa_new");
        Thread.sleep(2000);
        System.gc();
        ((JavascriptExecutor) driver).executeScript("$('.preview.preview-edit.js-af-remove-file').first().click()");
        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).clear();
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed1.jpg");
        Thread.sleep(2000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        //EDIT CHAIN BY PENCIL/////////////////////////////////////////////////////
        Thread.sleep(5000);

        //act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        driver.findElement(By.xpath("//tr[2]/td[5]")).click();
        Thread.sleep(1000);
        System.gc();
        ((JavascriptExecutor) driver).executeScript("$('.icon.icon-edit').click()");
//token->    driver.findElement(By.cssSelector("//div[@id='content-wrapper']/div/div/div/div[2]/div/a[2]/i")).click();

        Thread.sleep(3000);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789_new2");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine_new2");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("VinnitsaCity_new2");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Vinnitsa_new2");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("$('.preview.preview-edit.js-af-remove-file').first().click()");
        System.gc();
        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).clear();
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed3.jpg");
        Thread.sleep(2000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        //DELETE CREATED-CHANGE CHAIN//////////////////////////////////////////////
        Thread.sleep(3000);
        //act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        driver.findElement(By.xpath("//tr[2]/td[5]")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("actionAcceptButton")).click();

        //LOG OUT//////////////////////////////////////////////
        Thread.sleep(6000);
        System.gc();
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "ChainManagement")
    public void ChainManagementNewChain_10() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions act = new Actions(driver);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(3500);
        driver.findElement(By.id("select2-selectChain-container")).click();
        System.gc();
        driver.findElement(By.linkText("New")).click();
        Thread.sleep(3500);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("VinnitsaCity");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Vinnitsa");
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).clear();
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed.png");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        System.gc();
        Thread.sleep(3000);
        //act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        driver.findElement(By.xpath("//tr[2]/td[5]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("actionAcceptButton")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "ChainManagement")
    public void ChainManagementResetCancel_11() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions act = new Actions(driver);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        //driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();
        Thread.sleep(3000);
        //act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        driver.findElement(By.linkText("New")).click();
        System.gc();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("VinnitsaCity");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Vinnitsa");
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).clear();
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed.png");
        Thread.sleep(2000);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789_new");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Ukraine_new");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("VinnitsaCity_new");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("Vinnitsa_new");
        System.gc();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("$('.preview.preview-edit.js-af-remove-file').first().click()");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[3]/button")).click();
        System.gc();
        Thread.sleep(2500);
        try {
            if (driver.getPageSource().contains("Vinnitsa_new")) {
                throw new Error("Error! Fields was not clear !!!");
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        driver.findElement(By.xpath("//button[2]")).click();

        Thread.sleep(2000);
        System.gc();
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "ChainManagement")
    public void ChainManagementSearchField_12() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        System.gc();
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();

        //CREATE NEW Chain////////////////////////////////////////////////////////
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(3500);
        driver.findElement(By.id("select2-selectChain-container")).click();
        System.gc();
        driver.findElement(By.linkText("New")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainADD" + "_" + RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("country")).clear();
        driver.findElement(By.name("country")).sendKeys("Uganda");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("UgandaCity");
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys("UgandaCity");
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).clear();
//        driver.findElement(By.cssSelector("div.af-select-file > input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed.png");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        //////////////////////////////////////////////////////////////////////////////

        //VERIFY Such CHAIN///////////////////////////////////////////////////////////
        Thread.sleep(2500);
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("Ug");
        driver.findElement(By.id("customSearch")).sendKeys(Keys.RETURN);
        Thread.sleep(2500);
        System.gc();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("td[title=\"Uganda\"]")).getText(), "Uganda");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys(Keys.RETURN);
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("ww");
        driver.findElement(By.id("customSearch")).sendKeys(Keys.RETURN);

        Thread.sleep(2500);
        try {
            if (driver.getPageSource().contains("Uganda")) {
                throw new Error("Uganda NOT find !!!");
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys(Keys.RETURN);

        //DELETING CHAIN////////////////////////////////////////////
        System.gc();
        Thread.sleep(3000);
        //act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[5]"))).build().perform();
        driver.findElement(By.xpath("//tr[2]/td[5]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("actionAcceptButton")).click();
        System.gc();
        ////////////////////////////////////////////////////////////


        //LOGOUT////////////////////////////////////////////////////
        Thread.sleep(4500);

        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        ///////////////////////////////////////////////////////////

        driver.quit();
    }

    /////////////////////Hotel MANAGEMENT ////////////////////////
    @Test(groups = "HotelManagement")
    public void HMeditHotel_13() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        //SELECT CHAIN////////////////////////////////////////////////////
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();
        ((JavascriptExecutor) driver).
                executeScript("$('#selectChain').val($('.select2-results__option')." +
                        "last().attr('id').split('-').pop()).change();$('#selectChain').trigger('select2:select')");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul[1]/li/ul/li[1]/a")).click();
        Thread.sleep(2000);
        /////////////////////////////////////////////////////////////////


        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[2]/a")).click();

        Thread.sleep(2500);
        System.gc();
        driver.findElement(By.id("tree")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//div/a/span")).click();
        Thread.sleep(3500);
        driver.findElement(By.linkText("Hotel")).click();
        Thread.sleep(3500);
        driver.findElement(By.name("hotelId")).clear();
        driver.findElement(By.name("hotelId")).sendKeys("NewHotel");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewName");
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("description")).sendKeys("NewDescription");
        driver.findElement(By.name("location")).clear();
        driver.findElement(By.name("location")).sendKeys("NewLocation");
        driver.findElement(By.name("url")).clear();
        driver.findElement(By.name("url")).sendKeys("newurl.com.ne");
        driver.findElement(By.name("occupancyTarget")).clear();
        driver.findElement(By.name("occupancyTarget")).sendKeys("1");
        driver.findElement(By.name("efficiencyTarget")).clear();
        driver.findElement(By.name("efficiencyTarget")).sendKeys("2");
        driver.findElement(By.name("leadTime")).clear();
        driver.findElement(By.name("leadTime")).sendKeys("3");
        System.gc();
//        driver.findElement(By.cssSelector("input.js-file")).clear();
//        driver.findElement(By.cssSelector("input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed.png");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.icon.icon-save")).click();

        //EDIT HOTEL///////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('.jstree-anchor').first().click()");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('.jstree-anchor').last().click()");
        //Thread.sleep(3500);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewName_new");
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("description")).sendKeys("NewDescription_new");
        driver.findElement(By.name("location")).clear();
        driver.findElement(By.name("location")).sendKeys("NewLocation_new");
        driver.findElement(By.name("url")).clear();
        driver.findElement(By.name("url")).sendKeys("newurl_new.com.ne");
        driver.findElement(By.name("occupancyTarget")).clear();
        driver.findElement(By.name("occupancyTarget")).sendKeys("4");
        driver.findElement(By.name("efficiencyTarget")).clear();
        driver.findElement(By.name("efficiencyTarget")).sendKeys("4");
        driver.findElement(By.name("leadTime")).clear();
        driver.findElement(By.name("leadTime")).sendKeys("4");

        ((JavascriptExecutor) driver).executeScript("$('.preview.preview-edit.js-af-remove-file').click()");
        //driver.findElement(By.cssSelector("input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed1.jpg");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.icon.icon-save")).click();
        System.gc();


        //DELETE CREATED HOTEL//////////////////////////////////////////////////////////////////
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("$('.jstree-anchor').last().click()");
        driver.findElement(By.xpath("//div[2]/a/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='actionModal']/div/div/div[3]/button[2]")).click();
        System.gc();
        Thread.sleep(6000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "HotelManagement")
    public void HMnewCluster_14() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        System.gc();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();

        ((JavascriptExecutor) driver).
                executeScript("$('#selectChain').val($('.select2-results__option')." +
                        "last().attr('id').split('-').pop()).change();$('#selectChain').trigger('select2:select')");
        Thread.sleep(2500);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[2]/a")).click();
        Thread.sleep(2500);
        System.gc();
        driver.findElement(By.id("tree")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//div/a/span")).click();
        Thread.sleep(2500);
        driver.findElement(By.linkText("Cluster")).click();
        Thread.sleep(3500);
        System.gc();

        //TYPE DATA TO NEW CLUSTER///////////////////////////////////////////////////
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewCluster");
        driver.findElement(By.name("url")).clear();
        driver.findElement(By.name("url")).sendKeys("newclusterurl.comcl");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("ul.select2-selection__rendered")).click();
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("$('[name=hotelIds]').val($('.select2-results__option').attr('id').split('-').pop()).trigger('change')");
        System.gc();
//
//       // ((JavascriptExecutor)driver).executeScript("$('.js-file').click()");
//
//        //div[2]/div[3]/div/div
//        driver.findElement(By.cssSelector("input.js-file")).clear();
//        driver.findElement(By.cssSelector("input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed1.jpg");
        driver.findElement(By.cssSelector("i.icon.icon-save")).click();
        System.gc();

        //DELETE CREATED CLUSTER////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        //$('.jstree-node.jstree-closed a').last().click()
        System.gc();
        ((JavascriptExecutor) driver).executeScript("$('.jstree-node.jstree-closed a').last().click()");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("actionAcceptButton")).click();
        System.gc();
        Thread.sleep(6000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "HotelManagement")
    public void HMnewHotel_15() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();


        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);

        //SELECT CHAIN////////////////////////////////////////////////////
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();
        ((JavascriptExecutor) driver).
                executeScript("$('#selectChain').val($('.select2-results__option')." +
                        "last().attr('id').split('-').pop()).change();$('#selectChain').trigger('select2:select')");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul[1]/li/ul/li[1]/a")).click();
        Thread.sleep(2000);
        /////////////////////////////////////////////////////////////////

        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[2]/a")).click();
        Thread.sleep(2500);
        System.gc();
        driver.findElement(By.id("tree")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//div/a/span")).click();
        Thread.sleep(2500);
        System.gc();
        driver.findElement(By.linkText("Hotel")).click();
        Thread.sleep(2500);
        driver.findElement(By.name("hotelId")).clear();
        Thread.sleep(2500);
        System.gc();
        driver.findElement(By.name("hotelId")).sendKeys("NewHotel");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewName");
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("description")).sendKeys("NewDescription");
        driver.findElement(By.name("location")).clear();
        driver.findElement(By.name("location")).sendKeys("NewLocation");
        driver.findElement(By.name("url")).clear();
        driver.findElement(By.name("url")).sendKeys("newurl.com.ne");
        driver.findElement(By.name("occupancyTarget")).clear();
        driver.findElement(By.name("occupancyTarget")).sendKeys("1");
        driver.findElement(By.name("efficiencyTarget")).clear();
        driver.findElement(By.name("efficiencyTarget")).sendKeys("2");
        driver.findElement(By.name("leadTime")).clear();
        driver.findElement(By.name("leadTime")).sendKeys("3");

//        driver.findElement(By.cssSelector("input.js-file")).clear();
//        driver.findElement(By.cssSelector("input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed1.jpg");

        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.cssSelector("i.icon.icon-save")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("$('.jstree-anchor').last().click()");
        driver.findElement(By.xpath("//div[2]/a/i")).click();
        Thread.sleep(2000);
        System.gc();
        driver.findElement(By.xpath("//div[@id='actionModal']/div/div/div[3]/button[2]")).click();
        Thread.sleep(6000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "HotelManagement")
    public void HMsearchFormTest_16() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        baseUrl = "http://localhost:3000";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);

        //SELECT CHAIN////////////////////////////////////////////////////
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='select2-selectChain-container']")).click();
        ((JavascriptExecutor) driver).
                executeScript("$('#selectChain').val($('.select2-results__option')." +
                        "last().attr('id').split('-').pop()).change();$('#selectChain').trigger('select2:select')");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul[1]/li/ul/li[1]/a")).click();
        Thread.sleep(2000);
        System.gc();
        /////////////////////////////////////////////////////////////////

        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
        driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/ul/li[2]/a")).click();
        if (!driver.getPageSource().contains("Z_hotel")) {
            driver.findElement(By.id("tree")).click();
            Thread.sleep(2500);
            driver.findElement(By.xpath("//div/a/span")).click();
            Thread.sleep(2500);
            System.gc();
            driver.findElement(By.linkText("Hotel")).click();
            Thread.sleep(2500);
            driver.findElement(By.name("hotelId")).clear();
            driver.findElement(By.name("hotelId")).sendKeys("Z_hotel");
            driver.findElement(By.name("name")).clear();
            driver.findElement(By.name("name")).sendKeys("Z_hotel");
            driver.findElement(By.name("description")).clear();
            driver.findElement(By.name("description")).sendKeys("NewDescriptionZ_hotel");
            driver.findElement(By.name("location")).clear();
            driver.findElement(By.name("location")).sendKeys("NewLocationZ_hotel");
            System.gc();
            driver.findElement(By.name("url")).clear();
            driver.findElement(By.name("url")).sendKeys("Z_hotelnewurl.com.ne");
            driver.findElement(By.name("occupancyTarget")).clear();
            driver.findElement(By.name("occupancyTarget")).sendKeys("1");
            driver.findElement(By.name("efficiencyTarget")).clear();
            driver.findElement(By.name("efficiencyTarget")).sendKeys("2");
            driver.findElement(By.name("leadTime")).clear();
            driver.findElement(By.name("leadTime")).sendKeys("3");

//            driver.findElement(By.cssSelector("input.js-file")).clear();
//            driver.findElement(By.cssSelector("input.js-file")).sendKeys("/home/zzevss/Downloads/Resorses/unnamed1.jpg");

            Thread.sleep(3000);
            System.gc();
            driver.findElement(By.cssSelector("i.icon.icon-save")).click();
        }
        Thread.sleep(3500);
        System.gc();
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div/div/div/div[2]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div/div/div/div[2]/div/input")).sendKeys("z");
        driver.findElement(By.id("treeSearch")).sendKeys(Keys.RETURN);

        try {
            if (!driver.getPageSource().contains("Z_hotel")) {
                throw new Error("Z_hotel NOT FIND !!!");
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        Thread.sleep(3500);
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div/div/div/div[2]/div/input")).clear();
        driver.findElement(By.id("treeSearch")).sendKeys(Keys.RETURN);
        System.gc();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div/div/div/div[2]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div/div/div/div[2]/div/input")).sendKeys("w");
        driver.findElement(By.id("treeSearch")).sendKeys(Keys.RETURN);
        Thread.sleep(3500);
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div/div/div/div[2]/div/input")).clear();
        driver.findElement(By.id("treeSearch")).sendKeys(Keys.RETURN);
        System.gc();
        Thread.sleep(4500);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    ////////////////////////////////  lOGIN   //////////////////////////////////////
    @Test(groups = "Login")
    public void loginFogot_17() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";

        driver.get(baseUrl);
        driver.findElement(By.id("at-forgotPwd")).click();
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        System.gc();
        Thread.sleep(6500);

        try {
            Thread.sleep(500);
            assertEquals(driver.findElement(By.xpath("//div[@id='auth-wrapper']/div/div/div/div[2]/div[2]")).getText(), "Email\n" +
                    "Email Reset Link");
        } catch (Error e) {

            verificationErrors.append(e.toString());
        }
        System.gc();
        driver.quit();
    }

    @Test(groups = "Login")
    public void loginNegativeWrongLogin_18() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";

        driver.get(baseUrl);
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("111111@test.com");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        try {
            Thread.sleep(6500);
            assertEquals(driver.findElement(By.xpath("//div[@id='auth-wrapper']/div/div/div/div[2]/div[2]/p")).getText(), "Login forbidden");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.gc();
        driver.quit();
    }

    @Test(groups = "Login")
    public void loginNegativeWrongPass_19() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";

        driver.get(baseUrl);
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("NXP33g5mS");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6000);
        try {

            assertEquals(driver.findElement(By.xpath("//div[@id='auth-wrapper']/div/div/div/div[2]/div[2]/p")).getText(), "Login forbidden");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.gc();
        driver.quit();
    }

    @Test(groups = "Login")
    public void loginPositive_20() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";

        driver.get(baseUrl);
        Thread.sleep(1000);
        driver.findElement(By.name("at-field-email")).clear();
        driver.findElement(By.name("at-field-email")).sendKeys("");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(4500);

        try {
            Thread.sleep(3000);

            assertEquals(driver.findElement(By.linkText("Hello Supernova Superadmin")).getText(), "Hello Supernova Superadmin");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);

        try {

            assertEquals(driver.findElement(By.xpath("//div[@id='auth-wrapper']/div/div/div/div[2]/div[2]/p")).getText(), "Must be logged in");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.gc();
        driver.quit();
    }


    //////////////////////////User Management/////////////////////////////////////////
    @Test(groups = "UserManagement")
    public void UMaddNewUser_21() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();

        //CREATE NEW INVITATION//////////////////////////////////////////////
        driver.findElement(By.cssSelector("a.new-input > span")).click();
        Thread.sleep(3000);
        System.gc();
        String EmailSendInvite = "fornovatestuser" + "_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@extremail.ru";
        String apiToken = "http://api.temp-mail.ru/request/mail/id/" + DigestUtils.md5Hex(EmailSendInvite) + "/format/json";
        //REquest to tmpMail and pars///////////////////////////////////////////

        //GET REQUEST CHECK FOR SUCCESS REQUEST/////////////////////////////////
        String buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }

        System.gc();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("NewTestUser");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestForNova");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.id("email")).sendKeys(EmailSendInvite);

        //CLICK ADD USER ///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[4]/span/span/span/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('#role')." +
                "val($('.select2-results__option').last().attr('id').split('-').pop())." +
                "trigger('change').trigger('select2:select')");
        ////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('#level').val('chain').trigger('change').trigger('select2:select')");
        Thread.sleep(1000);
        System.gc();

        //Module permissions///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[7]/span/span/span/ul")).click();
        ((JavascriptExecutor) driver).executeScript("$('#permissions')." +
                "val(['campaignManagement', 'competitiveData', 'analytics', 'reports']).trigger('change')");
        //////////////////////////////////////////////////////////////////

        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.xpath("//*[@id='formUsers']/div[6]/span/span[1]/span/ul"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(4000);
        System.gc();

        buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();
        int indexStart = buff.lastIndexOf("fornova.itsanes.com") + 29;
        int indexEnd = indexStart + 43;
        ////////////////////////////////////////////////////////////////////////

        try {
            if (buff == null || buff.isEmpty()) {
                throw new Error("Error! Request faild, INVITATION not delivered!!! START ROW = " + indexStart);
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }


        //LOGOUT/////////////////////////////////////////////////////////////
        Thread.sleep(3000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Start index: " + indexStart);
        System.out.println("Start index: " + indexEnd);


        //START FOR LOCALHOST OR INTERNET VER/////////////////////////////////
        driver.get("http://fornova.itsanes.com/invite/" + buff.substring(indexStart, indexEnd));
//        driver.get("http://localhost:3000" + buff.substring(indexStart,indexEnd));
        /////////////////////////////////////////////////////////////////////

        Thread.sleep(5000);
        System.gc();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("111111");
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys(EmailSendInvite);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMchangePasswordWrong_22() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();

        //CREATE NEW INVITATION//////////////////////////////////////////////
        driver.findElement(By.cssSelector("a.new-input > span")).click();
        Thread.sleep(3000);
        System.gc();
        String EmailSendInvite = "fornovatestuser" + "_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@extremail.ru";
        String apiToken = "http://api.temp-mail.ru/request/mail/id/" + DigestUtils.md5Hex(EmailSendInvite) + "/format/json";
        //REquest to tmpMail and pars///////////////////////////////////////////

        String buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();

        //GET REQUEST CHECK FOR SUCCESS REQUEST/////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("NewTestUser");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestForNova");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.id("email")).sendKeys(EmailSendInvite);

        //CLICK ADD USER ///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[4]/span/span/span/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('#role')." +
                "val($('.select2-results__option').last().attr('id').split('-').pop())." +
                "trigger('change').trigger('select2:select')");
        ////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('#level').val('chain').trigger('change').trigger('select2:select')");
        Thread.sleep(1000);
        System.gc();

        //Module permissions///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[7]/span/span/span/ul")).click();
        ((JavascriptExecutor) driver).executeScript("$('#permissions')." +
                "val(['campaignManagement', 'competitiveData', 'analytics', 'reports']).trigger('change')");
        //////////////////////////////////////////////////////////////////

        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.xpath("//*[@id='formUsers']/div[6]/span/span[1]/span/ul"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(4000);
        System.gc();
        buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();
        int indexStart = buff.lastIndexOf("fornova.itsanes.com") + 29;
        int indexEnd = indexStart + 43;
        ////////////////////////////////////////////////////////////////////////
        try {
            if (buff == null || buff.isEmpty()) {
                throw new Error("Error! Request faild, INVITATION not delivered!!! START ROW = " + indexStart);
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        //LOGOUT/////////////////////////////////////////////////////////////
        Thread.sleep(3500);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Start index: " + indexStart);
        System.out.println("Start index: " + indexEnd);


        //START FOR LOCALHOST OR INTERNET VER/////////////////////////////////
        driver.get("http://fornova.itsanes.com/invite/" + buff.substring(indexStart, indexEnd));
//        driver.get("http://localhost:3000/" + buff.substring(indexStart,indexEnd));
        /////////////////////////////////////////////////////////////////////

        //SET NEW PASSWORD FOR USER//////////////////////////////////////////
        Thread.sleep(6000);
        System.gc();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("111111");
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(3000);
        System.gc();
        /////////////////////////////////////////////////////////////////////

        //USER LOGIN WITH NEW PASSWORD//////////////////////////////////////
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys(EmailSendInvite);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();
        /////////////////////////////////////////////////////////////////////

        //CHANGE PASSWORD FOR NEW USER///////////////////////////////////////
        driver.findElement(By.linkText("Hello NewTestUser TestForNova")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Profile")).click();
        Thread.sleep(3500);
        System.gc();
        driver.findElement(By.name("oldPassword")).clear();
        driver.findElement(By.name("oldPassword")).sendKeys("111111");
        driver.findElement(By.name("newPassword")).clear();
        driver.findElement(By.name("newPassword")).sendKeys("newpassword");
        driver.findElement(By.name("confirmPassword")).clear();
        driver.findElement(By.name("confirmPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("#changePassword > div.form-group > button.btn.btn-primary")).click();
        /////////////////////////////////////////////////////////////////////

        Thread.sleep(3500);
        System.gc();
        //CHECK FOR WRONG PASSWORD///////////////////////////////////////////
        try {
            assertEquals(driver.findElement(By.cssSelector("div.bert-container")).getText(), "Passwords must be equal.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        /////////////////////////////////////////////////////////////////////
        Thread.sleep(2000);
        System.gc();

        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMchangeUserPassword_23() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();

        //CREATE NEW INVITATION//////////////////////////////////////////////
        driver.findElement(By.cssSelector("a.new-input > span")).click();
        Thread.sleep(3000);
        System.gc();
        String EmailSendInvite = "fornovatestuser" + "_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@extremail.ru";
        String apiToken = "http://api.temp-mail.ru/request/mail/id/" + DigestUtils.md5Hex(EmailSendInvite) + "/format/json";
        //REquest to tmpMail and pars///////////////////////////////////////////

        String buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();

        //GET REQUEST CHECK FOR SUCCESS REQUEST/////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("NewTestUser");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestForNova");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.id("email")).sendKeys(EmailSendInvite);

        //CLICK ADD USER ///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[4]/span/span/span/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('#role')." +
                "val($('.select2-results__option').last().attr('id').split('-').pop())." +
                "trigger('change').trigger('select2:select')");
        ////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('#level').val('chain').trigger('change').trigger('select2:select')");
        Thread.sleep(1000);
        System.gc();

        //Module permissions///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[7]/span/span/span/ul")).click();
        ((JavascriptExecutor) driver).executeScript("$('#permissions')." +
                "val(['campaignManagement', 'competitiveData', 'analytics', 'reports']).trigger('change')");
        //////////////////////////////////////////////////////////////////


        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.xpath("//*[@id='formUsers']/div[6]/span/span[1]/span/ul"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(4000);
        System.gc();
        buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();
        int indexStart = buff.lastIndexOf("fornova.itsanes.com") + 29;
        int indexEnd = indexStart + 43;
        ////////////////////////////////////////////////////////////////////////

        try {
            if (buff == null || buff.isEmpty()) {
                throw new Error("Error! Request faild, INVITATION not delivered!!! START ROW = " + indexStart);
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }


        //LOGOUT/////////////////////////////////////////////////////////////
        Thread.sleep(3000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Start index: " + indexStart);
        System.out.println("Start index: " + indexEnd);


        //START FOR LOCALHOST OR INTERNET VER/////////////////////////////////
        driver.get("http://fornova.itsanes.com/invite/" + buff.substring(indexStart, indexEnd));
//        driver.get("http://localhost:3000/" + buff.substring(indexStart,indexEnd));
        /////////////////////////////////////////////////////////////////////

        //SET NEW PASSWORD FOR USER//////////////////////////////////////////
        Thread.sleep(5000);
        System.gc();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("111111");
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(5000);
        System.gc();
        /////////////////////////////////////////////////////////////////////

        //USER LOGIN WITH NEW PASSWORD//////////////////////////////////////
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys(EmailSendInvite);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();
        /////////////////////////////////////////////////////////////////////

        //CHANGE PASSWORD FOR NEW USER///////////////////////////////////////
        driver.findElement(By.linkText("Hello NewTestUser TestForNova")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Profile")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.name("oldPassword")).clear();
        driver.findElement(By.name("oldPassword")).sendKeys("111111");
        driver.findElement(By.name("newPassword")).clear();
        driver.findElement(By.name("newPassword")).sendKeys("newpassword");
        driver.findElement(By.name("confirmPassword")).clear();
        driver.findElement(By.name("confirmPassword")).sendKeys("newpassword");
        driver.findElement(By.cssSelector("#changePassword > div.form-group > button.btn.btn-primary")).click();
        /////////////////////////////////////////////////////////////////////

        //USER LOGOUT WITH CHANGED PASSWORD /////////////////////////////////////
        Thread.sleep(5000);
        driver.findElement(By.linkText("Hello NewTestUser TestForNova")).click();
        driver.findElement(By.linkText("Logout")).click();
        /////////////////////////////////////////////////////////////////////

        //USER LOGIN WITH CHANGED PASSWORD /////////////////////////////////////
        Thread.sleep(3000);
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys(EmailSendInvite);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("newpassword");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(3000);
        System.gc();
        //////////////////////////////////////////////////////////////////////
        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMeditProfile_24() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();

        //CREATE NEW INVITATION//////////////////////////////////////////////
        driver.findElement(By.cssSelector("a.new-input > span")).click();
        Thread.sleep(3000);
        System.gc();
        String EmailSendInvite = "fornovatestuser" + "_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@extremail.ru";
        String apiToken = "http://api.temp-mail.ru/request/mail/id/" + DigestUtils.md5Hex(EmailSendInvite) + "/format/json";
        String buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();

        //REquest to tmpMail and pars///////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("NewTestUser");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestForNova");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.id("email")).sendKeys(EmailSendInvite);


        //CLICK ADD USER ///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[4]/span/span/span/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('#role')." +
                "val($('.select2-results__option').last().attr('id').split('-').pop())." +
                "trigger('change').trigger('select2:select')");
        ////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('#level').val('chain').trigger('change').trigger('select2:select')");
        Thread.sleep(1000);
        System.gc();

        //Module permissions///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[7]/span/span/span/ul")).click();
        ((JavascriptExecutor) driver).executeScript("$('#permissions')." +
                "val(['campaignManagement', 'competitiveData', 'analytics', 'reports']).trigger('change')");
        //////////////////////////////////////////////////////////////////


        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.id("firstName"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(4000);
        System.gc();


        //GET REQUEST CHECK FOR SUCCESS REQUEST/////////////////////////////////
        buff = getHTML(apiToken);
        for (int i = 0; i < 3; i++) {
            if (buff == null || buff.isEmpty()) {
                Thread.sleep(5000);
                buff = getHTML(apiToken);
            }
        }
        System.gc();
        int indexStart = buff.lastIndexOf("fornova.itsanes.com") + 29;
        int indexEnd = indexStart + 43;
        try {
            if (buff == null || buff.isEmpty()) {
                throw new Error("Error! Request faild, INVITATION not delivered!!! START ROW = " + indexStart);
            }
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        ////////////////////////////////////////////////////////////////////////


        //LOGOUT/////////////////////////////////////////////////////////////
        Thread.sleep(3000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Start index: " + indexStart);
        System.out.println("Start index: " + indexEnd);


        //CONFIRM FOR LOCALHOST OR INTERNET VER//////////////////////////////
        driver.get("http://fornova.itsanes.com/invite/" + buff.substring(indexStart, indexEnd));
//        driver.get("http://localhost:3000" + buff.substring(indexStart,indexEnd));
        /////////////////////////////////////////////////////////////////////

        //SET NEW PASSWORD FOR CREATED ACCOUNT///////////////////////////////
        Thread.sleep(5000);
        System.gc();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("111111");
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(3000);
        System.gc();
        ////////////////////////////////////////////////////////////////////

        //LOGIN GREATED ACCOUNT/////////////////////////////////////////////
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys(EmailSendInvite);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("111111");
        driver.findElement(By.id("at-btn")).click();
        System.gc();
        ////////////////////////////////////////////////////////////////////

        //LOGOUT/////////////////////////////////////////////////////////////
        Thread.sleep(6500);
        driver.findElement(By.linkText("Hello NewTestUser TestForNova")).click();
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);
        System.gc();

        //LOGIN SUPER USER///////////////////////////////////////////////////
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(3000);
        System.gc();
        ////////////////////////////////////////////////////////////////////

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();

        //ACTIVATE EDIT MODE BY PENCIL////////////////////////////////////////
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[6]"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("i.icon.icon-edit")).click();
        //////////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        System.gc();
        //EDIT CREATED USER///////////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("EditUserName");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("EditUserLastName");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(4000);
        System.gc();
        //////////////////////////////////////////////////////////////////////

        //DELETE CREATED USER/////////////////////////////////////////////////
        act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[6]"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.id("deleteUserAcceptButton")).click();
        System.gc();
        //////////////////////////////////////////////////////////////////////
        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMinviteSearch_25() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();
        /////////////////////////////////////////////////////////////////////


        //CREATE ADMIN INVITATION////////////////////////////////////////////
        String EmailSendInvite = "fornovatestuser" + "_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@tmpmil.ru";

        driver.findElement(By.cssSelector("a.new-input > span")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("NewTestUser");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestForNova");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.id("email")).sendKeys(EmailSendInvite);

        //CLICK ADD USER ///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[4]/span/span/span/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('#role')." +
                "val($('.select2-results__option').first().attr('id').split('-').pop())." +
                "trigger('change').trigger('select2:select')");
        ////////////////////////////////////////////////////////////////

        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('#level').val('chain').trigger('change').trigger('select2:select')");
        Thread.sleep(1000);
        System.gc();

        //Module permissions///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[7]/span/span/span/ul")).click();
        ((JavascriptExecutor) driver).executeScript("$('#permissions')." +
                "val(['campaignManagement', 'competitiveData', 'analytics', 'reports']).trigger('change')");
        //////////////////////////////////////////////////////////////////


        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.xpath("//*[@id='formUsers']/div[6]/span/span[1]/span/ul"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        /////////////////////////////////////////////////////////////////////

        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.id("customInvitationsSearch")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("customInvitationsSearch")).sendKeys("d");
        Thread.sleep(500);
        driver.findElement(By.id("customInvitationsSearch")).sendKeys(Keys.RETURN);
        Thread.sleep(1000);
        System.gc();
        try {
            assertEquals(driver.findElement(By.cssSelector("td[title=\"admin\"]")).getText(), "admin");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("customInvitationsSearch")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("customInvitationsSearch")).sendKeys("");
        Thread.sleep(500);
        driver.findElement(By.id("customInvitationsSearch")).sendKeys(Keys.RETURN);
        Thread.sleep(2500);
        System.gc();


        //DELETE CREATED USER/////////////////////////////////////////////////
        act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[6]"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("i.icon.icon-trash")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.id("deleteUserAcceptButton")).click();
        System.gc();
        //////////////////////////////////////////////////////////////////////
        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMresendInvitation_26() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        Thread.sleep(3000);
        System.gc();

        //CREATE NEW INVITATION//////////////////////////////////////////////
        driver.findElement(By.cssSelector("a.new-input > span")).click();
        Thread.sleep(3000);
        System.gc();

        String EmailSendInvite = "fornovatestuser" + "_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@extremail.ru";
//        String apiToken = "http://api.temp-mail.ru/request/mail/id/" + DigestUtils.md5Hex(EmailSendInvite) + "/format/json";
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='formUsers']/div/input")).sendKeys("NewTestUser");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("TestForNova");
        driver.findElement(By.cssSelector("#email")).clear();

        driver.findElement(By.id("email")).sendKeys(EmailSendInvite);
        //CLICK ADD USER ///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[4]/span/span/span/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('#role')." +
                "val($('.select2-results__option').last().attr('id').split('-').pop())." +
                "trigger('change').trigger('select2:select')");
        ////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("$('#level').val('chain').trigger('change').trigger('select2:select')");
        Thread.sleep(1000);
        System.gc();
        //Module permissions///////////////////////////////////////////////
        driver.findElement(By.xpath("//form[@id='formUsers']/div[7]/span/span/span/ul")).click();
        ((JavascriptExecutor) driver).executeScript("$('#permissions')." +
                "val(['campaignManagement', 'competitiveData', 'analytics', 'reports']).trigger('change')");
        //////////////////////////////////////////////////////////////////
        //Double click to empty field/////////////////////////////////////
        Actions act = new Actions(driver);
        Thread.sleep(1000);
        act.doubleClick(driver.findElement(By.xpath("//*[@id='formUsers']/div[6]/span/span[1]/span/ul"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        //Cancel creating INVITE for new user//////////////////////////////

        //RESEND and DELETE INVITATION/////////////////////////////////////
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]")).click();
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div[2]/div/div/div[2]/div/a/span")).click();
        Thread.sleep(1000);
        System.gc();
        driver.findElement(By.xpath("//div[4]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]")).click();
        driver.findElement(By.xpath("//div[@id='content-wrapper']/div[2]/div/div/div[2]/div/a[2]/i")).click();
        Thread.sleep(1000);
        System.gc();
        driver.findElement(By.xpath("//div[5]/div/div/div[3]/button[2]")).click();
        ///////////////////////////////////////////////////////////////////

        //LOGOUT///////////////////////////////////////////////////////////
        Thread.sleep(4000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMresetCancel_27() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        //LOGIN/////////////////////////////////////////////////////////////
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();
        Actions act = new Actions(driver);
        //GO to USER MANAGEMENT//////////////////////////////////////////////
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();


        //ACTIVATE EDIT MODE BY PENCIL////////////////////////////////////////
        Thread.sleep(3000);
        act.doubleClick(driver.findElement(By.xpath("//tr[2]/td[6]"))).build().perform();
        Thread.sleep(4000);
        System.gc();
        driver.findElement(By.cssSelector("i.icon.icon-edit")).click();
        //////////////////////////////////////////////////////////////////////

        //RESET - CLOSE////////////////////////////////////////////////////////
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[3]/button")).click();
        driver.findElement(By.xpath("//button[2]")).click();
        /////////////////////////////////////////////////////////////////////

        //LOGOUT/////////////////////////////////////////////////////////////
        Thread.sleep(3000);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(1000);
        System.gc();
        driver.quit();
    }

    @Test(groups = "UserManagement")
    public void UMsearchTest_28() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";

        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();
        driver.findElement(By.linkText("Campaign Management")).click();
        driver.findElement(By.linkText("User Management")).click();
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("U");
        Thread.sleep(1000);
        System.gc();
        try {
            assertEquals(driver.findElement(By.cssSelector("td[title=\"User\"]")).getText(), "User");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("");
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("d");
        Thread.sleep(1000);
        System.gc();
        try {
            assertEquals(driver.findElement(By.cssSelector("td[title=\"User\"]")).getText(), "User");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.cssSelector("td[title=\"Admin\"]")).getText(), "Admin");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("customSearch")).clear();
        driver.findElement(By.id("customSearch")).sendKeys("");

        Thread.sleep(3000);
        System.gc();
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    //////////////////////////Report/////////////////////////////////////////
    @Test(groups = "ReportMod")
    public void REmakeChainBrandsReport_29() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";

        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        driver.findElement(By.linkText("Reports")).click();
        driver.findElement(By.cssSelector("li.dropdown.open > ul.dropdown-menu > li > a")).click();
        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript("$('.icon.icon-new').click()");
        Thread.sleep(2500);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewChainReportGenerated");
        Thread.sleep(1500);
        driver.findElement(By.id("typeahead")).sendKeys("A");
        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript("$('.tt-selectable').first().click()");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='content-inputs']/div[1]/div[2]/div/span/span[1]/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('[name=\"brands\"]').val($('li.select2-results__option')" +
                ".first().text()).change()");
        driver.findElement(By.name("historyDays")).clear();
        driver.findElement(By.name("historyDays")).sendKeys("28");

        ((JavascriptExecutor) driver).executeScript("$('[name=\"markets\"]')." +
                "append('<option value=\"6th Of October, Egypt\" selected=\"selected\">6th Of October, Egypt</option>')" +
                ".trigger('change')");
        ((JavascriptExecutor) driver).executeScript("$('[name=\"sources\"] > option').first()" +
                ".prop('selected', 'selected');$('[name=\"sources\"]').trigger('change');");
        ((JavascriptExecutor) driver).executeScript("$('[name=\"POS\"] > option').first()" +
                ".prop('selected', 'selected');$('[name=\"POS\"]').trigger('change');");

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(6500);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();

        System.gc();
        driver.quit();
    }

    @Test(groups = "ReportMod")
    public void REmakeHotelReport_30() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        driver.findElement(By.linkText("Reports")).click();
        driver.findElement(By.cssSelector("li.dropdown.open > ul.dropdown-menu > li > a")).click();
        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript("$('.icon.icon-new').click()");
        Thread.sleep(2500);
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("NewHotelReportGenerated");

        driver.findElement(By.xpath("//*[@id='content-inputs']/div[2]/div/label")).click();
        driver.findElement(By.id("hotelSearch")).sendKeys("H");
        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript("$('.left.list-group-item').first().click()");
        ((JavascriptExecutor) driver).executeScript("$('.left.list-group-item').last().click()");

        driver.findElement(By.xpath("//*[@id='content-inputs']/div[1]/div[2]/div/span/span[1]/span")).click();
        ((JavascriptExecutor) driver).executeScript("$('[name=\"brands\"]').val($('li.select2-results__option')" +
                ".first().text()).change()");
        driver.findElement(By.name("historyDays")).clear();
        driver.findElement(By.name("historyDays")).sendKeys("28");

        ((JavascriptExecutor) driver).executeScript("$('[name=\"markets\"]')." +
                "append('<option value=\"6th Of October, Egypt\" selected=\"selected\">6th Of October, Egypt</option>')" +
                ".trigger('change')");
        ((JavascriptExecutor) driver).executeScript("$('[name=\"sources\"] > option').first()" +
                ".prop('selected', 'selected');$('[name=\"sources\"]').trigger('change');");
        ((JavascriptExecutor) driver).executeScript("$('[name=\"POS\"] > option').first()" +
                ".prop('selected', 'selected');$('[name=\"POS\"]').trigger('change');");


        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(6500);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }

    @Test(groups = "ReportMod")
    public void REdeleteHotelChainReport_31() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/zzevss/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        baseUrl = "http://localhost:3000";
        driver.manage().window().maximize();

        driver.get(baseUrl);
        driver.findElement(By.id("at-field-password")).clear();
        driver.findElement(By.id("at-field-password")).sendKeys("----password----");
        driver.findElement(By.id("at-field-email")).clear();
        driver.findElement(By.id("at-field-email")).sendKeys("----Login----");
        driver.findElement(By.id("at-btn")).click();
        Thread.sleep(6500);
        System.gc();

        driver.findElement(By.linkText("Reports")).click();
        driver.findElement(By.cssSelector("li.dropdown.open > ul.dropdown-menu > li > a")).click();
        Thread.sleep(2500);
        System.gc();
        driver.findElement(By.cssSelector("td[title=\"NewHotelReportGenerated\"]")).click();
        driver.findElement(By.xpath("//*[@id='content-wrapper']/div[1]/div[1]/div/a[2]/i")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='deleteReportAcceptButton']")).click();
        Thread.sleep(4500);
        System.gc();

        driver.findElement(By.cssSelector("td[title=\"NewChainReportGenerated\"]")).click();
        driver.findElement(By.xpath("//*[@id='content-wrapper']/div[1]/div[1]/div/a[2]/i")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='deleteReportAcceptButton']")).click();
        Thread.sleep(4500);
        driver.findElement(By.linkText("Hello Supernova Superadmin")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.gc();
        driver.quit();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
