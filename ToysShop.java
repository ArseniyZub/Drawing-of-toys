import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ToysShop<T> {
    
    private ArrayList<Toys> list;

    public ToysShop(){
        this.list = new ArrayList<>();
    }

    public void addСategories(Toys toy) {
        for (int i = 0; i < toy.getQuantity(); i++) {
            list.add(new Toys(toy.getName(), toy.getQuantity(), toy.getChance()));
        }
    }

    public void randomSelection(ToysShop<Toys> list) {
        Random r = new Random();
        int randomValue = r.nextInt(100);
        boolean status = false;

        for (int i = 0; i < list.size(); i++) {
            if (randomValue <= list.get(i).getChance()) {
                status = true;
                WriteInFile(list.get(i), status);

                removeToy(list.get(i));
                setList(i, list.get(i));
                
                break;
            }
        }

        if (!status) {
            WriteInFile(list.get(0), status);
        }
    }

    public void WriteInFile(Toys toy, boolean win) {
        String filePath = "C:\\Users\\zubko\\OneDrive\\Рабочий стол\\DrawingOfToys\\DrawingOfToys\\doc.text";
        String lose = "\n-----------------------------\n" + "Упс... Похоже вам не повело :/ ";
        
        try {
            if (win) {
                Files.write(Paths.get(filePath), toy.toString().getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(filePath), lose.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setList(int index, Toys toy) {
        list.set(index, toy);
    }

    public void removeToy(Toys toy) {
        list.remove(toy);
    }

    public int size() {
        return list.size();
    }

    public Toys get(int i) {
        return list.get(i);
    }

    public ArrayList<Toys> getList() {
        return list;
    }
}
