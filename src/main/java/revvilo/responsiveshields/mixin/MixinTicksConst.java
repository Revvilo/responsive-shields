package revvilo.responsiveshields.mixin;

import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import revvilo.responsiveshields.config.Config;

@Mixin(Items.class)
public class MixinTicksConst {
    @ModifyArg(
            method = "registerItem(Ljava/lang/String;Ljava/util/function.Supplier;Lnet/minecraft/world/item/Item$Properties;)Lnet/minecraft/world/item/Item;",
            at = @At(
                    value = "NEW",
                    target = "net/minecraft/world/item/BlocksAttacks"
            ),
            index = 0 // Index of the first argument (0.25F)
    )
    private float setShieldUseDelay(float constant) {
        if(Config.IS_ENABLED.get()) return Config.SHIELD_DELAY.get().floatValue();
        return constant;
    }
}
