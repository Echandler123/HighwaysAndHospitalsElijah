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
        int[] order = new int[n];
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }
        for (int[] city : cities) {
            int a = city[0] - 1;
            int b = city[1] - 1;
            int x = a;
            while (x != roots[x]) {
                x = roots[x];
            }
            while (a != roots[a]) {
                int temp = roots[a];
                roots[a] = x;
                a = temp;
            }
            x = b;
            while (x != roots[x]) {
                x = roots[x];
            }
            while (b != roots[b]) {
                int temp = roots[b];
                roots[b] = x;
                b = temp;
            }
            if (a != b)
                if (order[a] > order[b]){
                    roots[b] = a;
                    order[a] --;
                }
                else{
                    roots[b] = a;
                    order[b] --;
                }
        }
        long total = 0;
        int unique = 0;
        for(int i =0; i < n; i++){
            if(roots[i] == i){
                unique++;
            }
        }
        total += (long) (n - unique)* highwayCost;
        total += (long) unique * hospitalCost;
        return total;
    }

}
