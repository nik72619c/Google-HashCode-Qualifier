import java.util.ArrayList;

public class Slice {

    public Slice(Cell p1, Cell p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    Cell p1;
    Cell p2;
    ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("%d %d %d %d", p1.r, p1.c, p2.r, p2.c);
    }
}
