package com.pahimar.ee3.client.gui.inventory;

import com.pahimar.ee3.helper.ItemStackNBTHelper;
import com.pahimar.ee3.inventory.ContainerAlchemicalBag;
import com.pahimar.ee3.inventory.InventoryAlchemicalBag;
import com.pahimar.ee3.lib.Strings;
import com.pahimar.ee3.lib.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Equivalent-Exchange-3
 * <p/>
 * GuiAlchemicalBag
 *
 * @author pahimar
 */
@SideOnly(Side.CLIENT)
public class GuiAlchemicalBag extends GuiContainer
{
    private final ItemStack parentItemStack;
    private final InventoryAlchemicalBag inventoryAlchemicalBag;

    public GuiAlchemicalBag(EntityPlayer entityPlayer, InventoryAlchemicalBag inventoryAlchemicalBag)
    {
        super(new ContainerAlchemicalBag(entityPlayer, inventoryAlchemicalBag));

        this.parentItemStack = inventoryAlchemicalBag.parentItemStack;
        this.inventoryAlchemicalBag = inventoryAlchemicalBag;

        if (this.parentItemStack.getItemDamage() == 0)
        {
            xSize = 230;
            ySize = 186;
        }
        else if (this.parentItemStack.getItemDamage() == 1)
        {
            xSize = 230;
            ySize = 240;
        }
        else if (this.parentItemStack.getItemDamage() == 2)
        {
            xSize = 248;
            ySize = 256;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        if (this.parentItemStack.getItemDamage() == 0 || this.parentItemStack.getItemDamage() == 1)
        {
            fontRenderer.drawString(StatCollector.translateToLocal(inventoryAlchemicalBag.getInvName()), 8, 6, 4210752);
            fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 35, ySize - 95 + 2, 4210752);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if (this.parentItemStack.getItemDamage() == 0)
        {
            this.mc.getTextureManager().bindTexture(Textures.GUI_ALCHEMICAL_BAG_SMALL);
        }
        else if (this.parentItemStack.getItemDamage() == 1)
        {
            this.mc.getTextureManager().bindTexture(Textures.GUI_ALCHEMICAL_BAG_MEDIUM);
        }
        else if (this.parentItemStack.getItemDamage() == 2)
        {
            this.mc.getTextureManager().bindTexture(Textures.GUI_ALCHEMICAL_BAG_LARGE);
        }

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();

        if (mc.thePlayer != null)
        {
            for (ItemStack itemStack : mc.thePlayer.inventory.mainInventory)
            {
                if (itemStack != null)
                {
                    if (ItemStackNBTHelper.hasTag(itemStack, Strings.NBT_ITEM_ALCHEMICAL_BAG_GUI_OPEN))
                    {
                        ItemStackNBTHelper.removeTag(itemStack, Strings.NBT_ITEM_ALCHEMICAL_BAG_GUI_OPEN);
                    }
                }
            }
        }
    }
}
