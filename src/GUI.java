import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by abdelrahman on 5/8/17.
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{

    /**
     * Create the frame.
     */
    public GUI(AVLTree tree) {
        JPanel contentPane = new JPanel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        TreeDrawer drawer = new TreeDrawer(tree);

        contentPane.add(drawer);
        setContentPane(contentPane);
        setVisible(true);
    }

}

class TreeDrawer extends JPanel {

    private AVLTree tree;

    TreeDrawer(AVLTree tree){
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        draw((Graphics2D) g, 0, getWidth()-4, 0, getHeight() / Integer.max(tree.height() + 1, 1), tree
                .getRoot());
    }

    private void draw(Graphics2D g, int StartWidth, int EndWidth, int StartHeight, int Level, Node
            node) {
        if(node == null)
            return;
        String data = String.valueOf(node.data);
        g.setFont(new Font("Tahoma", Font.BOLD, 10));
        FontMetrics fm = g.getFontMetrics();
        int dataWidth = fm.stringWidth(data);

        g.drawRect(StartWidth + 2, StartHeight + 2, EndWidth-StartWidth - 2, Level - 2);


        if(dataWidth < (EndWidth - StartWidth)) {
            g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);
        }
        else {
            AffineTransform defaultAT = g.getTransform();
            // rotate
            g.translate((StartWidth + EndWidth) / 2, StartHeight + Level / 2 - dataWidth / 2);
            g.rotate(Math.PI / 2);
            g.drawString(data, 0, 0);

            g.setTransform(defaultAT);
        }

        if (node.left != null)
            draw(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.left);

        if (node.right != null)
            draw(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.right);
    }
}
