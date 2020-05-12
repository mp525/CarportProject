package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import FunctionLayer.Request;
import static org.junit.Assert.*;

public class StyklisteBeregnerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void round() {
    }

    @Test
    public void spærPakkePris() {
    }

    @Test
    public void antalSpær() {
    }

    @Test
    public void spærAfstand() {
    }

    @Test
    public void længdeSpær() {
    }

    @Test
    public void spærPris() {
    }

    @Test
    public void remPris() {
    }

    @Test
    public void beslagSkrueAntal() {
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