package block4.unit2.task2;

public class BinOps {
    public String sum(String a, String b) {
        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        return Integer.toBinaryString(sum);
    }

    public String mult(String a, String b) {
        int mult = Integer.parseInt(a) * Integer.parseInt(b);
        return Integer.toBinaryString(mult);
    }
}
