package packagebibtex.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import packagebibtex.ArticleConsoleInputStrategy;

public class TestIsValidDOI{
    ArticleConsoleInputStrategy currDriver = new ArticleConsoleInputStrategy();
    @Test
    public void Case0(){
        assertEquals(currDriver.isValidDOI(""), false);
    }

    @Test
    public void Case1(){
        assertEquals(currDriver.isValidDOI("https:"), false);
    }

    @Test
    public void Case2(){
        assertEquals(currDriver.isValidDOI("@@@__https://"), false);
    }

    @Test
    public void Case3(){
        assertEquals(currDriver.isValidDOI("https://doi.org/"), false);
    }

    @Test
    public void Case4(){
        assertEquals(currDriver.isValidDOI("https://doi.org/253.53"), false);
    }

    @Test
    public void Case5(){
        assertEquals(currDriver.isValidDOI("https://doi.org/25.241"), false);
    }

    @Test
    public void Case6(){
        assertEquals(currDriver.isValidDOI("https://doi.org/25.2422/abc"), true);
    }

    @Test
    public void Case7(){
        assertEquals(currDriver.isValidDOI("https://doi.org/ah.2422/abc"), false);
    }

    @Test
    public void Case8(){
        assertEquals(currDriver.isValidDOI("https://doi.org/24.fa3a/abc"), false);
    }

    @Test
    public void Case9(){
        assertEquals(currDriver.isValidDOI("https://doi.org/22.2533/__abc"), true);
    }

}

