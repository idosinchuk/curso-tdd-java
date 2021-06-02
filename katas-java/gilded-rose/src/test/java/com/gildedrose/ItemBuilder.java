package com.gildedrose;

public class ItemBuilder {
    private final String name;
    private int sellIn;
    private int quality;

    private ItemBuilder(String name) {
        this.name = name;
        this.sellIn = 10;
        this.quality = 10;
    }

    public static ItemBuilder aRegularItem() {
        return new ItemBuilder("Regular");
    }

    public static ItemBuilder agedBrie() {
        return new ItemBuilder("Aged Brie");
    }

    public static ItemBuilder backstagePasses() {
        return new ItemBuilder("Backstage passes to a TAFKAL80ETC concert");
    }

    public static ItemBuilder conjured() {
        return new ItemBuilder("Conjured");
    }

    public static ItemBuilder sulfuras() {
        return new ItemBuilder("Sulfuras, Hand of Ragnaros");
    }

    public ItemBuilder withSellIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    public ItemBuilder withQuality(int quality) {
        this.quality = quality;
        return this;
    }

    public Item build() {
        return new Item(name, sellIn, quality);
    }
}
