/* *****************************************************************************
 *  Name:              BE MELON
 *  Coursera User ID:  123456
 *  Last modified:     2/3/2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] arrayThreshold;
    private final int trials;
    private final double CONFIDENCE_95 = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.trials = trials;
        this.arrayThreshold = new double[trials];
        for (int tries = 0; tries < trials; tries++) {
            Percolation grid = new Percolation(n);
            while (!grid.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                grid.open(row, col);
            }

            arrayThreshold[tries] = (double) grid.numberOfOpenSites() / (n * n);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(arrayThreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(arrayThreshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev() / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats exp = new PercolationStats(n, trials);
        System.out.println("mean                    = " + exp.mean());
        System.out.println("stddev                  = " + exp.stddev());
        System.out.println(
                "95% confidence interval = [" + exp.confidenceLo() + ", " + exp.confidenceHi()
                        + "]");
    }
}
