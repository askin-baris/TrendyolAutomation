package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        List<WebElement> element = Driver.getDriver().findElements(By.xpath("dadasda"));
        Set<String> strings = new HashSet<>();
        strings.add("Amazon");
        strings.add("Trendyol");
        strings.add("Trendyol");
        strings.add("Youtube");
        strings.add("Youtube");
        strings.add("Efe");
        strings.add("Efe");
        strings.add("ayşe");
        strings.add("can");



        for(String alisverissiteisimleri : strings){
            System.out.println(alisverissiteisimleri);
        }

    }

}
