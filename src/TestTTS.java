import com.sun.speech.freetts.*;

public class TestTTS {
    public static void main(String[] args) {
        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        VoiceManager vm = VoiceManager.getInstance();
        for (Voice v : vm.getVoices()) {
            System.out.println("Found voice: " + v.getName());
        }

        Voice voice = vm.getVoice("kevin16");
        if (voice == null) {
            System.err.println("Voice not found");
            return;
        }
        voice.allocate();
        voice.speak("Hello, this is a Free TTS test.");
        voice.deallocate();
    }
}
