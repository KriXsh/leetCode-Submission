/ Your old code in java8 has been preserved below.
// /*
// https://hr.gs/25af1e8

// 0 => Empty
// 1 => Not Infected
// 2 => Infected
// Input: grid = {{0,1,2}
//              ,{0,1,2},
//              {2,1,1}}
// Output: 1
// Input: grid = {
//             {2,2,0,1}
//                 }
// Output: -1
// In recent pandemic, people were getting infected by virus. In Gotham city, Batman takes responsibility to save all residents. But he needs our help to determine what is the earliest time after which all the houses turns Infected.

//  A Infected house at index [i,j] can turn other not infected house at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.



//  Examples 

// Input:  arr[][C] = 
// {
// {2, 1, 0, 2, 1},
// {1, 0, 1, 2, 1},
// {1, 0, 0, 2, 1}
// };

// Output: 2

// Explanation: At 0th time frame:

// {2, 1, 0, 2, 1}
// {1, 0, 1, 2, 1}
// {1, 0, 0, 2, 1}

//  t=0
// At 1st time frame:

// {2, 2, 0, 2, 2}
// {2, 0, 2, 2, 2}
// {1, 0, 0, 2, 2}

// t= 1
// At 2nd time frame:

// {2, 2, 0, 2, 2}
// {2, 0, 2, 2, 2}
// {2, 0, 0, 2, 2}

// t=2

// Input:  arr[][C] = { {2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1}}

// Output: -1

// Explanation: At 0th time frame:

// {2, 1, 0, 2, 1}
// {0, 0, 1, 2, 1}
// {1, 0, 0, 2, 1}

// At 1st time frame:

// {2, 2, 0, 2, 2}
// {0, 0, 2, 2, 2}
// {1, 0, 0, 2, 2}

// At 2nd time frame:

// {2, 2, 0, 2, 2}
// {0, 0, 2, 2, 2}
// {1, 0, 0, 2, 2}

// The 1 at the bottom left corner of the matrix is never got infected.


// */

import java.util.LinkedList;
import java.util.Queue;

public class VirusSpread {

    // Helper class to represent a cell in the grid
    static class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int minTimeToInfectAll(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int notInfectedCount = 0;

        // Initialize the queue with all initially infected cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j));
                } else if (grid[i][j] == 1) {
                    notInfectedCount++;
                }
            }
        }

        // If no house is not infected, return 0
        if (notInfectedCount == 0) {
            return 0;
        }

        int time = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectionSpread = false;

            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                for (int[] dir : directions) {
                    int newX = cell.x + dir[0];
                    int newY = cell.y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Infect the house
                        queue.add(new Cell(newX, newY));
                        notInfectedCount--;
                        infectionSpread = true;
                    }
                }
            }

            if (infectionSpread) {
                time++;
            }
        }

        // If there are still houses not infected, return -1
        return notInfectedCount == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        int[][] grid2 = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        System.out.println(minTimeToInfectAll(grid1)); // Output: 2
        System.out.println(minTimeToInfectAll(grid2)); // Output: -1
    }
}
