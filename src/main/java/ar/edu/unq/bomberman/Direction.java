package ar.edu.unq.bomberman;

public enum Direction {

	North(new Position(0, 1)),
	South(new Position(0, -1)),
	East(new Position(-1, 0)),
	West(new Position(1, 0));

	private Position vector;

	Direction(Position vector){
		this.vector = vector;
	}

	public Position getVector() {
		return vector;
	}
}

