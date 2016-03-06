package org.igye.xogame.samplePlayer;

import org.igye.xogameclient.XOGame;

public class Main {
    public static void main(String[] args) {
        XOGame.start(
                getArgValue(args, "-h", "127.0.0.1"),
                Integer.parseInt(getArgValue(args, "-p", "5150")),
                getArgValue(args, "-i", "###"),
                new SamplePlayer(getArgValue(args, "-n", "SamplePlayer"))
        );
    }

    private static String getArgValue(String[] args, String argName, String defValue) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals(argName)) {
                return args[i+1];
            }
        }
        return defValue;
    }
}
