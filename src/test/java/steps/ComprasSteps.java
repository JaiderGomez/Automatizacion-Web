package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.es.*;
import pages.ComprasPage;
import utils.Email;

public class ComprasSteps {
	
	ComprasPage comprasPage = new ComprasPage();
	
	@Dado("el usuario inicia sesión")
	public void elUsuarioIniciaSesión() {
		comprasPage.iniciarSesion(Email.email, "12345678");
		
	}
	
	@Cuando("realiza la compra de un producto")
	public void realizaLaCompraDeUnProducto() {
		comprasPage.agregaProductoAlCarrito();
		comprasPage.ingresarDatosParaLaEntrega("Test Empresa", "Colombia", "Bogota", "Calle 20 #12-23", "Cra &7 #56-87", "12342", "3173333333", "2345678");
		comprasPage.seleccionarMetodoDePago();

	}
	
	@Entonces("valida compra exitosa")
	public void validaCompraExitosa() {

    	String mensaje = comprasPage.obtenerResultado();
        assertEquals("La Compra NO fue exitoso", "Your order has been successfully processed!", mensaje);
	}
	

}
