package com.framework.Figuras;

public class CanvasFactory
{
	public Canvas newPolygonBatch()
	{
		return new PolygonDrawer();
	}
}