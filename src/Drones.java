
public class Drones {
	
	private int droneID;
	private int maxWeight;
	private int[] products;

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public void initializeProducts(int nrProducts) {
		products = new int[nrProducts];
		for(int i = 0;i<nrProducts;i++){
			products[i]=0;
		}
	}
	
	public void load(int customerID, int productToLoad, int qntOfProduct) {
		
	}
	
	public void deliver(int customerID, int productToDeliver, int qntOfProduct) {
		
	}
	
	public void unload (int productToUnload, int nrOfProductsToUnload) {
		
	}
	
	public void wait (int turnsToWait) {
		
	}
	
	private ()
	
	
	
}
