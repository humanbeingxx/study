package local.interview_internal_reference.bytecode;

public class MissNum {

    public int findMissNum() {
        byte[] bitmap = new byte[1 << 29];
        int num = 1, index = 0;
        while (num != 0xFFFFFFFF) {
            for (int i = 0; i < 8 && num != 0xFFFFFFFF; i++) {
                if (num == Integer.MIN_VALUE + 1000) {
                    num++;
                    continue;
                }
                int mod = num & 0b111;
                if (mod == 0) {
                    bitmap[index] |= (1 << 7);
                } else {
                    bitmap[index] |= (1 << (mod - 1));
                }
                num++;
            }
            index++;
        }
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitmap[i] & (1 << j)) == 0) {
                    System.out.println(i);
                    return i * 8 + j + 1;
                }
            }
        }
        throw new IllegalStateException();
    }
}
