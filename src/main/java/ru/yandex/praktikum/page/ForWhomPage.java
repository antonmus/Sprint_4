package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Форма "Для кого"
public class ForWhomPage {
    private final WebDriver driver;
    private final By fieldName = By.xpath("//input[@placeholder='* Имя']"); //имя
    private final By fieldSurname = By.xpath("//input[@placeholder='* Фамилия']"); //фамилия
    private final By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); //адрес
    private final By stationOfMetro = By.className("select-search"); //станция метро(выпадающий список)
    private final By fieldPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); //телефон
    private final By buttonNext = By.xpath("//button[text()='Далее']"); //кнопка далее

    //метод для заполнения формы "для кого"
    public void fillinfFormForWhom(String name, String surname, String address, String phone) {

        driver.findElement(fieldName).sendKeys(name); //написать имя

        driver.findElement(fieldSurname).sendKeys(surname); //напистаь фамилию

        driver.findElement(fieldAddress).sendKeys(address); //написать адрес

        driver.findElement(stationOfMetro).click(); //выбрат станцию метро

        driver.findElement(By.xpath(".//button[@value='1']")).click(); //выбрать станцию метро

        driver.findElement(fieldPhone).sendKeys(phone); //написать номер телефона

        driver.findElement(buttonNext).click(); //нажать кнопку далее
    }
    public ForWhomPage(WebDriver driver){
        this.driver = driver;
    }

}
