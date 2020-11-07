package courseman2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import courseman2.controllers.ModuleManager;
import courseman2.controllers.StudentManager;

/**
 * @overview Represents the main class of the CourseMan program.
 *
 * @attributes
 *  sman StudentManager
 *  mman ModuleManager
 *  gui JFrame
 *
 * @abstract_properties
 *   optional(sman) = false /\
 *   optional(mman) = false /\
 *   optional(gui) = false
 *
 * @author congnv
 */
public class CourseManDemo extends WindowAdapter implements ActionListener {

    @DomainConstraint(type=DomainConstraint.Type.String,optional=false)
    private final StudentManager sman; // the student manager

    @DomainConstraint(type=DomainConstraint.Type.String,optional=false)
    private final ModuleManager mman; // the module manager

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JFrame gui;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenuBar menuBar;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenu jm1;
    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenu jm2;
    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenu jm3;

    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenuItem jmi1;
    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenuItem jmi2;
    @DomainConstraint(type=DomainConstraint.Type.Object,optional=false)
    private JMenuItem jmi3;

    /**
     * @effects initialise <tt>sman, mman</tt> <br>
     *          {@link #createGUI()}: create <tt>gui</tt>
     */
    public CourseManDemo() {
        sman = new StudentManager();
        mman = new ModuleManager();
        createGUI();
    }

    /**
     * @modifies this.gui
     * @effects create <tt>gui</tt> that has a menu bar with:
     *          <ol>
     *          <li>File menu has one item: Exit
     *          <li>Student menu has one item: New Student (to create a new student)
     *          <li>Module menu has one item: New Module (to create a new module)
     *          </ol>
     *          The action listener of the menu items is <tt>this</tt>.
     */
    public void createGUI() {
        gui = new JFrame();
        gui.setPreferredSize(new Dimension(400, 300));
        //menu bar
        menuBar = new JMenuBar();

        jm1 = new JMenu("File");
        jm2 = new JMenu("Student");
        jm3 = new JMenu("Module");

        jmi1 = new JMenuItem("Exit");
        jmi2 = new JMenuItem("New Student");
        jmi3 = new JMenuItem("New Module");

        jmi1.addActionListener(this);
        jmi2.addActionListener(this);
        jmi3.addActionListener(this);

        jm1.add(jmi1);
        jm2.add(jmi2);
        jm3.add(jmi3);

        menuBar.add(jm1);
        menuBar.add(jm2);
        menuBar.add(jm3);

        gui.setJMenuBar(menuBar);
        gui.pack();
    }

    /**
     * @effects show <tt>gui</tt>
     */
    public void display() {
        gui.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            shutDown();
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * @effects handles user actions on the menu items
     *
     *          <pre>
     *          if menu item is Student/New Student
     *            {@link #sman}.display()}
     *          else if menu item is Module/New Module
     *            {@link #mman}.display()
     *          else if menu item is File/Exit
     *            {@link #shutDown()}
     *          </pre>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Exit":
                try {
                    shutDown();
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case "New Student":
                sman.display();
                break;
            case "New Module":
                mman.display();
                break;
        }
    }

    /**
     * @effects start up <tt>sman, mman</tt>
     */
    public void startUp() throws IOException, ClassNotFoundException {
        System.out.println("Starting up...");
        sman.startUp();
        mman.startUp();
    }

    /**
     * @effects shut down <tt>sman, mman</tt> <br>
     *          dispose <tt>gui</tt> and end the program.
     */
    public void shutDown() throws IOException, ClassNotFoundException {
        System.out.println("Shutting down...");
        gui.dispose();
        sman.shutDown();
        mman.shutDown();
    }

    /**
     * The run method
     *
     * @effects create an instance of <tt>CourseManDemo</tt> {@link #startUp()}:
     *          start up the <tt>CourseManDemo</tt> instance {@link #display()}:
     *          display the main gui of <tt>CourseManDemo</tt> instance
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CourseManDemo app = new CourseManDemo();
        app.startUp();
        app.display();
    }
}
