public static int birthdayCakeCandles(List<Integer> candles) {
    int max = 0;
    int count = 0;

    for (int num : candles) {
        if (num > max) {
            max = num;
            count = 1;
        } else if (num == max) {
            count++;
        }
    }
    return count;
}
