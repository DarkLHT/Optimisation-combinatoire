import org.chocosolver.solver.constraints.*;
import org.chocosolver.solver.search.strategy.*;
import org.chocosolver.solver.variables.*;
import org.chocosolver.solver.*;
import org.chocosolver.solver.trace.*;
import org.chocosolver.solver.search.limits.*;
import org.chocosolver.solver.search.loop.monitors.*;

public class BasicKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solver solver = new Solver();
		IntVar[] items = new IntVar[3]; //il y a 5 items parmis lesquels choisir
		items[0] = VF.bounded("item00", 0, 3, solver);  //le nombre de chaque item qu'on peut choisir??
		items[1] = VF.bounded("item01", 0, 2, solver);
		items[2] = VF.bounded("item02", 0, 1, solver);
		
		
		IntVar totalWeight = VF.bounded("TotalWeight", 0, 8, solver);
		
		int[] weights = new int[]{1,3,8};
		int[] values = new int[]{1,4,10000};
		
		int maxValue=0;
		for(int j=0; j<items.length; j++) {
			maxValue = maxValue+ (items[j].getUB()*values[j]);
		}
		
		
		IntVar totalValue = VF.bounded("TotalValue", 0, maxValue, solver);
		
		
		solver.post(ICF.knapsack(items, totalWeight, totalValue, weights, values));
		
		solver.findOptimalSolution(ResolutionPolicy.MAXIMIZE, totalValue);
		for(int i = 0; i<3; i++) {
			System.out.println(items[i]);
		}
		System.out.println(totalValue);
		System.out.println(totalWeight);
		Chatterbox.printStatistics(solver);
	}

}
