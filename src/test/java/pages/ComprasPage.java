package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.lang.Thread;

public class ComprasPage extends BasePage{
	
	//Localizadores
	By login_link = By.className("ico-login");
	By email_input = By.id("Email");
	By password_input = By.id("Password");
	By btn_login = By.className("login-button");
	By computers_category_link = By.xpath("//div[contains(@class,'block-category-navigation')]//li//a[normalize-space()='Computers']");
	By desktops_sub_category_link = By.xpath("//div[contains(@class,'block-category-navigation')]//li//a[normalize-space()='Desktops']");
	By product72_link = By.xpath("//div[@data-productid='72']//h2[@class='product-title']/a");
	By btn_add_cart_product72 = By.id("add-to-cart-button-72");
	By shopping_cart_link = By.className("ico-cart");
	By agree_terms_of_service_input = By.id("termsofservice");
	By btn_checkout = By.id("checkout");
	
	By company_input = By.id("BillingNewAddress_Company"); //Billing address
	By country_selet = By.id("BillingNewAddress_CountryId"); //Billing address
	By city_input = By.id("BillingNewAddress_City"); //Billing address
	By address1_input = By.id("BillingNewAddress_Address1"); //Billing address
	By address2_input = By.id("BillingNewAddress_Address2"); //Billing address
	By postalCode_input = By.id("BillingNewAddress_ZipPostalCode"); //Billing address
	By phoneNumber_input = By.id("BillingNewAddress_PhoneNumber"); //Billing address
	By faxNumber_input = By.id("BillingNewAddress_FaxNumber"); //Billing address

	By btn_continue_billing_address = By.xpath("//li[@id = 'opc-billing']//input[contains(@class, 'new-address-next-step-button')]"); //Billing address
	By btn_continue_shipping_address = By.xpath("//li[@id = 'opc-shipping']//input[contains(@class, 'new-address-next-step-button')]"); 
	By btn_continue_shipping_method = By.xpath("//li[@id = 'opc-shipping_method']//input[contains(@class, 'shipping-method-next-step-button')]");
	By btn_continue_payment_method = By.xpath("//li[@id = 'opc-payment_method']//input[contains(@class, 'payment-method-next-step-button')]");
	By btn_continue_payment_info = By.xpath("//li[@id = 'opc-payment_info']//input[contains(@class, 'payment-info-next-step-button')]");
	By btn_confirm_order = By.xpath("//li[@id = 'opc-confirm_order']//input[contains(@class, 'confirm-order-next-step-button')]");
	
	By paymentmethod_Credit_Card_input = By.id("paymentmethod_2"); //Payment information
	By select_credit_card = By.id("CreditCardType"); //Payment information
	By card_holder_Name_input = By.id("CardholderName"); //Payment information
	By card_Number_input = By.id("CardNumber"); //Payment information
	By expireMonth_selet = By.id("ExpireMonth"); //Payment information
	By expire_Year_selet = By.id("ExpireYear"); //Payment information
	By card_Code_input = By.id("CardCode"); //Payment information
	
	By order_result = By.xpath("//div[@class = 'section order-completed']//div[@class='title']/strong");
	
	
	
	
	/*
	 * Metodo que permite hacer Login
	 * @author JAIDER GOMEZ
	 * */
	public void iniciarSesion(String email, String password) {
        click(login_link);
        escribir(email_input, email);
        escribir(password_input, password);
        click(btn_login);
		
		

	}
	
	
	
	
	
	/*
	 * Metodo Agrega un producto al carrito
	 * @author JAIDER GOMEZ
	 * */
	public void agregaProductoAlCarrito() {
		click(computers_category_link);
		click(desktops_sub_category_link);
		click(product72_link);
		click(btn_add_cart_product72);
		click(shopping_cart_link);
		click(agree_terms_of_service_input);
		click(btn_checkout);
		
	}
	
	
	
	/*
	 * Metodo para Ingresar datos solicitados para la entrega
	 * @author JAIDER GOMEZ
	 * */
    public void ingresarDatosParaLaEntrega(String empresa, String pais, String ciudad, String direccion_1, String direccion_2, String codigo_postal, String num_celular, String num_fax){

		escribir(company_input, empresa);
		select(country_selet, pais);
		escribir(city_input, ciudad);
		escribir(address1_input, direccion_1);
		escribir(address2_input, direccion_2);
		escribir(postalCode_input, codigo_postal);
		escribir(phoneNumber_input, num_celular);
		escribir(faxNumber_input, num_fax);
		
		click(btn_continue_billing_address);
		click(btn_continue_shipping_address);
		click(btn_continue_shipping_method);
		

		
    }
    
	/*
	 * Metodo para Selecciona método de pago y Completa la información de pago
	 * @author JAIDER GOMEZ
	 * */
    public void seleccionarMetodoDePago() {
    	
    	click(paymentmethod_Credit_Card_input);
    	click(btn_continue_payment_method);
    	
    	//Ingresar Información de pago
    	select(select_credit_card, "Visa");
    	escribir(card_holder_Name_input, "Barbara Gordon");
    	escribir(card_Number_input, "4485564059489345");
    	select(expireMonth_selet, "04");
    	select(expire_Year_selet, "2039");
    	escribir(card_Code_input, "123");
        //Ingresar Información de pago
    	
    	click(btn_continue_payment_info);
    	click(btn_confirm_order);


		
	}
    
    
	/*
	 * Metodo para Obtener el resultado
	 * @author JAIDER GOMEZ
	 * */
    public String obtenerResultado() {
    	WebElement element = esperarElement(order_result);

        // Scroll al elemento
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", element
        );
        
    	String result = element.getText();		
    	return result;
    }
    

}
