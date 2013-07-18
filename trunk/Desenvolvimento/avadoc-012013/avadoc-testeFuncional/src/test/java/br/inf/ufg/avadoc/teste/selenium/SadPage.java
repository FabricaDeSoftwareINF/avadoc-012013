package br.inf.ufg.avadoc.teste.selenium;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Página com as funcionalidades do sistema SAD utilizando o padrao Page Objects
 * O Page Objects representa os elementos da interface com o usuário como uma
 * série de objetos que se comunicam entre si.
 * 
 * @author Thais
 * 
 */

public class SadPage {
	
	/**
	 *  Utilização da anotação @FindBy em conjunto com a classe PageFactory para
	 *  localizar elementos de forma simples e elegante
	 */

	/**
	 * Campos do login
	 */
	@FindBy(id = "j_username")
	private WebElement campoUser;
	@FindBy(id = "j_password")
	private WebElement campoPassword;
	@FindBy(name = "j_idt39")
	private WebElement btEntrar;
	
	/**
	 * Campos da avaliação
	 */
	@FindBy(id="menus:j_idt23")
	private WebElement menuAvaliacao;
	@FindBy(id="form:j_idt45_label")
	private WebElement comboSelecione;
	@FindBy(id="form:j_idt50_label")
	private WebElement comboTipoAvaliacao;
	@FindBy(id="form:j_idt55")
	private WebElement btAvaliar;
	@FindBy(id="")
	private WebElement notaDiretoria;
	@FindBy(id="")
	private WebElement btAvaliarProbatorio;
	
	
	
	
	
	
	private WebDriver driver;

	public SadPage(WebDriver driver) {
		this.driver = driver;
	}

	public void abre() throws Exception {
		driver.navigate().to("localhost:8080/avadoc-web/login.jsf");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public SadPage login(String user, String senha) {
		this.campoUser.sendKeys(user);
		this.campoPassword.sendKeys(senha);
		this.btEntrar.click();
		return new SadPage(driver);
	}

	public boolean isAcaoEfetuada(String mensagem) {
		return driver.findElement(By.tagName("body")).getText()
				.contains(mensagem);
	}
	
	public SadPage acessarAvaliarDocente(String docente, String tipoAvaliacao){
		this.menuAvaliacao.click();		
		this.comboSelecione.click();
		driver.findElement(By.xpath("/html/body/div[9]/div/ul/li"+docente)).click();
		this.comboTipoAvaliacao.click();
		driver.findElement(By.xpath("/html/body/div[10]/div/ul/li"+tipoAvaliacao)).click();
		this.btEntrar.click();
		return new SadPage(driver);
	}
	
	public SadPage calcularProbatorio(String nota2){
		this.notaDiretoria.sendKeys(nota2);
		this.btAvaliarProbatorio.click();
		return new SadPage(driver);		
		
	}
	
	public String esperarAte(final String value) {
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElement(By.tagName("body")).getText()
						.contains(value);
			}
		});
		return value;
	}

	public void reportError(Throwable e) throws Exception {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		e.printStackTrace();
		takePrint("erro_"
				+ formater.format(calendar.getTime()) + ".png");
	}

	public void takePrint(String dir) throws Exception {
		// captura na variavel e depois grava no diretorio listado
		File scrFoto = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFoto, new File(dir));
	}

}
