import java.util.ArrayList;

public class Seminar01_Exceptions {
    public void a(){
        int x = 3/0;
    }

    public void b(){
        int[] arr = {0, 1, 2};
        int x = arr[3];
    }

    public void c(ArrayList<Integer> arr){
        int x = arr.get(0);
    }

    public int[] arraysDiff(int[] a, int[] b) throws Exception {
        if (a.length != b.length)
            throw new Exception("Длины массивов не равны");
        int[] res = a.clone();
        for (int i = 0; i < res.length; i++) {
            res[i] = a[i] - b[i];
        }
        return res;
    }

    public int[] arraysDivision(int[] a, int[] b) throws Exception {
        if (a.length != b.length)
            throw new RuntimeException("Длины массивов не равны");
        int[] res = a.clone();
        for (int i = 0; i < res.length; i++) {
            if (b[i] == 0) throw new RuntimeException(String.format("Попытка деления на ноль! a[%d]: %d, b[%d]: %d", i, a[i], i, b[i]));
            res[i] = a[i] / b[i];
        }
        return res;
    }
}
