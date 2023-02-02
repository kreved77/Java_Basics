package CodewarsCom;

/*
https://www.codewars.com/kata/51fda2d95d6efda45e00004e
*/
/*
A user starts at rank -8 and can progress all the way to 8.
There is no 0 (zero) rank. The next rank after -1 is 1.
A user cannot progress beyond rank 8. (Once you reach rank 8 there is no more progression).
A user's rank progress starts off at zero, each time the progress reaches 100 the user's rank is upgraded to the next level

As the user's current rank is compared to the rank of the activity, the progress is scored like so:
• Completing an activity that is ranked the same as that of the user's will be worth 3 points
• Completing an activity that is ranked one ranking lower than the user's will be worth 1 point
• Any activities completed that are ranking 2 levels or more lower than the user's ranking will be ignored
• Completing an activity ranked higher than the current user's rank will accelerate the rank progression. The greater the difference between rankings the more the progression will be increased. The formula is 10 * d * d where d equals the difference in ranking between the activity and the user.
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodewarsStyleRankingSystem {
    public static class User {

        int rank;
        int progress;

        public User() {
            this.rank = -8;
            this.progress = 0;
        }

// VER_1
        public void incProgress(int kataRank) {
            System.out.println("NEW!");
            System.out.println(rank + " | " + progress);

            if (kataRank < -8 || kataRank == 0 || 8 < kataRank) throw new IllegalArgumentException();
            if (this.rank < 0 && 0 < kataRank)  kataRank--;
            if (kataRank < 0  && 0 < this.rank) kataRank++;

//            if (this.rank - kataRank == 2) this.progress += 0;
            if (this.rank - kataRank == 1) this.progress += 1;
            if (this.rank == kataRank) this.progress += 3;
            if (this.rank < kataRank) {
                int d = kataRank - this.rank;
                this.progress += 10 * d * d;
            }

            while (this.progress >= 100 && this.rank < 8) {
                this.rank = (this.rank == -1) ? 1 : ++this.rank;
                this.progress -= 100;
            }

            if (this.rank == 8) this.progress = 0;
            System.out.println(rank + " | " + progress);
       }
   }



// Test DATA
    User user = new User();
    private void do_test(int rank, int expectedRank, int expectedProgress) {
        if(rank!=0) user.incProgress(rank);
        assertEquals("After applying rank of " + rank, expectedRank, user.rank);
        assertEquals("After applying rank of " + rank, expectedProgress, user.progress);
    }
    @Test
    public void testIncProgress() throws Exception {
        do_test(-8, -8, 3);

        user = new User();
        do_test(-7, -8, 10);

        user = new User();
        do_test(-6, -8, 40);

        user = new User();
        do_test(-5, -8, 90);

        user = new User();
        do_test(-4, -7, 60);

        user = new User();
        do_test(-8, -8, 3);

        user = new User();
        do_test(1, -2, 40);
        do_test(1, -2, 80);
        do_test(1, -1, 20);
        do_test(1, -1, 30);
        do_test(1, -1, 40);
        do_test(2, -1, 80);
        do_test(2, 1, 20);
        do_test(-1, 1, 21);
        do_test(3, 1, 61);
        do_test(8, 6, 51);
        do_test(8, 6, 91);
        do_test(8, 7, 31);
        do_test(8, 7, 41);
        do_test(8, 7, 51);
        do_test(8, 7, 61);
        do_test(8, 7, 71);
        do_test(8, 7, 81);
        do_test(8, 7, 91);
        do_test(8, 8, 0);
        do_test(8, 8, 0);
    }
    @Test(expected = Exception.class)
    public void invalidRange9() {
        user.incProgress(9);
    }
    @Test(expected = Exception.class)
    public void invalidRangeNeg9() {
        user.incProgress(-9);
    }
    @Test(expected = Exception.class)
    public void invalidRange0() {
        user.incProgress(0);
    }
}
