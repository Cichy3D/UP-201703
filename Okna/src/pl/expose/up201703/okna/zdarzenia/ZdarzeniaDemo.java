package pl.expose.up201703.okna.zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class ZdarzeniaDemo extends JFrame {

	public ZdarzeniaDemo(){
		super("Zdarzenia Demo");
		setSize(800, 300);
		setLocationRelativeTo(null);
		
		JPanel panelGlowny = new JPanel();
		add(panelGlowny);
		
		MouseListener ml = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() instanceof JButton){
					System.out.println("Mysz¹ klikniêto na przycisk");
				} else {
					System.out.println("Mysz¹ klikniêto");
				}
			}
		};
		
		JButton przycisk = (JButton) panelGlowny.add(new JButton("Wciœnij mnie!"));
		przycisk.addMouseListener(ml);
		JTextField textField = (JTextField) panelGlowny.add(new JTextField(30));
		textField.addMouseListener(ml);
		textField.addKeyListener(new KeyAdapter() {
			@Override public void keyTyped(KeyEvent e) {
				System.out.println("Klawisz wpisano: "+(int)e.getKeyChar());
				if((int)e.getKeyChar() == 127){
					textField.setText("");
				}
			}
		});
		Action akcja = new AbstractAction("Akcja") {
			{
				System.out.println("Akcja jest tworzona");
				putValue(SHORT_DESCRIPTION, "Opis Akcji");
				
				KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.SHIFT_DOWN_MASK);
		        putValue(ACCELERATOR_KEY, keyStroke);
			}
			
			@Override public void actionPerformed(ActionEvent e) {
				System.out.println("Zosta³a wykonana akcja");
			}
		};
		panelGlowny.add(new JButton(akcja));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu opcjeMenu = menuBar.add(new JMenu("Opcje"));
		opcjeMenu.add(akcja);
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Okno siê zamyka");
				System.exit(0);
			}
		});
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		new ZdarzeniaDemo();

	}

}
