package UI;


import com.sun.opengl.util.Animator;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EnrollmentPage extends JFrame implements ActionListener {

    private  JLabel ta;
    private JMenuBar mb;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;

    String clipText = new String("");

    GLCanvas glcanvas;
    NotePadGLEventListener listener = new NotePadGLEventListener();
   public static Animator animator = null;

    public static void main(String[] args) {
        final EnrollmentPage app = new EnrollmentPage("NotePad");

    }

    public EnrollmentPage(String title) {
        super(title);
        ta = new JLabel();
        mb = new JMenuBar();
        String s= """
                Welcome to LMS\s
                created by {Shorouk Mossaad_21-1-2023}
                ====================================================================================
                Home page
                ====================================================================================
                Student list:""";
        ta.setText(s);


        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open", 'o');
        openItem.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_DOWN_MASK));
        openItem.addActionListener(this);
        openItem.setActionCommand("O");
        saveItem = new JMenuItem("Save", 's');
        saveItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        saveItem.addActionListener(this);
        saveItem.setActionCommand("S");
        exitItem = new JMenuItem("Exit", 'x');
        exitItem.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_DOWN_MASK));
        exitItem.addActionListener(this);
        exitItem.setActionCommand("E");
        setJMenuBar(mb);
        mb.add(fileMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
ta.setBounds(520, 15, 100, 50);
add(ta);
       // add(new JScrollPane(ta));

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "O":
                openFile();
                break;
            case "S":
                saveContent();
                break;
            case "E":
                System.exit(0);
                break;

        }
    }

    private void openFile() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                ta.setText(new String(b));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                }

            }
        }
    }

    private void saveContent() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                byte[] b = ta.getText().getBytes();
                fos.write(b);
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                }

            }
        }

    }

    class NotePadGLEventListener implements GLEventListener {

        public void init(GLAutoDrawable glad) {
            GL gl = glad.getGL();
            GLU glu = new GLU();
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            gl.glViewport(-250, -150, 250, 150);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            glu.gluOrtho2D(-250, 250, -150, 150);
        }

        public void display(GLAutoDrawable glad) {
            GL gl = glad.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_LINE);

        }

        public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        }

        public void mouseClicked(MouseEvent e) {

            double x = e.getX();
            double y = e.getY();

            System.out.println(x + " " + y);

            Component c = e.getComponent();
            double width = c.getWidth();
            double height = c.getHeight();
            System.out.println(width + " " + height);

            glcanvas.repaint();
        }

        @Override
        public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {

        }

    }

}
