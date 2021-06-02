package com.gildedrose;

public class Conjured implements DegradableItem {

    private final Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void degrade() {
        item.sellIn = item.sellIn - 1;
        item.quality = Math.max(0, item.quality - 2);
    }
}
