
public class Sporty extends Owjek implements doIt {
	private int minTopSpeed;
	private int fixedCost;
	protected String sportstr;

	public Sporty() {
        super(3000, 0.6, 2015);
        this.minTopSpeed = 140;
    }

	public int first5Km() {
        return 20000;
    }
	
	//menghitung biaya keseluruhan sebelum promo
    public int getCost(int distance) {
    	return distance < 51 ? 20000 : 20000 + (distance - 50) * 300;
    }
    
    //menghitung biaya perkilometer setelah 5 km pertama
    public int getCostPerKm (int distance){
    	return (distance-50)*300;
    }
    
    //menghitung promo yang didapat yaitu 60% untuk 8 km pertama
    public int getPromo (int distance, int cost){
    	int promo = cost * 6/10;
        return distance < 81 ? promo : 17400;
    }
    
    //menghitung protection cost yaitu 10% dari biaya total
    public int getProtectionCost(int totalCost){
    	return (int) (totalCost*0.1);
    }

    //Mencetak kalkulasi biaya
    public void show(int distance) {
    	 int kmSel = getCost(distance) - first5Km();
         int promo = getPromo(distance, getCost(distance));
         int prtks = getProtectionCost(getCost(distance)-getPromo(distance, getCost(distance)));
         int total = first5Km() + kmSel + prtks - promo;
         sportstr = ("[Jarak] "+ distance / 10.0+" KM\n").replace('.', ',') + "[TipeO] Sporty\n" +
         "[5KMPe] Rp 20.000,00 (+)\n"+"[KMSel] "+ rupiah(kmSel) +" (+)\n" + "[Promo] "+ rupiah(promo) +" (-)\n"
         + "[Prtks] "+ rupiah(prtks) +" (+)\n" + "[TOTAL] "+ rupiah(total) + "\n";
    }

	public String getSportstr() {
		return sportstr;
	}

	public int getMinTopSpeed() {
		return minTopSpeed;
	}

	public void setMinTopSpeed(int minTopSpeed) {
		this.minTopSpeed = minTopSpeed;
	}

	public int getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(int fixedCost) {
		this.fixedCost = fixedCost;
	}

}
