### Brownish Greenfield Gilded Rose Kata*

Hi and welcome to team Gilded Rose!

As you know, we are a small inn with a prime location in a prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.

Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures.

Your task is to rewrite the system using an old class, that already exists. First an introduction to our system:

* All items have a SellIn value which denotes the number of days we have to sell the item
* All items have a Quality value which denotes how valuable the item is
* At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

* Once the sell by date has passed, Quality degrades twice as fast
* The Quality of an item is never negative
* “Aged Brie” actually increases in Quality the older it gets
* “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality
* The Quality of an item is never more than 50, however “Sulfuras” is a legendary item and as such its Quality is 80 and it never alters.
* “Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert
* “Conjured” items degrade in Quality twice as fast as normal items

Your task is to create the system from scratch, with only a restriction:
**You must use the Item class that Leeroy developed**.

But beware, before leaving Leeroy casted a curse on this class, so:

1. It must be used.
2. It can not be modified. This prohibition applies to modifying it, deleting it, adding new methods, deleting methodts, changing visibility of stuff, etc.
3. It cannot be extended.

If you break any of these rules a goblin in the corner will insta-rage and destroy you.

You'll find the initial code for this kata in this repository.

Good luck and beware the goblin!

*Adapted from the [Brownish Greenfield Gilded Rose Kata](https://alvarogarcia7.github.io/blog/2016/04/18/brownish-greenfield-gilded-rose-kata-formulation/)