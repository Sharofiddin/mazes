package uz.learn.objects;
import java.util.stream.*;
import java.util.*;

public class Grid{
    private Integer rows;
    private Integer columns;
    private Cell[][] mat; 
    public Grid(Integer rows, Integer columns){
        this.rows = rows;
        this.columns = columns;
        prepareGrid();
        configureCells();
    }

    private void prepareGrid(){
        mat = new Cell[rows][columns];
        for(int i = 0; i< rows; i++){
            for( int j  = 0; j < columns; j++){
                mat[i][j]=new Cell(i,j);
            }
        }
    }
   
    private void configureCells(){
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(i!=0) mat[i][j].setNorth(mat[i-1][j]);
                if(i!=rows-1) mat[i][j].setSouth(mat[i+1][j]);
                if(j!=columns-1) mat[i][j].setEast(mat[i][j+1]);
                if(j!=0) mat[i][j].setWest(mat[i][j-1]);
            }
        }
    }


    public Cell[][] getMat(){
        return mat;
    }
    @Override
    public String toString(){
       StringBuilder res = new StringBuilder("+");
       res.append(Stream.generate(() -> "---+").limit(mat.length).collect(Collectors.joining()));
       res.append("\n");
       for(Cell[] rows: mat){
           StringBuilder top  = new StringBuilder("|"); 
           StringBuilder bottom = new StringBuilder("+"); 
        for(Cell cell: rows){
          top.append("   ");
          top.append(cell.isLinked(cell.getEast()) ? " " :"|");
          bottom.append(cell.isLinked(cell.getSouth()) ? "   " : "---");
          bottom.append("+");
        }
        res.append(top).append("\n").append(bottom).append("\n");
       }

       return res.toString();
    }

}
