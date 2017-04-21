package pl.expose.up201703.okna.komponenty;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelOpcji extends JPanel {
	
	public interface SelectionChangeListener{
		public void onSelectionChanged();
	}
	
	private final JRadioButton[] przyciski;
	private final Object[] dane;
	private final List<SelectionChangeListener> changeListeners = new ArrayList<>();

	public PanelOpcji(String nazwa, Object... dane) {
		this.dane = dane;
		przyciski = new JRadioButton[dane.length];

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), nazwa));

		ButtonGroup grupa = new ButtonGroup();
		for (int i = 0; i < dane.length; i++) {
			przyciski[i] = new JRadioButton(dane[i].toString());
			final JRadioButton przycisk = przyciski[i];
			grupa.add(przycisk);
			add(przycisk);
			przycisk.addChangeListener((e)->{
				if(przycisk.isSelected()){
					fireSelectionChangeListeners();
				}
			});
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
		fireSelectionChangeListeners();
	}

	public void setSelectedIndex(int i) {
		if(getSelectedIndex() == i){
			return;
		}
		for (int k = 0; k < przyciski.length; k++) {
			przyciski[k].setSelected(false);
		}
		if (i > -1 && i < przyciski.length) {
			przyciski[i].setSelected(true);
			//fireSelectionChangeListeners();
		}
	}

	public void setSelectedItem(Object item) {
		Object wasSelectedItem = getSelectedItem();
		if(wasSelectedItem == item    ||     (item!=null && item.equals(wasSelectedItem))   ){
			return;
		}
		if(item == null){
			clearSelection();
		}
		for (int i = 0; i < przyciski.length; i++) {
			przyciski[i].setSelected(false);
		}
		for (int i = 0; i < dane.length; i++) {
			if(item.equals(dane[i])){
				przyciski[i].setSelected( true );
				//fireSelectionChangeListeners();
			}
		}
		
	}
	
	private void fireSelectionChangeListeners(){
		changeListeners.forEach(l->l.onSelectionChanged());
	}

	public void addSelectionChangeListener(SelectionChangeListener changeListener){
		changeListeners.add(changeListener);
	}
	
	public void removeSelectionChangeListener(SelectionChangeListener changeListener){
		changeListeners.remove(changeListener);
	}
	
}
