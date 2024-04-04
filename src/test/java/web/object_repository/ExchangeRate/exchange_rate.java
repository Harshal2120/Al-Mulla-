package web.object_repository.ExchangeRate;

import io.unity.framework.exception.locator_validation_exception;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;
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
        wait.wait_for_second(5);
        element.click("destination_country_dropdown_click");
        // element.enter_text("destination_country_dropdown_enter_value",value);
    }
    public void select_country_from_dropdown(String DestinationCountry) {
        wait.wait_for_second(5);
        element.perform_scroll_to_element("destination_country_dropdown_select_single");
        element.click("destination_country_dropdown_select_single");
        wait.wait_for_second(10);
    }

    public void enter_you_send(String value) {

        wait.wait_until_element_is_clickable("your_send_text_single");
        element.clear_and_enter_in_text_field("your_send_text_single",value);
    }

    public void click_you_receive_drop_down() {
        wait.wait_until_element_is_clickable("your_receive_text_currency_type_single");
        wait.wait_for_second(8);
        element.click("your_receive_text_currency_type_single");
        wait.wait_for_second(5);
    }

    public String get_enter_you_send(){
        wait.wait_for_second(15);
        String str = element.get_attribute_value("your_send_text_single","value");
        return str;
    }

    public String get_currency_type(){
        String str = element.get_element_text("your_receive_text_currency_type_single");
        return str;
    }

    public String get_conversion_rate_today(){
        wait.wait_for_second(2);
        String str = element.get_element_text("price_calculated_today");
        String number = extractNumericValue(str);
        return number;
    }

    public String extractNumericValue(String text) {

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public String get_text() {
        String ele = element.get_element_text("price_calculated_today");
        String number = extractNumericValue(ele);
        return number;
    }

    public String get_current_date_and_time(){
        wait.wait_until_element_is_visible("date_and_time_of_delivery");
        String str = element.get_element_text("date_and_time_of_delivery");
        return str;
    }

    public String get_total_fee_to_be_deducted(){
        wait.wait_until_element_is_visible("fee_amount_currency_exchange");
        String str = element.get_element_text("fee_amount_currency_exchange");
        return str;
    }

    public void create_dynamically_locator(String locator, Map<String, String> dynamic_value){
        try {
            element.find_element_using_dynamic_xpath(locator,dynamic_value).click();
        } catch (locator_validation_exception e) {
            e.printStackTrace();
        }
    }

    public void create_dynamically_locator_through_enter_text(String locator, Map<String, String> dynamic_value){
        try {
            element.clear_text_field("your_send_text_single");
            element.find_element_using_dynamic_xpath(locator,dynamic_value);
        } catch (locator_validation_exception e) {
            e.printStackTrace();
        }
    }

    // Dynamic method example
    public void perform_country_selection(String destinationCountry) {
        Map<String, String> dynamic_value_country = new HashMap<>();
        dynamic_value_country.put("element1", destinationCountry);

        if(dynamic_value_country.containsValue(destinationCountry)) {
            create_dynamically_locator("destination_country_dropdown_select_multiple", dynamic_value_country);
        } else {
            select_country_from_dropdown("destination_country_dropdown_select_single");
        }
    }

    public void enter_your_send(String yourSend) {
        String value= yourSend.replaceAll("\\..*", "");


        Map dynamic_value_send = new HashMap();
        dynamic_value_send.put("element1",value);

        enter_you_send(yourSend.replaceAll("\\..*", ""));
    }

    public void perform_you_receive_selection(String youReceive) {
        Map<String, String> dynamic_value_country = new HashMap<>();
        dynamic_value_country.put("element1", youReceive);

        click_you_receive_drop_down();

        if(dynamic_value_country.containsValue(youReceive)) {
            create_dynamically_locator("your_receive_text_currency_type_multiple", dynamic_value_country);
        } else {
            System.out.println("Selected default currency return type");
        }
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
        System.out.println("Current exchange value is:"+ roundedNumber);
        Reporter.log("Current exchange value is: "+ roundedNumber);
        return roundedNumber;
    }


    public void get_total_exchange_report(){


//
        String get_currency_type = get_currency_type();
        System.out.println("Currency type is: "+get_currency_type);
        Reporter.log("Currency type is: "+get_currency_type);


        String today_exchange_value = get_conversion_rate_today();
        String total_value_changed = today_exchange_value;
        System.out.println("Current exchange value is: "+total_value_changed);
        Reporter.log("Current exchange value is: "+total_value_changed);


        System.out.println("Amount you want to convert: "+get_enter_you_send());
        Reporter.log("Amount you want to convert: "+get_enter_you_send());

        int your_send = Integer.parseInt(get_enter_you_send());
        double doubleValue = Double.parseDouble(total_value_changed);

        long roundedResult = Math.round(doubleValue * your_send);

        System.out.println("Exchange value is: " +roundedResult);
        Reporter.log("Exchange value is: " +roundedResult);

        String current_date_of_exchange_is = get_current_date_and_time();
        System.out.println("Current date of exchange is: " +current_date_of_exchange_is);
        Reporter.log("Current date of exchange is: " +current_date_of_exchange_is);

        String total_fee_to_be_deducted_is = get_total_fee_to_be_deducted();
        System.out.println("Total fee to be deducted is: " +total_fee_to_be_deducted_is);
        Reporter.log("Total fee to be deducted is: " +total_fee_to_be_deducted_is);
    }

}