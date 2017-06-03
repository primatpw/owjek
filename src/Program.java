import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class Program extends JFrame {
	private JPanel panel;
	private JButton label1;
	private JButton label2;
	private JButton label3;
	private JLabel headerowjek;
	private JButton orderbutton;
	private JLabel label4;
	private JLabel label5;
	protected int distance;
	protected String type="regular";
	

	public Program(){
		/* Mengatur ukuran, judul, dan layout pada frame baru serta menjalankan beberapa method 
		 seperti createButton, insertImage, dan JPanel*/
		setSize (1008,730);
		setTitle ("OW-JEK! by Teresa Prima");
		setResizable(false);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		insertImage();
		createButton();
		JPanel();
		Color color;
		color=new Color(188,212,236);
		setBackground(color);
		setVisible(true);
	}
	
	public void JOptionPane(){
		/* Membuat JOption Pane untuk output atau hasil keluaran total harga setelah order*/
		Font font = new Font("Montserrat", Font.PLAIN, 15);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		/* JOptionPane keluar sesuai dengan type Owjeknya. Jika input user sudah benar, akan langung menampilkan output,
		 jika masih kurang, akan menampilkan pesan*/
		if (type.equalsIgnoreCase("regular")){
			Regular reg = new Regular();
			if (distance==0){
				JOptionPane.showMessageDialog(panel, "Select your pick-up and drop-off point. \nPick-up and drop-off points should be different.", "OW-JEK",
				        JOptionPane.INFORMATION_MESSAGE);
			}
			else {
			reg.show(distance);
		int n = JOptionPane.showConfirmDialog(
	            null,
	            "Thank you for using OW-JEK Regular! \n" + reg.getRegstr()
	            + "Would you like to ride again?",
	            "OW-JEK!",
	            JOptionPane.YES_NO_OPTION);
	        if(n==JOptionPane.YES_OPTION){
	        	setVisible(false);
	            Program program = new Program();
	        }
	        else{
	        	System.exit(0);
	        }
			}
		}
		
		else if (type.equalsIgnoreCase("sporty")){
			Sporty sporty = new Sporty();
			if (distance==0){
				JOptionPane.showMessageDialog(panel, "Select your pick-up and drop-off point. \nPick-up and drop-off points should be different.", "OW-JEK",
				        JOptionPane.INFORMATION_MESSAGE);
			} else {
			sporty.show(distance);
			
		int n = JOptionPane.showConfirmDialog(
	            null,
	            "Thank you for using OW-JEK Sporty! \n" + sporty.getSportstr()
	            + "Would you like to ride again?",
	            "OW-JEK!",
	            JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION){
        	setVisible(false);
            Program program = new Program();
        }
        else{
        	System.exit(0);
        	}
        }
		}
		else if (type.equalsIgnoreCase("exclusive")){
			Exclusive ex = new Exclusive();
			if (distance==0){
				JOptionPane.showMessageDialog(panel, "Select your pick-up and drop-off point. \nPick-up and drop-off points should be different.", "OW-JEK",
				        JOptionPane.INFORMATION_MESSAGE);
			} else {
			ex.show(distance);
		int n = JOptionPane.showConfirmDialog(
	            null,
	            "Thank you for using OW-JEK Exclusive! \n" + ex.getExstr()
	            + "Would you like to ride again?",
	            "OW-JEK!",
	            JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION){
        	setVisible(false);
            Program program = new Program();
        }
        else{
        	System.exit(0);
        }
        }
		}
	}
	
	public void createButton(){
		/* Membuat tombol JButton ORDER NOW beserta action listenernya yang jika diklik 
		  akan menjalankan method JOptionPane*/
		orderbutton = new JButton();
		orderbutton.setIcon(new ImageIcon("orderbutton.png"));
		orderbutton.setFocusPainted(false);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		orderbutton.setBorder(emptyBorder);
		Color color;
		color=new Color(46,204,113);
		orderbutton.setBackground(color);
		class AddInterestListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				JOptionPane();
			}
		}
		ActionListener listener = new AddInterestListener();
		orderbutton.addActionListener(listener);
	}
	
	public void insertImage(){
		/* Memasukkan image header(owjek) ke JLabel*/
		headerowjek = new JLabel();
		label1 = new JButton();
		label2 = new JButton();
		label3 = new JButton();
		label4 = new JLabel();
		label5 = new JLabel();
		/* Memasukkan gambar untuk tipe regular, sporty, dan exclusive ke button-button serta menambahkan action 
		 listener untuk mengubah warna tombol dan type owjek saat diklik*/
		headerowjek.setIcon(new ImageIcon("header.jpg"));
		label1.setIcon(new ImageIcon("regular.png"));
		label1.setFocusPainted(false);
		label2.setIcon(new ImageIcon("sporty.png"));
		label2.setFocusPainted(false);
		label3.setIcon(new ImageIcon("exclusive.png"));
		label3.setFocusPainted(false);
		label4.setIcon(new ImageIcon("gakosong.jpg"));
		label5.setIcon(new ImageIcon("kosong.jpg"));
		Color color = new Color(188,212,236);
		Color color2 = new Color(185,196,196);
		label1.setBackground(color2);
		label2.setBackground(color);
		label3.setBackground(color);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		label1.setBorder(emptyBorder);
		label2.setBorder(emptyBorder);
		label3.setBorder(emptyBorder);
		class AddInterestListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				resetButton();
				Color color;
				color=new Color(185,196,196);
				label1.setBackground(color);
				type = "regular";
			}
		}
		class AddInterestListener2 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				resetButton();
				Color color;
				color=new Color(185,196,196);
				label2.setBackground(color);
				type = "sporty";
			}
		}
		class AddInterestListener0 implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				resetButton();
				Color color;
				color=new Color(185,196,196);
				label3.setBackground(color);
				type = "exclusive";
			}
		}
		
		ActionListener listener = new AddInterestListener();
		ActionListener listener2 = new AddInterestListener2();
		ActionListener listener3 = new AddInterestListener0();
		label1.addActionListener(listener);
		label2.addActionListener(listener2);
		label3.addActionListener(listener3);
	}
	
	public void JPanel(){
		/* Membuat JPanel yang diadd dengan label-label yang sudah ada, lalu panel tersebut akan diadd ke frame*/
		JPanel bottom = new JPanel(); 	    
		Color color;
		color=new Color(188,212,236);
		bottom.setBackground(color);
		bottom.add(label4);
        bottom.add(label1);
        bottom.add(label2);
        bottom.add(label3);
        bottom.add(orderbutton);
        bottom.add(label5);
	    Drawmap mymap = new Drawmap();
	    add(headerowjek);
	    add(mymap);
	    add(bottom);
	    setVisible(true); 
	}
	
	public void resetButton(){
		/* Mereset seluruh warna tombol saat 1 tombol diklik, sehingga hanya ada satu tombol yang berwarna abu-abu*/
		Color color;
		color=new Color(188,212,236);
		label1.setBackground(color);
		label2.setBackground(color);
		label3.setBackground(color);
	}
	
	class Drawmap extends JPanel {
		public  boolean start=false;
		public  boolean finish=false;
		public  int xstart;
		public  int ystart;
		public  int xfinish;
		public  int yfinish;
		
		public Drawmap() {
			/* Membuat peta*/
			Map map= new Map();
			setSize(1000, 500);
			setPreferredSize(new Dimension(1000, 500));
			addMouseListener(new MouseListener() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	if (map.get(e.getY()/10, e.getX()/10)!="#".charAt(0)&&start==false) {
				        xstart=(e.getX()/10)*10;
				        ystart=(e.getY()/10)*10;
				        start=true;
				        repaint();
			    	}
			    	else if (map.get(e.getY()/10, e.getX()/10)!="#".charAt(0)&&start==true) {
				        xfinish=(e.getX()/10)*10;
				        yfinish=(e.getY()/10)*10;
				        getInputMethodListeners();
				        finish=true;
				        repaint();
			    	}   
			    }
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
			});
		}
		@Override
		public void paint(Graphics g)  {
			super.paint(g);
			Map map = new Map();
			/*Menggambar rectangle dengan 2 warna berbeda untuk jalan dan pagar sesuai koordinatnya*/
			for (int row=0;row<map.getMap().length;row++) {
				for (int col=0;col<map.getMap()[0].length;col++) {
					Color color;
					if (map.getMap()[row][col]=="#".charAt(0)) {
						color=new Color(219,219,219);
					}
					else {	
						color=new Color(254,244,242);
					}
					g.setColor(color);
					g.fillRect((10*col),(10*row), 10, 10);
					
				}
			}
			/* Menandai starting point*/
			if (start==true) {
				Color color=new Color(27,188,155);
				g.setColor(color);
				g.fillRect(xstart,ystart, 10, 10);
				g.drawString("PICK UP", xstart, ystart);
			}
			/* Menandai finish point, menjalankan shortest path, serta menggambar rute*/
			if (finish==true) {
				Color color=new Color(53,152,219);
				g.setColor(color);
				g.fillRect(xfinish,yfinish, 10, 10);
				g.drawString("DROP OFF", xfinish, yfinish);
				ShortestPath path = new ShortestPath(map);
				map.set('S',ystart/10,xstart/10); //Menaruh S dan F
                map.set('F',yfinish/10,xfinish/10);
				path.execute(ystart/10, xstart/10);
				map.set('S',ystart/10,xstart/10); //Menaruh S dan F
                map.set('F',yfinish/10,xfinish/10);
                distance = path.getDistance();
                g.drawString(distance/10.0 + " KM", 460, 490);
				ArrayList<Integer> coord = new ArrayList<Integer>();
				for (int row=0;row<map.getMap().length;row++) {
					for (int col=0;col<map.getMap()[0].length;col++) {
						if (map.getMap()[row][col]==".".charAt(0)) {
							Color color2=new Color(254,252,139);
							g.setColor(color2);
						coord.add(col*10);
						coord.add(row*10);
						g.fillRect((10*col),(10*row), 10, 10);
						}
					}
				}
			}
		}
	}		
}