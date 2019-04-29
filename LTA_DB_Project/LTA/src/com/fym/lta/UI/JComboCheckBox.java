import java.awt.CheckboxGroup;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.event.ListDataListener;

public class JComboCheckBox extends AbstractListModel implements ComboBoxModel {

    JCheckBox[] choices;
    Object selectedItem;

    public JComboCheckBox(JCheckBox[] choices) {
        this.choices = choices;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedItem = anItem;
    }

    @Override
    public Object getElementAt(int index) {
        return (JCheckBox)choices[index];
    }

    @Override
    public int getSize() {
        return choices.length;
    }
}
