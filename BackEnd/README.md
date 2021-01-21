This is our backend project folder. Once pulled into your own branch, you need to import it in sts.
Make sure you add tomcat to the projects properties/targeted runtimes and make sure you have the tomcat server
in your servers tab in sts as well (make sure apache port is not 8080 as well). Finally, in the current version of dev,
 you will need to change your db credendials in the applicationcontext.xml under the WEB-INF folder as well. 