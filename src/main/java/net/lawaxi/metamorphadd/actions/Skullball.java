package net.lawaxi.metamorphadd.actions;

import mchorse.metamorph.api.abilities.IAction;
import mchorse.metamorph.api.morphs.AbstractMorph;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Skullball implements IAction {
    @Override
    public void execute(EntityLivingBase target, @Nullable AbstractMorph morph) {

        World world = target.world;

        if (world.isRemote) {
            return;
        }

        if (target instanceof EntityPlayer && ((EntityPlayer) target).getCooledAttackStrength(0.0F) < 1) {
            return;
        }

        Vec3d vec3d = target.getLook(1.0F);

        double d1 = 4.0D;
        double d2 = vec3d.x * d1;
        double d3 = vec3d.y * d1;
        double d4 = vec3d.z * d1;

        world.playEvent((EntityPlayer) null, 1016, new BlockPos(target), 0);

        EntityWitherSkull skullball = new EntityWitherSkull(world, target, d2, d3, d4);

        skullball.posX = target.posX;
        skullball.posY = target.posY + target.height * 0.9;
        skullball.posZ = target.posZ;

        world.spawnEntity(skullball);

        if (target instanceof EntityPlayer) {
            ((EntityPlayer) target).resetCooldown();
        }
    }

}
