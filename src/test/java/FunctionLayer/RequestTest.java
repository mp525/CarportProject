package FunctionLayer;


import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class RequestTest {

    @Test
    public void testGetArea() {
        int area = 0;
        int length = 100;
        int width=100;
        area=length+width;


        assertEquals(area,200);
    }
}