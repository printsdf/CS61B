import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void TestArrayDequeAdd() {
        /**
         * @source StudentArrayDequeLauncher.java
         */
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        int sad1Remove, ads1Remove;

        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 10; i += 1) {
                double numberBetweenZeroAndOne = StdRandom.uniform();

                if (numberBetweenZeroAndOne < 0.5) {
                    sad1.addLast(i);
                    ads1.addLast(i);
                    sad1Remove = sad1.removeLast();
                    ads1Remove = ads1.removeLast();
                } else {
                    sad1.addFirst(i);
                    ads1.addFirst(i);
                    sad1Remove = sad1.removeFirst();
                    ads1Remove = ads1.removeFirst();
                }

                assertEquals(ads1Remove, sad1Remove);
            }
        }
    }

}
