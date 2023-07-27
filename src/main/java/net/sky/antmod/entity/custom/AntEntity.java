package net.sky.antmod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AntEntity extends Monster implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public AntEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chomper.walk", true));
            return PlayState.CONTINUE;
        }f

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chomper.idle", true));
        return PlayState.CONTINUE;

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

        protected void playStepSound(BlockPos pos, BlockState blockIn) {
            this.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 0.15F, 1.0F);
        }

        protected SoundEvent getAmbientSound() {
            return SoundEvents.CAT_STRAY_AMBIENT;
        }

        protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
            return SoundEvenzts.DOLPHIN_HURT;
        }

        protected SoundEvent getDeathSound() {
            return SoundEvents.DOLPHIN_DEATH;
        }

        protected float getSoundVolume() {
            return 0.2F;
        }

}
