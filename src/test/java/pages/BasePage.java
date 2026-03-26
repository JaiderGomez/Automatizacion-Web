package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage() {
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    
	/**
	 * Metodo para Esperar elemento visible
	 * @author JAIDER GOMEZ
	 * */
    public WebElement esperarElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("Elemento NO visible: " + locator.toString());
        }
    }

    
	/**
	 * Metodo para Hacer CLICK
	 * @author JAIDER GOMEZ
	 * */
    public void click(By locator) {
        try {
            WebElement element = esperarElement(locator);
            
            //Scroll al elemento
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            
            element.click();
        } catch (Exception e) {
            throw new RuntimeException("Error al hacer CLICK en: " + locator.toString());
        }
    }
    
    
	/**
	 * Metodo para escribir
	 * @author JAIDER GOMEZ
	 * */
    public void escribir(By locator, String text) {
        try {
            WebElement element = esperarElement(locator);
            
            //Scroll al elemento
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Error al escribir en: " + locator.toString() + " texto: " + text);
        }
    }
    
    
	/**
	 * Metodo para seleccionar elemento
	 * @author JAIDER GOMEZ
	 * */
    public void select(By locator, String texto) {
        try {
            WebElement element = esperarElement(locator);

            // Scroll al elemento
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element
            );

            Select select = new Select(element);
            select.selectByVisibleText(texto);

        } catch (Exception e) {
            throw new RuntimeException("Error al seleccionar '" + texto + "' en: " + locator, e);
        }
    }
    
    
    
}
