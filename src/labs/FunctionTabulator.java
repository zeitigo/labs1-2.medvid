package labs.medvid;

/**
 * This class performs tabulation of a piecewise mathematical function.
 * It generates arrays of argument values (x) and corresponding function values (y),
 * finds the maximum and minimum elements, and computes the sum and average of y-values.
 */
public class FunctionTabulator {

    /** Array of argument values. */
    private double[] xValues;

    /** Array of function values. */
    private double[] yValues;

    /** Constant parameter a used in the function definition. */
    private final double a = 2.3;

    /**
     * Computes the value of the piecewise-defined function for a given x.
     *
     * @param x input argument
     * @return computed value of the function y(x)
     */
    public double computeFunction(double x) {

        if (x <= 0.3) {
            return 1.5 * a * Math.pow(Math.cos(x), 2);

        } else if (x <= 2.3) {
            return Math.pow(x - 2, 2) + 6 * a;

        } else {
            return 3 * a * Math.tan(x);
        }
    }

    /**
     * Calculates the number of steps required for tabulation.
     *
     * @param start beginning of interval
     * @param end end of interval
     * @param step increment value
     * @return number of tabulation points
     */
    public int computeSteps(double start, double end, double step) {
        return (int) Math.floor((end - start) / step) + 1;
    }

    /**
     * Generates arrays of x- and y-values for the specified interval and step.
     *
     * @param start beginning of interval
     * @param end end of interval
     * @param step increment value
     */
    public void generateArrays(double start, double end, double step) {

        int n = computeSteps(start, end, step);

        xValues = new double[n];
        yValues = new double[n];

        double x = start;

        for (int i = 0; i < n; i++) {
            xValues[i] = x;
            yValues[i] = computeFunction(x);
            x += step;
        }
    }

    /**
     * Returns an element of the x-array by index.
     *
     * @param index position of element
     * @return x[index]
     */
    public double getX(int index) {
        return xValues[index];
    }

    /**
     * Returns an element of the y-array by index.
     *
     * @param index position of element
     * @return y[index]
     */
    public double getY(int index) {
        return yValues[index];
    }

    /**
     * Finds the index of the maximum element in y-array.
     *
     * @return index of maximum y-value
     */
    public int indexOfMax() {
        int index = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] > yValues[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the index of the minimum element in y-array.
     *
     * @return index of minimum y-value
     */
    public int indexOfMin() {
        int index = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] < yValues[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Computes the sum of all y-values.
     *
     * @return sum of elements in y-array
     */
    public double sum() {
        double s = 0;
        for (double y : yValues) s += y;
        return s;
    }

    /**
     * Computes the average value of the y-array.
     *
     * @return average of y-values
     */
    public double average() {
        return sum() / yValues.length;
    }

    /**
     * Program entry point. Runs tabulation and prints results.
     *
     * @param args program arguments
     */
    public static void main(String[] args) {

        FunctionTabulator tab = new FunctionTabulator();

        double start = 0.2;
        double end = 2.8;
        double step = 0.002;

        tab.generateArrays(start, end, step);

        int maxIndex = tab.indexOfMax();
        int minIndex = tab.indexOfMin();

        System.out.println("===== РЕЗУЛЬТАТИ ТАБУЛЮВАННЯ =====");

        System.out.println("\nНайбільший елемент масиву:");
        System.out.println("Номер = " + maxIndex +
                ", x = " + tab.getX(maxIndex) +
                ", y = " + tab.getY(maxIndex));

        System.out.println("\nНайменший елемент масиву:");
        System.out.println("Номер = " + minIndex +
                ", x = " + tab.getX(minIndex) +
                ", y = " + tab.getY(minIndex));

        System.out.println("\nСума всіх значень y: " + tab.sum());
        System.out.println("Середнє значення y: " + tab.average());
    }
}
