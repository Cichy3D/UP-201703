package pl.expose.up201703.okna.podstawy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Przeglad extends JFrame {

	public JProgressBar progress;
	public JComboBox combo;

	public Przeglad() throws HeadlessException {
		super("Przegl¹d komponentów Swing'u");
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		JPanel panelGlowny = new JPanel();
		//panelGlowny.setLayout(new GridLayout(2, 20));
		add(panelGlowny);
		
		JScrollPane scroll = new JScrollPane(new JTextArea());
		scroll.setPreferredSize(new Dimension(100, 100));
		panelGlowny.add(scroll);
		panelGlowny.add(new JLabel("<HTML>To <font color=#ff0000><u>jest</u></font> labelka"
				+ "<table style='background: #ff0000'><tr><td>aaaa</td></tr><tr><td>aaaa</td></tr></table>"));
		panelGlowny.add(new JButton("OK"));
		panelGlowny.add(new JTextField(10));
		panelGlowny.add(new JPasswordField(8));
		panelGlowny.add(new JCheckBox("Czy zgadzasz siê na warunki licencji"));
		combo = (JComboBox) panelGlowny.add(new JComboBox<>(new String[]{"Opcja 1", "Opcja 2","Opcja A","Opcja B"}));
		JScrollPane scrollLisy = new JScrollPane(new JList<>("Ala ma kota, a kot ma Alê".split(" ")));
		scrollLisy.setPreferredSize(new Dimension(60, 100));
		panelGlowny.add(scrollLisy);
		
		JPanel radioPanel = (JPanel) panelGlowny.add(new JPanel());
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.PAGE_AXIS));
		radioPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Opcje"));
		{
			ButtonGroup grupa = new ButtonGroup();
			JRadioButton radio1 = (JRadioButton) radioPanel.add(new JRadioButton("Opcja 1"));
			JRadioButton radio2 = (JRadioButton) radioPanel.add(new JRadioButton("Opcja 2"));
			JRadioButton radioA = (JRadioButton) radioPanel.add(new JRadioButton("Opcja A"));
			JRadioButton radioB = (JRadioButton) radioPanel.add(new JRadioButton("Opcja B"));
			grupa.add(radio1);
			grupa.add(radio2);
			grupa.add(radioA);
			grupa.add(radioB);
		}
		progress = (JProgressBar)panelGlowny.add(new JProgressBar(SwingConstants.HORIZONTAL));
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		Przeglad p = new Przeglad();
		
		
		
		//new JFileChooser().showOpenDialog(null);
		int t = 0;
		while(p.isVisible()){
			Thread.sleep(50);
			int index = p.combo.getSelectedIndex();
			
			t = (t+index)%100;
			p.progress.setValue(t);
			
		}
		
	}

}
