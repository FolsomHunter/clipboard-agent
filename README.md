# clipboard-agent

Fix of race condition on Windows in AWT.

# Building

- Execute `gradlew build`

	- Building may require that the languageVersion in `build.gradle.kts` be updated.
		For example, change:
		```kotlin
		java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))
		```
		to:
		```kotlin
		java.toolchain.languageVersion.set(JavaLanguageVersion.of(20))
		```

- Locate the file `build/libs/clipboard-agent.jar`


# For NetBeans:

- Navigate to your NetBeans install directory
- Enter `etc` folder.
- Open `netbeans.conf`
- Add `-J-javaagent:agent_dir/clipboard-agent.jar` to `netbeans_default_options`.
- To test that the agent works, it is recommended that you run NetBeans from the terminal the first time.

Normal log during agent initialization:

```
Patched sun.awt.datatransfer.SunClipboard
Patched sun.awt.windows.WClipboard
Applied the clipboard patch
```
