/*
 * The CompanySize class calculates the maximum number of employees possible at the company 
 * for a given number of management levels n. A manager can manage at most 8 employees 
 * All employees have exactly 1 manager except for the top level manager whom does not have a manager.
 */
public class CompanySize {

    /**
     * It takes an Int, in this case the number of management levels in a company,
     * and calculates the max number of employees recursively.
     * 
     * @param n Number of management levels
     * @return The max number of employees
     */
    static int solve(int n) {
        if (n <= 0) {
            return 1;
        }
        return (solve(n - 1) * 8) + 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(0));
        System.out.println(solve(1));
        System.out.println(solve(2));
    }
}
