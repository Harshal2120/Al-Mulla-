package web.object_repository.Customer_onboarding;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class customer_onboarding {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public customer_onboarding(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }

    public void enter_ec_number(String EC_Number) {
        verify.check_element_is_present("admin_page_ecnumber_text_box");
        element.click("admin_page_ecnumber_text_box");
        wait.wait_for_second(2);
        element.enter_text("admin_page_ecnumber_text_box", EC_Number);
    }

    public void enter_smart_card_number(String smart_card_number) {
        verify.check_element_is_present("admin_page_scan_smart_card_text_box");
        element.click("admin_page_scan_smart_card_text_box");
        element.enter_text("admin_page_scan_smart_card_text_box", smart_card_number);
    }

    public void enter_otp(String otp) {
        verify.check_element_is_present("admin_page_otp_text_box");
        element.click("admin_page_otp_text_box");
        element.enter_text("admin_page_otp_text_box", otp);
    }

    public void click_on_submit_button() {
        verify.check_element_is_present("admin_page_submit_button");
        wait.wait_for_second(2);
        element.click("admin_page_submit_button");
    }
}
