public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        int j = 0;
        while (j < 500) {
            if (!Flik.isSameNumber(i, j)) {
                break;
            }
            i++;
            j++;
        }
        System.out.println("i is " + i);
    }
}
