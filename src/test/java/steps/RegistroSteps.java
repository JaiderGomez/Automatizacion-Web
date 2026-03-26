package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.es.*;
import pages.RegistroPage;
import utils.Email;

public class RegistroSteps {
	
	RegistroPage registerPage = new RegistroPage();

    @Dado("el usuario entra a la pagina")
    public void elUsuarioEntraALaPagina() {
        // Se abre en el Hook
    }

    @Cuando("el usuario se registra correctamente")
    public void elUsuarioSeRegistraCorrectamente() {
        registerPage.clickRegister();
        registerPage.ingresarDatos(false, "Test", "Gomez", "12345678");
        
        Email.email = registerPage.obtenerEmail();
    }

    @Entonces("el registro debe ser exitoso")
    public void elRegistroDebeSerExitoso() {
    	String mensaje = registerPage.verificarRegistroExitoso();
        assertEquals("El registro NO fue exitoso", "Your registration completed", mensaje);
    	
   
    	
    	
    }

}
