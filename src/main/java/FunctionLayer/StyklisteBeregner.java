package FunctionLayer;

import sun.security.util.Length;

import java.util.ArrayList;

public class StyklisteBeregner {

    public static int antalSpær(int length){
        //Samme antal universal 190mm højre og venstre som der er spær
        //4,0x50mm.	beslagskruer 250 stk, 3 pakker
        double antal = Math.round((length / 55.0)) + 1.0;
        int spær = (int) antal;
        return spær;
    }
    public static int længdeSpær(int width){
        int længde = 0;
        // int længde = width;
        /*if (width > 600){
        * længde = (width/2);
        * }
        * Spærlængder må ikke overskride 6m? Er det ligemeget i vores tilfælde, og så bare lave spær
        * længere end 6m? Behøves længdeSpær metoden, hvis spærets længde bare kan være width?
        */
        switch(width){
            case 240: længde = 420;
            case 270: længde = 420;
            case 300: længde = 420;
            case 330: længde = 420;
            case 360: længde = 420;
            case 390: længde = 420;
            case 420: længde = 420;
            case 450: længde = 540;
            case 480: længde = 540;
            case 510: længde = 540;
            case 540: længde = 540;
            case 570: længde = 600;
            case 600: længde = 600;
            case 630: længde = 600;
            case 660: længde = 660;
            case 690: længde = 600;
            case 720: længde = 600;
            case 750: længde = 600;
        }
        return længde;
    }
    public static double spærPris(int spærLængde, int spærAntal){
        double spærPris = spærLængde * spærAntal * 54.95; //meterprisen
        return spærPris;
    }
    public static double remPris(int remLængde, int remAntal){
        double remPris = remLængde * remAntal * 54.95; //meterprisen
        return remPris;
    }
    public static int beslagSkrueAntal(int længde){
        int antalPakker = 0;
        if(længde <= 260){
            antalPakker = 1;
        } else if(længde <= 520){
            antalPakker = 2;
        } else if(længde <= 780){
            antalPakker = 3;
        }
        return antalPakker;
    }

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

     // @Vibeke
    public void shed() {
     // Regnestykke: (b*h*2)+(l*h*2)+dørtilbehør
     // Antagelser:
     // Dør i meter
     double doorH = 2.15;
     double doorW = 1.0;
     // Dør vil blive placeret på en bredde side

     // Skur højde i meter
     double shedH = 2.5;

     // Test mål i meter:
     double length = 1.80;
     double width = 2.40;
     double area = length*width;

     // Wood for walls:
     double woodPriceM = 22.95;
     double woodPriceOne = shedH*woodPriceM;

     double wallL1 = length/0.16;
 }

}
