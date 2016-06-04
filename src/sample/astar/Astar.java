package sample.astar;

import java.util.*;
/**
 * Created by Arkadiusz Chrobak on 08.05.2016.
 */
public class Astar {

    /// There are reversed X and Y
    public static final int DIAGONAL_COST = 14;
    public static final int V_H_COST = 10;
    public static boolean foundPath = false;


    public static Map <Integer, AstarPoints> pathXY=new HashMap<Integer, AstarPoints>();

    static class Cell{
        int heuristicCost = 0;

        // Koszt całkowity przejścia G + H
        int finalCost = 0;
        int i, j;
        Cell parent;

        Cell(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString(){
            return "["+this.i+", "+this.j+"]";
        }
    }

    //Blocked cells are just null Cell values in grid
    static Cell [][] grid = new Cell[5][5];

    static PriorityQueue<Cell> open;

    static boolean closed[][];
    static int startI, startJ;
    static int endI, endJ;

    public static void setBlocked(int i, int j){
        grid[i][j] = null;
    }

    public static void setOilCost(int i, int j){
        Cell current;
        current = grid[i][j];
        current.heuristicCost = 800;
    }

    public static void setStartCell(int i, int j){
        startI = i;
        startJ = j;
    }

    public static void setEndCell(int i, int j){
        endI = i;
        endJ = j;
    }

    static void checkAndUpdateCost(Cell current, Cell t, int cost){
        if(t == null || closed[t.i][t.j])return;
        int t_final_cost = t.heuristicCost+cost;

        boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.finalCost){
            t.finalCost = t_final_cost;
            t.parent = current;
            if(!inOpen)open.add(t);
        }
    }

    public static void AStar(){

        //add the start location to open list.
        open.add(grid[startI][startJ]);

        Cell current;

        while(true){
            current = open.poll();
            if(current==null)break;
            closed[current.i][current.j]=true;

            if(current.equals(grid[endI][endJ])){
                return;
            }

            Cell t;

            // Dół
            if(current.i-1>=0){
                t = grid[current.i-1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);

                // Skos lewo
                if(current.j-1>=0){
                    t = grid[current.i-1][current.j-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST);
                }
                // Skos w prawo
                if(current.j+1<grid[0].length){
                    t = grid[current.i-1][current.j+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST);
                }
            }

            // W lewo
            if(current.j-1>=0){
                t = grid[current.i][current.j-1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);
            }

            // W prawo
            if(current.j+1<grid[0].length){
                t = grid[current.i][current.j+1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);
            }

            // Góra
            if(current.i+1<grid.length){
                t = grid[current.i+1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST);

                // Skos lewo
                if(current.j-1>=0){
                    t = grid[current.i+1][current.j-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST);
                }

                // Skos prawo
                if(current.j+1<grid[0].length){
                    t = grid[current.i+1][current.j+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST);
                }
            }
        }
    }

    public static void operationCommond(int pointX, int pointY, int pointX_parent, int pointY_parent ) {
        if(pointX>pointX_parent){
            if(pointY>pointY_parent){
//                System.out.print("Obracam się o 45 stopni prawo. ");
//                System.out.print("Idę w dół\n");
            }
            if(pointY<pointY_parent){
//                System.out.print("Obracam się o 45 stopni w lewo. ");
//                System.out.print("Idę w dół\n");
            }
            if(pointY == pointY_parent){
//                System.out.print("Idę w dół\n");
            }

        }
        else if(pointX<pointX_parent){
            if(pointY>pointY_parent){
//                System.out.print("Obracam się o 45 stopni w prawo, do góry. ");
//                System.out.print("Idę do góry\n");
            }
            if(pointY<pointY_parent){
//                System.out.print("Obracam się o 45 stopni w lewo, do góry. ");
//                System.out.print("Idę do góry\n");
            }
            if(pointY == pointY_parent){
//                System.out.print("Idę w górę\n");
            }
        }
        else if(pointY>pointY_parent){
//            System.out.print("Idę w prawo\n");
        }
        else if(pointY<pointY_parent){
//            System.out.print("Idę w lewo\n");
        }
    }



    public static void test(int x, int y, int si, int sj, int ei, int ej, int[][] blocked) {

        // Override X and Y of grid
        grid = new Cell[x][y];
        closed = new boolean[x][y];
        open = new PriorityQueue<>((Object o1, Object o2) -> {
            Cell c1 = (Cell) o1;
            Cell c2 = (Cell) o2;

            return c1.finalCost < c2.finalCost ? -1 :
                    c1.finalCost > c2.finalCost ? 1 : 0;
        });
        //Set start position
        setStartCell(si, sj);

        //Set End Location
//        setEndCell(5,5);
        setEndCell(ei, ej);

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                grid[i][j] = new Cell(i, j);

                // Manhattan Distance
                grid[i][j].heuristicCost = Math.abs(i - endI) + Math.abs(j - endJ);

            }
        }
        grid[si][sj].finalCost = 0;

        // Set Blocked cells values to null
        for (int i = 0; i < blocked.length-10; ++i) {
            setBlocked(blocked[i][0], blocked[i][1]);
        }

        for(int i=blocked.length-10; i < blocked.length; ++i) {
            setOilCost(blocked[i][0], blocked[i][1]);
        }

        //Display initial Gui
//        System.out.println("Grid: ");
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {

                // Source
                if (i == si && j == sj) System.out.print("SO  ");
                    // Destination
                else if (i == ei && j == ej) System.out.print("DE  ");
                else if (grid[i][j] != null) System.out.printf("%-3d ", 0);
                    // Blocked
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();

        AStar();
        System.out.println("\nMap with values: ");

        // Fill the Gui with costs
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < x; ++j) {
                if (grid[i][j] != null) System.out.printf("%-3d ", grid[i][j].finalCost);
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();

        if (closed[endI][endJ]) {

            //Trace back the path
            System.out.println("Path: ");
            Cell current = grid[endI][endJ];
            // System.out.print(current);
            int it = 0;
            pathXY.put(it, new AstarPoints(current.i, current.j));
            while (current.parent != null) {
                System.out.print(" <- " );
                operationCommond(current.i, current.j, current.parent.i, current.parent.j);

                current = current.parent;
                it++;
                pathXY.put(it, new AstarPoints(current.i, current.j));
                foundPath = true;

            }
            System.out.println();
        } else {
            System.out.println("No possible path");
            foundPath = false;
        }
    }
}