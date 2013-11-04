package picture.test;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

import picture.model.Figure;

public class FigureTest {

	private Figure figure = new Figure(100, 100, 100, 20, Figure.ROUND, Color.RED);
	@Test
	public void testMove() {
		figure.move(20, 40, 60);
		Assert.assertEquals(20.0, figure.getX(), 1);
		Assert.assertEquals(40.0, figure.getY(), 1);
		Assert.assertEquals(60.0, figure.getZ(), 1);
	}

}