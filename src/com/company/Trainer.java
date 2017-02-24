package com.company;

public class Trainer
{
    NeuralNetwork nn;
    double[][] question;
    double[][] answer;
    double errBound = 0.45;

    public Trainer(int inputs, int outputs, int layers, int[] nodes, double[][] question, double[][] answer)
    {
        nn = new NeuralNetwork(inputs, outputs, layers, nodes);
        nn.randomize(-10, 10);
        this.question = question;
        this.answer = answer;
    }

    long timeComputeErrorAndLearn()
    {
        long time = System.nanoTime();

    }

    boolean teachTillLearned(double[] question, double[] answer)
    {
        long start = System.nanoTime();
        for (int i = 0; true; i++)
        {
            nn.run(question);
            double relErr = answer[0] - nn.layer[nn.layer.length - 1].input[0];
            double err = Math.abs(relErr);
            if (err < errBound && err > -errBound)
                return i == 0;
            else
                nn.computeErrorAndLearn(relErr, 0);
        }
    }

    int teachTillLearned(double[] question, double[] answer, long start, boolean terminating)
    {
        for(int i = 0; true; i++)
        {
            //if (terminating && System.currentTimeMillis() - start > 15000)
            //    return -1;
            nn.run(question);
            double relErr = answer[0] - nn.layer[nn.layer.length - 1].input[0];
            double err = Math.abs(relErr);
            if (err < errBound && err > -errBound)
                return i;
            else
                nn.computeErrorAndLearn(relErr, i);
        }
    }

    void teachAllTillLearned()
    {
        boolean done = false;
        while (!done)
        {
            done = true;
            for (int i = 0; i < question.length; i++)
                done &= teachTillLearned(question[i], answer[i]);
        }
    }

    void setSeed(int seed)
    {
        nn.randomize(-10, 10, (long)seed);
    }
}