package com.GooberGunter.GrandSorcery.common.items;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArcanometer extends Item{
	
	static int[] element= {0,0,0,0,0};
	private boolean isheld;
	
	public ItemArcanometer(String registryName) {
		super();
		this.setRegistryName(registryName);
		this.setUnlocalizedName(GSReferences.MODID+"."+registryName);
		isheld=false;
		this.setCreativeTab(ModItems.tabGrandSor);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        //TODO sense arcana
		if(!worldIn.isRemote) {
			Chunk chunk = worldIn.getChunkFromBlockCoords(playerIn.getPosition());
			IArcana a = chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);
			int[] s = a.getArcana();
			int f = s[0];
			int ai = s[1];
			int ea = s[2];
			int w = s[3];
			int ar = s[4];
			int life = s[5];
			int death = s[6];
			int light = s[7];
			int shadow = s[8];
			
			
			playerIn.sendMessage(new TextComponentTranslation("Fire: "+f+" Air: "+ai+" Earth: "+ea+" Water: "+w+" Arcana: "+ar+" Life: "+life+" Death: "+death+" Light: "+light+" Shadow: "+shadow));
			//Util.logger.info("Fire: "+f+" Air: "+ai+" Earth: "+ea+" Water: "+w+" Arcana: "+ar);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
	@SideOnly(Side.CLIENT)
	public static void setElement(int[] val) {
		element = val;
	}
	
	
	

}
