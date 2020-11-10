package local.design.factory.composite;

public class MicrosoftFactory extends AbstractFactory {

    private static Producer microsoftPhoneProducer = new Producer() {
        @Override
        public Product produce() {
            return (Phone) () -> "MS phone calling";
        }

        @Override
        public ProductType supportProductType() {
            return ProductType.PHONE;
        }
    };

    private static Producer microsoftPCProducer = new Producer() {
        @Override
        public Product produce() {
            return (PC) () -> "MS PC computing";
        }

        @Override
        public ProductType supportProductType() {
            return ProductType.PC;
        }
    };

    public MicrosoftFactory() {
        addProducer(microsoftPhoneProducer);
        addProducer(microsoftPCProducer);
    }
}
