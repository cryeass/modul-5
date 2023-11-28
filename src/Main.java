import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] nama = {"Andi", "Bima", "Rahma", "Zeno", "Rahma", "Andi"};
        String[] nim = {"11119", "11112", "11131", "11198", "11131", "11119"};
        String[] semester = {"1", "1", "3", "9", "3", "1"};


        Map<String, ArrayList<String>> map = new HashMap<>();


        for (int i = 0; i < nama.length; i++) {
            String key = nama[i] + " " + nim[i];


            if (!map.containsKey(key)) {
                ArrayList<String> value = new ArrayList<>();
                value.add(semester[i]);
                map.put(key, value);
            }
        }


        String output = "Nama NIM Semester\n";
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            output += entry.getKey() + " " + entry.getValue().get(0) + "\n";
        }

        try {
            File file = new File("data_mahasiswa.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(output);
            fileWriter.close();
            System.out.println("Data has been written to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
