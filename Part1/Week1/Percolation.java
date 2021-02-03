/* *****************************************************************************
 *  Name:              BE MELON
 *  Coursera User ID:  123456
 *  Last modified:     2/2/2021
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n, top, bottom;
    private int opened = 0;
    private boolean[][] grid;
    private final WeightedQuickUnionUF ufGrid;
    private final WeightedQuickUnionUF realUFgrid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
        ufGrid = new WeightedQuickUnionUF(n * n + 2);
        realUFgrid = new WeightedQuickUnionUF(n * n + 1);
        this.n = n;
        top = n * n;
        bottom = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        if (isOpen(row, col)) {
            return;
        }
        opened += 1;
        int row2D = trans2D(row);
        int col2D = trans2D(col);

        grid[row2D][col2D] = true;
        if (row2D > 0 && isOpen(row - 1, col)) {
            ufGrid.union(trans1D(row, col), trans1D(row - 1, col));
            realUFgrid.union(trans1D(row, col), trans1D(row - 1, col));
        }
        else if (row2D == 0 && isOpen(row, col)) {
            ufGrid.union(trans1D(row, col), top);
            realUFgrid.union(trans1D(row, col), top);
        }

        if (row2D < (n - 1) && isOpen(row + 1, col)) {
            ufGrid.union(trans1D(row, col), trans1D(row + 1, col));
            realUFgrid.union(trans1D(row, col), trans1D(row + 1, col));
        }
        else if (row2D == (n - 1) && isOpen(row, col)) {
            ufGrid.union(trans1D(row, col), bottom);
        }

        if (col2D > 0 && isOpen(row, col - 1)) {
            ufGrid.union(trans1D(row, col), trans1D(row, col - 1));
            realUFgrid.union(trans1D(row, col), trans1D(row, col - 1));
        }

        if (col2D < (n - 1) && isOpen(row, col + 1)) {
            ufGrid.union(trans1D(row, col), trans1D(row, col + 1));
            realUFgrid.union(trans1D(row, col), trans1D(row, col + 1));
        }
        // System.out.println("[DEBUG] UF.find = " + UFgrid.find(trans1D(row, col)));
        // System.out.println("[DEBUG] UF.find(top) = " + UFgrid.find(top));
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) {
            throw new IllegalArgumentException();
        }
        return grid[trans2D(row)][trans2D(col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) {
            throw new IllegalArgumentException();
        }
        return realUFgrid.find(top) == realUFgrid.find(trans1D(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opened;
    }

    // does the system percolate?
    public boolean percolates() {
        return ufGrid.find(top) == ufGrid.find(bottom);
    }

    private int trans2D(int n) {
        return n - 1;
    }

    private int trans1D(int row, int col) {
        return trans2D(row) * n + trans2D(col);
    }

    // test client (optional)
    public static void main(String[] args) {
        // pass
    }
}
