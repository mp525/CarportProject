package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import FunctionLayer.Request;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StyklisteBeregnerTest {

    private Request reqF;
    private Request reqS;
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
}