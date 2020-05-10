package FunctionLayer;

import com.mysql.cj.protocol.x.XProtocolRowInputStream;

public class TagBeregnerSlop {


//Tagpakken

    public static int antalBnCDob(Request req) {

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;

        amount = Math.ceil(LnW/enTinDel);
        int montus = (int) amount * 60;
        return montus;
    }
    public static double prisBnCDob(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;

        amount = Math.ceil(LnW/enTinDel);
        int montus = (int) amount * 60;
        double prisnung = montus * 5.45;
        return prisnung;

    }


    public static int antalRygsten(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        return mallus;
    }

    public static double prisRygsten(Request req) {

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW / enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        double prislus = mallus * 9.95;

        return prislus;
    }

public static int antalTopLaegHolds(Request req){

    int enTinDel = 56250;
    int width = req.getWidth();
    int length = req.getLength();
    double amount = 1.0;
    double LnW = length * width;


    amount = Math.ceil(LnW/enTinDel);
    double montus = amount * 0.8;

    montus = Math.ceil(montus);
    int mallus = (int) montus;

    switch (mallus){
        case 1:
            mallus = 2;
            break;
        case 3:
            mallus = 4;
            break;
        case 5:
            mallus = 6;
            break;
        case 7:
            mallus = 8;
            break;
        case 9:
            mallus = 10;
            break;
    }


    return mallus;
}

    public static double prisTopLaegHolds(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 0.8;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        switch (mallus){
            case 1:
                mallus = 2;
                break;
            case 3:
                mallus = 4;
                break;
            case 5:
                mallus = 6;
                break;
            case 7:
                mallus = 8;
                break;
            case 9:
                mallus = 10;
                break;
        }


        double pris = mallus * 1.1;

        return mallus;
    }

    public static int antalRygstensBeslag(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        return mallus;
    }

    public static double prisRygstensBeslag(Request req){

        int enTinDel = 56250;
        int width = req.getWidth();
        int length = req.getLength();
        double amount = 1.0;
        double LnW = length * width;


        amount = Math.ceil(LnW/enTinDel);
        double montus = amount * 2.1;

        montus = Math.ceil(montus);
        int mallus = (int) montus;

        double prislus = mallus * 9.95;

        return prislus;
    }

    public static int bindsNNakrog(){

        return 2;
    }

    public static double prisNNakrog(){

        return 2 * 1.3;
    }


    //tree


    // der skal bruges 2 af dem her
    public static int strlseSternSidder25n150nx(Request req){

        int width = req.getWidth();

        int size = 100;

        switch (width){
            case 240:
            case 270:
            case 300:
            case 330:
            case 360:
                size = 300;
                break;

            case 390:
            case 420:
                size = 360;
                break;

            case 450:
            case 480:
                size = 420;
                break;

            case 510:
            case 540:
                size = 480;
                break;

            case 570:
            case 600:
                size = 540;
                break;

            case 630:
            case 660:
            case 690:
            case 720:
            case 750:
                size = 600;
                break;
        }


return size;
    }

    public static int SternSidderAntal(Request req){
        int width = req.getWidth();
        int etellerto = 2;
        if(width < 300){
            etellerto = 1;
        }

        return etellerto;
    }


    public static int tagFodLægteStørrelse(Request req) {

        int length = req.getLength();
        int fodSiz = 240;
        switch (length) {

            case 240:
                fodSiz = 210;
                break;

            case 270:
                fodSiz = 240;
                break;

            case 300:
            case 330:
            case 390:
                fodSiz = 270;

            case 420:
            case 450:
            case 480:
                fodSiz = 300;

            case 510:
            case 540:
            case 570:
                fodSiz = 360;
                break;

            case 600:
            case 630:
            case 660:
                fodSiz = 450;
                break;

            case 690:
            case 720:
            case 750:
                fodSiz = 540;
                break;
        }
return fodSiz;
    }

            //Measurements in Width or Length
            //240
            //270
            //300
            //330
            //360
            //390
            //420
            //450
            //480
            //510
            //540
            //570
            //600
            //630
            //660
            //690
            //720
            //750




    public static int doorSize(Request req){
        int length = req.getLength();

        int størrelsen = 240;

        switch(length){
            case 240:
            case 270:
                størrelsen = 300;
                break;
            case 300:
            case 330:
                størrelsen = 330;
                break;
            case 360:
            case 390:
                størrelsen = 360;
                break;
            case 420:
            case 450:
                størrelsen = 390;
                break;
            case 480:
            case 510:
                størrelsen = 420;
                break;
            case 540:
            case 570:
                størrelsen = 450;
                break;
            case 600:
            case 630:
                størrelsen = 480;
                break;
            case 660:
            case 690:
                størrelsen = 510;
                break;
            case 720:
            case 750:
                størrelsen = 540;
                break;

        }

        return  størrelsen;
    }

    //Redundant methods here

    public static int tagFodLægteAntal(){
            return 3;
    }

    public static double tagFodLægtePris(Request req){

            return 8.95 * 3;
    }




    public static int doorAmount(){
        return 1;
    }

    public static double doorPrice(){
        return 22.95 * 1.0;
    }
    //Redundant methods end;



    public static int antalH38x73mmotaglægteT1HRows(Request req){
        int width = req.getWidth();

        int amount = width / 17;


        switch (amount){

            case 14:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 28:
            case 30:
            case 32:
            case 34:
            case 36:
            case 38:
            case 40:
            case 42:
            case 44:

                amount++;

                break;
        }

        return amount;


    }


    public static double prisH38x73mmotaglægteT1HRows(Request req){
        int width = req.getWidth();

        int amount = width / 17;


        switch (amount){

            case 15:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 27:
            case 29:
            case 31:
            case 33:
            case 35:
            case 37:
            case 39:
            case 41:
            case 43:
            case 45:

                amount++;

                break;
        }


        double pricee = amount * 22.95;

        return pricee;


    }

    public static int sizeH38x73mmotaglægteT1HRows(Request req){
        int length = req.getLength();

        int størrelsen = 240;

        switch(length){
            case 240:
            case 270:
            case 300:
                størrelsen = 240;
                break;
            case 330:
            case 360:
            case 390:
                størrelsen = 360;
                break;
            case 420:
            case 450:
            case 480:
            case 510:
                størrelsen = 420;
                break;
            case 540:
            case 570:
            case 600:
            case 630:
                størrelsen = 480;
                break;
            case 660:
            case 690:
            case 720:
            case 750:
                størrelsen = 540;
                break;

        }

        return  størrelsen;
    }


    public static int sizeH38x73mmotaglægteT1HHolders(Request req){

int length = req.getLength();
int sizu = 420;

if (length <= 420){
    sizu = 240;
}

return sizu;
    }

    //redundance inbound

    public static double priceH38x73mmotaglægteT1HHolders(){
        return 22.95 * 2;
    }

    public static int amountH38x73mmotaglægteT1HHolders(){
        return 2;
    }

public static int amount4Komma5x60Skruer(){
        return 1;
}
public static double price4Komma5x60Skruer(){
        return 74.95;
}
    public static int amount5Komma0x40Skruer(){
        return 1;
    }
    public static double price5Komma0x40Skruer(){
        return 259.0;
    }

    public static int amount5komma0x40100Skruer(){
        return 2;
    }
    public static double price5komma0x40100Skruer(){
        return 398.0;
    }

    //redundance done


    //Besla og Skruers





}