package sevice;

import sevice.exeption.MapReadExeption;

import java.util.Scanner;

public class DataHandler {

    public int readInMapSize() throws MapReadExeption {
        System.out.print("Please enter the size of the map: ");
        Scanner scanner=null;
        int size;
        try {
            scanner = new Scanner(System.in);
            size=scanner.nextInt();
        }
        catch (NumberFormatException e){
            throw new MapReadExeption("The number of columns/rows must be a number!");

        }finally {
            if(scanner!=null) {
                scanner.close();
            }
        }
        return size;

    }
    public String readInOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your turn: ");
        return scanner.nextLine();

    }
}
