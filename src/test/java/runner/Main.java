package runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Set<String> strings = new HashSet<>();
        strings.add("Aamzon");
        strings.add("Trendyol");
        strings.add("Trendyol");
        strings.add("Youtube");
        strings.add("Youtube");
        strings.add("Efe");
        strings.add("ayşe");
        strings.add("can");


        for(String str : strings){
            System.out.println(str);
        }

    }

}
