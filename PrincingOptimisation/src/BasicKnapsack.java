import org.chocosolver.solver.constraints.*;
import org.chocosolver.solver.search.strategy.*;
import org.chocosolver.solver.variables.*;
import org.chocosolver.solver.*;
import org.chocosolver.solver.trace.*;
import org.chocosolver.solver.search.limits.*;
import org.chocosolver.solver.search.loop.monitors.*;

public class BasicKnapsack {

	public static void main(String[] args) {
		Solver solver = new Solver();
		
		//nb d'items différents qu'on peut choisir
		IntVar[] items = new IntVar[3]; 

		//le nombre de chaque item qu'on peut choisir
		items[0] = VF.bounded("item00", 0, 3, solver);  
		items[1] = VF.bounded("item01", 0, 1, solver);
		items[2] = VF.bounded("item02", 0, 1, solver);
		
		//la capacité du sac à dos
		IntVar totalWeight = VF.bounded("TotalWeight", 0, 8, solver);
		
		//tableau de poids pour tous les items i
		int[] weights = new int[]{2,2,8};
		
		//tableau de valeurs pour tous les items i
		int[] values = new int[]{3000,4000,10000};
		
		//calcul de la valeur maximale possible (pour un sac à dos sans capacité maximale)
		int maxValue=0;
		for(int j=0; j<items.length; j++) {
			maxValue = maxValue+ (items[j].getUB()*values[j]);
		}
		
		//valeur à maximiser
		IntVar totalValue = VF.bounded("TotalValue", 0, maxValue, solver);
		
		
		solver.post(ICF.knapsack(items, totalWeight, totalValue, weights, values));
		
		//affichage de la solution
		solver.findOptimalSolution(ResolutionPolicy.MAXIMIZE, totalValue);
		for(int i = 0; i<3; i++) {
			System.out.println(items[i]);
		}
		System.out.println(totalValue);
		System.out.println(totalWeight);
		
		
		Chatterbox.printStatistics(solver);
	}

}
