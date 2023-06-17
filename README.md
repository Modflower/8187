# [MC-8187] / 2x2 Surrounded Saplings Fix

The 2x2 Surrounding Saplings fix for [MC-8187] allows 2x2 saplings such as spruce,
jungle and dark oak to grow even when completely surrounded on all 4 sides.

## How does it work?

Simple, it fixes an offset in TreeFeature.getTopPosition that makes 2x2 trees
check a 3x3 area at the trunk, catching additional blocks that don't determine
how the tree should grow.

## How do I use it?

Simply install [Fabric] or [Quilt] for Minecraft 1.16 and newer,
then install this mod.

## Any side effects?

Theoretically, 2x2 trees *may* spawn more frequently in a given world,
and old builds not expecting 2x2 saplings to grow may suddenly get a surprise.

Any modded trees that are 3x3 may also erroneously check for a 2x2 trunk if it
relies on the generator to filter out whether a space is valid.

## Fun facts:

- This mod was written on 1.16.5 and works as is on 1.16 through 1.20.1.
- I wrote this mod using [Segoe Script](https://learn.microsoft.com/en-us/typography/font-list/segoe-script).
- Some hate the compatibility cockroach that is this mod.

[Fabric]: https://fabricmc.net/use

[Quilt]: https://quiltmc.org/install

[MC-8187]: https://bugs.mojang.com/browse/MC-8187
