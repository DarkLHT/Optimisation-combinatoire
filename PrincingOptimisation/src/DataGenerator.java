import java.util.Random;


public class DataGenerator {
	
	
	public static void main(String[] args) {
		//constantes
		int NUM_TICKETS = 50;
		int NUM_REGIONS = 5;
		
		//générateur de nombres aléatoire
		Random rand = new Random();
		
		double[] tkCosts = new double[NUM_TICKETS];
		double[] tkPrices = new double[NUM_TICKETS];
		int[] tkRegions = new int[NUM_TICKETS];
		
		//test
		int[] rgCount = new int[NUM_REGIONS];
		for(int j =0; j<NUM_REGIONS; j++) {
			rgCount[j]=0;
		}
	
		//assigner des couts à chaque billet
		for(int i = 0; i<NUM_TICKETS; i++) {
			tkCosts[i] = Math.round((150+1000*Math.random())*100);
			tkCosts[i] = tkCosts[i]/100;
			
			tkPrices[i] = Math.round((tkCosts[i]+(1.5*tkCosts[i]*Math.random()))*100);
			tkPrices[i] = tkPrices[i]/100;
			
			tkRegions[i] = rand.nextInt(4-0+1);
			//temporaire: tests pour voir le nombre de billets dispo par région
			rgCount[tkRegions[i]]++;
		}
		
		//afficher les données
		//cout de billets
		System.out.println("Ticket costs:");
		for(int j=0; j<NUM_TICKETS; j++) {
			if(j==0) {
				System.out.print("["+tkCosts[j]+",");
			}
			else if (j==NUM_TICKETS-1) {
				System.out.println(tkCosts[j]+"]");
			}
			else {
				System.out.print(tkCosts[j]+",");
			}
		}
		//prix de vente de billets
		System.out.println("Ticket prices:");
		for(int j=0; j<NUM_TICKETS; j++) {
			if(j==0) {
				System.out.print("["+tkPrices[j]+",");
			}
			else if (j==NUM_TICKETS-1) {
				System.out.println(tkPrices[j]+"]");
			}
			else {
				System.out.print(tkPrices[j]+",");
			}
		}
		
		//région de destination
		System.out.println("Destination region:");
		for(int j=0; j<NUM_TICKETS; j++) {
			if(j==0) {
				System.out.print("["+tkRegions[j]+",");
			}
			else if (j==NUM_TICKETS-1) {
				System.out.println(tkRegions[j]+"]");
			}
			else {
				System.out.print(tkRegions[j]+",");
			}
		}
		
		//region count
		for(int j =0; j<NUM_REGIONS; j++) {
			System.out.println("Region "+j+": "+rgCount[j]);
		}
	}

}
