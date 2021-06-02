package com.gildedrose;

import java.util.stream.Stream;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items)
                .map(DegradableItem::create)
                .forEach(DegradableItem::degrade);
    }
}
