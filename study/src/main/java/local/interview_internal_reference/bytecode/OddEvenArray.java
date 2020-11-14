package local.interview_internal_reference.bytecode;

public class OddEvenArray {

    public void moveOddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int evenIndex = 0, oddIndex = 1;
        while (evenIndex < arr.length) {
            if (arr[evenIndex] % 2 == 0) {
                while (oddIndex < arr.length) {
                    if (arr[oddIndex] % 2 == 1) {
                        exchange(arr, evenIndex, oddIndex);
                        oddIndex += 2;
                        break;
                    }
                    oddIndex += 2;
                }
            }
            evenIndex += 2;
        }
    }

    private void exchange(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

}
