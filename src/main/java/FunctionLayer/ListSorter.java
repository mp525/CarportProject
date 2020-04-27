package FunctionLayer;

import DBAccess.RequestMapper;

import java.util.*;

import java.util.stream.Stream;


public class ListSorter {


    public static void main(String[] args) {
        ListSorter l= new ListSorter();
        ArrayList<Request>requests=new ArrayList<>();
        Request r = new Request(1, "mattibenhansen@gmail.com",  12, 20, "ok", true, "træ", 25, 25, 25);
        Request e = new Request(1, "kattibenhansen@gmail.com",  11, 20, "ok", true, "træ", 25, 25, 25);
        requests.add(r);
        requests.add(e);


        System.out.println(l.getSortedByWidth(requests));
        System.out.println(l.getSortedByArea(requests));
        System.out.println(l.getSortedByLength(requests));
    }


    public ArrayList<Request> getSortedByLength(ArrayList<Request> sortedByLength) {
        sortedByLength = RequestMapper.getRequests();



        Collections.sort(sortedByLength, Comparator.comparing(Request::getLength));
        return sortedByLength;
    }

    public ArrayList getSortedByWidth (ArrayList<Request> requests) {
        requests = new ArrayList<>();




        Collections.sort(requests, Comparator.comparing(Request::getWidth));

        return requests;
    }

    public ArrayList getSortedByArea(ArrayList<Request> sortedByArea) {
        sortedByArea = RequestMapper.getRequests();



        Collections.sort(sortedByArea, Comparator.comparing(Request::getArea ));

        return sortedByArea;
    }

}
