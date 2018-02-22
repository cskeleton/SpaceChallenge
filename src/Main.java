import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isU1 = true;
        Simulation simulation = new Simulation();
        ArrayList<Item> stage1 = new ArrayList<>();
        ArrayList<Item> stage2 = new ArrayList<>();

        try {
            stage1 = simulation.loadItems(importFile());
            stage2 = simulation.loadItems(importFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String input;

        do{
            System.out.println("Using U1 or U2 rocket? (answer \"U1\" or \"U2\".)");
            input = scanner.nextLine();
            switch (input) {
                case "U1":
                    isU1 = true;
                    break;
                case "U2":
                    isU1 = false;
                    break;
                default:
                    System.out.println("Please choose U1 or U2.");
                    break;
            }
        }while (!(input.equals("U1") || input.equals("U2")));

        calcCosts(isU1,simulation,stage1,stage2);
    }

    private static String importFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file: ");
        return scanner.nextLine();
    }

    private static void calcCosts(boolean isU1,
                                  Simulation simulation,
                                  ArrayList<Item> stage1,
                                  ArrayList<Item> stage2){

        ArrayList<Rocket> stageRoc1;
        ArrayList<Rocket> stageRoc2;


        if(isU1){
            stageRoc1 = simulation.loadU1(stage1);
            stageRoc2 = simulation.loadU1(stage2);
            System.out.println("U1 costs is: ");
        }else {
            stageRoc1 = simulation.loadU2(stage1);
            stageRoc2 = simulation.loadU2(stage2);
            System.out.println("U2 costs is: ");
        }

        System.out.println(simulation.runSimulation(stageRoc1)
                + simulation.runSimulation(stageRoc2));
    }
}
