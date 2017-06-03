import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;

public class GUI extends JFrame{
	private JButton button;
	private JPanel panel;
	private JLabel label;
	private JLabel showmap;

	public GUI(){
		/* Mengatur ukuran, judul, dan layout pada frame serta menjalankan beberapa method 
		 seperti createButton, insertImage, dan JPanel*/
		setSize (1015,730);
		setResizable(false);
		setTitle ("OW-JEK! by Teresa Prima");
		setLayout(new GridBagLayout());
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		createButton();
		insertImage();
		JPanel();
		setVisible(true);
	}
	
	public void createButton(){
		/* Membuat tombol JButton show map beserta action listenernya yang jika diklik 
		  akan menjalankan class Program*/
		button = new JButton ("SHOW MAP");
		button.setFocusPainted(false);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		button.setBorder(emptyBorder);
		Color color;
		color=new Color(56,69,79);
		button.setBackground(color);
		button.setFont(new Font("Montserrat", Font.PLAIN, 20));
		button.setForeground(Color.WHITE);
		class AddInterestListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Program program = new Program();
				setVisible(false);
			}
		}
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	
	
	public void JPanel(){
		/* membuat JPanel, mengatur layout serta menambahkan button pada panel*/
		panel = new JPanel ();
		panel.setLayout(new GridBagLayout());
		panel.add(label);
		panel.add(button);
		GridBagConstraints gc = new GridBagConstraints();
        gc.ipady = 15;
        gc.ipadx = 50;
        gc.gridx = 0;
        gc.gridy = 0;
        panel.add(button, gc);
		add(panel);
	}
	
	public void insertImage(){
		/* Memasukkan background image ke label*/
		label = new JLabel();
		label.setIcon(new ImageIcon("owjek.jpg"));
	}
}