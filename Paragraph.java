import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paragraph {

    List<Line> lines;


    public Paragraph(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }


    public int count(String text){
        int count=0;
        for (Line line : lines) {

            count+=line.count(text);
        }
        return count;
    }

    public boolean contains(String test) {
        Stream<Line> result=   lines.parallelStream()
                .filter(p -> p.getLine().contains(test));
        lines = result.collect(Collectors.toList());

        if (lines.size()>0)
            return true;
        else
            return false;
    }
}