package gravestone.grave;

import gravestone.mod_Gravestone;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemGrave extends Item{

	public ItemGrave(int par1) {
		super(par1);
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("brick");
	}

	public void addInformation(ItemStack stack, EntityPlayer p1, List list, boolean yesno) {
		NBTTagCompound tags = stack.getTagCompound();

		if (tags != null) 
		{
			if (tags.hasKey("Meta")) 
			{
				list.add(StatCollector.translateToLocal("Type : " + String.valueOf(tags.getInteger("Meta"))));
			}
			if (tags.hasKey("Name")) 
			{
				list.add(StatCollector.translateToLocal("Name : " + String.valueOf(tags.getString("Name"))));
			}
			if (tags.hasKey("Message"))
			{
				String name = tags.getString("Message");
				list.add(StatCollector.translateToLocal("Message : "+ String.valueOf(name.replace("_", " "))));
			}
			if (tags.hasKey("Message2"))
			{
				String name = tags.getString("Message2");
				list.add(StatCollector.translateToLocal("Message2 : "+ String.valueOf(name.replace("_", " "))));
			}
		}
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		NBTTagCompound nbt = par1ItemStack.getTagCompound();
		par3World.setBlock(x, y+1, z, mod_Gravestone.gravestone.blockID);
		TileEntity te = par3World.getBlockTileEntity(x,y+1,z);
		if(te != null)
		{
			TEGrave grave = (TEGrave)te;
			if(nbt != null)
			{
				if(nbt.hasKey("Message") && nbt.hasKey("Meta")&& nbt.hasKey("Name") && nbt.hasKey("Message2"))
				{
					grave.setName(nbt.getString("Name"));
					grave.setMeta(nbt.getInteger("Meta"));
					grave.setDeathMessage(nbt.getString("Message"), nbt.getString("Message2"));
					par3World.setBlockTileEntity(x, y+1, z, te);
				}
			}
			else
				par2EntityPlayer.sendChatToPlayer("Arguments missing !");
		}	
		else
			par2EntityPlayer.sendChatToPlayer("te == null");

		return false;
	}
}
