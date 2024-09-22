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
        int[] roots = new int[n];
        for(int i =0; i < n; i++){
            roots[i] = i;
        }

        for (int[] city : cities){
            int a = city[0] - 1;
            int b = city[1] - 1;
            while(a != roots[a]){
                a = roots[a];
            }
            while(a != roots[b]){
                b = roots[b];
            }
            if(a != b)
                roots[b] = a;
        }
        int total = 0;
        int v = 0;
        for(int i =0; i < n; i++){
            if(roots[i] == i){
                v++;
            }
        }
        System.out.println(v);
        return total;
    }

}
