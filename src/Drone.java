
public class Drone {
	
	private int droneID;
	private int maxWeight;
	private int[] products;
	private int positionX;
	private int positionY;

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public void initializeProducts(int nrProducts) {
		products = new int[nrProducts];
		for(int i = 0;i<nrProducts;i++){
			products[i]=0;
		}
	}
	
	public void load(int warehouseID, int product, int quantity) {
		if (products[product]>quantity) {
			products[product] = products[product]-quantity;
			System.out.println(droneID + " L " + warehouseID + " " + product + " " + quantity);
		}
	}
	
	public void deliver(int customerID, int product, int quantity) {
		if(products[product]>quantity) {
			products[product] = products[product]-quantity;
			System.out.println(droneID + " D " + customerID + " " + product + " " + quantity);
		}
		
	}
	
	public void unload (int productToUnload, int nrOfProductsToUnload) {
		
	}
	
	public void wait (int turnsToWait) {
		
	}
		
	
	
}
