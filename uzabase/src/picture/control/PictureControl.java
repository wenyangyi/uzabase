package picture.control;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import picture.model.Panel;
import picture.model.Figure;
import picture.util.PictureError;

public class PictureControl extends JPanel {
	private static final long serialVersionUID = 1L;

    private static final int WIDTH = Panel.SIZE;
    private static final int HEIGHT = Panel.SIZE;
    private static final int FIGURECOUNT = 3;

    private Panel picture = new Panel();

    public static void main(String[] args) {
        PictureControl pc = new PictureControl();
        pc.pictureCreate();
        pc.runScenario();
    }

    public PictureControl() {
        JFrame app = new JFrame("Computer Science");
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        app.setSize(WIDTH, HEIGHT);
        app.setResizable(false);
        app.getContentPane().add(this);
        app.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        picture.draw(g);
    }

    /**
     * PictureView の draw メソッドを呼んで画面を描き直した後、
     * 100 ミリ秒一時停止する。
     */
    public void pause() {
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 絵の生成
     */
    public void pictureCreate() {
    	Figure[] figures = new Figure[FIGURECOUNT];
    	figures[0] = new Figure(100, 100, 0, 20, Figure.ROUND, Color.YELLOW);
    	figures[1] = new Figure(-100, -150, 0, 20, Figure.DIAMOND, Color.BLUE);
    	figures[2] = new Figure(30, 0, 400, 40, Figure.DIAMOND, Color.RED);
    	try {
			picture.create(figures);
		} catch (PictureError e) {
			e.printStackTrace();
			System.out.print("PictureError!");
		}
    }
    /**
     * 絵の動きのシナリオ
     */
    public void runScenario() {
    	Figure[] elements = picture.getElements();
    	pause();
        for (int i = 0; true; i++) {
            double theta = 2.0 * Math.PI * i / 50.0;
            picture.lateralMove(elements[0], theta);
            picture.verticalMove(elements[1], theta);
            pause();
        }
    }
}
