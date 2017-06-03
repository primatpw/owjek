
public class Owjek {
	private int minYearAllowed;
	private double costPerKm;
    private double promo;

    public Owjek(int minYearAllowed, double costPerKm, double promo) {
    	this.minYearAllowed = minYearAllowed;
    	this.costPerKm = costPerKm;
        this.promo = promo;
    }
    
    //Merapikan format cost sehingga menjadi rupiah
    public String rupiah(int x){
        String str = x + "";
        String uang = str;
        if (str.length()>3){
            uang = str.substring(0,str.length()-3)+ "." +str.substring(str.length()-3);
        }
        return "Rp "+ uang + ",00";
    }

	public int getMinYearAllowed() {
		return minYearAllowed;
	}

	public void setMinYearAllowed(int minYearAllowed) {
		this.minYearAllowed = minYearAllowed;
	}

	public double getCostPerKm() {
		return costPerKm;
	}

	public void setCostPerKm(double costPerKm) {
		this.costPerKm = costPerKm;
	}

	public double getPromo() {
		return promo;
	}

	public void setPromo(double promo) {
		this.promo = promo;
	}

}
