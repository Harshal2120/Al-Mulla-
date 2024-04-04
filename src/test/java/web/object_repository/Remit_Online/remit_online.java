package web.object_repository.Remit_Online;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class remit_online {

    WebDriver driver;
    Element element;
    Verify verify;
    Wait wait;

    public remit_online(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    public void click_on_remit_online_linked_text() {
        driver.manage().window().maximize();
        wait.wait_for_second(2);
        element.click("remit_online_linked_text");
        wait.wait_for_second(3);
        String First_window = driver.getWindowHandle();
        Set<String> allwindowids = driver.getWindowHandles();
        for (String s : allwindowids) {
            if (!s.equals(First_window)) {
                driver.switchTo().window(s);
            }
        }
    }
    public void click_on_sign_up_button_on_remit_online() {
        wait.wait_for_second(4);
        element.click("sign_up_on_remit_online_page");
    }

   /* public void click_on_civil_id_textbox() {
        wait.wait_for_second(4);
        element.click("civil_id_text_on_remit_online");

    }*/

    public void enter_three_digits_on_civil_id_textbox(String id) {
        wait.wait_for_second(3);
         element.click("civil_id_text_on_remit_online");
         wait.wait_until_element_is_clickable("civil_id_text_on_remit_online");
        element.enter_text("civil_id_text_on_remit_online",id);
    }

    public void verify_validation_message_after_entering_less_than_12_digit(String validation_text_less_than_3_digits
    ){
        wait.wait_for_second(2);
        Assert.assertEquals(element.get_element_text("length_of_civil_id_should_be_12_digits_on_remit_online"),validation_text_less_than_3_digits);
    }

    public void enter_twelve_digits_on_civil_id_textbox(String id) {
        wait.wait_for_second(2);
        element.enter_text("civil_id_text_on_remit_online",id);
    }

    public void click_on_send_otp_button(){
        wait.wait_for_second(2);
        element.click("send_otp_button_on_remit_online");
        wait.wait_for_second(4);
    }

 /*   public void verify_validation_message_after_invalid_12_digits(){
        wait.wait_until_element_is_visible("invalid_message_after_invalid_12_digits_on_remit_online");
        Assert.assertEquals(element.get_element_text("invalid_message_after_invalid_12_digits_on_remit_online"),);

    }*/


}
