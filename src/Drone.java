
public class Drone {
	
	private int droneID;
	private int maxWeight;
	private int[] products;
	private int x;
	private int y;

	
	public Drone(int droneID, int maxWeight, int products, int x, int y) {
		super();
		this.droneID = droneID;
		this.maxWeight = maxWeight;
		this.products = new int[products];
		for(int i = 0;i<products;i++){
			this.products[i]=0;
		}
		this.x = x;
		this.y = y;
	}

	public String load(int warehouseID, int product, int quantity) {
		if (products[product]>quantity) {
			products[product] = products[product]-quantity;
			//this should be printed on a file
			return(droneID + " L " + warehouseID + " " + product + " " + quantity);
		}
		return null;
	}
	
	public String deliver(int customerID, int product, int quantity) {
		if(products[product]>quantity) {
			products[product] = products[product]-quantity;
			//this should be printed on a file
			return(droneID + " D " + customerID + " " + product + " " + quantity);
		}
		return null;		
	}
	
	public void unload (int productToUnload, int nrOfProductsToUnload) {
		
	}
	
	public void wait (int turnsToWait) {
		
	}
		
	
}
