package ar.edu.unq.bomberman;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Board {
  Map<Pair<Integer, Integer>, Cell> cells = new HashMap<>();

  void addCell (Integer x, Integer y, Cell cell){
    cells.put(new Pair<>(x, y), cell);
  }

  public Cell getCellAt(Integer x, Integer y){
    return cells.get(new Pair<>(x, y));
  }

  void move(Cell cell, Direction direction){
    //acá iria la fucking logica
  }
}
