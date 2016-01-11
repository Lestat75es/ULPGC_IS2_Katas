package kata7.application.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import kata7.control.Command;
import kata7.model.Attribute;
import kata7.view.AttributeDialog;
import kata7.view.PopulationDialog;
import org.jfree.ui.action.ActionButton;

public class ToolBar extends JPanel implements AttributeDialog, PopulationDialog {

    private final Map<String, Command> commands;
    private final List<Attribute> attributes;
    private JComboBox combo;

    public ToolBar(Map<String, Command> commands) {
        super(new FlowLayout());
        this.attributes = new ArrayList<>();
        this.commands = commands;
        this.add(mailDomainAttribute());
        this.add(firstMailAttribute());
        this.add(comboBox());
        this.add(calculateButton());
    }

    @Override
    public Attribute<Person, String> attribute() {
        return attributes.get(combo.getSelectedIndex());
    }

    @Override
    public List population() {
        try {
            return MailReader.read("emails.txt");
        } catch (IOException ex) {
            return new ArrayList();
        }
    }

    private JComboBox comboBox() {
        combo = new JComboBox(Options("Mail Domain", "First Char"));
        return combo;
    }

    private String[] Options(String... options) {
        return options;
    }

    private void add(Attribute attribute) {
        attributes.add(attribute);
    }

    private Attribute mailDomainAttribute() {
        return new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        };
    }

    private Attribute firstMailAttribute() {
        return new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        };
    }

    private JButton calculateButton() {
        JButton button = new ActionButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("calculate").execute();
            }
        });
        return button;
    }
}
