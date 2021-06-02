package com.gildedrose;

class AgedBrie implements DegradableItem {

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void degrade() {
        item.sellIn = item.sellIn - 1;
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
