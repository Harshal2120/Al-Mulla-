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
    public void verify_data_is_selected(String destinationCountry, String yourSend, String currencyType) {

        exchange_rate = new exchange_rate(driver);
        driver.manage().window().maximize();

        exchange_rate.enter_destination_country();
        exchange_rate.dynamic_value_input(destinationCountry);
        exchange_rate.enter_you_send(yourSend.replaceAll("\\..*", ""));
        exchange_rate.click_you_receive_drop_down();

        Map dynamic_value_you_receive = new HashMap();
        dynamic_value_you_receive.put("element1", currencyType);
        exchange_rate.create_dynamically_locator("your_receive_text_currency_type_multiple", dynamic_value_you_receive);
        exchange_rate.get_current_date_and_time();
        exchange_rate.get_total_fee_to_be_deducted();



    }


}