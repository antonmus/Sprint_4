package ru.yandex.praktikum.page;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//Главная страница
public class MainPageScooter {
    private final WebDriver driver;
    private final By cookieButton = By.xpath(".//button[text()='да все привыкли']");  //кнопка модуля про куки
    private final By buttonOrderUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']"); //кнопка Заказать №1
    private final By buttonOrderDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"); //кнопка Заказать №2
    private final String questionLocator = "accordion__heading-%s"; //вопросы в аккордеоне
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']"; //ответы в аккордеоне

    //метод для нажатия верхней кнопки "Заказать"
    public void clickButtonUp() {
        driver.findElement(buttonOrderUp).click();
    }

    //метод для нажатия нижней кнопки "Заказать"
    public void clickButtonDown() {

        WebElement element = driver.findElement(buttonOrderDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(buttonOrderDown).click();
    }

    //метод для нажатия на кнопку в модули про куки
    public void cookikeClick(){
        driver.findElement(cookieButton).click();
    }
    public  void expandQuestion(int index){

        WebElement element = driver.findElement(By.id(String.format(questionLocator, index)));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public  boolean answerIsDisplayed(String expectedAnswer){
        WebElement element = driver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }
}



