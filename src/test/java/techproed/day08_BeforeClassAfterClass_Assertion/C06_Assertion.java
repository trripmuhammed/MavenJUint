package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    /*
    Assertionlarda exitlik icin expected,actual olarak kullanilir.
     */
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test04() {
        String actualName = "erol";
        String expectedName = "Erol";
        Assert.assertEquals(actualName,expectedName);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test05() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertTrue(emeklilikYas<yas);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test06() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertTrue(emeklilikYas>yas);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test07() {
        int yas = 50;
        int emeklilikYas = 65;
        Assert.assertFalse(emeklilikYas<yas);
        System.out.println("Test basarili bir sekilde calisti");
    }


}
