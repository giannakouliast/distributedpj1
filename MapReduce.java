import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapReduce {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double counted;

        List<Paragraph> paragraphs = new ArrayList<>();

        paragraphs.add(
                new Paragraph(Arrays.asList(
                        new Line("first test"),
                        new Line("map test"), new Line("test test"),
                        new Line("map reduce"))));

        paragraphs.add(new Paragraph(Arrays.asList(
                new Line("first test"), new Line("map test"),
                new Line("map reduce"))));

        counted = paragraphs.stream().filter(p ->
                p.contains("test"))
                .map(p -> p.count("test")).reduce(0,(sum, p) ->
                {return sum + p;});

        System.out.println(counted);}}