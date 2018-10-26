package ar.edu.unq.bomberman;

public class Bomb {
	
	private Integer range;
	private Integer ticks;
	private Cell cell;
	
	public Bomb(Integer range, Integer ticks, Cell cell) {
		this.range = range;
		this.ticks = ticks;
		this.cell = cell;
	}
	
	public void decreaseTick() {
		ticks -= 1;
		if(ticks == 0) {this.explode();}
	}
	
	public void explode() {
		cell.explodeBomb(range);
	}
	
	public Integer getTicks() {
		return ticks;
	}
}
