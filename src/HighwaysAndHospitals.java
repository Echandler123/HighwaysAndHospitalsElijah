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
        if(hospitalCost < highwayCost){
            return (long) n * hospitalCost;
        }
        int[] roots = new int[n];
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }
        for (int[] city : cities) {
            int a = city[0] - 1;
            int b = city[1] - 1;
            while (a != roots[a]) {
                a = roots[a];
            }
            while (b != roots[b]) {
                b = roots[b];
            }
            if (a != b)
                roots[b] = a;
        }
        long total = 0;
        int unique = 0;
        for(int i =0; i < n; i++){
            if(roots[i] == i){
                unique++;
            }
        }
        total += (long) (n - unique)* highwayCost;
        System.out.println(highwayCost);
        System.out.println(hospitalCost);
        System.out.println(unique);
        total += (long) unique * hospitalCost;
        System.out.println(total);
        return total;
    }

}
