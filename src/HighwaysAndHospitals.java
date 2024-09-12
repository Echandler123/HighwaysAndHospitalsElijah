import java.util.ArrayList;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [Elijah Chandler]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
//        System.out.println(highwayCost);
//        System.out.println(hospitalCost);
        int connected = 0;
        int[] counted = new int[cities.length];
        int totalcost =0;
        for(int i = 0; i < cities.length; i++){
            for(int j = 0; j< cities[0].length; j++) {
                if (cities[i][0] == cities[0][j]){
                    for(int k = 0; k < cities.length; k++){
                        if(cities[i][0] != counted[k]){
                            connected++;
                            counted[i] = cities[i][0];
                        }
                    }
                }
                else if (cities[i][0] == cities[j][0]) {
                    for(int k = 0; k < cities.length; k++){
                        if(cities[i][0] != counted[k]){
                            connected++;
                            counted[i] = cities[i][0];
                        }
                    }
                }
            }
        }
        System.out.println(connected);
//        if(highwayCost < hospitalCost) {
//            totalcost += connected*hospitalCost;
//            totalcost += (n- connected) * highwayCost;
//            return totalcost;
//        }
//        else {
//            return hospitalCost * n;
//        }
        return 0;
    }
}
