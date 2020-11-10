package local.design.factory.composite;

import java.util.List;

public class AbstractFactory implements CompositeFactory {

    protected List<Producer> producerList;

    private static final Producer INVALID_PRODUCER = new Producer() {
        @Override
        public Product produce() {
            return null;
        }

        @Override
        public ProductType supportProductType() {
            return null;
        }
    };

    @Override
    public void addProducer(Producer producer) {
        producerList.add(producer);
    }

    @Override
    public Product makeProduct(ProductType productType) {
        return producerList.stream()
                .filter(p -> p.supportProductType() == productType)
                .findFirst()
                .orElse(INVALID_PRODUCER)
                .produce();
    }
}
