package com.gildedrose;

class RegularItem implements DegradableItem {

    private final Item item;

    public RegularItem(Item item) {
        this.item = item;
    }

    @Override
    public void degrade() {
        item.sellIn = item.sellIn - 1;
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
