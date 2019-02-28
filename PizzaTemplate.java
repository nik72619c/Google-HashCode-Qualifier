import java.util.ArrayList;

public class Pizza {
    int Row;
    int Col;
    int L;
    int H;
    ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

    @Override
    public String toString() {
        return "Pizza{" +
                "R=" + Row +
                ", C=" + Col +
                ", L=" + L +
                ", H=" + H +
                ", matrix=" + matrix +
                '}';
    }
}