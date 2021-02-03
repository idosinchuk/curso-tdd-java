package com.gildedrose;

public class Inventory {

    public static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item item;

    public Inventory(Item item) {
        this.item = item;
    }

    public void updateItem() {
        updateQuality();
        decreaseSellIn();
    }

    private void updateQualityWhenSellInOut() {
        if (isSellInOut()) {
            if (isAgedBrie(item)) increaseQuality(item);
            else if (isBlackstagePasses(item)) devaluateQuality(item);
            else decreaseQuality(item);
        }
    }

    private void updateQuality() {
        if (isAgedBrie(item)) increaseQuality(item);
        else if (isBlackstagePasses(item)) increaseBlackStageQuality(item);
        else decreaseQuality(item);
    }

    private void increaseBlackStageQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private boolean isSellInOut() {
        return item.sellIn < 0;
    }

    private void decreaseSellIn() {
        if (!isSulfuras()) {
            item.sellIn--;
            updateQualityWhenSellInOut();
        }
    }

    private boolean isSulfuras() {
        return item.name.equals(SULFURAS);
    }

    private void devaluateQuality(Item item) {
        item.quality = 0;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !isSulfuras()) {
            item.quality--;
        }
    }

    private boolean isBlackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

}
