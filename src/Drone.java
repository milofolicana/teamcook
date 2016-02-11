
public class Drone {
	
	private int droneID;
	private int maxWeight;
	private int[] products;
	private int positionX;
	private int positionY;

	
	public Drone(int droneID, int maxWeight, int products, int positionX,
			int positionY) {
		super();
		this.droneID = droneID;
		this.maxWeight = maxWeight;
		this.products = new int[products];
		for(int i = 0;i<products;i++){
			this.products[i]=0;
		}
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public void load(int warehouseID, int product, int quantity) {
		if (products[product]>quantity) {
			products[product] = products[product]-quantity;
			//this should be printed on a file
			System.out.println(droneID + " L " + warehouseID + " " + product + " " + quantity);
		}
	}
	
	public void deliver(int customerID, int product, int quantity) {
		if(products[product]>quantity) {
			products[product] = products[product]-quantity;
			//this should be printed on a file
			System.out.println(droneID + " D " + customerID + " " + product + " " + quantity);
		}
		
	}
	
	public void unload (int productToUnload, int nrOfProductsToUnload) {
		
	}
	
	public void wait (int turnsToWait) {
		
	}
		
	
	
}
