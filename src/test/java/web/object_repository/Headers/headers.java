package web.object_repository.Headers;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class headers {

    WebDriver driver;
    Element element;
    Verify verify;
    Wait wait;

    public headers(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    public void click_and_verify_about_us_link(String about_us_header_text,String about_us_text, String About_us) {
        driver.manage().window().maximize();
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("about_us_header"), about_us_header_text);
        element.click("about_us_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), About_us);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("about_us_text"), about_us_text);
    }

    public void click_and_verify_services_link(String services_header_text, String services_text, String Services) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("services_header"), services_header_text);
        element.click("services_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Services);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("services_text"), services_text);
    }

    public void click_and_verify_branches_link(String branches_header_text,String branches_text, String Branches) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("branches_header"), branches_header_text);
        element.click("branches_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Branches);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("branches_location_text"), branches_text);
    }

    public void click_and_verify_promotions_link(String promotions_header_text, String promotions_text, String Promotions) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("promotions_header"), promotions_header_text);
        element.click("promotions_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Promotions);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("promotions_offers_text"), promotions_text);
    }

    public void click_and_verify_contact_us_link(String contact_header_text, String contact_text, String Contact) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("contact_header"), contact_header_text);
        element.click("contact_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Contact);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("contact_header_text"), contact_text);
    }

    public void click_and_verify_remit_online_link(String remit_online_header_text,String sign_up_text, String Remit_online) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("remit_online_header"), remit_online_header_text);
        element.click("remit_online_header");
        wait.wait_for_second(3);
        String First_window = driver.getWindowHandle();
        Set<String> allwindowids = driver.getWindowHandles();
        for (String s : allwindowids) {
            if (!s.equals(First_window)) {
                driver.switchTo().window(s);
            }
        }
        String link = "https://app-kwt.almullaexchange.com/login";
        Assert.assertEquals(link, Remit_online);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("remit_online_sign_up_text"), sign_up_text);
        wait.wait_for_second(2);
        driver.switchTo().window(First_window);
    }

    public void click_and_verify_news_link(String news_header_text, String news_text, String News) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("news_header"), news_header_text);
        element.click("news_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), News);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("news_header_text"), news_text);
    }

    public void click_and_verify_faq_link(String faqs_header_text, String faqs_text, String FAQS) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("faq_header"), faqs_header_text);
        element.click("faq_header");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), FAQS);
        Assert.assertEquals(element.get_element_text("faq_text"), faqs_text);
    }

    public void click_and_verify_arabic_link(String arabic_language_header_test, String about_us_header_in_arabic, String about_us_text_in_arabic, String Arabic) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("arabic_language_header"), arabic_language_header_test);
        element.click("arabic_language_header");
        wait.wait_for_second(5);
        Assert.assertEquals(driver.getCurrentUrl(), Arabic);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("about_us_header"), about_us_header_in_arabic);
        element.click("about_us_header");
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("about_us_text"),about_us_text_in_arabic );
    }

    public void click_and_verify_company_overview_header_in_arabic(String company_overview_header_text, String company_overview_text_in_arabic){
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("about_us_header"),company_overview_header_text);
        element.click("about_us_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("about_us_text"), company_overview_text_in_arabic);
    }
    public void click_and_verify_services_header_in_arabic(String services_header_text, String services_text) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("services_header"),services_header_text);
        element.click("services_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("services_text"), services_text);
    }
    public void click_and_verify_branches_header_in_arabic (String branches_header_text, String branches_location_text) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("branches_header"),branches_header_text);
        element.click("branches_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("branches_location_text"), branches_location_text);
    }
     public void click_and_verify_promotions_header_in_arabic (String promotions_header_text, String promotions_offers_text) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("promotions_header"),promotions_header_text);
        element.click("promotions_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("promotions_offers_text"), promotions_offers_text);
    }
    public void click_and_verify_contact_header_in_arabic (String contact_header_text, String contact_text) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("contact_header"),contact_header_text);
        element.click("contact_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("contact_header_text"), contact_text);
    }

    public void click_and_verify_remit_online_header_in_arabic(String transfer_online_header_text,String create_new_account_text ) {
        wait.wait_for_second(2);
        element.click("arabic_language_link_text");
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("remit_online_header"),transfer_online_header_text);
        element.click("remit_online_header");
        String First_window = driver.getWindowHandle();
        Set<String> allwindowids = driver.getWindowHandles();
        for (String s : allwindowids) {
            if (!s.equals(First_window)) {
                driver.switchTo().window(s);
            }
        }
//        String link = "https://app-kwt.almullaexchange.com/login";
//        Assert.assertEquals(link, Remit_online);
//        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("remit_online_sign_up_text"), create_new_account_text);
        wait.wait_for_second(2);
        driver.switchTo().window(First_window);
    }
   public void click_and_verify_news_header_in_arabic (String news_header_text, String news_text) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("news_header"),news_header_text);
        element.click("news_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("news_header_text"), news_text);
    }
    public void click_and_verify_faqs_header_in_arabic (String faq_header_text, String faq_text) {
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("faq_header"),faq_header_text);
        element.click("faq_header");
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("faq_text"), faq_text);
    }






}

