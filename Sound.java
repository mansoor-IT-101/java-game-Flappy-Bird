import javax.sound.sampled.*;
import java.io.*;
import java.io.IOException;

public class Sound {

    public static void playSound(String fileName) {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(
                Sound.class.getResource("/resources/" + fileName)  // correct path
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
