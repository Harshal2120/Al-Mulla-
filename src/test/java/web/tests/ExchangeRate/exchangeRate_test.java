package web.tests.ExchangeRate;

import io.unity.framework.init.base;
import io.unity.framework.readers.DataReaders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.object_repository.ExchangeRate.exchange_rate;
import java.util.HashMap;
import java.util.Map;

public class exchangeRate_test extends base {

    web.object_repository.ExchangeRate.exchange_rate exchange_rate = null;

    @DataProvider(name = "currency_exchange_rate")
    public Object[][] data_provider() {
        DataReaders reader = new DataReaders();

        Object[][] data = null;


        data = reader.getExcelDataForDataProvider("TestData.xlsx", 0);

        return data;
    }

    @Test(dataProvider = "currency_exchange_rate")
    public void verify_data_is_selected(String destinationCountry, String yourSend, String currencyType){

        exchange_rate = new exchange_rate(driver);
        driver.manage().window().maximize();
        Map dynamic_value_country = new HashMap();
        dynamic_value_country.put("element1",destinationCountry);

        exchange_rate.enter_destination_country();

         /*
        Printing the value inside the excel for destination country
         */
        if(dynamic_value_country.containsValue(destinationCountry)) {
            exchange_rate.create_dynamically_locator("destination_country_dropdown_select_multiple", dynamic_value_country);
        }else{
            exchange_rate.select_country_from_dropdown("destination_country_dropdown_select_single");
        }

        /*
        Your Send
         */
        String value= yourSend.replaceAll("\\..*", "");

        Map dynamic_value_send = new HashMap();
        dynamic_value_send.put("element1",value);


        exchange_rate.enter_you_send(yourSend.replaceAll("\\..*", ""));


        /*
        Your receive
         */
        Map dynamic_value_you_receive = new HashMap();
        dynamic_value_you_receive.put("element1",currencyType);

        if(dynamic_value_you_receive.containsValue(currencyType)){
            exchange_rate.click_you_receive_drop_down();
            exchange_rate.create_dynamically_locator("your_receive_text_currency_type_multiple", dynamic_value_you_receive);
        }else {
            System.out.println("Selected default currency return type");
        }

        String get_currency_type = exchange_rate.get_currency_type();
        System.out.println("Currency type is: "+get_currency_type);

        String today_exchange_value = exchange_rate.get_conversion_rate_today();
        String total_value_changed = today_exchange_value.replaceFirst(".*=", "").replace(get_currency_type,"");
        System.out.println("Current exchange value is: "+total_value_changed);


        System.out.println("Amount you want to convert: "+exchange_rate.get_enter_you_send());

        int your_send = Integer.parseInt(exchange_rate.get_enter_you_send());
        double doubleValue = Double.parseDouble(total_value_changed);

        long roundedResult = Math.round(doubleValue * your_send);

        System.out.println("Exchange value is: " +roundedResult);

        String current_date_of_exchange_is = exchange_rate.get_current_date_and_time();
        System.out.println("Current date of exchange is: " +current_date_of_exchange_is);

        String total_fee_to_be_deducted_is = exchange_rate.get_total_fee_to_be_deducted();
        System.out.println("Total fee to be deducted is: " +total_fee_to_be_deducted_is);

    }


}