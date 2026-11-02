package com.thewindsofwinter;

import com.thewindsofwinter.network.CharacterSelectPayload;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.text.Text;

public class TheWindsOfWinter implements ModInitializer {
	@Override
	public void onInitialize() {
		// 1. Registramos el tipo de paquete en el servidor
		PayloadTypeRegistry.playC2S().register(CharacterSelectPayload.ID, CharacterSelectPayload.CODEC);

		// 2. Definimos qué ocurre cuando el servidor recibe la elección del cliente
		ServerPlayNetworking.registerGlobalReceiver(CharacterSelectPayload.ID, (payload, context) -> {
			context.server().execute(() -> {
				// Aquí entregaremos el inventario más adelante. Por ahora, confirmamos en el chat:
				context.player().sendMessage(Text.literal("§6[The Winds of Winter] §fHas asumido el legado de: §b" + payload.characterId()), false);
			});
		});
	}
}