package betterbreeds.gui;
 
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import betterbreeds.entity.EntityWolf4;
 
public class GuiName3 extends GuiScreen {
    private BufferedImage img;
    private int imgID = 2055;
    public static EntityWolf4 wolf4;
   
    public GuiName3(EntityPlayer p1, int wolfId)
    {
    	World world = p1.worldObj;
    	wolf4= (EntityWolf4)world.getEntityByID(wolfId);
    	}
    
    private GuiTextField textfield;
   
    public final int xSizeOfTexture = 256;
   	public final int ySizeOfTexture = 153;
   

    public void initGui() {
   	 try {
         img = ModLoader.loadImage(mc.renderEngine, "/subaraki/DogGui2.png");
         mc.renderEngine.setupTexture(img, imgID);
     } 
     catch (Exception e) {
         e.printStackTrace();
     }
	int posX = (this.width - xSizeOfTexture) / 2;
	int posY = (this.height - ySizeOfTexture) / 2;
    buttonList.clear();
    buttonList.add(new GuiButton(1, posX +90, posY+100, 70, 20, "Done"));
    buttonList.add(new GuiButton(2, posX +235, posY+1, 20, 20, "X"));
    
    textfield = new GuiTextField(fontRenderer, posX+68 , posY+60, 120, 20);
     textfield.setText("Name Your Dog");
     textfield.setMaxStringLength(32);

   
    }
    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 1)
        {
        	System.out.println("preNameSend");
        	ByteArrayOutputStream bytes = new ByteArrayOutputStream() ;
			ObjectOutput out;
			try {
				out = new ObjectOutputStream(bytes);			    
				out.writeInt(3);
				out.writeInt(wolf4.entityId);
				out.writeUTF(textfield.getText());
				out.close();
				Packet250CustomPayload packet = new Packet250CustomPayload("secondChannel",bytes.toByteArray());
				ModLoader.clientSendPacket(packet); 
	    		System.out.println("nameSend");

			}
			catch (IOException e) {
				e.printStackTrace();
	    		System.out.println("nameSendFailed");

			}
			this.mc.thePlayer.closeScreen();
                
        }
        if(guibutton.id == 2)
        {
			this.mc.thePlayer.closeScreen();
        }
    }
    protected void keyTyped(char c, int i)
    {
        super.keyTyped(c, i);
        textfield.textboxKeyTyped(c, i);
    }
    protected void mouseClicked(int i, int j, int k)
    {
        super.mouseClicked(i, j, k);
        textfield.mouseClicked(i, j, k);
    }
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    public void onGuiClosed()
    {
    }
    public void drawScreen(int i, int j, float f)
    {
    	drawDefaultBackground();
   	 try {
   		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/subaraki/DogGui2.png");
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
   	 }
   	 finally
   	 {
   		 textfield.drawTextBox();
   	 }
        super.drawScreen(i, j, f);
    }
 
 
}