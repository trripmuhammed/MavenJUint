package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
        Notasyonlara sahip methodlar olusturabilmek icin mouse+sagtik+generate(kısayol alt+insert) yaparak
        after methodu icin tearDown'u seceriz.
        before method'u icin setup'i seceriz.
        test method'u icin de test'i seceriz.
            JUnit frameworkunde testlerimizi siralama yapaiblmek icin ekstra bir notasyon yokturç
        Eger belli bir silamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak
        belirtmemiz gerekir.
            Eger before ve after'i birden fazla kullanirsak ikisinide calistirir.
            Fakat onerilmez.
         */
    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra 1 kere calisir.");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once 1 kez calisir.");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu calisti.");
    }
    @Test
    public void test2() {
        System.out.println("Test2 methodu calisti.");
    }
    @Test
    public void test3() {
        System.out.println("Test3 methodu calisti.");
    }

}
