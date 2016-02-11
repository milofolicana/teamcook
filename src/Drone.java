
public class Drone {
	
	private int droneID;
	private int maxWeight;
	private int[] products;
	private int x;
	private int y;
	StringBuffer sb = new StringBuffer();

	
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

	public void load(int warehouseID, int product, int quantity) {
		if (products[product]>quantity) {
			products[product] = products[product]+quantity;
			//this should be printed on a file
			sb.append(droneID + " L " + warehouseID + " " + product + " " + quantity);
		}
	}
	
	public void deliver(int customerID, int product, int quantity) {
		if(products[product]>quantity) {
			products[product] = products[product]-quantity;
			//this should be printed on a file
			sb.append(droneID + " D " + customerID + " " + product + " " + quantity);
		}
	}
	
	public void unload (int productToUnload, int nrOfProductsToUnload) {
		
	}
	
	public void wait (int turnsToWait) {
		
	}
		
	public String getPath(){
		return sb.toString();
	}
	
}
