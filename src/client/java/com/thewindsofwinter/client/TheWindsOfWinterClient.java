package com.thewindsofwinter.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheWindsOfWinterClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("twow-client");

	@Override
	public void onInitializeClient() {
		LOGGER.info("The Winds of Winter Client initialized!");
	}
}
