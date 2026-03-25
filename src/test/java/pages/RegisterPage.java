package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class RegisterPage extends BasePage{
	
	
	//Localizadores 
	By register_link = By.xpath("//a[@class='ico-register']");
	By gender_male_input = By.xpath("//input[@id='gender-male']");
	By gender_female_input = By.xpath("//input[@id='gender-female']");
	By first_name_input = By.xpath("//input[@id='FirstName']");
	By last_name_input = By.xpath("//input[@id='LastName']");
	By email_input = By.xpath("//input[@id='Email']");
	By password_input = By.xpath("//input[@id='Password']");
	By confirm_password_input = By.xpath("//input[@id='ConfirmPassword']");
	By btn_register = By.xpath("//input[@id='register-button']");
	By btn_continue = By.xpath("//input[contains(@class, 'register-continue-button')]");
	By result_div = By.xpath("//div[@class = 'result']");
	
	//Clic registro
    public void clickRegister() {
        click(register_link);
    }
    
    //generar email
    public String generarEmail() {
        return "test" + System.currentTimeMillis() + "@gmail.com";
    }
    
    
   
	/**
	 * Llenar Formulario
	 * @author JAIDER GOMEZ
	 * */
    public void ingresarDatos(Boolean gender, String first_name, String last_name, String password) {
        String email = generarEmail();
        
        if (gender) {
        	click(gender_male_input);
			
		} else {
			click(gender_female_input);
		}      
        
        escribir(first_name_input, first_name);
        escribir(last_name_input, last_name);
        escribir(email_input, email);
        escribir(password_input, password);
        escribir(confirm_password_input, password);
        
        
        click(btn_register);
        

    }

    //Verificar que el registro sea exitoso
    public String verificarRegistroExitoso() {
    	String result = driver.findElement(result_div).getText();
    	if (result.equalsIgnoreCase("Your registration completed")) {
    		return "Pass";
			
		}else {
			return "Fail";
		}

    }
	
	

}
