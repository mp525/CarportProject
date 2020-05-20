package FunctionLayer;

import DBAccess.RequestMapper;

import java.util.*;

import java.util.stream.Stream;

/**
 * @author Matti
 * Denne klasse er lavet til at sortere lister af requests.
 *
 *
 */

public class ListSorter {


    /**
     *
     * @param sortedByLength
     * @return ArrayList - object requests
     * Denne metode sortere efter længde
     *
     */
    public ArrayList<Request> getSortedByLength(ArrayList<Request> sortedByLength) {
        sortedByLength = RequestMapper.getRequests();



        Collections.sort(sortedByLength, Comparator.comparing(Request::getLength));
        return sortedByLength;
    }


    /**
     *
     * @param requests
     * @return ArrayList - object requests
     * Denne metode sortere efter bredde
     *
     */
    public ArrayList getSortedByWidth (ArrayList<Request> requests) {
        requests = new ArrayList<>();




        Collections.sort(requests, Comparator.comparing(Request::getWidth));

        return requests;
    }

    /**
     *
     * @param sortedByArea
     * @return ArrayList - object requests
     * Denne metode sortere efter areal
     *
     */

    public ArrayList getSortedByArea(ArrayList<Request> sortedByArea) {
        sortedByArea = RequestMapper.getRequests();



        Collections.sort(sortedByArea, Comparator.comparing(Request::getArea ));

        return sortedByArea;
    }

}
