# gson-tutorial
Guide to google gson library 

<div class="font-family-page">
<div style="box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px;">
<a href="https://github.com/google/gson" target="_blank">Gson</a> is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.</div>
<div style="box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px;">
Gson can work with arbitrary Java objects including pre-existing objects that you do not have a source code of.&nbsp;The following tutorials will demonstrate how you can leverage GSON to manage your JSON conversions.</div>
<div style="box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px;">
<span style="background-color: white;">Gson was originally created for use inside Google where it is currently used in a number of projects. It is now used by a number of public projects and companies.</span></div>
<h2 style="border-bottom: 1px solid rgb(234, 236, 239); box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; line-height: 1.25; margin-bottom: 16px; margin-top: 24px; padding-bottom: 0.3em;">
Goals for Gson</h2>
<ul style="box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px; margin-top: 0px; padding-left: 2em;">
<li style="box-sizing: border-box;">Provide easy to use mechanisms like&nbsp;<code style="background-color: rgba(27, 31, 35, 0.05); border-radius: 3px; box-sizing: border-box; font-family: SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace; font-size: 13.6px; margin: 0px; padding: 0.2em 0.4em;">toString()</code>&nbsp;and constructor (factory method) to convert Java to JSON and vice-versa</li>
<li style="box-sizing: border-box; margin-top: 0.25em;">Allow pre-existing unmodifiable objects to be converted to and from JSON</li>
<li style="box-sizing: border-box; margin-top: 0.25em;">Allow custom representations for objects</li>
<li style="box-sizing: border-box; margin-top: 0.25em;">Support arbitrarily complex objects</li>
<li style="box-sizing: border-box; margin-top: 0.25em;">Generate compact and readable JSON output</li>
</ul>
<div>
<h2 style="background-color: white; border-bottom: 1px solid rgb(234, 236, 239); box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; line-height: 1.25; margin-bottom: 16px; margin-top: 24px; padding-bottom: 0.3em;">
GSON Maven Dependency</h2>
<div style="background-color: white; box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px;">
To use Gson with Maven2/3, you can use the Gson version available in Maven Central by adding the following dependency:</div>
<div class="highlight highlight-text-xml" style="background-color: white; box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px;">
<pre style="background-color: #f6f8fa; border-radius: 3px; border: 1px solid rgb(61, 133, 198); box-sizing: border-box; font-family: SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace; font-size: 13.6px; line-height: 1.45; overflow-wrap: normal; overflow: auto; padding: 16px; word-break: normal;">&lt;<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">dependencies</span>&gt;
    &lt;<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">dependency</span>&gt;
      &lt;<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">groupId</span>&gt;com.google.code.gson&lt;/<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">groupId</span>&gt;
      &lt;<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">artifactId</span>&gt;gson&lt;/<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">artifactId</span>&gt;
      &lt;<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">version</span>&gt;2.8.5&lt;/<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">version</span>&gt;
      &lt;<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">scope</span>&gt;compile&lt;/<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">scope</span>&gt;
    &lt;/<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">dependency</span>&gt;
