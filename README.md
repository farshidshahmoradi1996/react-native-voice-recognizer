# react-native-voice-recognizer:microphone:
![speech-api-lead](https://user-images.githubusercontent.com/37307562/78901097-159fe800-7a8d-11ea-948a-0ce9ff01a5b6.png)<br>
>A tiny lib for open native platform voice regonizer in react native.
## Motivation
<a href="https://github.com/react-native-community">`react-native-community`<a/> provides an awesome <a href="https://github.com/react-native-community/voice">@react-native-community/voice</a> for reconiting voice but sometimes you don't want to create your own voice reconizer also you want only recogniting with native platform tool.
## Feautures
  - tiny and clean way :rocket:.
  - Native Implementation :chart_with_upwards_trend: .
  - Easy To Use :heart_eyes: ( only have one method ) .
  - No `ios` Support :hankey: ( may be add in future ) .
## Result
<a href="https://gifyu.com/image/lslg"><img src="https://s6.gifyu.com/images/3w0l7v.gif" alt="3w0l7v.gif" border="0" /></a>
## Installation
installing with yarn : 

```bash
yarn add react-native-voice-recognizer
```

or alternativly with npm :
```bash
npm i react-native-voice-recognizer
```
 <br><br>
Note : if you are using RN@>=0.60 you dont need any more enjoy RN auto-linking with `npx react-native run-android` <br><br> but for RN@<0.60 you need to `link` with `react-native link` or linking manually .
>manully linking will add soon here.

## Usage

first import 
```js
import VoiceRecognizer from 'react-native-voice-recognizer';
```
then use with <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises">then/catch</a> ES6 syntax :
```js
    //settings are required
    const locale = 'en-US'; //or for example : 'fa-IR'
    const promptLabel = 'Say Something...';

    //request for recognizing
    VoiceRecognizer.requestVoice(locale, promptLabel)
      .then(result => {
        //do anything with result and enjoy
      })
      .catch(e => {
        //your device does not support voice recognition
      });
```
And Enjoy. :heart_eyes:<br><br>
Or use with <a href="https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Asynchronous/Async_await">async/await ES2017</a> feature :
```js
  const startListennig = async () => {
    //settings are requires
    const locale = 'en-US'; //or for example :'fa-IR'
    const promptLabel = 'Say Something...'; //or anything you want

    try {
      const result = await VoiceRecognizer.requestVoice(locale, promptLabel);
      //do anything with result and enjoy
    } catch (error) {
      //your device does not support voice recognition
    }
  };
```
## Api

> soon add here 

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Licence
<a href="https://choosealicense.com/licenses/mit/">MIT</a>

maked with :heart: for developers.


