package net.roks.farmalert.screen;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

public class FarmAlertScreen extends Screen {

    public FarmAlertScreen() {
        super(Component.literal("FarmAlert"));
    }

    @Override
    protected void init() {

        Button button = Button.builder(
                        Component.literal("Hello World"),
                        btn -> {

                            this.minecraft.getToastManager().addToast(
                                    SystemToast.multiline(
                                            this.minecraft,
                                            SystemToast.SystemToastId.NARRATOR_TOGGLE,
                                            Component.literal("Hello World"),
                                            Component.literal("FarmAlert Screen Works")
                                    )
                            );

                        })
                .bounds(40, 40, 140, 20)
                .build();

        this.addRenderableWidget(button);

    }

    @Override
    public void extractRenderState(
            GuiGraphicsExtractor graphics,
            int mouseX,
            int mouseY,
            float delta) {

        super.extractRenderState(
                graphics,
                mouseX,
                mouseY,
                delta
        );

        graphics.text(
                this.font,
                "Special Button",
                40,
                40 - this.font.lineHeight - 10,
                0xFFFFFFFF,
                true
        );

    }

}