package org.igye.xogame.samplePlayer;

import org.igye.xogameclient.XOGame;

public class Main {
    public static void main(String[] args) {
        XOGame.start("127.0.0.1", 5150, "defaultId", new SamplePlayer(getArgValue(args, "-n")));
    }

    private static String getArgValue(String[] args, String argName) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals(argName)) {
                return args[i+1];
            }
        }
        return null;
    }
}
