Warren provided some valuable feedback. He requested how to debug your app when an uncaught exception is thrown.

With that in mind, the initial state of the DemoIntent project:
* it builds clean
* no warnings (ignore the warning from the manifest)
* no errors (that means your project won't build)

HOWEVER... the app does not successfully launch :( Indeed, I've baked in four sources of run-time
errors. Can you find them all???

I will provide a demo on how to chase the errors.

In case you miss my demo, some hints:
* CaptializedTextActivit.java - *look closely* are we in the plain (boo!) activity or the capitalized activity (yeah!)?
* AndroidManifest.xml - *remember* ALL activities must described in the manifest.