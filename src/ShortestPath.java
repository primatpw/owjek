import java.util.*;


public class ShortestPath {
	private Map map;
	private Queue<Point> q;
	private int distance;
	
	public ShortestPath(Map map) {
		this.map = map;
		q = new LinkedList<Point>();
	}
 
	//memasukkan koordinat x, y menjadi bentuk poin
	private class Point {
		int x;
		int y;
		Point parent;
		
		public Point (int x, int y, Point parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}

		public Point getParent() {
			return parent;
		}
		public String toString() {
			return ("("+x+","+y+")");
		}
	}
	
	//mengecek apakah koordinat tersebut adalah jalan atau bukan
	public boolean checkRoute (int x, int y) {
		if (map.get(x, y) == ' ' || map.get(x, y) == 'F') { 
			return true;
		}
		else {
			return false;
		}
	}
	
	public Point goFinish (int x, int y) {
		q.add(new Point(x, y, null));
		
		while (!q.isEmpty()) {
			
			Point p = q.remove();
			if (map.get(p.x, p.y) == 'F') {
				return p;
			}
			map.set('o', p.x, p.y);
			
			//ke atas
			if (checkRoute (p.x, p.y+1)) {
				q.add(new Point(p.x, p.y+1, p));
			}
			
			//ke bawah
			if (checkRoute (p.x, p.y-1)) {
				q.add(new Point (p.x, p.y-1, p));
			}
			
			//ke kanan
			if (checkRoute(p.x+1, p.y)) {
				q.add(new Point (p.x+1, p.y, p));
			}
			
			//ke kiri
			if (checkRoute (p.x-1, p.y)) {
				q.add(new Point (p.x-1, p.y, p));
			}
		}
		return null;
	}
	
	public Map execute (int x, int y) {
		Point p = goFinish(x, y);
		
		//menghilangkan tanda o untuk mengecek jalan menuju finish sebelumnya
		for (int i = 0; i<map.HEIGHT; i++) {
			for (int j = 0; j<map.WIDTH; j++) {
				if (map.get(i, j) == 'o') {
					map.set(' ', i, j);
				}
			}
		}
		
		//mengisi jarak terdekat dengan'.'
	    while(p.getParent() != null) {
            map.set('.', p.x, p.y);
            p = p.getParent();
            distance++;
        }
        return map;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
