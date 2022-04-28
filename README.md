NoIdling
========

A small utility that prevents your computer from locking off when your company tries to enforce such behaviour.

How to use
----------
1. Make sure you have OpenJDK 17
2. Download a release or compile it on your own
3. Optionally create a configuration file (`config.properties` in same folder as *.jar)
4. Run it using `javaw.exe` instead of `java.exe` (so the terminal won't show up)

Configuration
-------------
If you don't create a configuration file, the application will load the default values shown below.
```properties
# Seconds to wait before sending fake cursor move events
idleTimeBeforeMouseMove=210
```

Compiling
---------
1. `./gradlew build`
2. You will find a runnable jar in `build/libs`