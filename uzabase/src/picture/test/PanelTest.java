package picture.test;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

import picture.model.Figure;
import picture.model.Panel;
import picture.util.PictureError;

public class PanelTest {

	private Panel panel = new Panel();
	@Test
	public void testCreate() {
		
		Figure[] figures_large = createFigure(20);
		Figure[] figures_same = createFigure(10);
		Figure[] figures_small = createFigure(5);

		try {
			panel.create(figures_large);
		} catch (PictureError e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		}
		try {
			panel.create(figures_same);
		} catch (PictureError e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}
		try {
			panel.create(figures_small);
		} catch (PictureError e) {
			// TODO Auto-generated catch block
			Assert.fail();;
		}
	}
	
	private Figure[] createFigure(int count) {
		Figure[] figures = new Figure[count];
		for (int i = 0; i< count; i++) {
			figures[i] = new Figure(100, 100, 100, 20, Figure.ROUND, Color.YELLOW);
		}
		return figures;
	}
}
