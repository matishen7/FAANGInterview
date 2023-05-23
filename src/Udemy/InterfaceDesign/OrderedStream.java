package Udemy.InterfaceDesign;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream implements IOrderedStream {
    private String[] streams;
    int prt = 0;

    public OrderedStream(int n) {
        streams = new String[n];
    }

    @Override
    public List<String> insert(int idKey, String value) {
        if (idKey >= 1 && idKey <= streams.length)
            streams[idKey - 1] = value;
        List<String> result = new ArrayList<>();
        for (int i = prt; i < streams.length; i++) {
            String s = streams[i];
            if (s == null)
                break;
            result.add(s);
            prt++;
        }
        return result;
    }
}
