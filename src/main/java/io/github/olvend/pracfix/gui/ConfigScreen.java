package io.github.olvend.pracfix.gui;

import io.github.olvend.pracfix.PracFix;
import io.github.olvend.pracfix.gui.widget.BooleanConfigButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

import java.io.IOException;

public class ConfigScreen extends GuiScreen {
    private final GuiScreen parentScreen;
    private final String title = "Prac Fix Config";

    public ConfigScreen(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    @Override
    public void initGui() {
        buttonList.add(new BooleanConfigButton(
                0,
                width / 2 - 155,
                height / 6 - 12,
                "pracfix.config.fixPrac",
                () -> PracFix.config.fixPrac,
                value -> PracFix.config.fixPrac = value
        ));

        buttonList.add(new BooleanConfigButton(
                0,
                width / 2 + 5,
                height / 6 - 12,
                "pracfix.config.debugPositionUpdates",
                () -> PracFix.config.debugPositionUpdates,
                value -> PracFix.config.debugPositionUpdates = value
        ));

        buttonList.add(new GuiButton(200, width / 2 - 100, height / 6 + 168, I18n.format("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (!button.enabled) return;

        if (button.id == 200) {
            mc.displayGuiScreen(parentScreen);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        drawCenteredString(fontRendererObj, title, width / 2, 15, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
