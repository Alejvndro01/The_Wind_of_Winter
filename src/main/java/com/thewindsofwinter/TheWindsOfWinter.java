package com.thewindsofwinter;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheWindsOfWinter implements ModInitializer {
	public static final String MOD_ID = "the-winds-of-winter";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing The Winds of Winter Mod...");

		// Lanzamos la inicialización del núcleo del mod
		com.thewindsofwinter.core.ModCore.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
