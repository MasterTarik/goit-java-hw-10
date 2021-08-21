import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Sorted {
    private static List<String> list;

    public static void main(String[] args) {

        String fileDirectoryTask1and2 = "src\\main\\resources\\namelist.txt";
        String fileDirectoryTask3 = "src\\main\\resources\\integerList.txt";

        Sorted task = new Sorted();
        task.uploadListFromFile(fileDirectoryTask1and2);

        System.out.println("Used names: " + task.list);
        System.out.println("Task 1.: \n" + task.unpaired(task.list));
        task.sortedList();
        System.out.println("Task 2.: \n" + task.list);
        System.out.println(Arrays.toString(task.reversAndUpperCaseList()));

        Sorted task3 = new Sorted();
        task3.uploadListFromFile(fileDirectoryTask3);
        task3.sortedList();
        System.out.println("Task 3:. \n" + task3.list);
        System.out.println("separator " + task3.intSeparator());

        System.out.println("int: " + task3.intArray());

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

    public void sortedList() {
        this.list.sort(String::compareToIgnoreCase);
    }

    public String[] reversAndUpperCaseList() {
        String[] revers = new String[this.list.size()];
        for (int i = 1; i <= this.list.size(); i++) {
            revers[this.list.size() - i] = this.list.get(i - 1).toUpperCase(Locale.ROOT);
        }
        return revers;
    }

    public List<Integer> intArray() {
        List<Integer> result = new ArrayList<>();
        for (String intString : intSeparator().split("\\s+")) {
            result.add(Integer.parseInt(intString));
        }
        result.sort(Integer::compareTo);
        return result;
    }

    public String intSeparator() {
        String result = "";
        for (String str : list) {
            result = result + str.strip() + " ";
        }
        return result;
    }

    private void uploadListFromFile(String fileDirectory) {
        this.list = new ArrayList<>();
        try (FileReader file = new FileReader(fileDirectory)) {
            BufferedReader bufferedReader = new BufferedReader(file);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                this.list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
