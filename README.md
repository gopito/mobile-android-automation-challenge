# qa-automation-android-test

### Setup:
  1) Install Android Studio as described [here](https://developer.android.com/studio/install)
  
  2) [Fork](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository) the repository to local.
  
  3) Open the repository in Android Studio and build the application. You can choose to build it on a physical device or an emulator.

### Additional Info:
   **Username**: automation@gymondo.de
   
   **Password**: automation
   
### How to launch tests
1) Change directory in terminal to **mobile-android-automation-challenge** or better open project in Android studio
2) Launch android emulator (we use TestButler which is not working with physical device without hacks).

4) When you changed directory in terminal to **mobile-android-automation-challenge** enter command
```
bash
adb shell mkdir /sdcard/allure-results && ./gradlew connectedCheck && adb pull /sdcard/allure-results && ./gradlew allureServe  

```

