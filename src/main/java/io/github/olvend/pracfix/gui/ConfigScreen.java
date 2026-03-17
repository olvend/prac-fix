package io.github.olvend.pracfix.gui;

import net.minecraft.client.gui.GuiScreen;

public class ConfigScreen extends GuiScreen {
    private final GuiScreen parentScreen;

    public ConfigScreen(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
