package main;

public class Cafe {
    private int beansInStock = 0;
    private int milkInStock = 0;

    public Coffee brew (CoffeeType coffetype) { return brew(coffetype, 1);}

    public Coffee brew(CoffeeType coffeeType, int quantity) {
        requirePositive(quantity);

        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
            throw  new IllegalStateException("Insufficient beans or milk");
        }
        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;
        return new Coffee(coffeeType, requiredBeans, requiredMilk);
    }

    public void restockBeans (int weightInGrams) {
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        milkInStock +=weightInGrams;

    }

    public void requirePositive(int value) {
        if(value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInStock() {
        return beansInStock;
    }

    public int getMilkInStock() {
        return milkInStock;
    }
}
