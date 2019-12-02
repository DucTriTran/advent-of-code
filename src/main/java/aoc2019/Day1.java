package aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args) throws IOException {

        Stream<String> lineStream = Files.lines(Paths.get("src/main/java/aoc2019/day1input.txt"));
        List<Integer> fuels = lineStream.map(line -> getFuel(Integer.parseInt(line))).collect(Collectors.toList());
        int fuelSum = fuels.stream().mapToInt(Integer::intValue).sum();
        System.out.println(fuelSum);
    }

    public static int getFuel(int mass) {
        if (mass <= 0) {
            return 0;
        }
        int fuelLevel1 = mass / 3 - 2;
        if (fuelLevel1 <= 0) {
            return 0;
        }
        return fuelLevel1 + getFuel(fuelLevel1);
    }
}
