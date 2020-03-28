package Module;

public class logics {

    private int n=0,m=0;
    private String Message=" ";
    private   int Arr[][];

    public void setN(String a) {
      int  c = Integer.parseInt(a);
      this.n = c;
    }
    public void setM(String a) {
       int c = Integer.parseInt(a);
        this.m = c;
    }
        public boolean getcheck(String a) {
            try {
                int d = Integer.parseInt(a);
            } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
            return true;
        }

    public String getMessage() {
        return Message;
    }
    protected  void removeDuplicates(int[] values) {
        boolean mask[] = new boolean[values.length];
        int removeCount = 0;
        for (int i = 0; i < values.length; i++) {
            if (!mask[i]) {
                int tmp = values[i];
                for (int j = i + 1; j < values.length; j++) {
                    if (tmp == values[j]) {
                        mask[j] = true;
                        removeCount++;
                    }
                }
            }
        }
        int[] result = new int[values.length - removeCount];
        for (int i = 0, j = 0; i < values.length; i++) {
            if (!mask[i]) {
                result[j++] = values[i];
            }
        }
       for(int i=0;i<result.length;i++){
           Message +=result[i]+",";
       }
        Message+="}";
    }
    public  void TranslationArray (String a) {
        Arr= new int[n][m];
        String str = a;
        String strArr[] = str.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        if (n * m >= strArr.length) {
            int ArrayArr = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ArrayArr < numArr.length) {
                        Arr[i][j] = numArr[ArrayArr];
                        ArrayArr++;
                    }else
                        Arr[i][j] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Message+=(Arr[i][j]+" ");
                }
                Message+=("\n");
            }
            Message+="Результат:R \\ {";
            removeDuplicates(numArr);
        }
    }
}