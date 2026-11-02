package com.thewindsofwinter.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class TheWindsOfWinterClient implements ClientModInitializer {
    private static KeyBinding openSelectScreenKey;

    @Override
    public void onInitializeClient() {
        // Registramos la tecla 'O' para abrir el selector de personajes
        openSelectScreenKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.the-winds-of-winter.select_character",
                InputUtil.Type.KEY,
                GLFW.GLFW_KEY_O,
                "category.the-winds-of-winter.general"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openSelectScreenKey.wasPressed()) {
                if (client.player != null) {
                    client.setScreen(new CharacterSelectScreen());
                }
            }
        });
    }
}