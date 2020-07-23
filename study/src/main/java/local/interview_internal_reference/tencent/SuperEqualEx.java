package local.interview_internal_reference.tencent;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/9 0:42
 */
public class SuperEqualEx extends SuperEqual {

    private int valEx;

    public static void main(String[] args) {
        SuperEqualEx ex1 = new SuperEqualEx();
        SuperEqualEx ex2 = new SuperEqualEx();
        SuperEqualEx ex3 = new SuperEqualEx();
        ex1.valEx = 1;
        ex2.valEx = 2;
        ex3.valEx = 2;
        System.out.println(ex1.equals(ex2));
        System.out.println(ex3.equals(ex2));
    }
}
