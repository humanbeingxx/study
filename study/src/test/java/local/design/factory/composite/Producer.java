package local.design.factory.composite;

public interface Producer {

    Product produce();

    ProductType supportProductType();
}
