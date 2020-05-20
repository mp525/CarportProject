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


    // Roof Flat tests begin

    @Test
    public void roofPlateLengthsTest(){
        int result = StyklisteBeregner.roofPlateLengths(reqF);
        int exp = 750;
        assertEquals(exp, result);
    }

    @Test
    public void numRofPlatesSinglsTest(){
    int result = StyklisteBeregner.numRofPlatesSingls(reqF);
    int exp = 10;
    assertEquals(exp, result);
    }

@Test
public void rofMatPris(){
        double result = StyklisteBeregner.roofMatPrice(reqF);
        double exp = 2990.0;
        assertEquals(exp,result,0.0);
}


    @Test
    public void RofScrewPrice(){
        double result = StyklisteBeregner.RofScrewPrice(reqF);
            double exp = 818.0;
            assertEquals(exp,result,0.0);
    }

    @Test
    public void numOfRofScrews(){
        int result = sb.numOfRofScrews(reqF);
        int exp = 3;
        assertEquals(exp,result);

    }

    @Test
    public void Cal25x200x300FnBTest(){
        int result = StyklisteBeregner.Cal25x200x300FnB(reqF);
        int exp = 4;
        assertEquals(exp,result);

    }
    @Test
    public void Cal25x200x300FnBPriceTest(){
        double result = StyklisteBeregner.Cal25x200x300FnBPrice(reqF);
        double exp = 135.8;
        assertEquals(exp,result,0.0);

    }

    @Test
    public void Cal25x125x300FrontTest(){
        int result = StyklisteBeregner.Cal25x125x300Front(reqF);
        int exp = 2;
        assertEquals(exp, result);
    }

    @Test
    public void Cal25x125x300FrontPriceTest(){
        double result = StyklisteBeregner.Cal25x125x300FrontPrice(reqF);
        double exp = 55.9;
        assertEquals(exp,result,0.0);
    }

    @Test
    public void Cal25x125x360SidesTest(){
        int result = StyklisteBeregner.Cal25x125x360Sides(reqF);
        int exp = 4;
        assertEquals(exp, result);
    }

    @Test
    public void Cal25x125x360SidesPriceTest(){
        double result = StyklisteBeregner.Cal25x125x360SidesPrice(reqF);
        double exp = 111.8;
        assertEquals(exp,result,0.0);
    }


    @Test
    public void CaL19x100x480Test(){
        int result = StyklisteBeregner.CaL19x100x480(reqF);
        int exp = 2;
        assertEquals(exp,result);

    }

    @Test
    public void CaL19x100x480PriceTest(){
        double result = StyklisteBeregner.CaL19x100x480Price(reqF);
        double exp = 45.9;
        assertEquals(exp,result,0.0);

    }

@Test
public void CaL19x100x420ForendTest(){
    int result = StyklisteBeregner.CaL19x100x420Forend(reqF);
    int exp = 2;
    assertEquals(exp,result);
}

@Test
public void CaL19x100x420ForendPriceTest(){
        double result = StyklisteBeregner.CaL19x100x420ForendPrice(reqF);
        double exp = 45.9;
        assertEquals(exp,result,0.0);
}

    //Roof Flat tests end




    //Roof slop tests start

    @Test
    public void antalBnCDobTest(){
        int result = StyklisteBeregner.antalBnCDob(reqS);
        int exp = 480;
        assertEquals(exp,result);
    }

    @Test
    public void prisBnCDob(){
            double result = StyklisteBeregner.prisBnCDob(reqS);
            double exp = 2616.0;
            assertEquals(exp, result,0.0);
    }

    @Test
    public void antalRygsten(){
        int result = StyklisteBeregner.antalRygsten(reqS);
        int exp = 17;
        assertEquals(exp,result);
    }

    @Test
    public void prisRygsten(){
        double result = StyklisteBeregner.prisRygsten(reqS);
        double exp = 169.0;
        assertEquals(exp,result,0.0);
    }


    @Test
    public void antalTopLaegHolds(){
        int result = StyklisteBeregner.antalTopLaegHolds(reqS);
        int exp = 8;
        assertEquals(exp,result);
    }
    @Test
    public void prisTopLaegHolds(){
        double result = StyklisteBeregner.prisTopLaegHolds(reqS);
        double exp = 8.0;
        assertEquals(exp,result,0.0);
    }
    @Test
    public void antalRygstensBeslagTest(){
        int result = StyklisteBeregner.antalRygstensBeslag(reqS);
        int exp = 17;
        assertEquals(exp,result);
    }
    @Test
    public void prisRygstensBeslagTest(){
        double result = StyklisteBeregner.prisRygstensBeslag(reqS);
        double exp = 169.0;
        assertEquals(exp,result,0.0);
    }


    @Test
    public void strlseSternSidder25n150nx(){
        int result = StyklisteBeregner.strlseSternSidder25n150nx(reqS);
        int exp = 720;
        assertEquals(exp,result);
    }

    @Test
    public void SternSidderAntalTest(){
    int result = StyklisteBeregner.SternSidderAntal(reqS);
    int exp = 2;
    assertEquals(exp,result);
    }

    @Test
    public void SternBrædderPris(){
        double result = StyklisteBeregner.SternBrædderPris(reqS);
        double exp = 59.9;
        assertEquals(exp,result,0.0);

    }

    @Test
    public void tagFodLægteStørrelsetEST(){
        int result = StyklisteBeregner.tagFodLægteStørrelse(reqS);
        int exp = 540;
        assertEquals(exp,result);
    }

    @Test
    public void doorSize(){
        int result = StyklisteBeregner.doorSize(reqS);
        int exp = 540;
        assertEquals(exp,result);
    }

    @Test
    public void tagFodLægtePris(){
        double result = StyklisteBeregner.tagFodLægtePris();
        double exp = 26.85;
        assertEquals(exp,result,0.0);
    }

    @Test
    public void antalH38x73mmotaglægteT1HRowsTest(){
        int result = StyklisteBeregner.antalH38x73mmotaglægteT1HRows(reqS);
        int exp = 34;
        assertEquals(exp,result);
    }

    @Test
    public void prisH38x73mmotaglægteT1HRowsTest(){
        double result = StyklisteBeregner.prisH38x73mmotaglægteT1HRows(reqS);
    double exp = 803.25;
        assertEquals(exp,result,0.0);
    }

    @Test
    public void sizeH38x73mmotaglægteT1HRowsTest(){
        int result = StyklisteBeregner.sizeH38x73mmotaglægteT1HRows(reqS);
        int exp =  540;
        assertEquals(exp,result);
    }


    @Test
    public void sizeH38x73mmotaglægteT1HHoldersTest(){
        int result = StyklisteBeregner.sizeH38x73mmotaglægteT1HHolders(reqS);
        int exp = 420;
        assertEquals(exp,result);
    }




    //Roof slop tests end




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