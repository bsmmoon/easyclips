# easyclips
easier way to play with CLIPS (C Language Integrated Production System)

<h2>Installation</h2>
1. git clone the repository and add it as a project in eclipse<br>
2. Get clips_jni_050.zip from http://sourceforge.net/projects/clipsrules/files/CLIPS/6.30/<br>
3. Unzip it. Move CLIPSJNI.dll into System32<br>
4. From the eclipse, right click on project and open Properties. Go to Java Build Path, press Add External JARs and select CLIPSJNI.jar.<br>

<h2>How to use</h2>
1. Compile it on eclipse. The console will say 'Press Enter to execute...'.
2. Open condition.clp and command.clp and use it with your favourite text editor such as Sublime.
3. When you are ready, press enter on the console. It will run and show whatever the original CLIPS will show.
4. For further process, you don't need to recompile. Simply change your condition.clp and command.clp and press enter again.
