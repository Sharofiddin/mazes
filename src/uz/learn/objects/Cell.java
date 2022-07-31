package uz.learn.objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Cell{
    private Integer row;
    private Integer column;
    Map<Cell, Boolean> links;
    private Cell north;
    private Cell south;
    private Cell east; 
    private Cell west;

    public Cell(Integer row, Integer column){
        this.row = row;
        this.column = column;
        links = new HashMap<>();
    }

    public Cell getNorth(){
        return this.north;
    }
    public void setNorth(Cell north){
        this.north = north;
    }

    public Cell getSouth (){
        return this.south;
    }
    public void setSouth(Cell south){
        this.south = south;
    }

    public Cell getEast(){
        return this.east;
    }
    public void setEast(Cell east){
        this.east = east;
    }

    public Cell getWest(){
        return this.west;
    }
    public void setWest(Cell west){
        this.west = west ;
    }

    public Integer getRow(){
        return this.row;
    }

    public Integer getColumn(){
        return this.column;
    }

    public Cell link(Cell cell, boolean bidi){
        links.put(cell, true);
        if(bidi){
            cell.link(this, false);//to avoid circular call
        }
        return this;
    }
   
    public Cell unlink(Cell cell, boolean bidi){
        links.remove(cell);
        if(bidi){
            cell.unlink(this, false); //to avoid circular call
        }
        return this;
    }

    public Set<Cell>  getLinkedCells(){
        return this.links.keySet();
    }

    public boolean isLinked(Cell cell){
        return this.links.containsKey(cell);
    }


    public List<Cell> getNeighbours(){
       List<Cell> neighbours = new ArrayList<>();
       if(north!=null) neighbours.add(north);
       if(south!=null) neighbours.add(south);
       if(east!=null) neighbours.add(east);
       if(west!=null) neighbours.add(west);
       return neighbours;
    }
}
