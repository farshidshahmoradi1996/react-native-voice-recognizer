package com.reactlibrary;

//required for bridge native and js
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.ActivityEventListener;

//required for android native
import android.speech.RecognizerIntent;
import android.content.ActivityNotFoundException;
import android.app.Activity;
import android.content.Intent;

//required for java
import java.util.ArrayList;

public class VoiceRecognizerModule extends ReactContextBaseJavaModule implements ActivityEventListener {

    private static final int REQUEST_VOICE_RECOGNIZER_CODE = 100;
    private final ReactApplicationContext reactContext;
    private Promise mPickerPromise;

    public VoiceRecognizerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addActivityEventListener(this);
        this.reactContext = reactContext;
    }

    @Override
    public void onActivityResult(Activity activity, final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == REQUEST_VOICE_RECOGNIZER_CODE) {
            if (resultCode == Activity.RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                mPickerPromise.resolve(result.get(0).toString());
            }
        }
    }

    @Override
    public String getName() {
        return "VoiceRecognizer";
    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @ReactMethod
    public void requestVoice(final String language, final String prompt, final Promise promise) {
        mPickerPromise = promise;
        try {
            Activity currentActivity = getCurrentActivity();
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, language);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, language);
            intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, language);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, prompt);
            currentActivity.startActivityForResult(intent, REQUEST_VOICE_RECOGNIZER_CODE);

        } catch (Exception e) {
            mPickerPromise.reject("ERROR", e);
            mPickerPromise = null;
        }
    }
}
