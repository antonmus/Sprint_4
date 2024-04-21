package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;


//Форма "Про аренду"
public class AboutRentPage {
    private final WebDriver driver;
    private final By fieldStartDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); //когда привезти(календарь с вводом)
    private final By termOfRent = By.className("Dropdown-control"); //срок аренды(выпадающий список)
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка заказать

    // Форма хотите оформить заказ
    private final By buttonYes = By.xpath(".//button[text()='Да']"); //кнопка да
    //private final By complitedOrder = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']"); //Форма заказ оформлен
    private final By complitedOrder = By.xpath(".//div[text()='Заказ оформлен']"); //Форма заказ оформлен

    //метод для заполнения формы "Про аренду"
    public void fillingFormAboutRent(String startDate) {

        driver.findElement(fieldStartDate).sendKeys(startDate, Keys.ENTER); //написать дату

        driver.findElement(termOfRent).click();
        driver.findElement(By.xpath(".//div[text()='двое суток']")).click(); //выбрать срок аренды

        driver.findElement(buttonOrder).click(); //нажать на кнопку заказать

        driver.findElement(buttonYes).click(); //нажать на кнопку да
    }

    //метод для проверки появления окна "Заказ оформлен"
    public void orderOk() {

       WebElement orderOk = driver.findElement(complitedOrder);
       assertTrue(orderOk.isDisplayed()); //проверить что появилось всплывающее окно заказ оформлен
    }
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }
}
