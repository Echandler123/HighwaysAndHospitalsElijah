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
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Case of the hospital costing less than highways so just build hospitals everywhere
        if(hospitalCost < highwayCost){
            return (long) n * hospitalCost;
        }
        // Map for roots of nodes
        int[] roots = new int[n];
        // Map for weight of trees
        int[] order = new int[n];
        // Setting every city to be the root of itself
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }
        // For loop going through every city in the array
        for (int[] city : cities) {
            // Setting the current nodes
            int a = city[0] - 1;
            int b = city[1] - 1;
            int x = a;
            // Finding the root of city a
            while (x != roots[x]) {
                x = roots[x];
            }
            // Path compression of city a making all the nodes on the path to the furthest root point to that root
            while (a != roots[a]) {
                int temp = roots[a];
                roots[a] = x;
                a = temp;
            }
            x = b;
            // Finding the root of city b
            while (x != roots[x]) {
                x = roots[x];
            }
            // Path compression of city b making all the nodes on the path to the furthest root point to that root
            while (b != roots[b]) {
                int temp = roots[b];
                roots[b] = x;
                b = temp;
            }
            // Union of the city a and b
            if (a != b)
                // If the subtree of a is larger than b then the subtree of b is added to a for efficiency
                if (order[a] < order[b]){
                    roots[b] = a;
                    // Using negative numbers to represent weight so decreasing the value of a to show an increase in
                    // weight
                    order[a] --;
                }
                // If the subtree of b is larger or equal to a then the tree of a is added to b for efficiency
                else{
                    roots[a] = b;
                    // Using negative numbers to represent weight so decreasing the value of b to show an increase in
                    // weight
                    order[b] --;
                }
        }
        long total = 0;
        int unique = 0;
        // Calculating the number of large cities/trees
        for(int i =0; i < n; i++){
            if(roots[i] == i){
                unique++;
            }
        }
        // Calculating the total cost when highway cost less than hospitals
        total += (long) (n - unique)* highwayCost;
        total += (long) unique * hospitalCost;
        return total;
    }

}
