package web.tests.ExchangeRate;

import io.unity.framework.data.TestDatas;
import io.unity.framework.init.base;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.object_repository.ExchangeRate.exchange_rate;

public class currency_exchange_rateTests extends base {

    web.object_repository.ExchangeRate.exchange_rate exchange_rate = null;

//    @DataProvider(name = "currency_exchange_rate")
//    public Object[][] data_provider() {
//        DataReaders reader = new DataReaders();
//        Object[][] data = null;
//
//        data = reader.getExcelDataForDataProvider("TestData.xlsx", 0);
//
//        return data;
//    }


    @Test//(dataProvider = "currency_exchange_rate")
    public void verify_data_is_selected(){
        exchange_rate = new exchange_rate(driver);

        exchange_rate.enter_destination_country();

        exchange_rate.select_country_from_dropdown("destination_country_dropdown_select_single");

        //enter your amount
        String amount = TestDatas.random_numeric_string(3);
        exchange_rate.enter_you_send(amount);

        //get daily amount
        String get_daily_amount = exchange_rate.get_value();

        //extracting numeric value
        String extracted_value = exchange_rate.extractNumericValue(get_daily_amount);

        //calculation
        int get_calculated_value = exchange_rate.final_exchange_value(extracted_value,amount);
        System.out.println(get_calculated_value);
        int expected_value= exchange_rate.get_received_value();

        //comparing calculated and actual value
        Assert.assertEquals(get_calculated_value,expected_value);
        System.out.println(expected_value);

        exchange_rate.get_daily_kwd();
        exchange_rate.get_daily_date_time_and_delivery();
        exchange_rate.get_daily_fees();

    }
}
