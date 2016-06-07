package com.company;

/**
 * Created by yges on 2/15/2016.
 */
public class Layer
{
    double[] input;
    double[] node;
    double[][] weight;
    double[][] phi;
    boolean first = false;
    boolean last = false;
    int nodes;
    Layer next;

    void clean()
    {
        for(int i = 0; i < nodes; i++)
        {
            input[i] = 0;
            if (!last)
                node[i] = 0;
        }
        if (!last)
            next.clean();
    }

    void act()
    {
        if (last)
            return;
        if (!first)
            activate();
        next.fillInput(node, weight);
        if (!next.last)
            next.computePhi();
        next.act();
    }

    private void activate()
    {
        for(int i = 0; i < input.length; i++)
        {
            node[i] = sigmoid(input[i]);
        }
    }

    private void fillInput(double[] prevLayer, double[][] prevWeight)
    {
        assert input.length == prevWeight[0].length;
        for(int j = 0; j < input.length; j++)
        {
            assert prevLayer.length == prevWeight.length;
            assert input[j] == 0;
            for (int i = 0; i < prevLayer.length; i++)
            {
                input[j] += prevLayer[i] * prevWeight[i][j];
            }
        }
    }

    private void computePhi()
    {
        for(int i = 0; i < nodes; i++)
        {
            for(int j = 0; j < next.nodes; j++)
            {
                phi[i][j] = weight[i][j] * sigmoidPrime(node[i]);
            }
        }
    }

    private double sigmoid(double x)
    {
        return 1 / (1 + Math.pow(2.718281828, -x));
    }

    private double sigmoidPrime(double x)
    {
        return sigmoid(x) * sigmoid(-x);
    }

    Layer(int size)
    {
        nodes = size;
    }

    void addNextLayer(Layer nextLayer)
    {
        input = new double[nodes];
        node = new double[nodes];
        next = nextLayer;
        weight = new double[nodes][next.nodes];
        phi = new double[nodes][next.nodes];
    }

    void consoleLastLayer()
    {
        assert last = true;
        input = new double[nodes];
    }

    void randomize(double min, double max)
    {
        for(int j = 0; j < next.nodes; j++)
        {
            for(int i = 0; i < nodes; i++)
            {
                weight[i][j] = (Math.random() * (max - min)) + min;
            }
        }
    }
}
