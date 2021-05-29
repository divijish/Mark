package tech.divij;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StreamTest {
    public static void main(String ...args) throws IOException {


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

        long totalTimetaken;
        totalTimetaken = end-start;
        insertInFile("nonstream time "+totalTimetaken+": sum "+primitivesum+"\n");
        Long newSum;// = 0L;
        start = System.currentTimeMillis();

        newSum=numList.stream().reduce(0L, Long::sum);

        end = System.currentTimeMillis();
        totalTimetaken = end-start;
        insertInFile("stream time "+totalTimetaken+": sum "+newSum+"\n");

    }

    public static void insertInFile(String str) throws IOException {
        File file = new File("log-file.txt");
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str);

        bw.close();
        fw.close();
    }
}
