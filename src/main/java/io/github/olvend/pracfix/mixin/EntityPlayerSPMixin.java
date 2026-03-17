package io.github.olvend.pracfix.mixin;

import io.github.olvend.pracfix.PracFix;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EntityPlayerSP.class)
public class EntityPlayerSPMixin {

    @Shadow
    private double lastReportedPosX, lastReportedPosY, lastReportedPosZ;

    @Unique
    private boolean prac_fix$wasMoving = false;

    @ModifyVariable(method = "onUpdateWalkingPlayer", at = @At("STORE"), ordinal = 2)
    private boolean modifyFlag2(boolean original) {
        if (!PracFix.config.fixPrac) {
            return original;
        }

        EntityPlayerSP player = (EntityPlayerSP) (Object) this;

        boolean isMoving = player.motionX != 0.0 || player.motionZ != 0.0;
        boolean isSyncedWithServer =
                player.posX == lastReportedPosX &&
                player.getEntityBoundingBox().minY == lastReportedPosY &&
                player.posZ == lastReportedPosZ;

        if (prac_fix$wasMoving && !isMoving && !isSyncedWithServer) {
            if (PracFix.config.debugPositionUpdates) {
                player.addChatMessage(new ChatComponentText("SYNCED"));
            }
            prac_fix$wasMoving = false;
            return true;
        }

        prac_fix$wasMoving |= isMoving;

        return original;
    }
}
