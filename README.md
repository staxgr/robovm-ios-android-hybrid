This is an example Gradle project that aims to show how easy you can use Gradle, Java and the amazing (RoboVM | http://robovm.org) to setup a project that builds both a native Android and a native iOS app that share a common code layer in Java.

To understand this example fully, you need to be familiar with Android development using Android Studio and Gradle, and you should have a look at www.robovm.org

All configuration is done with gradle, and the only prerequesite is that you have XCode (and preferably Android Studio) installed and working on your Mac.

The project consists of three main parts (or modules): app-android, app-ios and common. One Android app, one iOS app (configured to use RoboVM) and a plain old Java project that holds common code for both apps.

To build and run the apps from command line:

```bash
git clone <this repo>

# Build all three projects:
./gradlew build

# Run the Android app
./gradlew installDebug

# Run the iOS app
./gradlew launchIPhoneSimulator


```



