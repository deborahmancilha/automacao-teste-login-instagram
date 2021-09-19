package tests;

import static org.junit.Assert.*; //importação estática de todos os métodos dessa classe

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName(); //obter nome do método atual

    @Before
    public void setup() {

        //Abre o navegador:
        System.setProperty("webdriver.chrome.driver", "C:\\todosdrivers\\chromedriver.exe"); //ChromeDriver
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        // Navegando para a pág:
        navegador.get("https://www.instagram.com");
    }

    @Test
    public void testLogin() {

        //Identificar campo com name "username" que está dentro do label de class "f0n8F"
        WebElement formularioSignInBox = navegador.findElement(By.className("f0n8F"));

        //Digitar no campo com name "username" que está dentro do label de class "f0n8F" o texto "debsqueendom"
        formularioSignInBox.findElement(By.name("username")).sendKeys("contateste_0102");

        //Digitar no campo com name "password" o texto "LuaNova_382"
        navegador.findElement(By.name("password")).sendKeys("Teste0102");

        //Clicar no link de login com elemento CSS ".Igw0E"
        navegador.findElement(By.cssSelector(".Igw0E")).click();

        //Clicar no button Agora Não em Salvar informações de login
        navegador.findElement(By.xpath("//div[@class='cmbtv']/button")).click();

        //Clicar em Agora Não em Ativar Notificações
        navegador.findElement(By.xpath("//button[contains(text(),'Agora não')]")).click();

        //Validar login
        WebElement login = navegador.findElement(By.className("gmFkV"));
        String textologin = login.getText();
        assertEquals("contateste_0102", textologin);

        //print do resultado do login
        String print = "C:\\Users\\debor\\IdeaProjects\\br.com.deborahmancilha.webdriverJava\\test-report\\"
                + Generator.dataHoraParaArquivo()
                + test.getMethodName()
                + ".png";
        Screenshot.tirar(navegador, print);

    }

    @After
    public void tearDown() {
        //Fechar o navegador
        //navegador.quit();
    }
}