&lt;/<span class="pl-ent" style="box-sizing: border-box; color: #22863a;">dependencies</span>&gt;</pre>
</div>
</div>
<div>
<h2 style="background-color: white; border-bottom: 1px solid rgb(234, 236, 239); box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; line-height: 1.25; margin-bottom: 16px; margin-top: 0px !important; padding-bottom: 0.3em;">
Two ways to create Gson objects</h2>
<div style="background-color: white; box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px;">
Gson object can be created in two ways. First way gives you a quick <i>Gson</i> object ready for faster coding, while the second way uses <i>GsonBuilder</i> to build a more sophisticated <i>Gson</i> object.</div>
<div class="highlight highlight-source-java" style="background-color: white; box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px; overflow: visible !important;">
<pre style="background-color: #f6f8fa; border-radius: 3px; box-sizing: border-box; font-family: SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace; font-size: 13.6px; line-height: 1.45; overflow-wrap: normal; overflow: auto; padding: 16px; word-break: normal;"><span class="pl-c" style="box-sizing: border-box; color: #6a737d;"><span class="pl-c" style="box-sizing: border-box;">//</span>First way to create a Gson object for faster coding</span>
<span class="pl-smi" style="box-sizing: border-box;">Gson</span> gson <span class="pl-k" style="box-sizing: border-box; color: #d73a49;">=</span> <span class="pl-k" style="box-sizing: border-box; color: #d73a49;">new</span> <span class="pl-smi" style="box-sizing: border-box;">Gson</span>();</pre>
</div>
<div class="highlight highlight-source-java" style="background-color: white; box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-size: 16px; margin-bottom: 16px; overflow: visible !important;">
<pre style="background-color: #f6f8fa; border-radius: 3px; box-sizing: border-box; font-family: SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace; font-size: 13.6px; line-height: 1.45; overflow-wrap: normal; overflow: auto; padding: 16px; word-break: normal;"><span class="pl-c" style="box-sizing: border-box; color: #6a737d;"><span class="pl-c" style="box-sizing: border-box;">//</span>Second way to create a Gson object using GsonBuilder</span>
<span class="pl-smi" style="box-sizing: border-box;">Gson</span> gson <span class="pl-k" style="box-sizing: border-box; color: #d73a49;">=</span> <span class="pl-k" style="box-sizing: border-box; color: #d73a49;">new</span> <span class="pl-smi" style="box-sizing: border-box;">GsonBuilder</span>()
             .disableHtmlEscaping()
             .setFieldNamingPolicy(<span class="pl-smi" style="box-sizing: border-box;">FieldNamingPolicy</span><span class="pl-c1" style="box-sizing: border-box; color: #005cc5;"><span class="pl-k" style="box-sizing: border-box; color: #d73a49;">.</span>UPPER_CAMEL_CASE</span>)
             .setPrettyPrinting()
             .serializeNulls()
             .create();</pre>
