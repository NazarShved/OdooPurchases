package SoftAssertionsClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntroSoftAssertion {

    @Test
    public void test1(){
        System.out.println("TEst 1 is starting...");

        Assert.assertEquals(4,5);

        System.out.println("Tets 1 is middle...");

        Assert.assertTrue(false);

        System.out.println("Test1 is ending...");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 is starting...");
    }
}
