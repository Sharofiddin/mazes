package uz.learn.objects;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class BinaryTree{
    private static Random rnd = new Random();
    public static Grid on(Grid grid){
        for(Cell[] row:  grid.getMat()){
            for(Cell cell: row){
               List<Cell> neighbours = new ArrayList<>();
               if(cell.getNorth() != null)
                   neighbours.add(cell.getNorth());
               if(cell.getEast()!=null)
                   neighbours.add(cell.getEast());
               if(!neighbours.isEmpty()){
                int idx = rnd.nextInt(neighbours.size());
                cell.link(neighbours.get(idx), true);
               }
            }
        }
        return grid;
    }

}
