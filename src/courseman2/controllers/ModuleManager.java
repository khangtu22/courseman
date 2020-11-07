package courseman2.controllers;

import courseman2.DomainConstraint;
import courseman2.models.CompulsoryModule;
import courseman2.models.ElectiveModule;
import courseman2.models.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ModuleManager extends WindowAdapter implements ActionListener {
    private final String STORAGE_FILE = "//Users//khangtu//IdeaProjects//CourseMan//src//courseman2//controllers//module.dat";
    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private ArrayList<Module> modules;

    // view elements
    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JFrame gui;

    private JFrame frame;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JPanel north;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JPanel south;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JPanel centre;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JLabel title;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JButton ok;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JButton cancel;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JTextField tf1, tf2, tf3, tf4, tf5;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JComboBox c1;

    public ModuleManager() {
        modules = new ArrayList<>();
        createGUI();
    }

    /**
     * @modifies this.gui
     * @effects create <tt>gui</tt> as required (mockup image) <br>
     *          The action listener of the buttons is <tt>this</tt>.
     */
    public void createGUI() {
        // Main GUI
        gui = new JFrame("Create New Module");
        gui.setPreferredSize(new Dimension(550, 250));

        // North panel
        north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gui.add(north, BorderLayout.NORTH);
        JPanel centrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centre = new JPanel(new GridLayout(5,2));
        centrePanel.add(centre);
        gui.add(centrePanel, BorderLayout.CENTER);

        // South panel
        south = new JPanel();
        gui.add(south, BorderLayout.SOUTH);
        title = new JLabel("Enter Module details:");
        north.add(title);

        // the buttons
        ok = new JButton("OK");
        ok.addActionListener(this);

        cancel = new JButton("CANCEL");
        cancel.addActionListener(this);

        south.add(ok);
        south.add(cancel);

        // LABELS STUDENT TRAIT
        lbl1 = new JLabel("Module Type:");
        lbl2 = new JLabel("Name:(*)");
        lbl3 = new JLabel("Semester:(*)");
        lbl4 = new JLabel("Credit:(*)");
        lbl5 = new JLabel("Department Name:(*)");

        // the text fields
        String s1[] = { "Compulsory Module", "Elective Module" };
        c1 = new JComboBox<String>(s1);

        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        tf5 = new JTextField(20);

        // bind labels to text fields
        lbl1.setLabelFor(c1);
        lbl2.setLabelFor(tf2);
        lbl3.setLabelFor(tf3);
        lbl4.setLabelFor(tf4);
        lbl5.setLabelFor(tf5);

        centre.add(lbl1);
        centre.add(c1);
        centre.add(lbl2);
        centre.add(tf2);
        centre.add(lbl3);
        centre.add(tf3);
        centre.add(lbl4);
        centre.add(tf4);
        centre.add(lbl5);
        centre.add(tf5);

        tf5.setVisible(false);
        lbl5.setVisible(false);
        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) c1.getSelectedItem();
                switch (s) {//check for a match
                    case "Compulsory Module":
                        tf5.setVisible(false);
                        lbl5.setVisible(false);
                        break;
                    case "Elective Module":
                        tf5.setVisible(true);
                        lbl5.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        };
        c1.addActionListener(cbActionListener);

        gui.pack();
        gui.setLocationRelativeTo(null);
    }

    /**
     * @requires <tt>gui != null</tt>
     * @effects show <tt>gui</tt>
     */
    public void display() {
        gui.setVisible(true);
    }

    /**
     * @effects handles user actions on the buttons
     *
     *          <pre>
     *          if button is OK
     *            {@link #createModule()}: create a new student from form data
     *          else if button is Cancel
     *            {@link #clearInput()}: reset form fields
     *          </pre>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "OK" -> createModule();
            case "CANCEL" -> clearInput();
            case "EXIT" -> shutDown();
        }
    }

    /**
     * @effects
     *
     *          <pre>
     *  create a new student from the data in the data panel of gui and add it to <tt>this.students</tt>
     *
     *  if not success (exception is thrown)
     *      display the exception message on the GUI dialog
     *          </pre>
     */
    private void createModule() {
        // TODO: complete this code
        if (Objects.equals(c1.getSelectedItem(), "Compulsory Module")) {
            String moduleType = (String) c1.getSelectedItem();
            String name = tf2.getText();
            if (name.equals("") || tf3.getText().equals("") ||tf4.getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Created Module fail!!");
            }else {
                int semester = Integer.parseInt(tf3.getText());
                int credit = Integer.parseInt(tf4.getText());
                CompulsoryModule module = new CompulsoryModule(name, semester, credit);
                modules.add(module);
                System.out.println("Module: " + module.toString() + " created.");
                JOptionPane.showMessageDialog(frame, "Created Compulsory Module: " + module.toString());
            }
        } else if (Objects.equals(c1.getSelectedItem(), "Elective Module")){
            String moduleType = (String) c1.getSelectedItem();
            String name = tf2.getText();
            String dmn= tf5.getText();
            if (name.equals("") || tf3.getText().equals("") ||tf4.getText().equals("") || dmn.equals("")){
                JOptionPane.showMessageDialog(frame, "Created Module fail!!");
            }else {
                int semester = Integer.parseInt(tf3.getText());
                int credit = Integer.parseInt(tf4.getText());
                ElectiveModule module = new ElectiveModule(name, semester, credit, dmn);
                modules.add(module);
                System.out.println("Module: " + module.toString() + " created.");
                JOptionPane.showMessageDialog(frame, "Created Elective Module: " + module.toString());
            }
        } else {
            System.out.println("Create Module Fails!!");
            JOptionPane.showMessageDialog(frame, "Created module fail!" );
        }
    }

    /**
     * @requires this.tfName != null /\ this.tfDob != null /\ this.tfAddress != null
     *           /\ this.tfEmail != null
     */
    private void clearInput() {
        Component[] comps = centre.getComponents();
        Component comp;
        JTextField tf;
        for (Component component : comps) {
            comp = component;
            if (comp instanceof JTextField) {
                // found a text field
                tf = (JTextField) comp;

                // only clear the enabled text fields
                if (tf.isEnabled())
                    tf.setText("");
            } else if (comp instanceof JPanel) {
                clearInput();
            }
        }
    }

    /**
     * @requires <tt>gui != null</tt>
     * @effects hide <tt>gui</tt>
     */
    @Override
    public void windowClosing(WindowEvent e) {
        if (!gui.isVisible()){
            gui.setVisible(false);
            System.out.println("ModuleManager: closed!");
        }
    }

    /**
     * @requires <tt>students != null</tt>
     * @modifies this
     * @effects load into <tt>students</tt> the data students in the storage file
     *          <tt>students.dat</tt> that was saved before.
     *
     *          <pre>
     *          if succeeds
     *            display a console message
     *          else
     *            display a console error message
     *          </pre>
     */
    public void startUp() {
        if (modules != null){
            try (FileInputStream fis = new FileInputStream("modules.dat");
                 ObjectInputStream ois = new ObjectInputStream(fis);){
                try {
                    while (true){
                        Module m = (Module) ois.readObject();
                        modules.add(m);
                    }
                } catch (IOException e) {
                    System.out.println("Modules loaded "+modules.size()+" objects");
                    System.out.println("Reading Modules finished!");
                } catch (ClassNotFoundException e){
                    System.out.println("Modules loaded "+modules.size()+" objects");
                    System.out.println("Reading Modules finished!");
                }
            } catch (IOException e) {
                System.out.println("Reading Modules finished! File is empty!!!");
            }
        }
    }

    /**
     * @requires <tt>gui != null</tt>
     * @modifies this
     * @effects
     *
     *          <pre>
     *          dispose <tt>gui</tt> and clear <tt>students</tt>
     *          store <code>this.students</code> to file and shutdown the application
     *          </pre>
     */
    public void shutDown() {
        if(this.gui != null){
            this.gui.dispose();
            try (FileOutputStream fos = new FileOutputStream("modules.dat");
                 ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                modules.stream().forEach(m -> {
                    try {
                        oos.writeObject(m);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("ModuleManager.shutDown ...stored "+modules.size()+" objects");
                modules.clear();
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
