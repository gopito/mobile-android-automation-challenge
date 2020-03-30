### Why did you choose the framework you used?
1) Espresso has access to internals of the application. So we can make 
white box testing.
2) I have experience with Espresso.
3) Espresso test are stored near the application. You don't need to 
download additional repository with test.
4) Android studio has good integrations with Espresso framework.
5) I don't need to test behavior outside the Application scope. For example 
I don't need to interact with Launcher and Notification panel.
6) Espresso has integrated synchronization for tasks. You rarely need to 
write Idling Resources. In my tests I used the wrapper which uses FailureHandlers 
instead of Idling Resources.

### What were the advantages and disadvantages of your choice?
#### Advantages
1) Espresso as fast as UI Automator but have more convenient syntax. It is
faster than Appium too.
2) Espresso test are stored near the application. You don't need to 
download additional repository with test. Developers can launch tests with
one button click.
3) Tests are written on Kotlin as the main Application. So everyone in a
team can fix them or extend.
4) Espresso has integrated synchronization for tasks. You rarely need to 
write Idling Resources. In my tests I used the wrapper which uses FailureHandlers 
instead of Idling Resources.
5) There are a lot of third party frameworks around Espresso.
6) It supported by Google (but maybe it is disadvantage too)

#### Disadvantages
1) It could interact with interface only inside the scope of Application
2) It is really difficult to use Espresso without source. As I know we need
to change Manifest of the main Application and sign it with the signature 
that the testing Application has. So they could work in one process. But I 
haven't tried it yet :)
3) Proguard rules could brake the accessibility to Application resources. So
If we want to test on application which is similar to realise one. We should 
tune our proguard rules.
4) We need to build Application and Test Application it takes time.
5) We need to rebuild Test Application after we change something in R.id.
Cause Test Application could store Int reference on other value.

### What was the most complicated part?
1) Write Idling Resource without touching the code. Finally I used FailureHandler
way.
2) Right testing of search functionality was not trivial.

### Which good coding practices did you follow when writing your tests?
1) I used Page object pattern
2) Also used very simple DSL. I could use Kakao or Kaspresso, but deviced
to try new framework.

### How do you make sure your code is maintainable by other team members?
1) Test are not dependent one from other.
2) Page object incaplulates changing parts.
3) I used good naming of tests (I think so)
4) Also I added Report system (haven't set it up completely). So we could
see the logs and screens after fails.