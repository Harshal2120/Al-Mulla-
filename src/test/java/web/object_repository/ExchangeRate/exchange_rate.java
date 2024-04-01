package web.object_repository.ExchangeRate;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class exchange_rate {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public exchange_rate(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }
    public void enter_destination_country() {
        wait.wait_for_second(5);
        element.click("destination_country_dropdown_click");
    }
    public void select_country_from_dropdown(String DestinationCountry) {
        wait.wait_for_second(5);
        element.perform_scroll_to_element("destination_country_dropdown_select_single");
        element.click("destination_country_dropdown_select_single");
        wait.wait_for_second(10);
    }

    public void enter_you_send() {
        element.clear_and_enter_in_text_field("your_send_text","100");
    }

}
