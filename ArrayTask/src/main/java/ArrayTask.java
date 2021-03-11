public class ArrayTask {
    //У вас есть массив с целыми числами, в том числе и отрицательными,
    // вам нужно найти самое большое произведение 3 чисел из этого массива.

    //Например: у вас есть массив list_of_ints, содержащий числа -10, -10, 1, 3, 2.
    // Функция, которая обрабатывает этот массив, должна вернуть 300, так как -10  -10  3 = 300.
    // Задание нужно выполнить максимально эффективно, не забывая учесть отрицательные числа.


    public int maxMultiplicationInArray(int[] array)
    {
        checkSizeOfArray(array);

        int max = Math.max(array[0], array[1]);
        int min =  Math.min(array[0], array[1]);
        int maxOf2 = array[0] * array[1];
        int minOf2  = array[0] * array[1];
        int maxOf3 = array[0] * array[1] * array[2];

        for(int i = 2; i < array.length; i++) {
            maxOf3 = getMaxOfThreeValues(maxOf3, array[i] * maxOf2, array[i] * minOf2);

            maxOf2 = getMaxOfThreeValues(maxOf2, array[i] * max, array[i] * min);

            minOf2 = getMinOfThreeValues(minOf2, array[i] * max, array[i] * min);

            max = Math.max(max, array[i]);

            min = Math.min(min, array[i]);
        }

        return maxOf3;
    }

    private void checkSizeOfArray(int[] array) {
        if (array.length < 3)
        {
            throw new NegativeArraySizeException("Wrong size of array. 3 numbers are expected at minimum.");
        }
    }

    private int getMaxOfThreeValues(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int getMinOfThreeValues(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
