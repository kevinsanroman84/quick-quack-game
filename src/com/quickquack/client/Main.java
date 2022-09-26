package com.quickquack.client;

import com.apps.util.SplashApp;
import com.quickquack.app.QuickQuackApp;

class Main implements SplashApp {
    @Override
    public void start() {
        QuickQuackApp.initialize();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.welcome();
        app.start();
    }
}