import java.util.ArrayList;

public class Data {

    private int R;
    private int A;
    ArrayList<Server> serverList = new ArrayList<>();

    static class Server{
        boolean isDisable = false;
        public Server() {
        }
    }

    public Data(int count) {
        R = 0;
        A = count;
        for (int i = 0; i < count; i++) {
            serverList.add(new Server());
        }

    }

    public Server getServer(int i) {

        return serverList.get(i -1);
    }

    public int getR() {
        return R;
    }

    public int getA() {
        return A;
    }

    public void setR(int r) {
        R = r;
    }

    public void setA(int a) {
        A = a;
    }

    public int getMultiplier() {
        return R * A;
    }
}
