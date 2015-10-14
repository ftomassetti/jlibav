# How to use this library? #
  * First of all you will need a copy of this library. If you are using Maven, you can simply add the following dependency:

```
    <dependency>
      <groupId>com.google.code.jlibav</groupId>
      <artifactId>jlibav</artifactId>
      <version>0.2.1</version>
    </dependency>
```

or you can use the snapshot which reflects the main trunk:

```
    <dependency>
      <groupId>com.google.code.jlibav</groupId>
      <artifactId>jlibav</artifactId>
      <version>0.3-SNAPSHOT</version>
    </dependency>
```

You have to also add the following repository if you want to use the snapshot:

```
    <repository>
      <id>sonatype</id>
      <name>Sonatype OSS Snapshots Repository</name>
      <url>http://oss.sonatype.org/content/groups/public</url>
    </repository>
```

You can also download the library manually from the download section or directly from the [repository](https://oss.sonatype.org/content/groups/public/com/google/code/jlibav/jlibav/). Remember you will have to get a copy of the JNA (in case of the 0.1.x version) or BridJ (since the 0.2 version) if you are not using Maven.

  * Finally you will need the Libav binaries. There are many ways how to get them. In case of the Windows platform you can download the Libav binaries from the http://win32.libav.org/. In case of the Linux platform you can use the binaries from your distribution's repository. If you cannot get the binaries you can always compile them from source codes. The Libav source code is available at http://libav.org/. On the Linux platform there is no problem with using shared libraries but in case of the Windows or if you don't want to use shared libraries for some reason, you will have to copy the Libav binaries into the libav folder inside your project's working directory.