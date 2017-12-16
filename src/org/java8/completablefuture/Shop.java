package org.java8.completablefuture;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 同步实现方式
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        //实现方式一
        /*CompletableFuture<Double> futurePrice = new CompletableFuture();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return  futurePrice;*/
        //实现方式二
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
