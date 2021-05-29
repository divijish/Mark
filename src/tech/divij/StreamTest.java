package tech.divij;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StreamTest {
    public static void main(String ...args){


        List<Long> numList = new ArrayList<>();

        for(int i = 0; i<9000000; i++){
            numList.add(new Random().nextLong());
        }

        long start = System.currentTimeMillis();
        long primitivesum = 0L;

        for(long i: numList){
            primitivesum += i;
        }


        long end = System.currentTimeMillis();

        long totalTimetaken = end-start;
        System.out.println("nonstream time "+totalTimetaken+": sum "+primitivesum);
        Long newsum = 0L;
        start = System.currentTimeMillis();

        newsum=numList.stream().reduce(0L, (x , y) -> x+y);

        end = System.currentTimeMillis();
        totalTimetaken = end-start;
        System.out.println("stream time "+totalTimetaken+": sum "+newsum);



    }
}
