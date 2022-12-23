package CodewarsCom;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/53dbd5315a3c69eed20002dd
*/

public class ListFiltering {

    public static void main(String[] args) {
        System.out.println("v_1");
        System.out.println(filterList(List.of(1, 2, "a", "b")));
        System.out.println(filterList(List.of(1, "a", "b", 0, 15)));
        System.out.println(filterList(List.of(1, 2, "aasf", "1", "123", 123)));
        System.out.println("v_2");
        System.out.println(filterList2(List.of(1, 2, "a", "b")));
        System.out.println(filterList2(List.of(1, "a", "b", 0, 15)));
        System.out.println(filterList2(List.of(1, 2, "aasf", "1", "123", 123)));
    }

    public static List<Object> filterList(final List<Object> list) {
        // Return the List with the Strings filtered out
        List<Object> newlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Integer) {
                Integer number = (Integer) list.get(i);
                newlist.add(number);
            }
        }
        return newlist;
    }

    public static List<Object> filterList2(final List<Object> list) {
        // Return the List with the Strings filtered out
         List<Object> newlist = list.stream()
//                .filter(e -> e.getClass().getName().equals(Integer.class.getName()))
//                .toList();
                .filter(e -> e instanceof Integer)
                .collect(Collectors.toList());
        return newlist;
    }
}
