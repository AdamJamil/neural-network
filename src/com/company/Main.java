package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main
{
    //for efficiency, the neuralnetwork has been formatted to run optimally with only one output
    //as of now, multiple output backprop has not been fully implemented
    public static void main(String[] args)
    {
        double[] time = new double[1000];
        int niceTimes = 0;
        int[] niceSeed = new int[1000];
        double[] niceTime;
        int greatTimes = 0;
        int[] greatSeed = new int[1000];
        double[] greatTime;
        int excellentTimes = 0;
        int[] excellentSeed = new int[1000];
        double[] excellentTime;
        int perfectTimes = 0;
        int[] perfectSeed = new int[1000];
        double[] perfectTime;

        for(int i = 0; i < 1000; i++)
        {
            long start = System.currentTimeMillis();
            Trainer kimJongIl = new Trainer(2, 1, 2, new int[]{100, 100, 10, 10, 2}, new double[][]{{2, 3}, {4, 5}, {4, 2}}, new double[][]{{6}, {20}, {8}});
            kimJongIl.setSeed(i);
            kimJongIl.teachMult(2, start);
            time[i] = (double) (System.currentTimeMillis() - start) / 1000;
            if (time[i] < 0.8)
            {
                niceSeed[niceTimes] = i;
                niceTimes++;
            }
        }

        niceTime = new double[niceTimes];
        System.out.println("There were " + niceTimes + " nice times.");
        System.out.println("Nice seeds: " + Arrays.toString(niceSeed));

        double totalTime = 0;

        for(int i = 0; i < niceTimes; i++)
        {
            long start = System.currentTimeMillis();
            Trainer kimJongIl = new Trainer(2, 1, 2, new int[]{100, 100, 10, 10, 2}, new double[][]{{2, 3}, {4, 5}, {4, 2}}, new double[][]{{6}, {20}, {8}});
            kimJongIl.setSeed(niceSeed[i]);
            kimJongIl.teachMult(3, start);
            niceTime[i] = (double) (System.currentTimeMillis() - start) / 1000;
            totalTime += niceTime[i];
        }

        for(int i = 0; i < niceTimes; i++)
        {
            if (niceTime[i] < totalTime / niceTimes)
            {
                greatSeed[greatTimes] = niceSeed[i];
                greatTimes++;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("There were " + greatTimes + " great times.");
        System.out.println("Great seeds: " + Arrays.toString(greatSeed));

        greatTime = new double[greatTimes];
        totalTime = 0;

        for(int i = 0; i < greatTimes; i++)
        {
            long start = System.currentTimeMillis();
            Trainer kimJongIl = new Trainer(2, 1, 2, new int[]{100, 100, 10, 10, 2}, new double[][]{{2, 3}, {4, 5}, {4, 2}}, new double[][]{{6}, {20}, {8}});
            kimJongIl.setSeed(greatSeed[i]);
            kimJongIl.teachMult(4, start);
            greatTime[i] = (double) (System.currentTimeMillis() - start) / 1000;
            totalTime += greatTime[i];
        }

        System.out.println("Great times: " + Arrays.toString(greatTime));

        for(int i = 0; i < greatTimes; i++)
        {
            if (greatTime[i] < totalTime / greatTimes)
            {
                excellentSeed[excellentTimes] = greatSeed[i];
                excellentTimes++;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("There were " + excellentTimes + " excellent times.");
        System.out.println("Excellent seeds: " + Arrays.toString(excellentSeed));

        excellentTime = new double[excellentTimes];
        totalTime = 0;

        for(int i = 0; i < excellentTimes; i++)
        {
            long start = System.currentTimeMillis();
            Trainer kimJongIl = new Trainer(2, 1, 2, new int[]{100, 100, 10, 10, 2}, new double[][]{{2, 3}, {4, 5}, {4, 2}}, new double[][]{{6}, {20}, {8}});
            kimJongIl.setSeed(excellentSeed[i]);
            kimJongIl.teachMult(5, start);
            excellentTime[i] = (double) (System.currentTimeMillis() - start) / 1000;
            totalTime += excellentTime[i];
        }

        System.out.println("Excellent times: " + Arrays.toString(excellentTime));

        for(int i = 0; i < excellentTimes; i++)
        {
            if (excellentTime[i] < totalTime / excellentTimes)
            {
                perfectSeed[perfectTimes] = excellentSeed[i];
                perfectTimes++;
            }
        }

        System.out.println("There were " + perfectTimes + " perfect times.");
        System.out.println("Perfect seeds: " + Arrays.toString(perfectSeed));

    }
}