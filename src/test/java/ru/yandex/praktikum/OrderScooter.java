package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.page.AboutRentPage;
import ru.yandex.praktikum.page.ForWhomPage;
import ru.yandex.praktikum.page.MainPageScooter;

@RunWith(Parameterized.class)
public class OrderScooter {

   private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String startDate;
   public OrderScooter(String name, String surname, String address, String phone, String startDate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.startDate = startDate;
    }

   @Parameterized.Parameters
    public static Object[][] getOrderScooter() {
        return new Object[][]{
                {"Аркадий", "Укупник", "Паспортовая д.12", "89051234567", "12.12.2025"},
                {"Святослав", "Русич", "Сильная д.12", "89051234356", "11.11.2026"},
        };
    }

   @Before
   public void setup() {
      driver = WebDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
      driver.get("https://qa-scooter.praktikum-services.ru");
   }

    @Test
    public void orderScooterVerOne(){

        MainPageScooter mainPageScooter = new MainPageScooter(driver);

        mainPageScooter.cookikeClick();

        mainPageScooter.clickButtonUp();

        ForWhomPage forWhomPage = new ForWhomPage(driver);

        forWhomPage.fillinfFormForWhom(name, surname, address, phone);

        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        aboutRentPage.fillingFormAboutRent(startDate);

        aboutRentPage.orderOk();
   }

   @Test
   public void orderScooterVerTwo(){
       MainPageScooter mainPageScooter = new MainPageScooter(driver);

       mainPageScooter.cookikeClick();

       mainPageScooter.clickButtonDown();

       ForWhomPage forWhomPage = new ForWhomPage(driver);

       forWhomPage.fillinfFormForWhom(name, surname, address, phone);

       AboutRentPage aboutRentPage = new AboutRentPage(driver);

       aboutRentPage.fillingFormAboutRent(startDate);

       aboutRentPage.orderOk();
   }

   @After
    public void tearDown() {
        driver.quit();
}
}
