package local.design.factory.composite;

public interface CompositeFactory {

    void addProducer(Producer producer);

    Product makeProduct(ProductType productType);
}
