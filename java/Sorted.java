import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Sorted {
    private List<String> list;

    public static void main(String[] args) {
        Sorted sorted = new Sorted();
        sorted.list = sorted.uploadListFromFile();

        System.out.println("Used names: " + sorted.list);
        System.out.println("Task 1.: \n" + sorted.unpaired(sorted.list));
        System.out.println("Task 2.: \n" + sorted.sortedList(sorted.list));
        System.out.println(Arrays.toString(sorted.reversAndUpperCaseList(sorted.list)));
    }

    public Sorted() {

    }

    public Sorted(List<String> list) {
        this.list = list;
    }

    public String unpaired(List<String> list) {
        String result = "";
        for (int i = 0; i < list.size(); i = i + 2) {
            if (list.get(i) != null) {
                result = result + (i + 1) + "." + list.get(i) + " ";
            }
        }
        return result;
    }

    public List<String> sortedList(List<String> list) {
        List<String> stringList = list;
        stringList.sort(String::compareToIgnoreCase);

        return stringList;
    }

    public String[] reversAndUpperCaseList(List<String> stringList) {
        String[] revers = new String[stringList.size()];
        for (int i = 1; i <= stringList.size(); i++) {
            revers[stringList.size() - i] = stringList.get(i - 1).toUpperCase(Locale.ROOT);
        }
        return revers;
    }

    private List<String> uploadListFromFile() {
        List<String> getList = new ArrayList<>();
        try (FileReader file = new FileReader("src\\main\\resources\\namelist.txt")) {
            BufferedReader bufferedReader = new BufferedReader(file);

            while (bufferedReader.readLine() != null) {
                getList.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getList;
    }

}
