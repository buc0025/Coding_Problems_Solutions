package Sorts;
/*Given 2 sorted arrays, merge them to form new sorted array
Ex.
arr1 = [1, 5, 6, 15, 21, 30]
arr2 = [6, 10, 20, 40]

new array = [1, 5, 6, 6, 10, 15, 20, 21, 30, 40]
*/
public class MergeSortedArrays {
    public static int[] combineArr1(int[] arr1, int[] arr2) {
        int[] combine = new int[arr1.length + arr2.length];
        int comboIn = 0;
        int index1 = 0;
        int index2 = 0;

        while (comboIn < combine.length) {
            if (index1 < arr1.length && index2 < arr2.length) {
                if (arr1[index1] < arr2[index2]) {
                    combine[comboIn] = arr1[index1];
                    comboIn++;
                    index1++;
                } else {
                    combine[comboIn] = arr2[index2];
                    comboIn++;
                    index2++;
                }
            } else if (index1 >= arr1.length) {
                combine[comboIn] = arr2[index2];
                index2++;
                comboIn++;
            } else {
                combine[comboIn] = arr1[index1];
                comboIn++;
                index1++;
            }
        }
        return combine;
    }

    public static int[] combineArr2(int[] arr1, int[] arr2) {
        int[] combine = new int[arr1.length + arr2.length];
        int comboIn = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                combine[comboIn] = arr1[index1];
                comboIn++;
                index1++;
            } else {
                combine[comboIn] = arr2[index2];
                comboIn++;
                index2++;
            }
        }
        while (index1 < arr1.length) {
            combine[comboIn] = arr1[index1];
            comboIn++;
            index1++;
        }
        while (index2 < arr2.length) {
            combine[comboIn] = arr2[index2];
            comboIn++;
            index2++;
        }
        return combine;
    }

    public static int[] combineArr3(int[] arr1, int[] arr2) {
        int[] combine = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < combine.length; i++) {
            if (index1 >= arr1.length) {
                combine[i] = arr2[index2];
                index2++;
            }
            else if (index2 >= arr2.length) {
                combine[i] = arr1[index1];
                index1++;
            }
            else if (arr1[index1] < arr2[index2]) {
                combine[i] = arr1[index1];
                index1++;
            } else {
                combine[i] = arr2[index2];
                index2++;
            }
        }
        return combine;
    }
}
