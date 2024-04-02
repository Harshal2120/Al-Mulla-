package web.object_repository.ExchangeRate;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        driver.manage().window().maximize();
        wait.wait_for_second(5);
        element.click("destination_country_dropdown_click");
    }

    public void select_country_from_dropdown(String DestinationCountry) {
        wait.wait_for_second(5);
        element.perform_scroll_to_element("destination_country_dropdown_select_single");
        element.click("destination_country_dropdown_select_single");
        wait.wait_for_second(10);
    }

    public void enter_you_send(String enterAmount) {
        wait.wait_for_second(2);
        element.clear_and_enter_in_text_field("your_send_text", enterAmount);
    }

    public void you_receive_amount() {
        int amount = 1 * 100;
        element.get_element_text("");
        element.click("your_receive_text_box");

    }

    public void select_currency() {
        element.click("select_currency_as_usd");
        element.click("select_currency_as_eur");
    }

    public String get_daily_amount() {
        String get_value = element.get_element_text("daily_amount");
        String value = get_value.substring(get_value.indexOf('=') + 1, get_value.indexOf(" ", get_value.indexOf('=') + 1)).trim();
        return value;
    }

    public int final_exchange_value(String value, String amount) {

        double doubleValue = Double.parseDouble(value);
        double doubleAmount = Double.parseDouble(amount);
        double finalValue = doubleValue * doubleAmount;
        System.out.println(finalValue);
        double decimal = finalValue - (int) finalValue;

        int roundedNumber;
        if (decimal >= 0.5) {
            roundedNumber = (int) finalValue + 1;
        } else {
            roundedNumber = (int) finalValue;
        }
        return roundedNumber;
    }

    public String get_value() {
        String ele = element.get_element_text("daily_amount");
        return ele;
    }

    public String extractNumericValue(String text) {

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public int get_received_value() {
        String receive_value = element.get_attribute_value("you_receive_value", "value");
        int intValue = Integer.parseInt(receive_value);
        return intValue;
    }

    public void get_daily_kwd() {
        wait.wait_for_second(2);
        String dailyKwd = element.get_element_text("get_daily_kwd");
        System.out.println(dailyKwd);
    }

    public void get_daily_date_time_and_delivery() {
        wait.wait_for_second(1);
        String date_time_delivery = element.get_element_text("get_daily_date_time_delivery");
        System.out.println(date_time_delivery);
    }

    public void get_daily_fees() {
        wait.wait_for_second(1);
        String daily_fees = element.get_element_text("get_daily_fees");
        System.out.println(daily_fees);
    }

    /*public void selecting_country_from_dropdown_(String country){
        List<WebElement> element3 = element.click("country_select_from_dropdown");
        for (String all_element : element3){

       }*/

}




