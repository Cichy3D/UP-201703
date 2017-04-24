package pl.expose.up201703.okna.zdarzenia;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WierakKoloru extends JFrame {

	public WierakKoloru(){
		super("Wybierak Koloru");
		setSize(800,600);
		setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		{
			northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
			
			JSlider[] sliderTab = new JSlider[3];
			
			ChangeListener changeListener = e-> {
				int r = sliderTab[0].getValue();
				int g = sliderTab[1].getValue();
				int b = sliderTab[2].getValue();
				centerPanel.setBackground(new Color(r>255?255:r, g>255?255:g, b>255?255:b));
			};
			
			for(int i=0; i<sliderTab.length; i++){
				sliderTab[i] = (JSlider) northPanel.add(new JSlider(0, 256, 256));
				sliderTab[i].setBorder(new EmptyBorder(10, 10, 10, 10));
				sliderTab[i].setPaintTicks(true);
				sliderTab[i].setMajorTickSpacing(64);
				sliderTab[i].setMinorTickSpacing(16);
				sliderTab[i].setSnapToTicks(true);
				sliderTab[i].addChangeListener(changeListener);
			}

			changeListener.stateChanged(null);
		}
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		new WierakKoloru();

	}

}
