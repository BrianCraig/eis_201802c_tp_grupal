package ar.edu.unq.bomberman;

public enum CellContent {
	
	Steel(false,false),
	Melamine(false,true),
	Empty(true,false),
	Bomb(false,true);
	
	private boolean canWalkThrough;
	private boolean destroyable;
	
	CellContent(boolean canWalkThrough, boolean destroyable){
		this.canWalkThrough = canWalkThrough;
		this.destroyable = destroyable;
	}
	
	boolean canWalkThrough() {
		return canWalkThrough;
	}
	
	boolean isDestroyable() {
		return destroyable;
	}

}
