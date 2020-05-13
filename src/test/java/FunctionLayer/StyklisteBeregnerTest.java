package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import FunctionLayer.Request;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StyklisteBeregnerTest {

    private Request reqF;
    private Request reqS;
    private int shedL;
    private int shedW;
    private StyklisteBeregner sb;
    private ArrayList<Material> stykliste;

    @Before
    public void setUp() throws Exception {
        reqF = new Request("mparking@live.dk", 600, 720, "Hardieplank",
                false, "Tagpap", 0, 240, 240);
        reqS = new Request("mparking@live.dk", 600, 720, "Hardieplank",
                true, "Eternittag", 25, 240, 240);
        sb = new StyklisteBeregner();
        stykliste = new ArrayList();
        shedL = 210;
        shedW = 240;
    }

    @Test
    public void round() {
        double result = sb.round(12.1234, 2);
        double exp = 12.12;
        assertEquals(exp, result, 0.0);
    }

    @Test
    public void spærPakkePris() {
        double result = sb.spærPakkePris(sb.antalSpær(reqS.getLength()), reqS.getWidth(), reqS.getSlopeangle(),
                reqS.getLength());
        double exp = 5749.42;
        assertEquals(exp, result, 0.0);
    }

    @Test
    public void antalSpær() {
        int result = sb.antalSpær(reqF.getLength());
        int exp = 16;
        assertEquals(exp, result);
    }

    @Test
    public void spærAfstand() {
        int result = sb.spærAfstand(reqF.getLength());
        int exp = 48;
        assertEquals(exp, result);
    }

    @Test
    public void længdeSpær() {
        int result = sb.længdeSpær(reqF.getWidth());
        int exp = 600;
        assertEquals(exp, result);
    }

    @Test
    public void spærPris() {
        double result = sb.spærPris(reqF.getWidth(), sb.antalSpær(reqF.getLength()));
        double exp = 5275.2;
        assertEquals(exp,result, 0.0);
    }

    @Test
    public void remPris() {
        double result = sb.remPris(reqF.getLength(), 2);
        double exp = 791.28;
        assertEquals(exp, result, 0.0);
    }

    @Test
    public void beslagSkrueAntal() {
        int result = sb.beslagSkrueAntal(reqF.getLength());
        int exp = 3;
        assertEquals(exp,result);
    }

    @Test
    public void stolpeAntal() {
        Request r = new Request("Mattemanden@gmail.com",400,400,"shed",true,"oak",0,200,200);
        StyklisteBeregner s = new StyklisteBeregner();
        //hver hjørne
        //skur 3 hjørner + 2 dør stolper =5
        //2 sider hvor der hver skal være 1 ekstra =2
        //1 side med 1
        //4+5+2+1=12
        int antalStolper= s.stolpeAntal(r);
        assertEquals(antalStolper,12);
        System.out.println("korrekt antal stolper");
    }
    @Test
    public void stolpePris() {
        Request r = new Request("Mattemanden@gmail.com",400,400,"shed",true,"oak",0,200,200);
        StyklisteBeregner s = new StyklisteBeregner();

        double antalPris= s.prisStolpe(r);
        assertEquals(antalPris,1711.56,0.1);
        System.out.println("korrekt pris");
    }

    // Test til skurets metoder:
    @Test
    public void amountWoodTest() {
        StyklisteBeregner s = new StyklisteBeregner();

        int result = s.amountWood(shedL, shedW);
        int exp = 112;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void priceWoodTest() {
        int amount = sb.amountWood(shedL, shedW);
        double result = sb.priceWood(amount);
        double exp = 6426.0;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void amountScrewsInnerTest() {
        int amount = sb.amountWood(shedL, shedW);
        int result = sb.amountScrewsInner(amount);
        int exp = 168;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void amountScrewsOuterTest() {
        int amount = sb.amountWood(shedL, shedW);
        int result = sb.amountScrewsOuter(amount);
        int exp = 336;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void amtBoxScrewInTest() {
        int amount = sb.amountWood(shedL, shedW);
        int amtScrIn = sb.amountScrewsInner(amount);
        int result = sb.amtBoxScrewIn(amtScrIn);
        int exp = 1;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void amtBoxScrewOutTest() {
        int amount = sb.amountWood(shedL, shedW);
        int amtScrOut = sb.amountScrewsOuter(amount);
        int result = sb.amtBoxScrewOut(amtScrOut);
        int exp = 2;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void priceLosholterTest() {
        double result = sb.priceLosholter(shedL);
        double exp = 719.4;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void priceScrewInTest() {
        int amount = sb.amountWood(shedL, shedW);
        int amtScrIn = sb.amountScrewsInner(amount);
        int amtBoxIn = sb.amtBoxScrewIn(amtScrIn);
        double result = sb.priceScrewIn(amtBoxIn);
        double exp = 99.95;
        assertEquals(result, exp, 0.1);
    }

    @Test
    public void priceScrewOutTest() {
        int amount = sb.amountWood(shedL, shedW);
        int amtScrOut = sb.amountScrewsOuter(amount);
        int amtBoxOut = sb.amtBoxScrewOut(amtScrOut);
        double result = sb.priceScrewOut(amtBoxOut);
        double exp = 398.0;
        assertEquals(result, exp, 0.1);
    }
}