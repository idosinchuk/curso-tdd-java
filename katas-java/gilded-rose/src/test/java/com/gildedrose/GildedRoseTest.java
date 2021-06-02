package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class GildedRoseTest {

    @Test
    void regular_items_decrease_sell_in_after_each_day() {
        Item item = aRegularItem().withSellIn(5).build();

        updateQuality(item);

        assertThat(item.sellIn, is(4));
    }

    @Test
    void regular_items_sell_in_can_be_negative() {
        Item item = aRegularItem().withSellIn(0).build();

        updateQuality(item);

        assertThat(item.sellIn, is(-1));
    }

    @Test
    void regular_items_quality_decreases_by_one_after_each_day() {
        Item item = aRegularItem().withQuality(10).build();

        updateQuality(item);

        assertThat(item.quality, is(9));
    }

    @Test
    void regular_items_quality_decreases_twice_as_fast_after_expiring() {
        Item item = aRegularItem().withQuality(10).withSellIn(0).build();

        updateQuality(item);

        assertThat(item.quality, is(8));
    }

    @Test
    void regular_items_quality_can_not_be_negative() {
        Item item = aRegularItem().withQuality(0).build();

        updateQuality(item);

        assertThat(item.quality, is(0));
    }

    @Test
    void aged_brie_increases_quality_the_older_it_gets() {
        Item item = agedBrie().withQuality(30).build();

        updateQuality(item);

        assertThat(item.quality, is(31));
    }

    @Test
    void aged_brie_increases_quality_twice_as_fast_after_expiring() {
        Item item = agedBrie().withQuality(30).withSellIn(0).build();

        updateQuality(item);

        assertThat(item.quality, is(32));
    }

    @Test
    void aged_brie_quality_can_not_be_above_50() {
        Item item = agedBrie().withQuality(50).build();

        updateQuality(item);

        assertThat(item.quality, is(50));
    }

    @Test
    void sulfuras_never_decreases_sell_in() {
        Item item = sulfuras().withSellIn(10).build();

        updateQuality(item);

        assertThat(item.sellIn, is(10));
    }

    @Test
    void sulfuras_never_decreases_quality() {
        Item item = sulfuras().withQuality(10).build();

        updateQuality(item);

        assertThat(item.quality, is(10));
    }

    @Test
    void backstage_passes_increases_quality_by_one_as_day_passes() {
        Item item = backstagePasses().withQuality(10).withSellIn(20).build();

        updateQuality(item);

        assertThat(item.quality, is(11));
    }

    @Test
    void backstage_passes_increases_quality_by_two_when_there_are_10_or_less_days_remaining() {
        Item item = backstagePasses().withQuality(10).withSellIn(10).build();

        updateQuality(item);

        assertThat(item.quality, is(12));
    }

    @Test
    void backstage_passes_increases_quality_by_three_when_there_are_5_or_less_days_remaining() {
        Item item = backstagePasses().withQuality(10).withSellIn(5).build();

        updateQuality(item);

        assertThat(item.quality, is(13));
    }

    @Test
    void backstage_passes_quality_can_not_be_above_50() {
        Item item = backstagePasses().withQuality(48).withSellIn(5).build();

        updateQuality(item);

        assertThat(item.quality, is(50));
    }

    @Test
    void backstage_passes_quality_drops_to_zero_after_expiring() {
        Item item = backstagePasses().withQuality(48).withSellIn(0).build();

        updateQuality(item);

        assertThat(item.quality, is(0));
    }

    @Test
    void conjured_decreases_sell_in_after_each_day() {
        Item item = conjured().withSellIn(3).build();

        updateQuality(item);

        assertThat(item.sellIn, is(2));
    }

    @Test
    void conjured_degrades_quality_twice_as_fast() {
        Item item = conjured().withQuality(20).build();

        updateQuality(item);

        assertThat(item.quality, is(18));
    }

    private void updateQuality(Item... items) {
        new GildedRose(items).updateQuality();
    }
}
