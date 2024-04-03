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

    public void click_and_verify_about_us_link(String text_to_enter, String About_us) {
        driver.manage().window().maximize();
        wait.wait_for_second(2);
        element.click("about_us_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), About_us);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("about_uS_text_when_clicked_on_about_us"), text_to_enter);
    }

    public void click_and_verify_services_link(String text_to_enter, String Services) {
        wait.wait_for_second(2);
        element.click("services_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Services);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("why_al_mulla_Exchange_text_when_clicked_on_services"), text_to_enter);
    }

    public void click_and_verify_branches_link(String text_to_enter, String Branches) {
        wait.wait_for_second(2);
        element.click("branches_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Branches);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("locations_text_when_clicked_on_branches"), text_to_enter);
    }

    public void click_and_verify_promotions_link(String text_to_enter, String Promotions) {
        wait.wait_for_second(2);
        element.click("promotions_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Promotions);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("promotions_text_when_clicked_on_promotions"), text_to_enter);
    }

    public void click_and_verify_contact_us_link(String text_to_enter, String Contact) {
        wait.wait_for_second(2);
        element.click("contact_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), Contact);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("contact_text_when_clicked_on_contact"), text_to_enter);
    }

    public void click_and_verify_remit_online_link(String text_to_enter, String Remit_online) {
        wait.wait_for_second(2);
        element.click("remit_online_link_text");
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
        Assert.assertEquals(element.get_element_text("login_text_when_clicked_on_remit_online"), text_to_enter);
        wait.wait_for_second(2);
        driver.switchTo().window(First_window);
    }

    public void click_and_verify_news_link(String text_to_enter, String News) {
        wait.wait_for_second(2);
        element.click("news_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), News);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("news_text_when_clicked_on_news"), text_to_enter);
    }

    public void click_and_verify_faq_link(String text_to_enter, String FAQS) {
        wait.wait_for_second(2);
        element.click("faq_link_text");
        wait.wait_for_second(3);
        Assert.assertEquals(driver.getCurrentUrl(), FAQS);
        Assert.assertEquals(element.get_element_text("how_can_we_help_you_when_clicked_on_faq"), text_to_enter);
    }

    public void click_and_verify_arabic_link(String text_to_enter, String Arabic) {
        wait.wait_for_second(2);
        element.click("arabic_language_link_text");
        wait.wait_for_second(5);
        Assert.assertEquals(driver.getCurrentUrl(), Arabic);
        wait.wait_for_second(3);
        Assert.assertEquals(element.get_element_text("arabic_language_page_text_when_clicked_on_arabic_language"), text_to_enter);
    }
}

