import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\test\\input.txt"))) {
            String[] lineFirst = br.readLine().split(" ");
            int dataCenter = Integer.parseInt(lineFirst[0]);
            int server = Integer.parseInt(lineFirst[1]);
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            ArrayList<Data> list = new ArrayList<>();
            for (int i = 0; i < dataCenter; i++) {
                Data data = new Data(server);
                list.add(data);

            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                if (line.contains("DISABLE")) {
                    Data data = list.get(Integer.parseInt(str[1]) - 1);
                    if(!data.getServer(Integer.parseInt(str[2])).isDisable){
                    int a = data.getA() - 1;
                    data.setA(a);
                    data.getServer(Integer.parseInt(str[2])).isDisable = true;
                    }

                }
                if (line.contains("RESET")) {
                    Data data = list.get(Integer.parseInt(str[1]) - 1);
                    int r = data.getR() + 1;
                    data.setR(r);
                    data.setA(server);
                    for (int i = 1; i < server + 1; i++) {
                        data.getServer(i).isDisable = false;

                    }
                }
                if (line.contains("GETMAX")) {
                    TreeMap<Integer, Integer> map = new TreeMap<>();
                    for (int i = 0; i < list.size(); i++) {
                        int mp = list.get(i).getMultiplier();
                        if (mp > max) {
                            max = mp;
                            map.put(max, i + 1);
                        }
                    }
                    System.out.println( map.get(map.lastKey()));
                }
                if (line.contains("GETMIN")) {
                    TreeMap<Integer, Integer> map = new TreeMap<>();
                    for (int i = 0; i < list.size(); i++) {
                        int mp = list.get(i).getMultiplier();
                        if (mp < min) {
                            min = mp;
                            map.put(min, i + 1);

                        }
                    }
                    System.out.println(map.get(map.firstKey()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
