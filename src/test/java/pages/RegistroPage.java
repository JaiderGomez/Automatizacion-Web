package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;



public class RegistroPage extends BasePage{
	
	
	//Localizadores 
	By register_link = By.className("ico-register");
	By gender_male_input = By.id("gender-male");
	By gender_female_input = By.id("gender-female");
	By first_name_input = By.id("FirstName");
	By last_name_input = By.id("LastName");
	By email_input = By.id("Email");
	By password_input = By.id("Password");
	By confirm_password_input = By.id("ConfirmPassword");
	By btn_register = By.id("register-button");
	By result_div = By.className("result");
	
	
	private String emailGenerado;
	

    
    //generar email
    public String generarEmail() {
    	return "test" + System.currentTimeMillis() + "@gmail.com";
    }
    

    
	//Clic registro
    public void clickRegister() {
        click(register_link);
    }
   
	/**
	 * Llenar Formulario
	 * @author JAIDER GOMEZ
	 * */
    public void ingresarDatos(Boolean gender, String first_name, String last_name, String password) {
        emailGenerado = generarEmail();
        
        if (gender) {
        	click(gender_male_input);
			
		} else {
			click(gender_female_input);
		}      
        
        escribir(first_name_input, first_name);
        escribir(last_name_input, last_name);
        escribir(email_input, emailGenerado);
        escribir(password_input, password);
        escribir(confirm_password_input, password);
        
        
        click(btn_register);
        

    }
    
    //Obtener email
    public String obtenerEmail() {
        return emailGenerado;
    }

    //Obtener resultado
    public String verificarRegistroExitoso() {
    	WebElement element = esperarElement(result_div);

        // Scroll al elemento
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", element
        );
        
    	String result = element.getText();
    	return result;

    }
	
	

}
