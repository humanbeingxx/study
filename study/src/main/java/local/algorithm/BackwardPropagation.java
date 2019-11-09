package local.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author cuixiaoshuang
 * @date 2019-10-23
 **/
public class BackwardPropagation {

    static class Structure {
        final BigDecimal in1 = new BigDecimal("0.05");
        final BigDecimal in2 = new BigDecimal("0.1");

        final BigDecimal ex_out1 = new BigDecimal("0.01");
        final BigDecimal ex_out2 = new BigDecimal("0.99");

        BigDecimal w1 = new BigDecimal("0.15");
        BigDecimal w2 = new BigDecimal("0.2");
        BigDecimal w3 = new BigDecimal("0.25");
        BigDecimal w4 = new BigDecimal("0.3");
        BigDecimal w5 = new BigDecimal("0.4");
        BigDecimal w6 = new BigDecimal("0.45");
        BigDecimal w7 = new BigDecimal("0.5");
        BigDecimal w8 = new BigDecimal("0.55");

        final BigDecimal b1 = new BigDecimal("0.35");
        final BigDecimal b2 = new BigDecimal("0.6");

        BigDecimal relu(BigDecimal x) {
            return x.compareTo(BigDecimal.ZERO) > 0 ? x : BigDecimal.ZERO;
        }

        BigDecimal deRelu(BigDecimal x) {
            if (x.compareTo(BigDecimal.ZERO) > 0) {
                return BigDecimal.ONE;
            }
            if (x.compareTo(BigDecimal.ZERO) < 0) {
                return BigDecimal.ZERO;
            }
            return new BigDecimal("0.5");
        }

        BigDecimal net_h1() {
            return w1.multiply(in1).setScale(8, RoundingMode.FLOOR).add(w2.multiply(in2)).add(b1);
        }

        BigDecimal out_h1() {
            return relu(net_h1());
        }

        BigDecimal net_h2() {
            return w3.multiply(in1).setScale(8, RoundingMode.FLOOR).add(w4.multiply(in2)).add(b1);
        }

        BigDecimal out_h2() {
            return relu(net_h2());
        }

        BigDecimal net_o1() {
            return w5.multiply(out_h1()).setScale(8, RoundingMode.FLOOR).add(w6.multiply(out_h2())).add(b2);
        }

        BigDecimal net_o2() {
            return w7.multiply(out_h1()).setScale(8, RoundingMode.FLOOR).add(w8.multiply(out_h2())).add(b2);
        }

        BigDecimal out_o1() {
            return relu(net_o1());
        }

        BigDecimal out_o2() {
            return relu(net_o2());
        }

        BigDecimal exception_o1() {
            return ex_out1.subtract(out_o1()).abs().divide(new BigDecimal("2"), 8, RoundingMode.FLOOR);
        }

        BigDecimal exception_o2() {
            return ex_out2.subtract(out_o2()).abs().divide(new BigDecimal("2"), 8, RoundingMode.FLOOR);
        }

        BigDecimal totalException() {
            return exception_o1().add(exception_o2());
        }

        BigDecimal partialDe_w5() {
            return (out_o1().subtract(ex_out1)).multiply(deRelu(net_o1())).multiply(out_h1()).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w6() {
            return (out_o1().subtract(ex_out1)).multiply(deRelu(net_o1())).multiply(out_h2()).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w7() {
            return (out_o2().subtract(ex_out2)).multiply(deRelu(net_o2())).multiply(out_h1()).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w8() {
            return (out_o2().subtract(ex_out2)).multiply(deRelu(net_o2())).multiply(out_h2()).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w1() {
            return deRelu(net_h1()).multiply(in1).multiply(
                    ((out_o1().subtract(ex_out1)).multiply(w5).multiply(deRelu(net_o1())))
                            .add(out_o2().subtract(ex_out2).multiply(w7).multiply(deRelu(net_o2())))
            ).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w2() {
            return deRelu(net_h1()).multiply(in2).multiply(
                    ((out_o1().subtract(ex_out1)).multiply(w5).multiply(deRelu(net_o1())))
                            .add(out_o2().subtract(ex_out2).multiply(w7).multiply(deRelu(net_o2())))
            ).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w3() {
            return deRelu(net_h2()).multiply(in1).multiply(
                    ((out_o1().subtract(ex_out1)).multiply(w6).multiply(deRelu(net_o1())))
                            .add(out_o2().subtract(ex_out2).multiply(w8).multiply(deRelu(net_o2())))
            ).setScale(8, RoundingMode.FLOOR);
        }

        BigDecimal partialDe_w4() {
            return deRelu(net_h2()).multiply(in2).multiply(
                    ((out_o1().subtract(ex_out1)).multiply(w6).multiply(deRelu(net_o1())))
                            .add(out_o2().subtract(ex_out2).multiply(w8).multiply(deRelu(net_o2())))
            ).setScale(8, RoundingMode.FLOOR);
        }

        public void fix_round() {
            w1 = w1.subtract(partialDe_w1().multiply(new BigDecimal("0.5")));
            w2 = w2.subtract(partialDe_w2().multiply(new BigDecimal("0.5")));
            w3 = w3.subtract(partialDe_w3().multiply(new BigDecimal("0.5")));
            w4 = w4.subtract(partialDe_w4().multiply(new BigDecimal("0.5")));
            w5 = w5.subtract(partialDe_w5().multiply(new BigDecimal("0.5")));
            w6 = w6.subtract(partialDe_w6().multiply(new BigDecimal("0.5")));
            w7 = w7.subtract(partialDe_w7().multiply(new BigDecimal("0.5")));
            w8 = w8.subtract(partialDe_w8().multiply(new BigDecimal("0.5")));
        }
    }
}
