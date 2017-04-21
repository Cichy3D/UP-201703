package pl.expose.up201703.okna.komponenty;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;

public class PanelOpcji extends JPanel {

	private final JRadioButton[] przyciski;
	private final Object[] dane;

	public PanelOpcji(String nazwa, Object... dane) {
		this.dane = dane;
		przyciski = new JRadioButton[dane.length];

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), nazwa));

		ButtonGroup grupa = new ButtonGroup();
		for (int i = 0; i < dane.length; i++) {
			przyciski[i] = new JRadioButton(dane[i].toString());
			grupa.add(przyciski[i]);
			add(przyciski[i]);
		}
	}

	public int getSelectedIndex() {
		for (int i = 0; i < przyciski.length; i++) {
			if (przyciski[i].isSelected()) {
				return i;
			}
		}
		return -1;
	}

	public Object getSelectedItem() {
		int i = getSelectedIndex();
		if (i == -1) {
			return null;
		} else {
			return dane[i];
		}
	}

	public void clearSelection() {
		for (int i = 0; i < przyciski.length; i++) {
			przyciski[i].setSelected(false);
		}
	}

	public void setSelectedIndex(int i) {
		clearSelection();
		if (i > -1 && i < przyciski.length) {
			przyciski[i].setSelected(true);
		}
	}

	public void setSelectedItem(Object item) {
		if (item != null) {
			for (int i = 0; i < dane.length; i++) {
				przyciski[i].setSelected( item.equals(dane[i]) );
			}
		}
	}

}
