
public class I_house {

	public static void main(String[] args) {
		House house1 = new House();
		House house2 = new House(3);
		House house3 = new House(5,6);
		
		System.out.println("Class House without any arguments: "+
							"\nOccupants: "+house1.getOccupants()+"  Income:"+house1.getIncome());
		System.out.println("\nClass House with one argument: "+
							"\nOccupants: "+house2.getOccupants()+"  Income: "+house2.getIncome());
		System.out.println("\nClass House with two arguments: "+
							"\nOccupants: "+house3.getOccupants()+"  Income: "+house3.getIncome());
	}

}
