
public class Exclusive extends Owjek implements doIt{
	private int minCc;
	private int fixedCost;
	protected String exstr;

	public Exclusive() {
        super(5000, 0.5, 2016);
        this.minCc = 500;
        this.fixedCost = 10000;
    }

	//menghitung biaya keseluruhan sebelum promo
    public int getCost(int distance) {
    	return getFixedCost() + getCostPerKm(distance);
    }
    
    //menghitung biaya total per kilometer
    public int getCostPerKm (int distance){
        return distance*500;
    }
    
    //menghitung promo yang didapat yaitu 50% dari biaya total
    public int getPromo (int distance, int cost){
        return cost/2;
    }
    
    //menghitung protection cost yaitu 5% dari biaya total
    public int getProtectionCost(int totalCost){
    	return (int) (totalCost*0.05);
    }
    
    //Mencetak kalkulasi biaya
    public void show(int distance) {
    	 int kmSel = getCostPerKm(distance);
         int promo = getPromo(distance, getCost(distance));
         int prtks = getProtectionCost(getCost(distance)-getPromo(distance, getCost(distance)));
         int total = 10000 + kmSel + prtks - promo;
         exstr = ("[Jarak] "+ distance / 10.0+" KM\n").replace('.', ',') + "[TipeO] Exclusive\n" +
         "[Fixed] Rp 10.000,00 (+)\n" + "[KMSel] "+ rupiah(kmSel) +" (+)\n" +
         "[Promo] "+ rupiah(promo) +" (-)\n" + "[Prtks] "+ rupiah(prtks) +" (+)\n" +
         "[TOTAL] "+ rupiah(total) + "\n";
    }

	public String getExstr() {
		return exstr;
	}

	public int getMinCc() {
		return minCc;
	}

	public void setMinCc(int minCc) {
		this.minCc = minCc;
	}

	public int getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(int fixedCost) {
		this.fixedCost = fixedCost;
	}
}
