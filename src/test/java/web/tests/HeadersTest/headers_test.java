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
    public void verify_data_in_header(String About_us, String Services, String Branches, String Promotions, String Contact, String Remit_online, String News , String FAQS, String Arabic){
        headers = new headers(driver);
        driver.manage().window().maximize();
        headers.click_and_verify_about_us_link("ABOUT US","ABOUT US", About_us );
        headers.click_and_verify_services_link("SERVICES","WHY AL MULLA EXCHANGE?", Services);
        headers.click_and_verify_branches_link("BRANCHES","LOCATIONS", Branches);
        headers.click_and_verify_promotions_link("PROMOTIONS","PROMOTIONS",Promotions );
        headers.click_and_verify_contact_us_link("CONTACT","CONTACT", Contact );
        headers.click_and_verify_remit_online_link("REMIT ONLINE","Sign up",Remit_online );
        headers.click_and_verify_news_link("NEWS","NEWS", News );
        headers.click_and_verify_faq_link("FAQ'S","How can we help you?", FAQS);
        headers.click_and_verify_arabic_link("العربية","نبذة عن الشركة","نبذة عن الشركة" ,Arabic);


        headers.click_and_verify_company_overview_header_in_arabic("نبذة عن الشركة", "نبذة عن الشركة");
        headers.click_and_verify_services_header_in_arabic("SERVICES", "لماذا الملا للصيرفة ؟");
        headers.click_and_verify_branches_header_in_arabic("الفروع","LOCATIONS" );
        headers.click_and_verify_promotions_header_in_arabic( "العروض الترويجية", "العروض");
        headers.click_and_verify_contact_header_in_arabic("تواصل معنا","إتصل");
        headers.click_and_verify_remit_online_header_in_arabic("حوّل أون لاين", "Sign up");
        headers.click_and_verify_news_header_in_arabic("الأخبار", "الأخبار");
        headers.click_and_verify_faqs_header_in_arabic("الأسئلة الشائعة", "عفواً، هل تحتاج مساعدة؟");

    }
}

