package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.heslingtonhustle.HeslingtonHustle;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(800,400);
		config.setForegroundFPS(60);
		config.setTitle("Heslington-Hustle");
		new Lwjgl3Application(new HeslingtonHustle(), config);
	}
}
