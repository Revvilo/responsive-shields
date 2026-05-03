package revvilo.responsiveshields.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import revvilo.responsiveshields.config.Config;

@Mixin(LivingEntity.class)
public class MixinTicksConst {
    @Shadow protected ItemStack useItem;

    @Inject(method = "getItemBlockingWith()Lnet/minecraft/world/item/ItemStack;",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getUseDuration(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)I"), cancellable = true)
    private void setShieldUseDelay(CallbackInfoReturnable<ItemStack> cir) {
        if(Config.IS_ENABLED.get()) {
            cir.setReturnValue(useItem);
        }
    }
}

// net.minecraft.world.item.Item.getUseDuration