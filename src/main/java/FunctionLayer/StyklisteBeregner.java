package FunctionLayer;

import sun.security.util.Length;

import java.util.ArrayList;

public class StyklisteBeregner {


    private ArrayList<Material> matList = new ArrayList();


 public int stolpeAntal(Request r){
     //starter med en i hvert hjørne så 4
     int stolpeAntal=4;
     int stolpeAntalBcLength = 0;
     int stolpeAntalBcWidth = 0;
     int stolpeAntalShed=0;

     int lengths =r.getLengthS();
     boolean shed=false;
    if(lengths!=0){
        shed=true;
    }

     //set i brochuren... //Forreste stolper skal være 208 cm. Høje og bagerste skal være 202 cm.
     int width  = r.getWidth();
     int length = r.getLength();
     System.out.println(width);
     System.out.println(length);
     //bredde

            stolpeAntalBcWidth=width/300;

    // længde

     stolpeAntalBcLength=length/300;
    stolpeAntalBcLength=stolpeAntalBcLength+stolpeAntalBcLength;
     //leder videoen første møde havde det her info.. //20 kvadrat meter = 4 stolper // 30 kvadrat meter = 6 stolper
     //teknisk møde med håndværker gav denne information... //hver tredje meter skal der være en stolpe(i hver side)

     if (shed==true){
         //hver hjørne af skuret

         //hver side af døren ved skuret
         stolpeAntalShed=6;
     }

     //+ alt
        stolpeAntal=stolpeAntal+stolpeAntalBcLength+stolpeAntalBcWidth+stolpeAntalShed;
     return stolpeAntal;
 }

}
