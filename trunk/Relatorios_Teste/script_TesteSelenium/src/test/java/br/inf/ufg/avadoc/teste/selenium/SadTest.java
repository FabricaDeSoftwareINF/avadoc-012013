package br.inf.ufg.avadoc.teste.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import br.inf.ufg.avadoc.teste.selenium.SadPage;

/**
 * Suite: SAD
 * Caso de Teste: avadoc-1:Logar no sistema
 * link: http://fs.inf.ufg.br/testlink/index.php
 * @author Thais
 *
 */

public class SadTest {
	private SadPage telaDeLogin;
	private WebDriver driver;

	@Before
	public void setup() throws Exception {
		driver = new FirefoxDriver();
		telaDeLogin = new SadPage(driver);
		telaDeLogin.abre();
		telaDeLogin = PageFactory.initElements(driver, SadPage.class);

	}
	
	/**
	 * avadoc-1: Testar o login quando informa-se os dados corretos
	 * @Test
	 * @throws Exception
	 */

	@Test
	public void testLoginSucesso() throws Exception {
		try {

			telaDeLogin.login("admin", "admin");
			Assert.assertEquals(telaDeLogin.isAcaoEfetuada("Inicio"), true);
		} catch (AssertionError e) {
			telaDeLogin.reportError(e);
		} catch (Exception e) {
			telaDeLogin.reportError(e);
		}
	}
	
	/**
	 * avadoc-1: Testar quando informa-se as credenciais incorretas
	 * @Test
	 * @throws Exception
	 */

	@Test
	public void testLoginFail() throws Exception {
		try {

			
			telaDeLogin.login("usuarioinvalido", "senhainvalida123");
			Assert.assertEquals(telaDeLogin.isAcaoEfetuada("Inicio"),false);
		} catch (AssertionError e) {
			telaDeLogin.reportError(e);
		} catch (Exception e) {
			telaDeLogin.reportError(e);
		}
	}
	
	/**
	 * Suite: SAD
	 * Caso de Teste: avadoc-2:Cálculo da avaliação parcial do docente em estágio probatório - 20 horas
	 * link: http://fs.inf.ufg.br/testlink/index.php
	 * @author Thais
	 *
	 */
	
	
	/**
	 * avadoc-2: Testar a nota parcial
	 * @throws Exception
	 * @Test
	 * 
	 */
	
	@Test
	public void testCalcularProbatorio20() throws Exception {
		try {
			telaDeLogin.login("admin", "admin");
			telaDeLogin.acessarAvaliarDocente("[2]", "[2]");
			telaDeLogin.calcularProbatorio("5");
			
			Assert.assertEquals(telaDeLogin.isAcaoEfetuada("Nota Parcial: 8.3"), true);
		} catch (AssertionError e) {
			telaDeLogin.reportError(e);
		} catch (Exception e) {
			telaDeLogin.reportError(e);
		}
	}	
	

	@After	
	public void DepoisDeTudoFeito() {
		driver.quit();
	}
	
	public void after(){
		driver.manage().deleteAllCookies();
	}

}