</div>
<h2 style="background-color: white; border-bottom: 1px solid rgb(234, 236, 239); box-sizing: border-box; color: #24292e; font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; line-height: 1.25; margin-bottom: 16px; margin-top: 0px !important; padding-bottom: 0.3em;">
Using Gson and GsonBuilder Examples</h2>
</div>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/gson-serialize-and-deserialize-primitive-types.html" target="_blank">GSON - Serialize and Deserialize Primitives Types</a></li>
In this quick article, we will discuss how to use GSON to serialize or deserialize any primitive type into JSON representation.</ul>
<div>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/convert-java-object-to-json-using-gson.html" target="_blank">Convert Java Object to JSON using GSON</a></li>
<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">In this article, we will create an example to converting or serializing Java object to JSON representation using the&nbsp;</span>GSON library<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">.</span></ul>
</div>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/convert-json-to-java-object-using-gson.html" target="_blank">Convert JSON to Java Object using GSON</a></li>
<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">In this article, we will create an example to convert JSON representation to Java Object using the&nbsp;</span>GSON library<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">.</span></ul>
</div>
</div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/gson-serialize-and-deserialize-collections-example.html" style="font-size: 16px;" target="_blank">GSON - Serialize and Deserialize Collections Example</a></li>
In this example, we serialize a collection of Integer and Employee objects into JSON representation and using the TypeToken to deserialize the collection of Integers into the arbitrary Java Object.</ul>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/gson-serializing-and-deserializing-generic-types.html" target="_blank">GSON - Serializing and Deserializing Generic Types</a></li>
In this quick article, we will see how to serialize and deserialize a generic class using GSON. Generic type information is lost while serializing because of Java Type Erasure. You can solve this problem by specifying the correct parameterized type for your generic type. Gson provides this with the <i>TypeToken</i> class.<br>
<br>
<li><a href="http://www.javaguides.net/2018/10/gson-serializing-and-deserializing-enums.html" target="_blank">GSON - Serializing and Deserializing Enums</a></li>
<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">In this quick article, we show you how to serialize and deserialize&nbsp;</span>enum types<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">&nbsp;to and from its JSON representation.</span><br>
<br>
<li><a href="http://www.javaguides.net/2018/10/gson-serializing-inner-classes-example.html" target="_blank">Gson - Serializing Inner Classes Example</a></li>
In this article, we will discuss how to serialization/deserialization of classes having inner classes.</ul>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/gson-array-and-multi-dimensional-array-example.html" target="_blank">GSON - Array and Multi-Dimensional Array Example</a></li>
In this quick article, we show you how to serialize and deserialize an array or a multidimensional array to and from its JSON representation.</ul>
</div>
</div>
<div>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/gson-custom-serialization-and-deseriliazation-examples.html" style="font-size: 16px;" target="_blank">GSON - Custom Serialization and Deserialization Examples</a></li>
<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">Many times, we need to write/read the JSON values which do not default representation of java object. In that case, Gson allows you to register your own custom serializer and deserializer.</span></ul>
<ul style="text-align: left;">
<li><a href="http://www.javaguides.net/2018/10/gson-excluding-fields-from-json-with-expose-annotation.html" target="_blank">GSON - Excluding fields from JSON with @Expose Annotation</a></li>
<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">In this quick article, we will discuss how to mark certain fields of our Java objects to be excluded for consideration for serialization and deserialization to JSON.</span><br><br>
<li><a href="http://www.javaguides.net/2018/10/gson-null-object-support.html" target="_blank">GSON - Null Object Support</a></li>
<span style="background-color: rgba(27 , 31 , 35 , 0.05); color: #d73a49; font-family: &quot;consolas&quot; , &quot;liberation mono&quot; , &quot;courier&quot; , monospace; font-size: 14.4px; padding: 0.2em 0.4em;">Gson</span><span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">&nbsp;by default generates optimized JSON content ignoring the NULL values. But&nbsp;</span><span style="background-color: rgba(27 , 31 , 35 , 0.05); color: #d73a49; font-family: &quot;consolas&quot; , &quot;liberation mono&quot; , &quot;courier&quot; , monospace; font-size: 14.4px; padding: 0.2em 0.4em;">GsonBuilder</span><span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">&nbsp;provides flags to show NULL values in the JSON output using the&nbsp;</span><span style="background-color: rgba(27 , 31 , 35 , 0.05); color: #d73a49; font-family: &quot;consolas&quot; , &quot;liberation mono&quot; , &quot;courier&quot; , monospace; font-size: 14.4px; padding: 0.2em 0.4em;">GsonBuilder.serializeNulls()</span><span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">&nbsp;method.</span><br><br>
<li><a href="http://www.javaguides.net/2018/10/gson-version-support-example.html" target="_blank">GSON - Version Support Example</a></li>
<span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">In this quick article, we will discuss how to use&nbsp;</span><span style="background-color: rgba(27 , 31 , 35 , 0.05); color: #d73a49; font-family: &quot;consolas&quot; , &quot;liberation mono&quot; , &quot;courier&quot; , monospace; font-size: 14.4px; padding: 0.2em 0.4em;">@Since</span><span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">&nbsp;annotation to support multiple versions of the same object. GSON introduced the&nbsp;</span><span style="background-color: rgba(27 , 31 , 35 , 0.05); color: #d73a49; font-family: &quot;consolas&quot; , &quot;liberation mono&quot; , &quot;courier&quot; , monospace; font-size: 14.4px; padding: 0.2em 0.4em;">@Since</span><span style="background-color: white; color: #24292e; font-family: , &quot;blinkmacsystemfont&quot; , &quot;segoe ui&quot; , &quot;helvetica&quot; , &quot;arial&quot; , sans-serif , &quot;apple color emoji&quot; , &quot;segoe ui emoji&quot; , &quot;segoe ui symbol&quot;; font-size: 16px;">&nbsp;annotation to support multiple versions of the same object. We can use this annotation on Classes and Fields.</span></ul>
<ul style="text-align: left;">
<li><a href="https://www.baeldung.com/gson-json-to-map" target="_blank">Convert JSON to a Map Using Gson</a></li>
In this quick tutorial, we’ll learn how to convert a JSON string to a Map using Gson from Google.

We’ll see three different approaches to accomplish that and discuss their pros and cons – with some practical examples.</ul>
<h2 style="background-color: white; border-bottom: 1px solid rgb(234, 236, 239); box-sizing: border-box; color: #24292e; line-height: 1.25; margin-bottom: 16px; margin-top: 24px; padding-bottom: 0.3em;">
Reference</h2>
<div>
<a href="https://github.com/google/gson/blob/master/UserGuide.md" target="_blank">GSON User Guide</a></div>
<div>
<a href="https://google.github.io/gson/apidocs/" target="_blank">GSON Java DOC</a></div>
</div>
</div>
