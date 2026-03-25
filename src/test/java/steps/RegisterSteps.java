package steps;

import io.cucumber.java.es.*;
import pages.RegisterPage;

public class RegisterSteps {
	
	RegisterPage registerPage = new RegisterPage();

    @Dado("el usuario entra a la pagina")
    public void elUsuarioEntraALaPagina() {
        // Se abre en el Hook
    }

    @Cuando("el usuario se registra correctamente")
    public void elUsuarioSeRegistraCorrectamente() {
        registerPage.clickRegister();
        registerPage.ingresarDatos(false, "Test", "Gomez", "123456789");
    }

    @Entonces("el registro debe ser exitoso")
    public void elRegistroDebeSerExitoso() {
    	registerPage.verificarRegistroExitoso();
    	
    	
    }

}
