package Views;

import Models.Chromosome;

/**
 * 
 * @author al3x_hh
 *
 */
public interface Observer {
	
	public void updatePlot(double[] mean, double[] bestGeneration, double[] best, int generations, Chromosome result);
}
