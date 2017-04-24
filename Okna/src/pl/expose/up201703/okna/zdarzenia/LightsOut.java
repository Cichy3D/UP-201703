package pl.expose.up201703.okna.zdarzenia;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import pl.expose.up201703.okna.komponenty.LightPanel;

public class LightsOut extends JFrame {

	static LightPanel[][] pole = new LightPanel[5][5];
	static Random random = new Random();
	
	public LightsOut(){
		super("Lights Out");
		setSize(800,600);
		setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel);
		JPanel centerPanel = new JPanel();
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		{
			centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
			centerPanel.setLayout(new GridLayout(5, 5));
			for(int i=0; i<25; i++){
				int x = i/5, y = i%5;
				pole[x][y] = new LightPanel();
				centerPanel.add(pole[x][y]);
				Component mojeOkno = this;
				pole[x][y].addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						pole[x][y].changeStan();
						if(x>0){
							pole[x-1][y].changeStan();
						}
						if(x<4){
							pole[x+1][y].changeStan();
						}
						if(y>0){
							pole[x][y-1].changeStan();
						}
						if(y<4){
							pole[x][y+1].changeStan();
						}
						repaint();
						boolean nieWygral = false;
						for(int a = 0; a<5; a++){
							for(int b = 0; b<5; b++){
								nieWygral |= pole[a][b].isStan();
							}
						}
						if(!nieWygral){
							JOptionPane.showMessageDialog(mojeOkno, "Zwyciêstwo!", "Wygrana", JOptionPane.INFORMATION_MESSAGE);
							newLevel();
							repaint();
						}
					}
				});
			}
		}
		JPanel southPanel = new JPanel();
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		{
			southPanel.setLayout(new GridLayout(1, 1));
			southPanel.setBorder(new EmptyBorder(0, 20, 20, 20));
			JButton newLevelButton = new JButton("New Level");
			southPanel.add(newLevelButton);
			newLevelButton.setBorder(new EmptyBorder(20, 20, 20, 20));
			newLevelButton.addActionListener(e-> {
				newLevel();
				repaint();
			});
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		new LightsOut();
		newLevel();
	}
	
	public static void newLevel(){
		for(int x=0; x<5; x++){
			for(int y=0; y<5; y++){
				pole[x][y].setStan(random.nextBoolean() && random.nextBoolean());
			}
		}
		pole[random.nextInt(5)][random.nextInt(5)].setStan(true);
	}

}
