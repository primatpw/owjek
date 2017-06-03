
public class Regular extends Owjek implements doIt{
	private String regstr;

	public Regular() {
        super(1000, 0.4, 2012);
    }
	
	public int first2Km() {
        return 3000;
    }
	
	//menghitung biaya keseluruhan sebelum promo
    public int getCost(int distance) {
    	return distance < 21 ? 3000 : 3000 + (distance - 20) * 100;
    }
    
    //menghitung biaya perkilometer setelah 2 km pertama
    public int getCostPerKm (int distance){
        return (distance-20)*100;
    }
    
    //menghitung promo yang didapat yaitu 40% untuk 6 km pertama
    public int getPromo (int distance, int cost){
        int promo = cost * 4/10;
        return distance < 61 ? promo : 2800;
    }
    
    public int getProtectionCost(int totalprice){
    	return 0;
    }

  //Mencetak kalkulasi biaya
    public void show(int distance) {
        int kmSel = getCost(distance) - first2Km();
        int promo = getPromo(distance, getCost(distance));
        int total = first2Km() + kmSel - promo;
        regstr = ("[Jarak] "+ distance / 10.0+" KM\n").replace('.', ',') + 
        		"[TipeO] Regular\n" + "[2KMPe] Rp 3.000,00 (+) \n"+
        		"[KMSel] " + rupiah(kmSel)+ " (+)\n" + 
        		"[Promo] " + rupiah(promo)+ " (-)\n" +
        		"[TOTAL] " + rupiah(total) + "\n";
    }

	public String getRegstr() {
		return regstr;
	}

}
