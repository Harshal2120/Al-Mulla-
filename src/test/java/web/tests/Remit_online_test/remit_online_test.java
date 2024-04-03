package web.tests.Remit_online_test;

import io.unity.framework.data.TestDatas;
import io.unity.framework.init.base;

import io.unity.framework.readers.DataReaders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.object_repository.Remit_Online.remit_online;

public class remit_online_test extends base {

    remit_online remit_online;


    @DataProvider(name = "get_validation_message")
    public Object[][] data_provider() {
        DataReaders reader = new DataReaders();
        Object[][] data;
        data = reader.getExcelDataForDataProvider("TestData.xlsx", 2);

        return data;
    }

    String enter_three_digit = TestDatas.random_alpha_numeric_string(3);
    String enter_twelve_digit  = TestDatas.random_alpha_numeric_string(12);

    @Test(dataProvider = "get_validation_message")
    public void verify_remit_online_page(String validation_text) {

        remit_online = new remit_online(driver);

        remit_online.click_on_remit_online_linked_text();
        remit_online.click_on_sign_up_button_on_remit_online();
        remit_online.click_on_civil_id_textbox();
        remit_online.enter_three_digits_on_civil_id_textbox("236");
        remit_online.click_on_send_otp_button();
        remit_online.verify_validation_message(validation_text);
        remit_online.enter_twelve_digits_on_civil_id_textbox("746993740982");
        remit_online.click_on_send_otp_button();

    }
}
