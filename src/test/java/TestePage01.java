import Pages.Page01;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestePage01 {

    private static Page01 page;

    @BeforeEach
    public void setUp() {
        page = new Page01();
        page.openApp();
    }


    @Test
    public void bugBankFlowTest() throws InterruptedException {
        page.registrarConta();
        Thread.sleep(2000);
        page.inputPersonalDetails("annagl@exemple.com","Anna","abc123","abc123");
        Thread.sleep(2000);
        page.cadastrarConta();
        Thread.sleep(2000);
        page.btnFecharModal();
        Thread.sleep(2000);
        page.inputAccessDetails("annagl@exemple.com","abc123");
        Thread.sleep(2000);
        page.confirmarAcesso();
        Thread.sleep(2000);
        page.acessoExtrato();
        Thread.sleep(2000);
        page.sairExtrato();
        Thread.sleep(2000);
        page.acessarTransferencia();
        Thread.sleep(2000);
        page.inputTransferenciaDetails("12345","0","100","Test 1");
        Thread.sleep(2000);
        page.concluirTransferencia();
        Thread.sleep(4000);
        String resultado = page.getError();

        assertTrue(resultado.contains("Conta inválida ou inexistente"));

        System.out.println("Resultado da busca: " + resultado);
        Thread.sleep(2000);
    }



    @AfterEach
    public void tearDown() {
        page.quitDriver();
    }


}
