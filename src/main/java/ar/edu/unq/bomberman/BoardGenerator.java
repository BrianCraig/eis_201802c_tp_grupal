package ar.edu.unq.bomberman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardGenerator {
  List<Cell> cellList = new ArrayList<>();

  public void add(Cell cell){
    cellList.add(cell);
  }

  public void linkCells(){
    cellList
      .forEach(cell -> {
        Arrays.stream(Direction.values())
          .forEach(direction -> {
            Position searchedPosition = cell.getPosition().getNextPosition(direction);
            cellList.stream()
              .filter(foundCell -> foundCell.getPosition()
              .equals(searchedPosition))
              .findFirst()
              .ifPresent(foundCell -> cell.addCell(direction, foundCell));
          });
      });
  }
}
