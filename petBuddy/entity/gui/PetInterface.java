package petBuddy.entity.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.PacketDispatcher;

import petBuddy.PetBuddyMain;
import petBuddy.entity.BlazeBuddy;
import petBuddy.entity.CowBuddy;
import petBuddy.entity.CreeperBuddy;
import petBuddy.entity.EntityBuddy;
import petBuddy.entity.PigBuddy;
import petBuddy.root.BuddyBase;

public class PetInterface extends GuiScreen {

	private float xSize_lo;
	private float ySize_lo;
	private int xSize = 0;
	private int ySize = 0;
	public static String hi ;
	public EntityPlayer thePlayer;
	public String playerName;
	public static PetInterface inst;

	public PetInterface(EntityPlayer player, String name) {
		super();
		hi = "Choose a new Buddy to adventure with you.";
		thePlayer = player;
		playerName = name;
		inst = this;
	}

	@Override
	public void initGui() {
		this.buttonList.clear();

		int posX = (this.width - xSize) / 2;
		int posY = (this.height - ySize) / 2;
		this.buttonList.add(new GuiButton(1, posX+150 , posY-100 , 20, 20, "X"));

		this.buttonList.add(new GuiButton(2, posX-200 , posY-20, 50, 20, "Pig"));
		this.buttonList.add(new GuiButton(3, posX-200 , posY-50, 50, 20, "Tiny you"));
		this.buttonList.add(new GuiButton(4, posX-200 , posY+10, 50, 20, "Creeper"));
		this.buttonList.add(new GuiButton(5, posX-200 , posY+40, 50, 20, "Cow"));
		this.buttonList.add(new GuiButton(6, posX-200 , posY+70, 50, 20, "Blaze"));

		this.buttonList.add(new GuiButton(7, posX-140 , posY-50, 50, 20, "Spider"));
		this.buttonList.add(new GuiButton(8, posX-140 , posY-20, 50, 20, "C.Spider"));
		this.buttonList.add(new GuiButton(9, posX-140 , posY+10, 50, 20, "RpgSpider"));
		this.buttonList.add(new GuiButton(10, posX-140 , posY+40, 50, 20, "Skeleton"));
		this.buttonList.add(new GuiButton(11, posX-140 , posY+70, 50, 20, "W.Skeleton"));

		this.buttonList.add(new GuiButton(12, posX-80 , posY-50, 50, 20, "Zombie"));
		this.buttonList.add(new GuiButton(13, posX-80 , posY-20, 50, 20, "Ghast"));
		this.buttonList.add(new GuiButton(14, posX-80 , posY+10, 50, 20, "Sheep"));
		this.buttonList.add(new GuiButton(15, posX-80 , posY+40, 50, 20, "EnderMan"));
		this.buttonList.add(new GuiButton(16, posX-80 , posY+70, 50, 20, "SilverFish"));

		this.buttonList.add(new GuiButton(17, posX-20 , posY-50, 50, 20, "SnowMan"));
		this.buttonList.add(new GuiButton(18, posX-20 , posY-20, 50, 20, "Iron Golem"));
		this.buttonList.add(new GuiButton(19, posX-20 , posY+10, 50, 20, "Witch"));
		this.buttonList.add(new GuiButton(20, posX-20 , posY+40, 50, 20, "Bat"));
		this.buttonList.add(new GuiButton(21, posX-20 , posY+70, 50, 20, "Chicken"));

		this.buttonList.add(new GuiButton(22, posX+40 , posY-50, 50, 20, "Mooshroom"));
		this.buttonList.add(new GuiButton(23, posX+40 , posY-20, 50, 20, "Ocelot"));
		this.buttonList.add(new GuiButton(24, posX+40 , posY+10, 50, 20, "Squid"));
		this.buttonList.add(new GuiButton(25, posX+40 , posY+40, 50, 20, "Villager"));
		this.buttonList.add(new GuiButton(26, posX+40 , posY+70, 50, 20, "Wolf"));

		this.buttonList.add(new GuiButton(27, posX+100 , posY-50, 50, 20, "Pig Zombie"));
		this.buttonList.add(new GuiButton(28, posX+100 , posY-20, 50, 20, "Slime"));
		this.buttonList.add(new GuiButton(29, posX+100 , posY+10, 50, 20, "Magma SLime"));
		this.buttonList.add(new GuiButton(1, posX+100 , posY+40, 50, 20, "x"));
		this.buttonList.add(new GuiButton(1, posX+100 , posY+70, 50, 20, "x"));

		this.buttonList.add(new GuiButton(1, posX+160 , posY-50, 50, 20, "x"));
		this.buttonList.add(new GuiButton(1, posX+160 , posY-20, 50, 20, "x"));
		this.buttonList.add(new GuiButton(1, posX+160 , posY+10, 50, 20, "x"));
		this.buttonList.add(new GuiButton(1, posX+160 , posY+40, 50, 20, "x"));
		this.buttonList.add(new GuiButton(1, posX+160 , posY+70, 50, 20, "x"));
	}

	public void drawScreen(int par1, int par2, float par3) {
		this.xSize_lo = (float) par1;
		this.ySize_lo = (float) par2;
		super.drawScreen(par1, par2, par3);

		try
		{
			this.mc.renderEngine.bindTexture("/gui/demo_bg.png");
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 5.0F);
			int posX = (this.width - xSize) / 2;
			int posY = (this.height - ySize) / 2;
			drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);
			drawTexturedModalRect(posX*2, posY+5, 0, 90, 45, ySize);
			fontRenderer.drawSplitString(hi, this.width / 2-49, this.height / 2-100, 150 ,0x000000);
			fontRenderer.drawSplitString(hi, this.width / 2-50, this.height / 2-101, 150 ,0xffffff);
		}
		catch (Throwable e){
		}
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.id == 1) 
		{
			mc.thePlayer.closeScreen();
		}
		else{
			sendPacket(button.id);
			mc.thePlayer.closeScreen();
		}
	}
	
	public void sendPacket(int id){
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		ObjectOutput out;
		DataOutputStream outputStream = new DataOutputStream(bytes);
		try {
			outputStream.writeInt(id);
			Packet250CustomPayload packet = new Packet250CustomPayload("buddyPet", bytes.toByteArray());
			PacketDispatcher.sendPacketToServer(packet);
			thePlayer.closeScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}