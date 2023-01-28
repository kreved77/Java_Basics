package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

/*
https://www.codewars.com/kata/550f22f4d758534c1100025a
*/
public class DirectionsReduction {


// VER_2
    public static String[] dirReduc(String[] arr) {

        List<String> slist = new ArrayList(Arrays.asList(arr));
        int flagChanges;

        do {
            flagChanges = 0;
            for (int i = 0; i < slist.size()-1; i++){
                if (       ((slist.get(i) == "NORTH") && (slist.get(i+1) == "SOUTH"))
                        || ((slist.get(i) == "SOUTH") && (slist.get(i+1) == "NORTH"))
                        || ((slist.get(i) == "EAST") && (slist.get(i+1) == "WEST"))
                        || ((slist.get(i) == "WEST") && (slist.get(i+1) == "EAST"))
                ) {
                    slist.remove(i);
                    slist.remove(i--);
                    flagChanges++;
                }
            }
        } while (flagChanges > 0);

        return slist.toArray(new String[0]);
    }


// VER_2_initial
//    public static String[] dirReduc(String[] arr) {
//
//        List<String> slist = new ArrayList(Arrays.asList(arr));
//        int flagChanges;
//
//        do {
//            flagChanges = 0;
//            for (int i = 0; i < slist.size()-1; i++){
//                //                           System.out.println("slist.size()=" + slist.size() + " slist=" + slist);
//                //                           System.out.println("i:" + i + " | s=" + s);
//
//                switch (slist.get(i)){
//                    case ("NORTH"):
//                        if (slist.get(i+1) == "SOUTH") {
//                            slist.remove(i);
//                            slist.remove(i--);
//                            flagChanges++;
//                        }
//                        break;
//                    case ("SOUTH"):
//                        if (slist.get(i+1) == "NORTH") {
//                            slist.remove(i);
//                            slist.remove(i--);
//                            flagChanges++;
//                        }
//                        break;
//
//                    case ("EAST"):
//                        if (slist.get(i+1) == "WEST") {
//                            slist.remove(i);
//                            slist.remove(i--);
//                            flagChanges++;
//                        }
//                        break;
//
//                    case ("WEST"):
//                        if (slist.get(i+1) == "EAST") {
//                            slist.remove(i);
//                            slist.remove(i--);
//                            flagChanges++;
//                        }
//                        break;
//                }
//            }
//        } while (flagChanges > 0);
//
//        String[] result = slist.toArray(new String[0]);
//        return result;
//    }


// VER_1 - don't pass the task details for sequential order of opposite sides in the path.
        // ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. BUT This version returns -> []
//    public static String[] dirReduc(String[] arr) {
//
//        List<String> slist = new ArrayList(Arrays.asList(arr));
//        int count = arr.length;
//
//        for (String s : arr){
//                System.out.println("slist=" + slist);
//                System.out.println("s=" + s);
//            switch (s){
//                case ("NORTH"):
//                case ("SOUTH"):
//                    if ((slist.indexOf("SOUTH") != -1)&& (slist.indexOf("NORTH") != -1)) {
//                        slist.remove(slist.indexOf("NORTH"));
//                        slist.remove(slist.indexOf("SOUTH"));
//                        count = count-2;
//                    }
//                    break;
//
//                case ("EAST"):
//                case ("WEST"):
//                    if ((slist.indexOf("WEST") != -1) && (slist.indexOf("EAST") != -1)) {
//                        slist.remove(slist.indexOf("WEST"));
//                        slist.remove(slist.indexOf("EAST"));
//                        count = count-2;
//                    }
//                    break;
//            }
//        }
//
//        String[] result = new String[slist.size()];
//        for (int i = 0; i < slist.size(); i++)
//            result[i] = slist.get(i);
//
//        return result;
//    }



// Test DATA
    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\",\"NORTH\"",
                new String[]{"NORTH"},
                dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH","NORTH"}));
        assertArrayEquals("\"EAST\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\", \"EAST\", \"EAST\", \"SOUTH\", \"NORTH\", \"WEST\"",
                new String[]{"EAST", "NORTH"},
                dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\", \"EAST\", \"NORTH\", \"EAST\", \"WEST\", \"WEST\", \"EAST\", \"EAST\", \"WEST\", \"SOUTH\"",
                new String[]{"NORTH", "EAST"},
                dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"}));
        assertArrayEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
        assertArrayEquals("\"EAST\", \"WEST\", \"WEST\", \"WEST\"",
                new String[]{"WEST", "WEST"},
                dirReduc(new String[]{"EAST", "WEST", "WEST", "WEST"}));
    }

    String[] randDir(int n) {
        String[] dirs = new String[]{"NORTH", "SOUTH", "EAST", "WEST"};
        String[] result = new String[n];
        for (int i = 0; i < n; ++i) {
            result[i] = dirs[(int) (Math.random() * 4)];
        }
        return result;
    }

    public String[] doDirReduc(String[] arr) {
        if (arr == null) return new String[] {};
        if (arr.length < 2) return arr;
        int i = 0;
        List<String> directions = Arrays.stream(arr).collect(Collectors.toList());
        do {
            String tmp = directions.get(i) + directions.get(i + 1);
            if (tmp.equals("NORTHSOUTH") || tmp.equals("SOUTHNORTH") || tmp.equals("EASTWEST") || tmp.equals("WESTEAST")) {
                directions.remove(i + 1);
                directions.remove(i);
                if (i > 0) i--;
            } else
                i++;
        } while (i < directions.size() - 1);
        return directions.stream().toArray(String[]::new);
    }

    @Test
    public void testRandomDirReduc() throws Exception {
        String[] u10 = randDir(10);
        assertArrayEquals("random 10 directions", doDirReduc(u10), dirReduc(u10));
        String[] u15 = randDir(15);
        assertArrayEquals("random 15 directions", doDirReduc(u15), dirReduc(u15));
        String[] u30 = randDir(30);
        assertArrayEquals("random 30 directions", doDirReduc(u30), dirReduc(u30));
    }
}
