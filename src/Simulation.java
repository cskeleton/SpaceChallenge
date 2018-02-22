import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String fileString) throws FileNotFoundException {
        ArrayList<Item> arrayList = new ArrayList<>();
        File file = new File(fileString);
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String[] itemString = line.split("=");
            Item item = new Item(itemString[0],Integer.parseInt(itemString[1]));
            arrayList.add(item);
        }
        return arrayList;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> arrayList){
        ArrayList<Rocket> listU1 = new ArrayList<>();
        int rocNum = 0;
        listU1.add(new U1());
        for (Item item :arrayList) {
            if(listU1.get(rocNum).canCarry(item)){
                listU1.get(rocNum).setCurrentWeight(item.getWeight());
            }else {
                rocNum++;
                listU1.add(new U1());
                listU1.get(rocNum).setCurrentWeight(item.getWeight());
            }
        }

        return listU1;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> arrayList){
        ArrayList<Rocket> listU2 = new ArrayList<>();
        int rocNum = 0;
        listU2.add(new U2());
        for (Item item :arrayList) {
            if(listU2.get(rocNum).canCarry(item)){
                listU2.get(rocNum).setCurrentWeight(item.getWeight());
            }else {
                rocNum++;
                listU2.add(new U2());
                listU2.get(rocNum).setCurrentWeight(item.getWeight());
            }
        }

        return listU2;
    }

    public int runSimulation(ArrayList<Rocket> rocketList){
        int totalCosts = 0;
        int counts = 0;
        for (Rocket ro : rocketList) {
            do{
                totalCosts += ro.getCost();
                counts++;
            } while (!(ro.launch() && ro.land()));
        }
        System.out.println("Rockets used " + counts + " times");
        return totalCosts;
    }
}
