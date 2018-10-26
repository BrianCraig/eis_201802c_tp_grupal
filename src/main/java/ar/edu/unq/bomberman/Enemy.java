package ar.edu.unq.bomberman;

public class Enemy implements Entity{
	
	Power power;
	Bomberman bomberman;
	
	public Enemy(Bomberman bomberman) {
		this.bomberman = bomberman;
	}
	
	public void givePowerToBomberman() {
		bomberman.givePower(this.power);
	}

	@Override
	public void kill() {
		this.givePowerToBomberman();
	}
}
