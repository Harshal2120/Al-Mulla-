package web.tests.ExchangeRate;

import io.unity.framework.init.base;
import io.unity.framework.readers.DataReaders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.annotations.DataProvider;
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

        String amount = "110";
        exchange_rate.enter_you_send(amount);

        String you = exchange_rate.get_value();
        exchange_rate.extractNumericValue(you);
        exchange_rate.get_text();

        String value = exchange_rate.get_text();
        int ghsdvqhvd = exchange_rate.final_exchange_value(value,amount);
        System.out.println(ghsdvqhvd);

    }


}
