package web.tests.HeadersTest;

import io.unity.framework.init.base;
import io.unity.framework.readers.DataReaders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.object_repository.Headers.headers;

public class headers_test extends base {

    web.object_repository.Headers.headers headers;
    @DataProvider(name = "get_texts_link")
    public Object[][] data_provider() {
        DataReaders reader = new DataReaders();
        Object[][] data;
        data = reader.getExcelDataForDataProvider("TestData.xlsx", 1);

        return data;
    }

    @Test(dataProvider = "get_texts_link")
    public void verify_headers(String About_us, String Services, String Branches, String Promotions, String Contact, String Remit_online, String News , String FAQS, String Arabic){
        headers = new headers(driver);
        headers.click_and_verify_about_us_link("ABOUT US", About_us );
        headers.click_and_verify_services_link("WHY AL MULLA EXCHANGE?", Services);
        headers.click_and_verify_branches_link("LOCATIONS", Branches);
        headers.click_and_verify_promotions_link("PROMOTIONS",Promotions );
        headers.click_and_verify_contact_us_link("CONTACT", Contact );
        headers.click_and_verify_remit_online_link("LOGIN",Remit_online );
        headers.click_and_verify_news_link("NEWS", News );
        headers.click_and_verify_faq_link("How can we help you?", FAQS);
        headers.click_and_verify_arabic_link("نبذة عن الشركة", Arabic);
    }
}

