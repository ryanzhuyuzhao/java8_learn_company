package org.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S",shops));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    public static List<String> findPrices(String product, List<Shop> shops) {
        //普通流  耗时4133ms
        /*return shops.stream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());*/

        //并行流  耗时1111ms
        /*return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());*/

        //使用CompletableFuture  耗时2059ms
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " +
                                shop.getPrice(product)
                ))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
