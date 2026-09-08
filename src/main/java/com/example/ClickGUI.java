package com.example;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ClickGUI extends Screen {

    public ClickGUI() {
        super(Text.literal("Visuals Menu"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("China Hat: " + (VisualMod.enableChinaHat ? "§aON" : "§cOFF")),
            button -> {
                VisualMod.enableChinaHat = !VisualMod.enableChinaHat;
                button.setMessage(Text.literal("China Hat: " + (VisualMod.enableChinaHat ? "§aON" : "§cOFF")));
            }
        ).dimensions(centerX - 75, centerY - 20, 150, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("Custom Fog: " + (VisualMod.enableCustomFog ? "§aON" : "§cOFF")),
            button -> {
                VisualMod.enableCustomFog = !VisualMod.enableCustomFog;
                button.setMessage(Text.literal("Custom Fog: " + (VisualMod.enableCustomFog ? "§aON" : "§cOFF")));
            }
        ).dimensions(centerX - 75, centerY + 10, 150, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        context.fill(this.width / 2 - 90, this.height / 2 - 40, this.width / 2 + 90, this.height / 2 + 50, 0x80000000);
        context.drawCenteredTextWithShadow(this.textRenderer, "§b§lBATTLY VISUALS", this.width / 2, this.height / 2 - 35, 0xFFFFFF);
        
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
