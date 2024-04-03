package web.object_repository.ExchangeRate;

import io.unity.framework.exception.locator_validation_exception;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class exchange_rate {

    WebDriver driver ;
    Element element ;
    Verify verify ;
    Wait wait ;

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

    public void enter_you_send(String yourSend) {
        String value= yourSend.replaceAll("\\..*", "");
        Map dynamic_value_send = new HashMap();
        dynamic_value_send.put("element1",value);

        wait.wait_until_element_is_clickable("your_send_text_single");
        element.clear_and_enter_in_text_field("your_send_text_single",value);
        String today_exchange_value = get_conversion_rate_today();
        String hh = get_currency_type();
        String total_value_changed = today_exchange_value.replaceFirst(".*=", "").replace(hh,"");
        System.out.println("Current exchange value is: "+ total_value_changed);

        double doubleValue = Double.parseDouble(total_value_changed);
        int your_are_sending = Integer.parseInt(value);
        long roundedResult = Math.round( doubleValue* your_are_sending);
        System.out.println("Exchange value is: " +roundedResult);
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
        System.out.println("Amount you want to convert: " + str);
        return str;
    }

    public String get_currency_type(){
        String str = element.get_element_text("your_receive_text_currency_type_single");
        System.out.println("Currency type is: " + str);
        return str;
    }

    public String get_conversion_rate_today(){
        wait.wait_for_second(5);
        String str = element.get_element_text("price_calculated_today");
        return str;
    }

    public void get_current_date_and_time(){
        wait.wait_until_element_is_visible("date_and_time_of_delivery");
        String str = element.get_element_text("date_and_time_of_delivery");
        System.out.println("Current date of exchange is: " + str);

    }

    public void get_total_fee_to_be_deducted(){
        wait.wait_until_element_is_visible("fee_amount_currency_exchange");
        String str = element.get_element_text("fee_amount_currency_exchange");
        System.out.println("Total fee to be deducted is:" + str);

    }

    public void create_dynamically_locator(String locator, Map<String, String> dynamic_value ) {
        try { Map dynamic_value_you_receive = new HashMap();
            dynamic_value_you_receive.put("element1","");
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

    public void dynamic_value_input(String destinationCountry) {
        {
            wait.wait_for_second(4);
            Map dynamic_value_country = new HashMap();
            dynamic_value_country.put("element1", destinationCountry);

            if(dynamic_value_country.containsValue(destinationCountry)) {
                create_dynamically_locator("destination_country_dropdown_select_multiple", dynamic_value_country);
            }else{
                select_country_from_dropdown("destination_country_dropdown_select_single");
            }
        }

    }

    }
