package Window;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readfile {
    private Scanner x;

    public void openFile(){

        try{
            x = new Scanner(new File("Chores.txt"));
        }
        catch(Exception e){

            System.out.println("Could not find file");
        }
    }
    public List<String> readFile(){
        List<String> a = new ArrayList<>();
        while(x.hasNext()){
            String b = x.nextLine();
            a.add(b);
        }
        return a;
    }
    public void closeFile(){
        x.close();
    }
}
