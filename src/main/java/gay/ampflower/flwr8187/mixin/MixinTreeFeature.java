/*
 * Copyright (C) 2023, Ampflower
 *
 * This software is subject to the terms of the Zlib License.
 * If a copy was not distributed with this file, you can obtain one at
 * https://github.com/Modflower/8187/blob/trunk/LICENSE
 *
 * Source: https://github.com/Modflower/8187
 * SPDX-License-Identifier: Zlib
 */

package gay.ampflower.flwr8187.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Fixes the offsets for 2x2 saplings at starting height
 * fixing <a href="https://bugs.mojang.com/browse/MC-8187">MC-8187</a>.
 *
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(TreeFeature.class)
public class MixinTreeFeature {
	/**
	 * Corrects the starting value if the trunk's minimum size is {@literal 1}
	 * and the starting value is {@literal -1} by returning {@literal 0}.
	 */
	@ModifyVariable(method = "method_29963", at = @At(value = "STORE", ordinal = 0), allow = 1, index = 8)
	private int flwr8187$fixOffset(int startValue, TestableWorld world, int i, BlockPos pos, TreeFeatureConfig config) {
		//  Roughly height == 0 && trunk == 1
		if (startValue == -1 && config.minimumSize.method_27378(i, 0) == 1) {
			return 0;
		}
		return startValue;
	}

	/**
	 * Redirects to {@link #flwr8187$fixOffset(int, TestableWorld, int, BlockPos, TreeFeatureConfig)}
	 */
	@ModifyVariable(method = "method_29963", at = @At(value = "STORE", ordinal = 0), allow = 1, index = 9)
	private int flwr8187$fixOffset2(int v, TestableWorld world, int i, BlockPos pos, TreeFeatureConfig config) {
		return flwr8187$fixOffset(v, world, i, pos, config);
	}
}
