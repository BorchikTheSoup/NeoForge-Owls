package net.borchik.borchiksowls.block.custom;

import com.mojang.serialization.MapCodec;
import net.borchik.borchiksowls.block.entity.OakOwlNestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class OakOwlNestBlock extends BaseEntityBlock {

    public static final MapCodec<OakOwlNestBlock> CODEC = simpleCodec(OakOwlNestBlock::new);

    public OakOwlNestBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    /* BLOCK ENTITY SHYT*/

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new OakOwlNestBlockEntity(blockPos, blockState);
    }

    
}
