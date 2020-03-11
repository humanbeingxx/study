package local.gof;

public enum EnumHolder implements SingletonWithEnum {

    /**
     * 用枚举方式的好处:
     * 无偿地提供了序列化机制，在面对复杂的序列化或者反射攻击时任然可以绝对防止多次实例化
     */
    SINGLETON {
        @Override
        public String getName() {
            return "only one";
        }
    };

    public static SingletonWithEnum getSingleton() {
        return SINGLETON;
    }
}
