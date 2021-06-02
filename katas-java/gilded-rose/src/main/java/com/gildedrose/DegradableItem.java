package com.gildedrose;

public interface DegradableItem {

    static DegradableItem create(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePasses(item);
            case "Aged Brie":
                return new AgedBrie(item);
            case "Conjured":
                return new Conjured(item);
            default:
                return new RegularItem(item);
        }
    }

    void degrade();
}
