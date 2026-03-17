package io.github.olvend.pracfix.gui.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class BooleanConfigButton extends GuiButton {
    private final BooleanSupplier valueSupplier;
    private final Consumer<Boolean> valueConsumer;
    private final String label;

    public BooleanConfigButton(int buttonId, int x, int y, String labelTranslationKey, BooleanSupplier valueSupplier, Consumer<Boolean> valueConsumer) {
        super(buttonId, x, y, 150, 20, "");
        this.valueSupplier = valueSupplier;
        this.valueConsumer = valueConsumer;
        this.label = I18n.format(labelTranslationKey);

        updateText();
    }

    private void updateText() {
        displayString = label + ": " + (valueSupplier.getAsBoolean() ?
                I18n.format("options.on") :
                I18n.format("options.off"));
    }

    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        if (!super.mousePressed(mc, mouseX, mouseY)) {
            return false;
        }

        boolean newValue = !valueSupplier.getAsBoolean();
        valueConsumer.accept(newValue);

        updateText();
        return true;
    }
}
