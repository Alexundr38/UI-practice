package store.Citilink.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AddProcessorToConfiguratorTest.class,
        AddProductToBasketTest.class,
        AddProductToCompareTest.class,
        AddProductToWishListTest.class,
        AddStoreTest.class,
        ChangeProfileNameTest.class,
        RemoveBasketProductTest.class,
        RemoveCompareProductTest.class,
        RemoveWishlistProductTest.class,
        UsingPriceFiltersTest.class
})
public class AllTests {
}