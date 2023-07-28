
public class House {
	
	private int occupants;
	private int income;
	
	House(){
		occupants = 1;
		income = 0;
	}
	
	House(int consOccupant){
		this.occupants = consOccupant;
	}
	
	House(int consIncome, int consOccupant){
		this.occupants = consOccupant;
		this.income = consIncome;
	}
	
	public void setOccupants(int occupants){
		this.occupants = occupants;
	}
	
	public int getOccupants(){
		return occupants;
	}
	
	public void setIncome(int income){
		this.income = income;
	}
	
	public int getIncome(){
		return income;
	}
	
	
}
